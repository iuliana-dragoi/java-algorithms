package com.iuliana.algorithms.node;


import java.util.LinkedList;
import java.util.Queue;

public class RecoverBST {

    // A Binary Search Tree (BST) is a binary tree in which, for every node, all values in the left subtree
    // are less than the node’s value, and all values in the right subtree are greater than the node’s value.

    static Node first = null;
    static Node second = null;
    static Node prev = null;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void main() {

        Node root = new Node(4);
        root.left = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        printByLevel(root);
        System.out.println();
        printInorder(root);
        System.out.println();

        recoverBTS(root);
    }

    static void recoverBTS(Node root) {
        findBrokenNodes(root);
        if(first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
        System.out.println();
        printInorder(root);
    }

    static void findBrokenNodes(Node root) {
        if(root == null) return;

        findBrokenNodes(root.left);

        int data = root.data;
        int prevData = prev != null ? prev.data : -1;

        if(prevData > data) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }

        //System.out.print(data + " ");

        prev = root;
        findBrokenNodes(root.right);
    }

    static void printInorder(Node root) {
        if(root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static void printByLevel(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int maxWidth = 5;

        while (!q.isEmpty()) {
            int size = q.size();
            int spaces = maxWidth >> level;

            for (int i = 0; i < spaces; i++) System.out.print(" ");

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                System.out.print(cur.data);

                for (int j = 0; j < spaces * 2; j++) System.out.print(" ");

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            System.out.println();
            level++;
        }
    }
}
