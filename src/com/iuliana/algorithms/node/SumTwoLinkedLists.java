package com.iuliana.algorithms.node;

public class SumTwoLinkedLists {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    static void main() {
        Node l1 = new Node(4);
        l1.next = new Node(5);

        Node l2 = new Node(3);
        l2.next = new Node(4);
        l2.next.next = new Node(5);

        System.out.print("Lista 1: ");
        printList(l1);
        System.out.print("Lista 2: ");
        printList(l2);

        Node result = addLists(l1, l2);
        printList(result);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static Node addLists(Node l1, Node l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        Node dummyHead = new Node(0);
        Node curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }

            curr.next = new Node(sum % 10);
            curr = curr.next;

            carry = sum / 10;
        }

        return reverse(dummyHead.next);
    }

    public static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
