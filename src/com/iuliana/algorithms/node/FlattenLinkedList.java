package com.iuliana.algorithms.node;

public class FlattenLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    static void main(String[] args) {
        // Create a hard-coded linked list:
        // 5 -> 10 -> 19 -> 28
        // |    |     |
        // V    V     V
        // 7    20    22
        // |          |
        // V          V
        // 8          50
        // |
        // V
        // 30

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        Node result1 = flatten(head);
        printList(result1);
    }

    static Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null;
        return result;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
    }
}
