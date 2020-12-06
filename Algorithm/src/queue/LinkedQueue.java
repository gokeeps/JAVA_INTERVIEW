package queue;

public class LinkedQueue<T> {


    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insert(T val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        }else {
            Node nodeTmp = head;
            while (nodeTmp.next != null) {
                nodeTmp = nodeTmp.next;
            }
            nodeTmp.next = node;
        }
    }

    public T pop() {
        Node nodeTmp = head;
        head = nodeTmp.next;
        return nodeTmp.val;
    }


    public boolean isEmpty () {
        return head == null;
    }


    @Override public String toString() {
        return "LinkedQueue{" + "head=" + head + '}';
    }

    private final class Node {
        private T val;
        private Node next;

        public Node(T val) {
            this.val = val;
        }

        @Override public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
