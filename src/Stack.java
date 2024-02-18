public class Stack {
    int top;
    int maxSize = 100;
    int item[] = new int[maxSize];

    public Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int val) {
        if (top > maxSize) {
            System.out.println("Stack Is Full");
        } else {
            top++;
            item[top] = val;
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Is Empty");
        } else {
            top--;
        }
    }
    int getPop() {
        int val;
        if (isEmpty()) {
            System.out.println("Stack Is Empty");
            return 0;
        } else {
            val = item[top];
            top--;
            return val;
        }
    }

    int getTop() {
        int val;
        if (isEmpty()) {
            System.out.println("Stack Is Empty");
            return 0;
        } else {
            val = item[top];
            return val;
        }
    }

    void print(){
        System.out.print("[ ");
        for (int i = top; i >= 0 ; i--) {
            System.out.print(item[i]+" ");

        }
        System.out.print("]");
        System.out.println();

    }


}
class Main {
    public static void main(String[] args) {
    Stack s =new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.print();
    System.out.println(s.getPop());
    s.print();
    }
}
