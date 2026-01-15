package com.iuliana.algorithms.node;

import java.util.HashSet;

public class DetectAndRemoveLoop {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = head.next.next;

        System.out.println("Before removing loop:");
        printListLimited(head, 10);

        detectLoopAndRemove(head);
        System.out.println("After removing loop:");
        printList(head);
    }

    static void detectLoopAndRemove(Node node) {
        HashSet<Node> set = new HashSet<>();
        Node prev = null;
        while (node != null) {
            //System.out.println(" " + node.data);

            if(set.contains(node)) { // if true we have a loop
                prev.next = null; // remove loop
                break;
            }
            else set.add(node);

            prev = node;
            node = node.next;
        }
    }

    static void printListLimited(Node head, int limit) {
        Node temp = head;
        int count = 0;
        while (temp != null && count < limit) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        if(temp != null) System.out.println("...");
        else System.out.println("null");
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
