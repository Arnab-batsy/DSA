package com.arnab.Lecture1;

public class LL2 {
    //Every node is itself a data structure
    //There is no single variable that can take you to the previous node (In a singly LL)
    //While solving questions, we take temp=head and then move the temp because it's scope will be in the
    //function only, and it will not change structure of the Linked List
    //node.something = something - means making a change.
    //If temp makes any changes in the object, the change will also be there for head since both are ref variables
    //making a change in the same object.
    //Doubly Linked List-Singly LL + prev
    //For DLL- head has prev null, Tail has next null
    //Only helps during backward traversals

    private NodeD head;
    private NodeD tail;
    private int size;
    public LL2() {this.size = 0;}

    public void insertFirst(int val) {
        NodeD node = new NodeD(val);
        node.next = head;
        node.prev= null;
        if (head == null) {
            head = tail = node;
            //Checking for null pointer
        }
        else {
            head.prev = node;
            head = node;
            if (tail == null) {
                tail = node;
            }
        }
        size++;
    }
    public void display() {
        NodeD node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("END");
    }

    public void displayRev() {
        NodeD node = tail;
        System.out.println("In reverse order");
        while (node != null) {
            System.out.print(node.val + "<-");
            node = node.prev;
        }
        System.out.println("START");
    }

    public void insertLast(int val) {
        NodeD node = new NodeD(val);
        if (head == null) {
            head = tail = node;
            head.prev = null;
            //Checking for null pointer
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.next= null;
            size++;
        }
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index >= size) {
            insertLast(val);
            return;
        }
        NodeD temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        NodeD node = new NodeD(val, temp.next, temp);
        if(temp.next == null) {
            temp.next = node;
            node.next=null;
            size++;
            return;
        }
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    private class NodeD {
        int val;
        NodeD next;
        NodeD prev;

        public NodeD(int val) {
            this.val = val;
        }

        public NodeD(int val, NodeD next, NodeD prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
