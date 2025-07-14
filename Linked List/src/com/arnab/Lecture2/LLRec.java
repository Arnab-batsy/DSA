package com.arnab.Lecture2;

public class LLRec {

    private Node head;
    private Node tail;
    private int size;

    public LLRec() {
        this.size = 0;
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

    //Inserting at an index
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index >= size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //Deleting from first
    public void deleteFirst() {
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    //Getting the value of a node at a particular index
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //Getting a particular node having a given value
    public Node find(int value) {
        Node temp = head;
        while(temp!=null){
            if(temp.value==value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //Deleting the last element
    public void deleteLast() { //Complexity O(N)
        if (size <= 1) {
            deleteFirst();
        }
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
    }

    //Delete from a particular index
    public void deleteIndex(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        Node atIndex = get(index - 1);
        atIndex.next = atIndex.next.next;
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

    //Inserting using recursion
    //In LL, you can do 2 things while using recursion
    //1. Make the return type void and make changes in the LL
    //2. Have a node return type that returns the list node to change the structure

    public void insertRec(int val, int index) {
        head= insertRec(val, index, head);
    }
    private Node insertRec(int val,int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next= insertRec(val, index-1, node.next);
        return node;
    }

    //Merging Linked Lists Leetcode- 21
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

    private class Node {
        //Custom Node

        private int value;
        private Node next;
        //By default, the value of next is Null when no object is provided.

        public Node() {
            this.value = 0;
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

    public static void main(String[] args) {
        LLRec lr = new LLRec();
        LLRec first= new LLRec();
        LLRec second= new LLRec();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        first.display();
        System.out.println(first.head.value);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(13);
        second.display();
        System.out.println(second.head.value);

        Node ans= lr.merge(first.head, second.head);
        while(ans!=null){
            System.out.print(ans.value + " -> ");
            ans = ans.next;
        }
        System.out.println("END");

        //Notes
        // Linked List fast and slow pointer method used for
        // 1. Cycle detection
        // 2. Finding a node in a cycle, etc.

        System.out.println("Cycle LL count begins");
        LLRec lr2 = new LLRec();
        lr2.insertLast(1);
        lr2.insertLast(3);
        lr2.insertLast(5);
        lr2.insertLast(9);
        lr2.insertLast(13);
        lr2.insertLast(11);
        lr2.display();
        Node temp= lr2.head;
        for (int i=0; i<2; i++){
            temp=temp.next;
        }
        Node ref= lr2.tail;
        ref.next= temp;
        System.out.println(lr2.head.value);
        System.out.println(lr2.lengthOfCycle(lr2.head));
        }
        //Q. find the length of the Linked List cycle
    public int lengthOfCycle(Node head) {
        Node fast= head;
        Node slow=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                do{
                    slow=slow.next;
                    count++;
                }while (slow!=fast);
                return count;
            }
        }
        return -1;
    }

    //To find the point where the cycle begins-
    //1. Find the length of the cycle
    //2. From the head, move the slow pointer length of the circle times
    //3. Take the head pointer to the start and then move the slow and fast pointers one by one
    //4. They will meet at the point where the cycle starts
    //Theorem-The meeting point of the slow and the fast pointers initially will be the length of the cycle.
    //Take the fast pointer to the start and then follow from step 3.

    }