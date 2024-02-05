package com.learn.algorithms.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        printList(head);
        reverseLL(head);
        System.out.println();
        printList(head);

    }

    public static Node head = new Node(13);

    public static void reverseLL(Node temp) {

        if (temp.next == null) {
            head = temp;
            return;
        }
        reverseLL(temp.next);
        Node q = temp.next;
        q.next = temp;
        temp.next = null;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
