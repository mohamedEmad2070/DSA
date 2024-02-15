class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedStack {
    private Node top;

    public LinkedStack() {
        this.top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int data) { // add elements to stack
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Error!! Stack is Empty");
            return -1;
        }
        int valueDel = top.data;
        top = top.next;
        return valueDel;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Error!! Stack is Empty");
            return -1;
        }
        return top.data;

    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();

    }
}

class Main {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print(); // Output: [30 20 10]
        System.out.println( stack.peek()); // Output: 30
        System.out.println(stack.pop()); // Output: 30
        stack.print(); // Output: [20 10]
    }
}


