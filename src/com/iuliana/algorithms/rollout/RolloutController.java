package com.iuliana.algorithms.rollout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RolloutController {

    private List<Cluster> clusters;
    private Map<Phase, Double> thresholds = Map.of(
            Phase.CANARY, 0.9,
            Phase.PILOT, 0.96,
            Phase.BROAD, 0.95
    );

    public RolloutController(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public void run() throws InterruptedException {
        int total = clusters.size();

        Phase[] phases = Phase.values();
        for(Phase phase : phases) {
            List<Cluster> phaseClusters = selectPhaseClusters(phase, total);
            System.out.println("Starting phase: " + phase + " on clusters: " + phaseClusters.size());

            // Simulate rollout parallel on clusters
            ExecutorService executor = Executors.newFixedThreadPool(phaseClusters.size());
            List<Future<Boolean>> results = new ArrayList<>();
            for (Cluster c : phaseClusters) {
                results.add(executor.submit(() -> rolloutCluster(c)));
            }
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.MINUTES);

            // Calculate success rate
            long successCount = results.stream().filter(f -> {
                try { return f.get(); } catch (Exception e) { return false; }
            }).count();

            double successRate = (double) successCount / phaseClusters.size();
            System.out.println("Phase " + phase + " success rate: " + successRate);

            if (successRate < thresholds.get(phase)) {
                System.out.println("Rollout failed, stopping at phase " + phase);
                return;
            }

        }

        System.out.println("Rollout completed successfully on all phases!");
    }


    public List<Cluster> selectPhaseClusters(Phase phase, int total) {
        int count;
        switch (phase) {
            case CANARY -> count = Math.max(1, total * 5 / 100);
            case PILOT -> count = Math.max(1, total * 25 / 100);
            case BROAD -> count = total - (total * 5 / 100) - (total * 25 / 100);
            default -> count = 0;
        }
        return  new ArrayList<>(clusters.subList(0, count));
    }

    private boolean rolloutCluster(Cluster c) throws InterruptedException {
        c.state = ClusterState.IN_PROGRESS;
        // Simulate rollout
        Thread.sleep(500);
        boolean success = new Random().nextDouble() > 0.05; // 95% chance success
        c.state = success ? ClusterState.SUCCEEDED : ClusterState.FAILED;
        System.out.println("Cluster " + c.name + " rollout " + c.state);
        return success;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Cluster> clusters = new ArrayList<>();
        for (int i = 1; i <= 20; i++) clusters.add(new Cluster("cluster-" + i));

        RolloutController controller = new RolloutController(clusters);
        controller.run();
    }
}
