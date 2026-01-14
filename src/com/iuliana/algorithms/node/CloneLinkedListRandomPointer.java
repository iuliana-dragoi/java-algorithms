package com.iuliana.algorithms.node;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListRandomPointer {

    static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
            next = null;
            random = null;
        }
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " (");
            if(head.random != null) {
                System.out.print(head.random.data + ")");
            }
            else System.out.print("null )");

            if(head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        print(head);

        Node clonedHead = clone(head);
        print(clonedHead);
    }

    public static Node clone(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node currentNode = head;

        while (currentNode != null) {
            map.put(currentNode, new Node(currentNode.data));
            currentNode = currentNode.next;
        }

        currentNode = head;
        while (currentNode != null) {
            Node copy = map.get(currentNode);
            copy.next = currentNode.next;
            copy.random = currentNode.random;
            currentNode = currentNode.next;
        }

        return map.get(head);
    }
}
