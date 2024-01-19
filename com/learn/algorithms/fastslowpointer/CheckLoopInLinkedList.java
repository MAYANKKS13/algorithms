package com.learn.algorithms.fastslowpointer;

public class CheckLoopInLinkedList {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;

        System.out.println(isLoop(head));

    }
    public static boolean isLoop(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
    public static void show(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
