package Lecture1;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue(7);
        cq.insert(1);
        cq.insert(2);
        cq.display();
        cq.insert(3);
        cq.insert(4);
        cq.insert(5);
        cq.insert(6);
        cq.insert(7);
        cq.display();
        System.out.println(cq.remove());
        cq.display();
        cq.remove();
        cq.display();
        System.out.println(cq.front());
    }
}
