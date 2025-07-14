package Lecture1;

public class CircularQueue {
    //Internally it will be an array
    //We only consider what is between the front and the end
    //All the other elements that is present will be overridden
    //Inserting, we move end (at last)| deleting, we move start (from first)
    //When last element reaches, we use e% size
    //Insertion and removal takes O(1) time here
    //Only display takes O(n) complexity

    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;

    protected int front=0;
    protected int end=0;
    private int size=0;

    public CircularQueue(int size) {
        this.data= new int[size];
    }
    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public boolean insert(int item){
        if (isFull()){
            System.out.println("Queue is full!");
            return false;
        }
        data[end++]=item;
        end= end % (data.length);
        size++;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int removed = data[front]++;
        front= front%data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return data[front];
    }

    public boolean isFull() {
        return size == data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i%=data.length;
        }while(i!=end);
        System.out.println("END");
    }
}
