package com.iuliana.algorithms.arrays;

/***
 *  Check if a Binary Tree is a BST or not
 *
 *  Rules:
 *  - For any node n:
 *      - All values in the left subtree < n.val
 *      - All values in the right subtree > n.val
 *
 *  - Each subtree must also be a BST
 *
 *  Solution:
 *  - Recursive min / max approach
 *      - For each node, we need to know the valid limits (min and max)
 *      - Without min/max, comparing only with the direct parent is not enough
 *
 ***/

// Pseudo Logic
//    20
//  5   55
// 2 6   40  80

public class CheckBST {

    public static void main(String[] args) {

        CheckBST check = new CheckBST();

        TreeNode root1 = new TreeNode(20);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(55);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(40);
        root1.right.right = new TreeNode(80);

        System.out.print("Inorder:   "); check.inorderPrint(root1);   System.out.println();
        System.out.print("Preorder:  "); check.preorderPrint(root1);  System.out.println();
        System.out.print("Postorder: "); check.postorderPrint(root1); System.out.println();

        System.out.println("---------------------------");
        System.out.println("Este acest arbore BST? " + check.isBST(root1));
    }

    void inorderPrint(TreeNode node) {
        if (node == null) return;
        inorderPrint(node.left);
        System.out.print(node.val + " ");
        inorderPrint(node.right);
    }

    void preorderPrint(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorderPrint(node.left);
        preorderPrint(node.right);
    }

    void postorderPrint(TreeNode node) {
        if (node == null) return;
        postorderPrint(node.left);
        postorderPrint(node.right);
        System.out.print(node.val + " ");
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBST(TreeNode node) {
        return validate(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode node, int min, int max) {
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        boolean leftOk = validate(node.left, min, node.val);
        boolean rightOk = validate(node.right, node.val, max);
        return leftOk && rightOk;
    }
}
