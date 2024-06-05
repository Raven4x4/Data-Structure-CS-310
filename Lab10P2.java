public class Lab10P2 {
    public static void main(String[] args) {
        QueueDoubleEnded d = new QueueDoubleEnded();
        System.out.println("\nDuoble Linked List Queue:");
        d.enQueueFront("Mohammed");
        d.enQueueRear("Ali");
        d.enQueueFront("Fatimah");
        d.enQueueRear("Zainab");
        d.display();
        d.deQueueRear();
        d.deQueueFront();
        d.display();
    }

}

class QueueDoubleEnded {
    private static class Node {
        private String data;
        private Node next;
        private Node prev;

        Node(String data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        String getData() {
            return data;
        }

        Node getNext() {
            return next;
        }

        Node getPrev() {
            return prev;
        }

        void setData(String data) {
            this.data = data;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void setPrev(Node prev) {
            this.prev = prev;
        }

        public String toString() {
            return data + "";
        }
    }

    private Node front = null, rear = null;
    private int size = 0;

    public QueueDoubleEnded() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node getFront() {
        if (isEmpty())
            return null;
        return front;
    }

    public Node getRear() {
        if (isEmpty())
            return null;
        return rear;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nERROR: Empty Queue!");
            return;
        } // end if
        System.out.print("\n********** Display Queue **************\n");
        Node current = front;
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != front);
        System.out.println("***************************************\n");
    }

    public void enQueueFront(String value) {
        Node newVal = new Node(value, null, null);
        if (isEmpty()) {
            front = newVal;
            rear = front;
        } else {
            front.prev = newVal;
            newVal.next = front;
            front = newVal;
        }
        size++;
        System.out.println(value + " - Added to Queue (enQueueFront)");
    }

    public void enQueueRear(String value) { 
        Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            front = rear = newNode;
            newNode.next = front;
            newNode.prev = front;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            front.prev = newNode;
            newNode.next = front;
            rear = newNode;
        }
        size++;
        System.out.println(value + " - Added to Queue (enQueueRear)");
    }

    public Node deQueueFront() {
        if (isEmpty()) {
            System.out.println("\nERROR: Queue Underflow!");
            return null;
        }
        Node temp = front;
        front = front.next;
        rear.next = front;
        front.prev = rear;
        size--;
        if (size == 0) {
            rear = front = null;
        }
        System.out.println(temp.data + "- Deleted from Queue (deQueueFront)");
        return temp;
    }

    public Node deQueueRear() {
        Node temp = front;
        if (isEmpty())
            System.out.println("Queue is Underflow");
        else {
            rear = temp;
            rear = rear.prev;
            rear.next = null;
            size--;
        }
        if (size == 0) {
            front = null;
            rear = null;
        }
        return temp;
    }

}
