package linked;

import java.util.Enumeration;

public class LInkedDemo {

    private Node head;

    public void insertHead(Integer num) {
        if (num == null) {
            return;
        }
        Node node = new Node(num);
        node.next = head;
        head = node;
    }

    public void insertTail(Integer num) {
        Node nodeTmp = head;
        while (nodeTmp.next != null) {
            nodeTmp = nodeTmp.next;
        }
        nodeTmp.next = new Node(num);
    }


    public Node getNodeByIndex(int index) {
        Node nodeTmp = head;
        int i = 0;
        while (nodeTmp != null) {
            if (i == index) {
                return nodeTmp;
            }else {
                nodeTmp = nodeTmp.next;
            }
            i++;
        }
        return null;
    }

    public void updateNodeByIndex(int index, int number) {
        Node node = getNodeByIndex(index);
        node.number = number;
    }

    /**
     * 根据索引修改
     * @param index
     */
    public void deleteByIndex(int index) {
        Node nodeTmp = head;
        int prevIndex = 0;
        while (nodeTmp != null && prevIndex != index - 1) {
            nodeTmp = nodeTmp.next;
            prevIndex ++;
        }
        if (prevIndex != 0 && nodeTmp != null && nodeTmp.next != null) {
            nodeTmp.next = nodeTmp.next.next;
        }
    }

    public void show() {
        Node nodeTmp =  head;
        while (nodeTmp != null) {
            System.out.print(nodeTmp.number + " ");
            nodeTmp = nodeTmp.next;
        }
        System.out.println();
    }


    public void reverseByPoint() {
        Node nextNode = head;
        while (nextNode != null) {
            nextNode = nextNode.next;
        }
    }


    public void reverseByNewNode() {
        Node nodeTmp = head;
        LInkedDemo lInkedDemo = new LInkedDemo();
        while (nodeTmp != null) {
            lInkedDemo.insertHead(nodeTmp.number);
            nodeTmp = nodeTmp.next;
        }
        head = lInkedDemo.head;
    }

    @Override public String toString() {
        return "LInkedDemo{" + "head=" + head + '}';
    }

    public static void main(String[] args) {
        LInkedDemo lInked =new LInkedDemo();
        lInked.insertHead(5);
        lInked.insertHead(4);
        lInked.insertTail(6);
        lInked.insertTail(7);
        lInked.insertTail(8);
        System.out.println(lInked.toString());
        lInked.deleteByIndex(4);
        System.out.println(lInked.toString());
        Node node = lInked.getNodeByIndex(3);
        System.out.println(node.number);
        lInked.updateNodeByIndex(3, 77);
        System.out.println(lInked.toString());
        lInked.show();
        lInked.reverseByNewNode();
        lInked.show();
        lInked.reverseByNewNode();
        lInked.show();
        lInked.reverseByPoint();
        lInked.show();
    }

    static class Node {
        public Integer number;
        public Node next;
        public Node(Integer number) {
            this.number = number;
        }

        @Override public String toString() {
            return "Node{" + "number=" + number + ", next=" + next + '}';
        }
    }
}
