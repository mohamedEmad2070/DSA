public class LinkedQueue {
    private Node front;
    private Node rear;
    private int length;

    public LinkedQueue() {
        this.front = this.rear = null;
        this.length = 0;
    }

    boolean isEmpty() {
        return length == 0;
    }

    void enQueue(int val) {
        Node newNode = new Node();
        newNode.item = val;
        newNode.next = null;
        if (isEmpty()) {
            rear = front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }

    void deQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue !!");
        }
        int temp = front.item;
        front = front.next;
        length--;
        if (isEmpty()) {
            rear = null;
        }
    }

    int getFront() {
        if (isEmpty()) {
            return -999;
        } else
            return front.item;
    }

    int getRear() {
        if (isEmpty()) {
            return -999;
        } else
            return rear.item;
    }

    void print() {
        Node cur = front;
        while (cur != null) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class Node {
    int item;
    Node next;
}


class Main {
    public static void main(String[] args) {
        LinkedQueue q1 = new LinkedQueue();
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.print();//10 20 30 40 50
        q1.deQueue();
        q1.print();//20 30 40 50
        System.out.println(q1.getFront());//20
        System.out.println(q1.getRear());//50

    }
}