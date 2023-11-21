package model;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    private String text;
    private HashMap<Character, Integer> charFrequencies;
    private HashMap<Character, String> huffmanCodes;
    private Node root;

    public Huffman(String text) {
        this.text = text;
        this.charFrequencies = new HashMap<>();
        this.huffmanCodes = new HashMap<>();
        getFrequencies();
        encode();
        generateHuffmanCodes(root, "");
    }

    /*
     * the function is used 
     * for getting the frequencies of 
     * each character in the text.
     */
    private void getFrequencies() {
        char[] characters = text.toCharArray();
        // looping through the characters in the text and counting them
        for (char character : characters) {
            Integer count = charFrequencies.get(character);
            if (count != null) {
                charFrequencies.put(character, count + 1);
            } else {
                count = 1;
                charFrequencies.put(character, count);
            }
        }
    }

    /*
     * the method uses the min prioity queue 
     * to get the lowest frequency characters and combine them to make huffman tree.
     */
    private void encode() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        // adds characters in to the queue
        charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));

        // while queue is has only root node
        while (queue.size() > 1) {
        	// gets the left and right child of new node by getting the lowest freq character
            Node left = queue.poll();
            Node right = queue.poll();
            
            // adds the new node to the queue
            queue.add(new Node(left, right));
        }
        // the remaining node will be the root node
        root = queue.poll();
    }

    
    /*
     * the recursive function which generates the huffman code for every character in the text
     */
    private void generateHuffmanCodes(Node node, String code) {
    	// if it is a leaf node, we assign the code
        if (node instanceof Leaf) {
            huffmanCodes.put(((Leaf) node).getLetter(), code);
        }
        // if it is left node we add "0" and if it is right node we add 1 to our code
        if (node.getLeftNode() != null) {
            generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        }

        if (node.getRightNode() != null) {
            generateHuffmanCodes(node.getRightNode(), code.concat("1"));
        }
    }

    /*
     * generates a full encoded huffman text
     */
    public String getEncodedText() {
        StringBuilder string = new StringBuilder();
        // loops through the text and 
        // converts every character to its corresponding code
        for (char character : text.toCharArray()) {
            string.append(huffmanCodes.get(character));
        }
        return string.toString();
    }

    /*
     * decodes the encoded huffman text
     */
    public String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        // for eveery character
        for (char character : encodedText.toCharArray()) {
        	// searches through until it goes to leaf node
        	// when it is in the leaf node, 
        	// it will add that character to the decoded text
            if (character == '0') {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }

            if (current instanceof Leaf) {
                sb.append(((Leaf) current).getLetter());
                // be sure to go back to the root node after finding the character
                current = root;
            }
        }
        return sb.toString();
    }
}
