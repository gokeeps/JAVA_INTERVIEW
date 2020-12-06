package stack;

import java.util.Arrays;

public class StackDemo {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.toString());
        int num = stack.pop();
        System.out.println(num);
        System.out.println(stack.toString());
        System.out.println(stack.peek());
    }

    static class Stack {
        private int size;
        private final int[] values;
        private int length;

        public Stack() {
            this.size = 16;
            this.length = 0;
            values = new int[this.size];
        }

        public Stack(int size) {
            this.size = size;
            values = new int[this.size];
            length = 0;
        }

        public void add(int val) throws Exception {
            if (values.length == length) {
                throw new Exception("超过栈的深度");
            }
            for (int i = length - 1; i >= 0; i--) {
                values[i + 1] = values[i];
            }
            values[0] = val;
            length ++;
        }

        public int pop() throws Exception {
            if (length == 0) {
                throw new Exception("无元素");
            }
            int stack = this.values[0];
            for (int i = 0; i < length - 1; i++) {
                values[i] = values[i + 1];
            }
            values[length - 1] = 0;
            length --;
            return stack;
        }


        public int peek() throws Exception {
            if (length == 0) {
                throw new Exception("无元素");
            }
            return values[0];
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override public String toString() {
            return "Stack{" + "size=" + size + ", values=" + Arrays.toString(values) + ", length=" + length + '}';
        }
    }
}
