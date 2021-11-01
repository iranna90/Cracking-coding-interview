package stacks;

public class StackWIthMin {

    private final NodeWithMin[] data;
    private final int size;
    private int index = -1;

    public StackWIthMin(int size) {
        this.data = new NodeWithMin[size];
        this.size = size;
    }

    public void push(int item) {
        NodeWithMin nodeWithMin;
        if (index == size - 1) {
            System.out.println("Overflow");
            return;
        }

        if (index == -1) {
            nodeWithMin = new NodeWithMin(item, item);
        } else {
            NodeWithMin previous = data[index];
            int min = Math.min(item, previous.min);
            nodeWithMin = new NodeWithMin(item, min);
        }


        index++;
        data[index] = nodeWithMin;
    }


    public int pop() {
        if (index == -1) {
            return -1;
        }

        NodeWithMin result = data[index];
        data[index] = null;
        index--;
        return result.data;
    }

    public int min() {
        if (index == -1) {
            return -1;
        }

        return data[index].min;
    }

    private static class NodeWithMin {
        private final int data;
        private final int min;

        private NodeWithMin(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        StackWIthMin stack = new StackWIthMin(9);
        stack.push(3);
        stack.push(9);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(7);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
    }
}
