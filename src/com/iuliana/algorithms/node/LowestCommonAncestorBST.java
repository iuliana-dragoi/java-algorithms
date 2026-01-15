package com.iuliana.algorithms.node;

public class LowestCommonAncestorBST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // LCA = cel mai jos nod din arbore care este stramos pentru ambele noduri
    static void main() {
        //          5
        //       /     \
        //      3       7
        //     / \     /  \
        //    2   4   6   8
        //                 \
        //                  20

        Node root = new Node(5);

        // Left subtree
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        // Right subtree
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.right = new Node(20);

        preorder(root, 0);
        inorder(root);
        postorder(root);

        Node node = LCA(root, 2,4);
        System.out.println("Node="+ node.data);
    }

    static Node LCA(Node head, int n1, int n2) {
        if(head == null) return null;

        int data = head.data;

        if(data == n1 || data == n2) return head;

        if(n1 < data && n2 < data) {  // search left
            return LCA(head.left, n1, n2);
        }

        if(n1 > data && n2 > data) {  // search right
            return LCA(head.right, n1, n2);
        }

        return head;
    }
    
    // Root -> Left -> Right
    static void preorder(Node head, int level) {
        if(head == null) return;

        System.out.println(head.data + " " + level);
        preorder(head.left, level+1);
        preorder(head.right, level+1);
    }

    // Left -> Root -> Right
    static void inorder(Node head) {
        if(head == null) return;

        inorder(head.left);
        System.out.println(head.data);
        inorder(head.right);
    }

    // Left -> Right -> Root
    static void postorder(Node head) {
        if(head == null) return;

        postorder(head.left);
        postorder(head.right);
        System.out.println(head.data);
    }
}
