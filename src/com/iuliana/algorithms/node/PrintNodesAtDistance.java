package com.iuliana.algorithms.node;

public class PrintNodesAtDistance {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void main() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);

        int k = 2;
        print(root, k);
    }

    static void print(Node head, int k) {
        if(head == null) return;

        if(k == 0) {
            System.out.print(head.data + " ");
        }

        print(head.left, k - 1);
        print(head.right, k - 1);
    }
}
