public class Lab8P2 {
    public static void main(String[] args){
        StackArray stack = new StackArray(10);
        int number = 8;
        while (number > 0) {
            int digit = number % 2;
            stack.push(digit);
            number = number / 2;
        }
        System.out.print("Binary equivalent: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}

class StackArray {
    private int cap;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        cap = size;
        stackArray = new int[cap];
        top = -1;
    }

    public void push(int digit) {
        if (isFull())
        {
            System.err.println("overflow");
            return;
        }
        stackArray[++top] = digit;
    }

    public int pop() {
        if (isEmpty()){
            System.out.println("underflow");
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull(){
        return (top+1 == cap);
    }
}
