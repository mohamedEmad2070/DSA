public class LinkedStack<T> {
    private Node<T> top;

    public LinkedStack() {
        this.top = null;
    }
    public void push(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(top);
        top=newNode;
    }
    public T pop(){
        if (top==null){
            System.out.println("Stack Is Empty");
        }
        Node<T> popedNode= top;
        top = top.getNext();
        return popedNode.getData();
    }

    public T peek(){
        if (top==null){
            System.out.println("Stack Is Empty");
        }

        return top.getData();
    }
    public boolean isEmpty() {
        return top == null;
    }
    public  void printLinkedStack(LinkedStack<T> stack) {
        Node<T> currentNode = stack.top;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.getData()+" ");
            currentNode = currentNode.getNext();
        }
        System.out.print("]");
        System.out.println();
    }



}


class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data=data;
            this.next=null;

        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;

        }
    }



 class M {
    public static void main(String[] args) {
        LinkedStack<Integer> l = new LinkedStack<>();
        l.push(1);
        l.push(2);
        l.push(3);
        l.push(4);
        l.printLinkedStack(l);//[4 3 2 1 ]
        l.pop();
        l.printLinkedStack(l);//[3 2 1 ]
        System.out.println(l.peek());//3
    }
}


