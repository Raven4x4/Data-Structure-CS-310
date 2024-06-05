
public class Lab7P2 {
    public static void main(String[] args) {
        StackLinked S1 = new StackLinked();
        StackLinked S2 = new StackLinked();
        S1.push(1);
        S1.push(2);
        S1.push(3);
        S1.push(4);
        S1.push(5);
        S1.display();
        System.out.println("-----------------");

        S2.moveAll(S1, S2);
        S2.display();
        System.out.println("-----------------");

        S1.makeEmpty();
        S1.display();
        System.out.println("-----------------");

    }
}

// stack using single linked list
class StackLinked {
    private Node top;
    private int count;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackLinked() {
        this.count = 0;
        this.top = null;
    }

    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
        count++;
    }

    public int pop() {
        if (!isEmpty()) {
            int temp = top.data;
            top = top.next;
            count--;
            return temp;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void display() {
        Node n = top;
        if (isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void makeEmpty() {
        top = null;
        count = 0;
    }

    public void moveAll(StackLinked S1, StackLinked S2) {
        StackLinked temp = new StackLinked();
        while (!S1.isEmpty()) {
            temp.push(S1.pop());
        }
        while (!temp.isEmpty()) {
            S2.push(temp.pop());
        }
    }
}