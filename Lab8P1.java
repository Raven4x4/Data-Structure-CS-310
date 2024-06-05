import java.util.Scanner;
public class Lab8P1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackArray stack = new StackArray(50);
        System.out.println("Please enter an expression with parentheses: ");
        String expression = input.nextLine();

        if (stack.missingBrackets(expression)) {
            System.out.println("Your expression is correct and balanced.");
        } else {
            System.out.println("Your expression is incorrect. Unbalanced parentheses.");
        }

    }
}

class StackArray {

    int top;
    int Stack[];
    int Arraysize;

    public StackArray(int size) {
        Stack = new int[size];
        top = -1;
        Arraysize = size;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    

    public int makeEmpty() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.. Cannot proceed.");
            return -1;
        } else {
            return top = -1;
        }
    }

    public boolean isFull() {
        return (size() == Arraysize);
    }

    public int size() {
        return top + 1;
    }

    public int Top() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return -1;
        }
        return Stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Stack.");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(Stack[i]);
        }
        System.out.println();
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow..");
            return;
        }

        top++;
        Stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow..");
            return -1;
        }
        int temp = Stack[top];
        top--;
        return temp;
    }

    public boolean missingBrackets(String expression) {
        StackArray stack = new StackArray(expression.length());
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = (char) stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    
}
