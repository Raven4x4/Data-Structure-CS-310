public class Lab10P1 {
    public static void main(String[] args) {
        QueueLinkedList s = new QueueLinkedList();
        System.out.println("\nSingel Linked List Queue:");
        s.enQueue(5);
        s.enQueue(12);
        s.enQueue(14);
        s.display();

        s.deQueue();
        s.deQueue();
        s.deQueue();
        s.display();
    }

}

class QueueLinkedList {

    private static class Node  {
        private int data;
        private Node  next;

        public Node(int data, Node  next) {
            this.data = data;
            this.next = next;
        }

        int getData() {
            return data;
        }

        Node  getNext() {
            return next;
        }

        void setData(int data) {
            this.data = data;
        }

        void setNext(Node  next) {
            this.next = next;
        }

        public String toString() {
            return data + "";
        }
    }

    private Node  front = null, rear = null;
    private int size = 0;

    public QueueLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node  getFront() {
        if (isEmpty())
            return null;
        return front;
    }

    public Node  getRear() {
        if (isEmpty())
            return null;
        return rear;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("\n********** Display Queue **************");
        Node current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
        System.out.println("***************************************\n");
    }

    public void enQueue(int value) {
        Node newnode = new Node(value, null);
        if (isEmpty()) {
            front = rear = newnode;
        } else {
            rear.next = newnode;
            rear = newnode;
        }
        size++;
        System.out.println(value + " Added to Queue");
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return 0;
        }
        int temp = front.data;
        front = front.next;
        size--;
        if (size == 0) {
            rear = null;
        }
        System.out.println(temp + " Deleted from Queue");
        return temp;
    }
}
