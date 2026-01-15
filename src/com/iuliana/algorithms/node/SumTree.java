package com.iuliana.algorithms.node;

public class SumTree {

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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(2);
        root.right.right = new Node(6);

        toSumTree(root);
        inorder(root);
    }

    public static int toSumTree(Node node) {
        if(node == null) return 0;

        int sumLeft = toSumTree(node.left);
        int sumRight = toSumTree(node.right);

        int oldValue = node.data;
        node.data = sumLeft + sumRight;
        return node.data + oldValue;
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}
