public class ArrayList {
    private int arr[];
    private int maxSize;
    private int length;

    public ArrayList(int maxSize) {
        if (maxSize <= 0) {
            this.maxSize = 10;
        } else {
            this.maxSize = maxSize;
            this.length = 0;
            this.arr = new int[maxSize];
        }
    }

    boolean isEmpty() {
        return length == 0;
    }

    boolean isFull() {
        return length == maxSize;
    }

    int getSize() {
        return length;
    }

    void insertAtPos(int pos, int element) {
        if (isFull()) {
            System.out.println("List Is Full!!");
        } else if (pos < 0 || pos > length) {
            System.out.println("Out Of Range");
        } else {
            for (int i = length; i > pos; i--) {
                arr[i] = arr[i - 1];
            }
            arr[pos] = element;
            length++;
        }

    }

    void insertAtEnd(int element) {
        if (isFull()) {
            System.out.println("List Is Full");
        } else {
            arr[length] = element;
            length++;
        }
    }

    int search(int element) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -999;
    }

    void insertNoDouble(int element) {
        if (search(element) == -999) {
            insertAtEnd(element);
        } else {
            System.out.println("No Double val Accepted");
        }
    }

    void getElement(int pos) {
        if (pos < 0 || pos > length) {
            System.out.println("Out Of Range");
        } else {
            System.out.println(arr[pos]);
        }
    }

    void removeAtPos(int pos) {
        if (isEmpty()) {
            System.out.println("List Is Empty");
        } else if (pos < 0 || pos > length) {
            System.out.println("Pos Out of Range");
        } else {
            for (int i = pos; i < length; i++) {
                arr[i] = arr[i + 1];
            }
            length--;
        }
    }


    void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}

class Main {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(10);
        al.insertAtPos(0, 10);
        al.insertAtPos(1, 20);
        al.insertAtPos(2, 30);
        al.insertAtPos(3, 40);
        al.insertAtEnd(50);
        al.print();//10 20 30 40 50
        al.removeAtPos(0);
        al.print();//20 30 40 50
        System.out.println(al.search(40));//2
        al.getElement(0);//20
    }
}
