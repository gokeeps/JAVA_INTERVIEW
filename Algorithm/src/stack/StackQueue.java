package stack;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;
import java.util.TreeMap;

public class StackQueue {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
        queue.push(5);
        queue.push(6);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }

    }

    public static class Queue {
        private Stack<Integer> from = new Stack<>();
        private Stack<Integer> to = new Stack<>();

        public boolean isEmpty() {
            return from.isEmpty() && to.isEmpty();
        }
        public void push(Integer num) {
            from.push(num);
        }


        public Integer pop() {
            if (to.isEmpty()) {
                while (!from.isEmpty()) {
                    to.push(from.pop());
                }
            }
            return to.pop();
        }

        public Stack<Integer> getTo() {
            return to;
        }

        public void setTo(Stack<Integer> to) {
            this.to = to;
        }

        public Stack<Integer> getFrom() {
            return from;
        }

        public void setFrom(Stack<Integer> from) {
            this.from = from;
        }

        @Override public String toString() {
            return "Queue{" + "from=" + from + ", to=" + to + '}';
        }
    }
}
