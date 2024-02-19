public class DoublyLinkedList {
    private Node first, last;
    private int length;

    public DoublyLinkedList() {
        this.first = this.last = null;
        this.length = 0;
    }

    boolean isEmpty() {
        return length == 0;
    }

    void insertAtFirst(int element) {
        Node newNode = new Node();
        newNode.data = element;
        if (isEmpty()) {
            first = last = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            newNode.next = first;
            newNode.prev = null;
            first.prev = newNode;
            first = newNode;

        }
        length++;
    }

    void insertLst(int element) {
        Node newNode = new Node();
        newNode.data = element;
        if (isEmpty()) {
            first = last = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            newNode.next = null;
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    void insertAt(int pos, int element) {
        if (pos < 0 || pos > length) {
            System.out.println("Out of Range");
            return;
        }
        if (pos == 0) {
            insertAtFirst(element);
        } else if (pos == length) {
            insertLst(element);
        } else {
            Node newNode = new Node();
            newNode.data = element;
            Node curr = first;
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next = newNode;
            curr.next.prev = newNode;
            length++;

        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Empty ll !!");
            return;
        } else if (length == 1) {
            last = first = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        length--;
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Empty ll !!");
            return;
        } else if (length == 1) {
            last = first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        length--;
    }

    void remove(int element) {
        if (isEmpty()) {
            System.out.println("Empty!!");
            return;
        } else if (first.data == element) {
            removeFirst();
        } else {
            Node curr = first.next;
            while (curr != null) {
                if (curr.data == element)
                    break;
                curr = curr.next;
            }
            if (curr == null) {
                System.out.println("Not found");
                return;
            } else if (curr.next == null) {
                removeLast();
            } else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                length--;
            }
        }
    }

    void print() {
        Node curr = first;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    void printAtRev() {
        Node curr = last;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;
    Node prev;
}

class Main{
    public static void main(String[] args) {
        DoublyLinkedList dll= new DoublyLinkedList();
        dll.insertLst(10);
        dll.insertLst(20);
        dll.insertLst(30);
        dll.insertLst(40);
        dll.print();//10 20 30 40
        dll.insertAtFirst(9);
        dll.insertAtFirst(8);
        dll.print();//8 9 10 20 30 40
        dll.insertAt(2,11);
        dll.print();//8 9 10 11 20 30 40
        dll.removeFirst();
        dll.removeLast();
        dll.remove(11);
        dll.print();//9 10 11 20 30

    }
}

