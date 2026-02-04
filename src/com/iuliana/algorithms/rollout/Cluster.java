package com.iuliana.algorithms.rollout;

public class Cluster {
    String name;
    ClusterState state = ClusterState.PENDING;

    public Cluster(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClusterState getState() {
        return state;
    }

    public void setState(ClusterState state) {
        this.state = state;
    }
}
