package linked;

public class OneLInked {

    /**
     * 必须保证head有元素
     */
    public Node head;

    public int len;

    /**
     * 从头部插入
     *
     * @param number
     */
    public void insertForHead(int number) {
        Node node = new Node(number);
        if (head == null) {
            head = node;
        } else {
            Node nextNode = head;
            head = node;
            head.next = nextNode;
        }
        len++;
    }

    public void insertForTail(int number) {
        Node node = new Node(number);
        if (head == null) {
            head = node;
        } else {
            Node nodeTmp = head;
            while (nodeTmp.next != null) {
                nodeTmp = nodeTmp.next;
            }
            nodeTmp.next = node;
            len++;
        }
    }

    public void deleteForIndex(int index) {
        if (head == null) {
            return;
        }
        if (index > len - 1) {
            return;
        }
        int i = 0;
        Node tempNode = head;
        Node prevNode = null;
        while (tempNode != null) {
            if (i == index) {
                if (prevNode == null) {
                    head = null;
                    len--;
                } else {
                    prevNode.next = tempNode.next;
                    len--;
                }
                break;
                // 处理
            } else if (i == index - 1) {
                prevNode = tempNode;
                tempNode = tempNode.next;
            } else {
                tempNode = tempNode.next;
            }
            i++;
        }
    }

    public void updateForIndex(int index, int number) {
        Node node = getNodeWithIndex(index);
        node.number = number;
    }

    public Node getNodeWithIndex(int index) {
        if (head == null) {
            return null;
        }
        if (index > len - 1) {
            return null;
        }
        int i = 0;
        Node tempNode = head;
        while (tempNode != null) {
            if (i == index) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
                i++;
            }
        }
        return null;
    }

    public void clean() {
        head = null;
        len = 0;
    }

    public void showNumbersForHead() {
        if (head == null) {
            System.out.println("No nodes");
            return;
        }
        Node nodeTmp = head;
        System.out.println("遍历结果: ");
        while (nodeTmp != null) {
            System.out.println(nodeTmp.number);
            nodeTmp = nodeTmp.next;
        }
    }

    @Override public String toString() {
        return "OneLInked{" + "head=" + head + ", len=" + len + '}';
    }

    public static void main(String[] args) {
        OneLInked lInked = new OneLInked();
        lInked.insertForHead(4);
        lInked.insertForHead(3);
        lInked.insertForHead(2);
        lInked.insertForHead(1);
        System.out.println(lInked.toString());
        lInked.showNumbersForHead();
        System.out.println("查找第n个元素: " + lInked.getNodeWithIndex(3));
        System.out.println("单向链表长度: " + lInked.len);
        lInked.deleteForIndex(2);
        System.out.println("删除第n个元素: " + lInked.toString());
        System.out.println(lInked.len);
        lInked.updateForIndex(2, 44);
        System.out.println(lInked.toString());
        lInked.clean();
        System.out.println(lInked.toString());
        lInked.insertForTail(4);
        lInked.insertForTail(3);
        lInked.insertForTail(2);
        lInked.insertForTail(1);
        System.out.println(lInked.toString());
    }

    public static class Node {
        public Node(int number) {
            this.number = number;
        }

        private int number;
        private Node next;

        @Override public String toString() {
            return "Node{" + "number=" + number + ", next=" + next + '}';
        }
    }
}
