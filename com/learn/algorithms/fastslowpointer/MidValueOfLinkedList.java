package com.learn.algorithms.fastslowpointer;

public class MidValueOfLinkedList {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        System.out.println(mid(head));

    }
    public static int mid(Node head) {

        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr.next != null) {

            fastPtr = fastPtr.next;
            if (fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            } else { // when even items present in LL
                System.out.println(slowPtr.data + ", " + slowPtr.next.data);
            }
        }
        return slowPtr.data;
    }
}

