package com.arnab.Lecture2;

public class LLSort {
     private Node head;
    private Node tail;
    private int size;

    public LLSort() {
        this.size = 0;
    }

    public static void main(String[] args) {
        LLSort ll = new LLSort();
        ll.insertLast(5);
        ll.insertLast(8);
        ll.insertLast(6);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(1);
        ll.insertLast(4);
        ll.insertLast(10);
        ll.insertLast(7);
        ll.insertLast(9);
        ll.display();
        //Node n= ll.mergeSort(ll.head);
        ll.bubbleSort();
        ll.display();
    }

    //Inserting Elements (Method)
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        ++size;
    }

    //Inserting at last
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);

        tail.next = node;
        tail = node;

        ++size;
    }

     public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

      //Displaying Elements
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

     private class Node {
        //Custom Node
        private int value;
        private Node next;
        //By default, the value of next is Null when no object is provided.

        public Node() {
            this.value = -1;
            this.next = null;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    //Sorting a Linked List using-Merge sort and Bubble
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid= getMid(head);
        Node left= mergeSort(head);
        Node right= mergeSort(mid);

        return merge(left,right);
    }

    public void bubbleSort() {
        bubbleSort(size-1, 0);
    }

    private void bubbleSort(int row, int col) {
        if(row==0){
            return;
        }
        if(col<row) {
            //Swap
            Node first= get(col);
            Node second= get(col+1);
            if(first.value>second.value){
                if(first==head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }
                else if(second==tail){
                    Node prev= get(col-1);
                    prev.next= second;
                    tail=first;
                    second.next=tail;
                    first.next=null;
                }
                else {
                    Node prev= get(col-1);
                    prev.next= second;
                    first.next=second.next;
                    second.next=first;
                }
            }
            bubbleSort(row, col+1);
        }
        else bubbleSort(row-1, 0);
    }

    public Node getMid(Node head) {
        Node slow = head, fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list into two parts
        if (prev != null) {
            prev.next = null;
        }

        return slow; // This is the start of the right half
    }


    public Node merge(Node first, Node second) {

        Node dummy= new Node();
        Node current = dummy;

        while (first != null && second != null) {
            if (first.value < second.value) {
                current.next = first;
                first = first.next;
            }
            else{
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        current.next = first!=null?first:second;
        return dummy.next;
    }

}
