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

}

class Node {
    int data;
    Node next;
    Node prev;
}

