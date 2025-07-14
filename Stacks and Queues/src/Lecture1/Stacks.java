package Lecture1;

//Custom implementation
public class Stacks {
    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;

    int ptr= -1;

    public Stacks(int size) {
        this.data= new int[size];
    }

    public Stacks() {
        this(DEFAULT_CAPACITY);
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack!");
        }
        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length-1;
    }
    public boolean isEmpty() {
        return ptr == -1;
    }
}
