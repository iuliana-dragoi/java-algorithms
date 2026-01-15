package com.iuliana.algorithms.node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSum {

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
        Node node = new Node(10);
        node.left = new Node(8);
        node.right = new Node(2);
        node.right.left = new Node(2);

        node.left.left = new Node(3);
        node.left.right = new Node(2);
        
        findPathWithSum(node, 21, 0, new ArrayList<>());

    }
    
    static void findPathWithSum(Node head, int sum, int currentSum, List<Integer> path) {
        if(head == null) return;

        path.add(head.data);
        currentSum += head.data;

        // System.out.println(head.data + " ");
        if(head.left == null && head.right == null && currentSum == sum) {
            System.out.println(path);
        }
        else {
            findPathWithSum(head.left, sum, currentSum, path);
            findPathWithSum(head.right,  sum, currentSum, path);
        }
    }
}
