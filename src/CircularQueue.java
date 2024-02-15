public class CircularQueue {
    private int front;
    private int rear;
    private int length;
    private int maxSize = 100;
    private int arr[] = new int[maxSize];

    public CircularQueue() {
        this.front = 0;
        this.rear = maxSize - 1;
        this.length = 0;
    }

    boolean isEmpty() {
        return length == 0;
    }

    boolean isFull() {
        return length == maxSize;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Is Full !!");
        } else {
            rear = (rear + 1) % maxSize;
            arr[rear] = data;
            length++;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Is Empty !!");
        } else {
            front = (front + 1) % maxSize;
            length--;
        }
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue Is Empty !!");
            return -1000;
        } else
            return arr[front];
    }

    int getRear() {
        if (isEmpty()) {
            System.out.println("Queue Is Empty !!");
            return -1000;
        } else
            return arr[rear];
    }

    void print() {
        int temp = front - 1;
        while (temp != rear) {
            temp = (temp + 1) % maxSize;
            System.out.print(arr[temp] + " ");
        }
        System.out.println();
    }

}

class M {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.print();//10 20 30 40
        q.dequeue();
        q.print();//20 30 40
        System.out.println(q.getFront());//20
        System.out.println(q.getRear());//40

    }
}

