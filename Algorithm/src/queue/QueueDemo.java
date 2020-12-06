package queue;

import java.util.Arrays;

public class QueueDemo {

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);
        queue.offset(1);
        queue.offset(2);
        queue.offset(3);
        queue.offset(4);
        queue.offset(5);
        System.out.println(queue.toString());
        int num = queue.pop();
        System.out.println(num);
        System.out.println(queue);
        int num2 = queue.peek();
        System.out.println(num2);
        System.out.println(queue);
    }
    static class Queue {
        // 队列长度
        private int length;
        // 最大长度
        private final int size;
        // 元素值
        private final int[] value;


        public Queue(int size) {
            this.size = size;
            this.length = 0;
            this.value = new int[size];
        }


        /**
         * 向队列里面添加
         * @param val
         */
        public void offset(int val) throws Exception {
            if (isFull()) {
                throw new Exception("队列已经满了");
            }
            this.value[length] = val;
            this.length ++;
        }


        public int pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列是空");
            }
            int res = this.value[length - 1];
            this.value[length - 1] = 0;
            length --;
            return res;
        }

        public int peek() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列是空");
            }
            return this.value[length - 1];
        }
        public boolean isEmpty() {
            return length == 0;
        }
        public boolean isFull() {
            return size == length;
        }

        @Override public String toString() {
            return "Queue{" + "length=" + length + ", size=" + size + ", value=" + Arrays.toString(value) + '}';
        }

        public int getSize() {
            return size;
        }

        public int[] getValue() {
            return value;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
