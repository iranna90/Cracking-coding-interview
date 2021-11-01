package stacks;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        System.out.println(queue.deque());
        queue.enque(9);
        queue.enque(8);
        queue.enque(7);
        System.out.println(queue.peek());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
    }

    private static class Queue {
        private final Stack<Integer> s1;
        private final Stack<Integer> s2;

        private Queue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void enque(int item) {
            s1.push(item);
        }

        public int deque() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()) {
                return -1;
            }

            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()) {
                return -1;
            }
            return s2.peek();
        }
    }
}
