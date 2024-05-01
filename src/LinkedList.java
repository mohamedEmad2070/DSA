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
            insertFirst(element);
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

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList Is Empty");
        } else if (length == 1) {
            last = first = null;
            length--;
        } else {
            first = first.next;
            length--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("LinkedList Is Empty");
        } else if (length == 1) {
            last = first = null;
            length--;
        } else {
            Node curr = first.next;
            Node prv = first;
            while (curr != last) {
                prv = curr;
                curr = curr.next;
            }
            prv.next = null;
            last = prv;
            length--;
        }

    }

    void removeElement(int element) {
        if (isEmpty()) {
            System.out.println("LinkedList Is Empty");
            return;
        } else if (first.data == element) {
            first = first.next;
            if (length == 0)
                last = null;
        } else {
            Node curr, prev;
            curr = first.next;
            prev = first;
            while (curr != null) {
                if (curr.data == element) {
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (curr == null) {
                System.out.println("Not Found!!");
            } else {
                prev.next = curr.next;
                if (last == curr)
                    last = prev;
                length--;
            }

        }

    }

    void reverse() {
        Node prev, next, curr;
        prev = null;
        curr = first;
        next = curr.next;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            first = prev;
        }
    }

    int search(int element) {
        Node curr = first;
        int pos = 0;
        while (curr != null) {
            if (curr.data == element) {
                return pos;
            }
            curr = curr.next;
            pos++;
        }
        return -999;


    }


}

class Node {
    int data;
    Node next;
}


class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(0, 10);
        ll.insertAtPos(1, 20);
        ll.insertAtPos(2, 30);
        ll.print();// 10 20 30
        ll.insertEnd(40);
        ll.insertEnd(50);
        ll.print();// 10 20 30 40 50
        ll.insertFirst(9);
        ll.insertFirst(8);
        ll.print();//8 9 10 20 30 40 50
        ll.removeFirst();
        ll.print();//9 10 20 30 40 50
        ll.removeLast();
        ll.print();//9 10 20 30 40
        ll.removeElement(10);
        ll.print();//9 20 30 40
        ll.reverse();
        ll.print();//40 30 20 9
        System.out.println(ll.search(20));//2
    }
}
