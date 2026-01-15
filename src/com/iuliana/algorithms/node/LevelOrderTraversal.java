package com.iuliana.algorithms.node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
        Node node = new Node(5);
        node.left = new Node(12);
        node.right = new Node(13);
        node.right.left = new Node(2);

        node.left.left = new Node(7);
        node.left.left.left = new Node(17);
        node.left.left.right = new Node(23);

        node.right.right = new Node(2);
        node.right.right.left = new Node(8);
        node.right.right.right = new Node(11);

        node.right.left = new Node(14);
        node.right.left.left = new Node(27);
        node.right.left.right = new Node(3);

        levelOrder(node);
    }

    public static void levelOrder(Node head) {
        if(head == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }
}
