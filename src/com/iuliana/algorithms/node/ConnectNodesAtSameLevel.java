package com.iuliana.algorithms.node;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int val) {
            data = val;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    static void main() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);

        connect(root);
        printNextRights(root);
    }

    public static void connect(Node root) {
        if (root == null) return;
        root.nextRight = null;
        connectRecursive(root);
    }

    public static void connectRecursive(Node root) {
        if(root == null) return;

        if(root.left != null) {
            root.left.nextRight = root.right;
        }

        if(root.right != null) {
            root.right.nextRight = (root.nextRight != null) ? root.nextRight.left : null;
        }

        connectRecursive(root.left);
        connectRecursive(root.right);
    }

    static void printNextRights(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + "->" +
                        (curr.nextRight != null ? curr.nextRight.data : "null") + "  ");
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            System.out.println();
        }
    }
}
