package linked;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import sun.awt.windows.WPrinterJob;

import javax.swing.*;

public class TwoLinked {
    public Node head;
    private Node tail;

    public void insertHead(Integer number) {
        Node node = new Node(number);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void insertTail(Integer number) {
        Node node = new Node(number);
        if (tail == null) {
            head = node;
            tail = node;
        }else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void showByNext() {
        Node node = head;
        while (node != null) {
            System.out.print(node.number + " ");
            node = node.next;
        }
        System.out.println();
    }


    public void showByTail() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.number + " ");
            node = node.prev;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TwoLinked linked = new TwoLinked();
        linked.insertHead(4);
        linked.insertHead(3);
        linked.insertHead(2);
        linked.insertHead(1);
        linked.showByNext();
        linked.insertTail(5);
        linked.insertTail(6);
        linked.insertTail(7);
        linked.insertTail(8);
        linked.showByNext();
        linked.showByTail();
    }

    public class Node {
        public Node(int number) {
            this.number = number;
        }

        public int number;
        public Node prev;
        public Node next;
    }
}
