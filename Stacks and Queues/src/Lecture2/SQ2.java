package Lecture2;

public class SQ2 {
    // If you're dealing with ordering-Putting stuff in order and getting it back in order,
    // then you're going to use Stacks and Queues
    // Holding values, working with sequences, working with orders

    //Q1- Implement queues using Stacks
    //https://leetcode.com/problems/implement-queue-using-stacks/description/
    //If you want to add in a queue, Insert in stack normally
    //For removing, put the elements of one stack into another and then just remove it
    //In order to remove one item, you need to traverse through all the items. So, complexity is O(N)
    //In this case, it's called Insert efficient Queue
    //For Remove efficient queue-While inserting a new element, empty the first stack,
    //put the elements in the second stack. Now put the new element in the first stack and then again
    //Put all the elements from the second stack to the first stack

    //Q2- Game of Two Stacks
}
