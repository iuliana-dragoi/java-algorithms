package com.iuliana.algorithms.node;

public class DeleteMiddleLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void main() {
        // 1 -> 2 -> 3 -> 4 -> 5.
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        printList(head);
        deleteMiddle(head);
        printList(head);

    }

    static Node deleteMiddle(Node node) {
        if(node == null || node.next == null) return null;

        Node slow = node;
        Node fast = node;
        Node prev = null;

        // Fast & Slow pointer
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;
        System.out.println();
        return node;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
