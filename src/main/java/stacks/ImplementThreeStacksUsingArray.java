package stacks;

public class ImplementThreeStacksUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(9);
        stack.push(1, 9);
        stack.push(2, 9);
        stack.push(3, 9);
        stack.push(3, 8);
        stack.push(3, 7);
        stack.push(3, 9);

        System.out.println(stack.pop(3));
        stack.push(3, 100);
        System.out.println(stack.pop(1));
        stack.push(1, 200);
        stack.push(1, 300);


        DynamicStack ds = new DynamicStack(9);
        ds.push(1,11);
        ds.push(1,12);
        ds.push(1,13);
        ds.push(1,14);
        ds.push(2,21);
        ds.push(2,22);
        ds.push(2,23);

        System.out.println(ds.pop(1));
        ds.push(3,31);
        ds.push(3,32);
        ds.push(3,33);
        System.out.println(ds.pop(2));
        ds.push(3, 33);

        System.out.println();
    }

    // [0,1,2,3,4,5,6,7,8]
    // this uses fixed size for each of the stack, resulting memory not fully utilized.
    private static class Stack {
        private final int[] array;

        private final int eachStackSize;
        int[] indexes = {0, 0, 0};


        private Stack(int arraySize) {
            this.array = new int[arraySize];
            eachStackSize = arraySize / 3;
        }

        public void push(int stackNumber, int item) {
            int currentIndex = indexes[stackNumber - 1];
            if (currentIndex == eachStackSize) {
                return;
            }

            int startIndex = (stackNumber - 1) * eachStackSize;
            currentIndex = currentIndex + 1;
            indexes[stackNumber - 1] = currentIndex;
            int overallIndex = startIndex + (currentIndex - 1);
            array[overallIndex] = item;
        }

        public int pop(int stackNumber) {
            int currentIndex = indexes[stackNumber - 1];
            if (currentIndex == 0) {
                return -1;
            }

            int indexInActualArray = (stackNumber - 1) * eachStackSize + (currentIndex - 1);
            indexes[currentIndex - 1]--;
            return array[indexInActualArray];
        }
    }

    // the items in the stack can be stored in random order,
    // only thing at the end we need to know where the last element is
    // and each element needs to know where is the previous element of this stack.
    private static class DynamicStack {
        private static class StackNode {
            private final int data;
            private final int previousElementIndex;

            private StackNode(int data, int previousElementIndex) {
                this.data = data;
                this.previousElementIndex = previousElementIndex;
            }
        }


        private  final int[] indexes = {-1, -1, -1};
        private final StackNode[] data;
        private final int totalSize;
        private int totalIndex = 0;


        public DynamicStack(int size) {
            data = new StackNode[size];
            this.totalSize = size;
        }

        public void push(int stackNumber, int value) {
            if (totalIndex == totalSize) {
                System.out.println("Overflow.");
                return;
            }

            int previousNodeIndex = indexes[stackNumber - 1];
            StackNode node = new StackNode(value, previousNodeIndex);
            data[totalIndex] = node;
            indexes[stackNumber - 1] = totalIndex;
            totalIndex++;
        }

        public int pop(int stackNumber) {
            int index = indexes[stackNumber - 1];

            if (index == -1) {
                return -1;
            }

            StackNode node = data[index];
            data[index] = null;

            indexes[stackNumber -1] = node.previousElementIndex;
            totalIndex--;

            return node.data;
        }
    }
}
