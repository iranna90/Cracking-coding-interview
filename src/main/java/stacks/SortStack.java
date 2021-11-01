package stacks;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(6);
        stack.push(5);
        stack.push(1);
        stack.push(9);
        stack.push(3);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static class SortedStack {
        private final Stack<Integer> data;
        private final Stack<Integer> temp;

        private SortedStack() {
            this.data = new Stack<>();
            this.temp = new Stack<>();
        }

        public void push(int item) {
            if (data.isEmpty()) {
                data.push(item);
                return;
            }

            while (!data.isEmpty() && data.peek() < item) {
                temp.push(data.pop());
            }

            // either empty or the item at the top is greater, push the current item
            data.push(item);

            // now push back all the values from temp
            while (!temp.isEmpty()) {
                data.push(temp.pop());
            }
        }

        public int pop() {
            if (data.isEmpty()) {
                return -1;
            }

            return data.pop();
        }

        public int peek() {
            if (data.isEmpty()) {
                return -1;
            }

            return data.peek();
        }

        public void print() {
            data.forEach(System.out::println);
        }
    }
}
