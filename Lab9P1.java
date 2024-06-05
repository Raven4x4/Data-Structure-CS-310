
public class Lab9P1 {

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(4);

        q.enQueue(1);
        q.enQueue(5);
        q.enQueue(12);
        q.enQueue(14);
        q.display();

        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.display();

        q.enQueue(1);
        q.enQueue(5);
        q.enQueue(12);
        q.enQueue(14);
        q.display();

    }
}

class LinearQueue {

    private int count = 0;
    private int front = 0;
    private int rear = 0;
    private int[] queue;

    LinearQueue(int capacity) {
        queue = new int[capacity];
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
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
        if (isEmpty()) {
            System.out.println("Empty Queue!");
            return -1;
        }
        return queue[rear - 1];
    }

    public void display() {
        System.out.println("\n***** Display Queue ****");
        if (isEmpty()) {
            System.out.println("\nEmpty Queue!\n");
            System.out.println("************************\n");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.println(queue[i]);
        }
        System.out.println("************************\n");
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overfllow!");
            return;
        }

        queue[rear] = value;
        rear++;
        count++;
        System.out.println(value + " Added to Queue");
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        int temp = queue[front];
        front++;
        count--;
        System.out.println(temp + " Deleted from Queue");

        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        return temp;
    }
}
