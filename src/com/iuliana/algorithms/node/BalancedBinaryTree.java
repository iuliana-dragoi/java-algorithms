package com.iuliana.algorithms.node;

public class BalancedBinaryTree {

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

        System.out.println(isBalanced(root)); // metoda O(n^2)
        System.out.println(isBalancedOptimized(root)); // metoda O(n)
    }

    static int height(Node root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // BF = Height(LeftSubtree) - Height(RightSubtree)
    static boolean isBalanced(Node root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    static int checkBalance(Node root) {
        if (root == null) return 0;

        int leftHeight = checkBalance(root.left);
        if(leftHeight == -1) return -1;

        int reightHeight = checkBalance(root.right);
        if(reightHeight == -1) return -1;

        if(Math.abs(leftHeight - reightHeight) > 1) return -1;

        return Math.max(leftHeight, reightHeight) + 1;
    }

    static boolean isBalancedOptimized(Node root) {
        return checkBalance(root) != -1;
    }
}
