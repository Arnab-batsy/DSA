package Lecture1;

import java.util.*;

public class SQ1 {
    public static void main(String[] args) throws StackException {
        //Stacks in Java
        //First in last out || Last in first out (FILO AND LIFO)
        //Removal-POP, Insertion-PUSH
        //Queues in java
        //First in first out || Last in last out (FIFO AND LILO)
        //Just like First come, first served

        //Inbuilt Examples
        Stack<Integer> stack = new Stack<>(); //Extends the Vector class
        //Internally it itself is an array
        //I can't directly modify this array it's an abstract data type
        //That's why it's called a stack according to its implementation
        //Time complexity-Constant
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        //Whenever an item is removed from any data Structure, it is returned by convention
        System.out.println(stack.pop()); //It returns an Integer
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //If you're removing from an empty stack, you'll get exception

        //Queue is like a Linked list the FIFO is the head.
        //Internally this LL has both the head and the tail.
        Queue<Integer> queue = new LinkedList<>();
        //There is no class called queue since it is an interface.It used the Linked list class.
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue.peek());
        System.out.println(queue);
        //peek just gets the head but doesn't remove it
        System.out.println(queue.remove()); //This does both
        System.out.println(queue);

        //When do we use this stack and queue
        //Ans-When you want to store the answer so far to use those later on
        //When you want to have a particular group of elements inside a particular data structure for a period of time
        //Ex- Tree traversals and BFS and DFS, Converting recursion programs into iterations

        //Deque-pronounced as Deck
        //It is a doubly ended queue. Can be added and removed from both the sides.
        Deque<Integer> deque = new ArrayDeque<>(); //Is also an interface and implements a ArrayDeque
        //ArrayDeque is faster than a Linked list and stacks and doesn't have capacity restrictions
        //Null elements are not allowed in this.
        //Has methods like- addFirst, addLast, offerFirst, RemoveFirst, pollLast, getFirst, peekFirst, etc
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);
        deque.addLast(7);
        deque.addFirst(8);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);

        DynamicStack stacks= new DynamicStack(5);
        stacks.push(34);
        stacks.push(45);
        stacks.push(2);
        stacks.push(9);
        stacks.push(18);
        stacks.push(7);
        stacks.push(6);
        stacks.push(8);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());

    }
}
