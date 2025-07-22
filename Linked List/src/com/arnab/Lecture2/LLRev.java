package com.arnab.Lecture2;
import com.arnab.Lecture1.LL;

public class LLRev extends LL {
    //Reversing a Linked list
    public LLRev() {
        super();
    }
    public static void main(String[] args) {
        LLRev lr = new LLRev();
        lr.insertLast(5);
        lr.insertLast(4);
        lr.insertLast(3);
        lr.insertLast(2);
        lr.insertLast(1);
        lr.insertLast(0);
        lr.display();
        lr.reverse();
        lr.display();
        Node newHead= lr.inPlaceRev(lr.head);
        lr.display(newHead);
    }
    //Recursive approach
     public Node reverse() {
        head= reverseRec(head);
        return head;
     }

    private Node reverseRec(Node current) {
        //Base condition if the list is empty or single node
        if(current==null || current.next==null) {
            return current;
        }
        //Reverse the rest of the list
        Node newHead=reverseRec(current.next);

        current.next.next=current;
        current.next=null;

        return newHead;
    }

    //In place reversal of LL (Iterative)
    public Node inPlaceRev(Node head){
            //Three pointer approach
            Node prev= null;
            Node pres= head;
            if(pres==null || pres.next==null) return head;
            Node next= pres.next;
            while(pres!=null){
                pres.next= prev;
                prev= pres;
                pres= next;
                if(next!= null){
                    next= next.next;
                }
            }
            return prev;
            //Time Complexity- O(n)
        }
    }

