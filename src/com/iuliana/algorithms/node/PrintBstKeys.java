package com.iuliana.algorithms.node;

import java.util.ArrayList;
import java.util.List;

public class PrintBstKeys {

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
        Node node = new Node(22);
        node.left = new Node(12);
        node.right = new Node(30);

        node.left.left = new Node(8);
        node.left.right = new Node(20);

        findKeysInRange(node, 10, 22);
    }

    static void findKeysInRange(Node root, int n1, int n2) {
        if(n1 > n2) return;

        List<Integer> keys = new ArrayList<>();
        search(root, n1, n2, keys);

        System.out.println();
        for(Integer key : keys) {
            System.out.print(key + " ");
        }
    }

    private static void search(Node root, int n1, int n2, List<Integer> keys) {
        if(root == null) return;
        search(root.left, n1, n2, keys);
        if(root.data >= n1 && root.data <= n2) keys.add(root.data);
        System.out.print(root.data + " -> ");
        search(root.right, n1, n2, keys);
    }
}
