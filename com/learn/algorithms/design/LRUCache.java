package com.learn.algorithms.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 10);
        lru.put(2, 20);
//        System.out.println(lru.get(1)); // 10
        lru.put(3, 30);
        System.out.println(lru.get(2)); // -1
        lru.put(4, 40);
//        System.out.println(lru.get(3)); // -1
//        System.out.println(lru.get(3)); // 30
//        System.out.println(lru.get(4)); // 40
        System.out.println(lru.head.next.value);

    }

    private int capacity;
    private Map<Integer, Node1> map;
    private Node1 head;
    private Node1 last;

    LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node1(0,0);
        last = new Node1(0,0);
        head.next = last;
        last.prev = head;
    }

    private void deleteNode(Node1 node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAtHead(Node1 node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node1 node = map.get(key);
            deleteNode(node);
            addAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node1 node = map.get(key);
            node.value = value;
            deleteNode(node);
            addAtHead(node);
        }
        else{
            Node1 node = new Node1(key,value);
            map.put(key, node);
            if(map.size() > capacity){
                map.remove(last.prev.key);
                deleteNode(last.prev);
            }
            addAtHead(node);
        }
    }


}

class Node1{
    int key;
    int value;
    Node1 prev;
    Node1 next;

     Node1(int key, int value){
        this.key = key;
        this.value = value;
    }
}
