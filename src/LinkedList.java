public class LinkedList {
    private Node first;
    private Node last;
    private int length;

    public LinkedList() {
        this.first = this.last = null;
        this.length = 0;
    }

    boolean isEmpty() {
        return length == 0;
    }

    void insertFirst(int element) {
        Node newNode = new Node();
        newNode.data = element;
        if (isEmpty()) {
            first = last = newNode;
            newNode.next = null;
        } else {
            newNode.next = first;
            first = newNode;
        }
        length++;
    }

    void insertEnd(int element) {
        Node newNode = new Node();
        newNode.data = element;
        if (isEmpty()) {
            first = last = newNode;
            newNode.next = null;
        } else {
            last.next = newNode;
            newNode.next = null;
            last = newNode;
        }
        length++;
    }

    void insertAtPos(int pos, int element) {
        if (pos < 0 || pos > length) {
            System.out.println("Out Of Range");
            return;
        }
        Node newNode = new Node();
        newNode.data = element;
        if (pos == 0) {
            insertEnd(element);
        } else if (pos == length) {
            insertEnd(element);
        } else {
            Node curr = first;
            for (int i = 1; i < pos; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            length++;
        }

    }

    void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}

class Node {
    int data;
    Node next;
}

class Main{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(0,10);
        ll.insertAtPos(1,20);
        ll.insertAtPos(2,30);
        ll.print();// 10 20 30
        ll.insertEnd(40);
        ll.insertEnd(50);
        ll.print();// 10 20 30 40 50
        ll.insertFirst(9);
        ll.insertFirst(8);
        ll.print();//8 9 10 20 30 40 50
    }
}
