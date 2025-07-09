package com.arnab.Lecture1;

public class LL3 {
    //Circular Linked list (Maybe double or may not be)
    //Here things are not null. No one is pointing to null unless list is empty.
    //The next of tail is head and prev of head is tail

    private NodeC head;
    private NodeC tail;
    private int size;
    public LL3() {this.size = 0;}

    //inserting a value after the tail
    public void insertLast(int data) {
        NodeC node = new NodeC(data);
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.next= node;
        node.prev = tail;
        node.next = head;
        head.prev = node;
        tail = node;

    }

    public void display() {
        NodeC node = head;
        if (head != null) {
            do {
                System.out.print(node.val + "->");
                node = node.next;
            } while (node != head);
            System.out.println("HEAD");
        }
    }

    public void delete(int data) {
        NodeC node = head;
        if (head == null) {
            System.out.println("HEAD IS NULL");
            return;
        }
        if(head.val==data){
            head=head.next;
            tail.next= head;
        }
        do{
            NodeC n= node.next;
            if(n.val==data){
                node.next= n.next;
                break;
            }
            node= node.next;
        }
        while (node != head);

    }

    private class NodeC{
        int val;
        NodeC next;
        NodeC prev;

        public NodeC(int val) {
            this.val = val;
        }

        public NodeC(int val, NodeC next, NodeC prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
