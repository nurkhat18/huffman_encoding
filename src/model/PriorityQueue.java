// Structure for the elements in the priority queue
class Item {
    public char letter;
    public int priority;

    public Item(char letter, int priority) {
        this.letter = letter;
        this.priority = priority;
    }
}

class PriorityQueue {
    private Item[] queue;
    private int size;

    public PriorityQueue(int capacity) {
        queue = new Item[capacity];
        size = 0;
    }

    public void enqueue(char letter, int priority) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        Item newItem = new Item(letter, priority);
        queue[size] = newItem;
        size++;
        heapifyUp();
    }
    
    public char peek() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot peek.");
            return '\0'; // Null character as a placeholder
        }

        return queue[0].letter;
    }
    
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        queue[0] = queue[size - 1];
        size--;
        heapifyDown();
    }

    private void heapifyUp() {
        int current = size - 1;
        int parent = (current - 1) / 2;
        while (current > 0 && queue[current].priority > queue[parent].priority) {
            Item temp = queue[current];
            queue[current] = queue[parent];
            queue[parent] = temp;

            current = parent;
            parent = (current - 1) / 2;
        }
    }
    
    private void heapifyDown() {
        int current = 0;
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        int largest = current;

        while (leftChild < size) {
            if (leftChild < size && queue[leftChild].priority > queue[largest].priority) {
                largest = leftChild;
            }
            if (rightChild < size && queue[rightChild].priority > queue[largest].priority) {
                largest = rightChild;
            }

            if (largest != current) {
                Item temp = queue[current];
                queue[current] = queue[largest];
                queue[largest] = temp;

                current = largest;
                leftChild = 2 * current + 1;
                rightChild = 2 * current + 2;
            } else {
                break;
            }
        }
    }

//    public static void main(String[] args) {
//        PriorityQueue priorityQueue = new PriorityQueue(100);
//        priorityQueue.enqueue('A', 2);
//        priorityQueue.enqueue('B', 4);
//        priorityQueue.enqueue('C', 4);
//        priorityQueue.enqueue('D', 3);
//        char topElement = priorityQueue.peek();
//        System.out.println(topElement);
//        priorityQueue.dequeue();
//        topElement = priorityQueue.peek();
//        System.out.println(topElement);
//        priorityQueue.dequeue();
//        topElement = priorityQueue.peek();
//        System.out.println(topElement); }
}
