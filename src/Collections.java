import java.util.*;
import java.util.concurrent.*;

public class Collections {

    static void main() {
        arrayListExample();
        linkedListExample();

        hashSetExample();
        linkedHashSetExample();
        treeSetExample();

        hashMapExample();
        linkedHashMapExample();
        treeMapExample();

        queueExample();
        dequeExample();

        priorityQueueExample();
        maxHeapExample();

        concurrentHashMapExample();
        blockingQueueExample();

        immutableCollectionsExample();
    }

    /** =========================================================
       LIST IMPLEMENTATIONS
    ========================================================= **/

    static void arrayListExample() {
        // ArrayList
        // Backed by a dynamic array
        // Fast random access, slow inserts/removals in the middle

        List<Integer> list = new ArrayList<>();

        list.add(1);          // O(1) amortized
        list.add(2);          // O(1) amortized
        list.get(0);          // O(1)
        list.remove(0); // O(n) - elements are shifted
    }

    static void linkedListExample() {
        // LinkedList
        // Doubly-linked list
        // Fast insert/remove, slow random access

        List<Integer> list = new LinkedList<>();

        list.add(1);          // O(1)
        list.add(2);          // O(1)
        list.get(1);          // O(n)
        list.remove(0); // O(1) if node reference is known
    }

    /** =========================================================
    SET IMPLEMENTATIONS
    ========================================================= **/

    static void hashSetExample() {
        // HashSet
        // Backed by HashMap
        // No ordering, fastest operations

        Set<Integer> set = new HashSet<>();

        set.add(1);           // O(1) amortized
        set.contains(1);      // O(1)
        set.remove(1);     // O(1)
    }

    static void linkedHashSetExample() {
        // LinkedHashSet
        // Preserves insertion order

        Set<Integer> set = new LinkedHashSet<>();

        set.add(1);           // O(1)
        set.add(2);           // O(1)
    }

    static void treeSetExample() {
        // TreeSet
        // Backed by Red-Black Tree
        // Sorted, slower than HashSet

        Set<Integer> set = new TreeSet<>();

        set.add(1);           // O(log n)
        set.add(2);           // O(log n)
        set.contains(1);      // O(log n)
    }

    /** =========================================================
     MAP IMPLEMENTATIONS
     ========================================================= **/

    static void hashMapExample() {
        // HashMap
        // Key-value structure, unordered
        // Fastest lookup

        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);      // O(1) amortized
        map.get("a");         // O(1)
        map.remove("a");  // O(1)
    }

    static void linkedHashMapExample() {
        // LinkedHashMap
        // Preserves insertion order (or access order)

        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("a", 1);      // O(1)
        map.put("b", 2);      // O(1)
    }

    static void treeMapExample() {
        // TreeMap
        // Sorted by key
        // Backed by Red-Black Tree

        Map<String, Integer> map = new TreeMap<>();

        map.put("a", 1);      // O(log n)
        map.get("a");         // O(log n)
    }

    /** =========================================================
       QUEUE / DEQUE
    ========================================================= **/

    static void queueExample() {
        // Queue (FIFO)
        // ArrayDeque is preferred over LinkedList

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);       // O(1)
        queue.offer(2);       // O(1)
        queue.poll();         // O(1)
        queue.peek();         // O(1)
    }

    static void dequeExample() {
        // Deque (Double-ended queue)
        // Can act as stack or queue

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);    // O(1)
        deque.addLast(2);     // O(1)
        deque.removeFirst();  // O(1)
        deque.removeLast();   // O(1)
    }

    /** =========================================================
       PRIORITY QUEUE (HEAP)
    ========================================================= **/

    static void priorityQueueExample() {
        // PriorityQueue
        // Min-heap by default

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(3);       // O(log n)
        minHeap.add(1);       // O(log n)
        minHeap.poll();       // O(log n)
    }

    static void maxHeapExample() {
        // Max-heap using comparator

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(3);       // O(log n)
        maxHeap.add(1);       // O(log n)
        maxHeap.poll();       // O(log n)
    }

    /** =========================================================
       CONCURRENT COLLECTIONS
    ========================================================= **/

    static void concurrentHashMapExample() {
        // ConcurrentHashMap
        // Thread-safe, non-blocking reads
        // Uses fine-grained locking

        ConcurrentHashMap<String, Integer> map =
                new ConcurrentHashMap<>();

        map.put("a", 1);      // O(1)
        map.get("a");         // O(1)
    }

    static void blockingQueueExample() {
        // BlockingQueue
        // Used in producer-consumer problems

        BlockingQueue<Integer> queue =
                new LinkedBlockingQueue<>();

        queue.offer(1);       // O(1)
        // queue.take();      // O(1) but blocks if empty
    }

    /** =========================================================
       IMMUTABLE COLLECTIONS (Java 9+)
    ========================================================= **/

    static void immutableCollectionsExample() {
        // Immutable collections
        // Thread-safe by design

        List<Integer> list = List.of(1, 2, 3);
        Set<Integer> set = Set.of(1, 2, 3);
        Map<String, Integer> map = Map.of("a", 1);

        // list.add(4); // UnsupportedOperationException
    }
}
