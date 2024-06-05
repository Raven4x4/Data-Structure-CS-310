
public class Lab7P1 {

    public static void main(String[] args) {

        StackArray s = new StackArray(6);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.display();

        s.shift(2);
        s.display();
         
        System.out.println("Count of 3: " + s.count(3) + "\n");
        
        s.removeLastTimes(2);
        s.display();
        
        s.removeFirstTimes(2);
        s.display();
        
        s.reverse();
        s.display();
         

    }

}

class StackArray {

    int top;
    int[] stack;
    int UB;

    public StackArray(int capacity) {
        stack = new int[capacity];
        top = -1;
        UB = capacity;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == UB);
    }

    public int size() {
        return top + 1;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return -1;
        } else {
            return stack[top];
        }
    }

    public void display() {
        System.out.println("----- Display Method -----");

        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = top; k >= 0; k--) {
                System.out.println(stack[k]);
            }
            System.out.println();
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow..");
            return;
        } else {
            top = top + 1;
            stack[top] = value;
            System.out.println(value + " PUSHED into stack");
            return;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack Underflow..");
            return 0;
        } else {
            int temp = stack[top];
            top = top - 1;
            System.out.println(temp + " POPPED from stack");
            return temp;
        }
    }

    public void shift(int n) {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k < n; k++) {
                int temp = stack[top];
                for (int i = top; i > 0; i--) {
                    stack[i] = stack[i - 1];
                }
                stack[0] = temp;
            }
        }
    }

    public int count(int value) {
        int count = 0;
        for (int k = 0; k <= top; k++) {
            if (stack[k] == value) {
                count++;
            }
        }
        return count;
    }

    public void multiply(int n) {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k <= top; k++) {
                stack[k] = stack[k] * n;
            }
        }
    }

    public void removeFirstTimes(int n) {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k < n; k++) {
                pop();
            }
        }
    }

    public void removeLastTimes(int n) {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < top; i++) {
                    stack[i] = stack[i + 1];
                }
                top--;
            }
        }
    }

    public void reverse() {
        int[] temp = new int[size()];
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k <= top; k++) {
                temp[k] = stack[k];
            }
            for (int k = 0; k <= top; k++) {
                stack[k] = temp[top - k];
            }
        }
    }

    public void reverseFirstN(int n) {
        int[] temp = new int[n];
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        } else {
            for (int k = 0; k < n; k++) {
                temp[k] = stack[k];
            }
            for (int k = 0; k < n; k++) {
                stack[k] = temp[n - k - 1];
            }
        }
    }
}
