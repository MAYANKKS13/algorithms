package com.learn.algorithms.design;

import java.util.Stack;


class MinStack {
    public static void main(String[] args) {
        MinStack1 minStack1 = new MinStack1();
        minStack1.push(-111);
        minStack1.push(2);
        minStack1.push(-5);
        minStack1.push(20);

        System.out.println(minStack1.getMin());
        System.out.println(minStack1.top());
        minStack1.pop();
        minStack1.pop();
        System.out.println(minStack1.getMin());

        MinStack2 minStack2 = new MinStack2();
        minStack2.push(10);
        System.out.println(minStack2.top());
        minStack2.push(-20);
        minStack2.push(30);
        minStack2.push(-50);
        System.out.println(minStack2.top());
        minStack2.getMin();
        minStack2.pop();
        System.out.println(minStack2.getMin());

    }
}

class MinStack2 {

    Node node;

    public MinStack2() {

    }

    public void push(int val) {
        if(node == null) {
            node = new Node(val, val);
        } else {
            Node newNode = new Node(val, Math.min(val, node.min));
            newNode.next = node;
            node = newNode;
        }
    }

    public void pop() {
        if(node == null) {
            return;
        }
        node = node.next;
    }

    public int top() {
        return node.data;
    }

    public int getMin() {
        return node.min;
    }
}

class Node {
    int data;
    int min;
    Node next;

    Node(int data, int min){
        this.data = data;
        this.min = min;
    }
}
class MinStack1 {
    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack1() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}