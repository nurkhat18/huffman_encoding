package model;
// This class is to build a priority queue and use it for building Huffman tree
// Structure for the elements in the priority queue
class Item {
    // creat a class that has priority and letter
    public char letter;
    public int priority;

    public Item(char letter, int priority) {
        this.letter = letter;
        this.priority = priority;
    }
}
//This class is building the PriorityQueue.
class PriorityQueue {
    private Node[] queue;
    private int size;
    // instructor for Priority Queue
    public PriorityQueue(int capacity) {
        queue = new Node[capacity];
        size = 0;
    }
    // Adding a new item into Priority Queue
    public void enqueue(Node node) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        
        queue[size] = node;
        size++;
        heapifyUp();
    }
    //This function is getting the first element on Priority Queue
    public Node peek() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot peek.");
            return null; // Null character as a placeholder
        }

        return queue[0];
    }
     // delete the first item in Priority Queue
    public Node dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        
        Node temp = queue[0];
        queue[0] = queue[size - 1];
        size--;
        heapifyDown();
        
        return temp;
    }
    // this function is using tree structure to build it and it
    // need to have same order compare parents and children.
    private void heapifyUp() {
        int current = size - 1;
        int parent = (current - 1) / 2;
        while (current > 0 && queue[current].getFrequency() > queue[parent].getFrequency()) {
            Node temp = queue[current];
            queue[current] = queue[parent];
            queue[parent] = temp;

            current = parent;
            parent = (current - 1) / 2;
        }
    }
    // this function is using tree structure to build it and it
    // need to have same order compare parents and children.
    private void heapifyDown() {
        int current = 0;
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        int largest = current;

        while (leftChild < size) {
            if (leftChild < size && queue[leftChild].getFrequency() > queue[largest].getFrequency()) {
                largest = leftChild;
            }
            if (rightChild < size && queue[rightChild].getFrequency() > queue[largest].getFrequency()) {
                largest = rightChild;
            }

            if (largest != current) {
                Node temp = queue[current];
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
    
    public int size() {
    	return size;
    }
}
