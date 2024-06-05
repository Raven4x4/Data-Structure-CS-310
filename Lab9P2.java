
public class Lab9P2 {

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);

        q.enQueue(1);
        q.enQueue(5);
        q.enQueue(12);
        //q.enQueue(14);
        q.display();

        q.deQueue();
        q.deQueue();
        //q.deQueue();
        q.display();
        
        q.enQueue(1);
        q.enQueue(5);
        //q.enQueue(12);
        q.display();

    }
}

class CircularQueue {

    private int size = 0;
    private int count = 0;
    private int front = 0;
    private int rear = 0;
    private int[] queue;

    CircularQueue(int capacity) {
        queue = new int[capacity];
        size = capacity;
    }

    public boolean isFull() {
        return size == count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (rear == 0 && count != 0) {
            return queue[size - 1];
        }
        return queue[rear - 1];
    }

    public void display() {
        System.out.println("\n***** Display Queue ****");
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return;
        }
        int i = front;
        do{
            System.out.println(queue[i]);
            i = (i+1)%size;            
        }while(i != rear % size);    
        System.out.println("************************\n");
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
        count++;
        System.out.println(value + " Added to Queue");
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        int temp = queue[front];
        front = (front + 1) % size;
        System.out.println(temp + " Deleted from Queue");
        count--;
        return temp;
    }
}
