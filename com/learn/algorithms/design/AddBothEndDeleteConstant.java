package com.learn.algorithms.design;

import java.util.HashMap;
import java.util.Map;

public class AddBothEndDeleteConstant {
    DoublyLinkedList doublyLinkedList;
    Map<Integer, DoublyLinkedList<DLLNode>> map;

    AddBothEndDeleteConstant() {
        doublyLinkedList = new DoublyLinkedList();
        map = new HashMap<>();
    }

    public void insertFirst(int value) {
        DLLNode newNode = new DLLNode(value);
        doublyLinkedList.addAtHead(newNode);
        DoublyLinkedList<DLLNode> nodeList = new DoublyLinkedList<>();
        if (map.containsKey(value)) {
            nodeList = map.get(value);
        }
        nodeList.addAtHead(new DLLNode(newNode));
        map.put(value, nodeList);
    }

    public void insertLast(int value) {
        DLLNode newNode = new DLLNode(value);
        doublyLinkedList.addAtEnd(newNode);
        DoublyLinkedList<DLLNode> nodeList = new DoublyLinkedList<>();
        if (map.containsKey(value)) {
            nodeList = map.get(value);
        }
        nodeList.addAtEnd(new DLLNode(newNode));
        map.put(value, nodeList);
    }

    public void deleteValue(int value) {
        DoublyLinkedList<DLLNode> tempNodeList = map.get(value);
        if (tempNodeList == null) {
            return;
        }
        DLLNode tempNode = tempNodeList.getHead().next;
        doublyLinkedList.deleteNode((DLLNode) tempNode.value);
        tempNodeList.deleteNode(tempNode);
    }

    public void printList() {
        doublyLinkedList.print();
    }

    public static void main(String[] args) {
        AddBothEndDeleteConstant ds = new AddBothEndDeleteConstant();
        ds.insertFirst(2);
        ds.insertFirst(3);
        ds.insertFirst(2);
        ds.insertFirst(4);
        ds.insertLast(7);
        ds.insertLast(2);
        ds.insertLast(9);
        ds.insertLast(2);
        ds.printList(); // 4  2  3  2  7  2  9  2
        ds.deleteValue(2);
        System.out.println();
        ds.printList(); // 4  3  2  7  2  9  2
        ds.deleteValue(2);
        System.out.println();
        ds.printList(); // 4  3  7  2  9  2
    }

}

class DoublyLinkedList<T> {
    private DLLNode head;
    private DLLNode last;

    DoublyLinkedList() {
        head = new DLLNode(0);
        last = new DLLNode(0);
        head.next = last;
        last.prev = head;
    }

    public DLLNode getHead() {
        return head;
    }

    public void addAtHead(DLLNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void addAtEnd(DLLNode node) {
        node.next = last;
        last.prev.next = node;
        node.prev = last.prev;
        last.prev = node;
    }

    public void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void print() {
        DLLNode temp = head.next;
        while (temp != last) {
            System.out.print(temp.value + "  ");
            temp = temp.next;
        }
    }
}

class DLLNode<T> {
    T value;
    DLLNode next;
    DLLNode prev;

    DLLNode(T value) {
        this.value = value;
    }
}
