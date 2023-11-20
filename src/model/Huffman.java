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

    private void getFrequencies() {
        char[] characters = text.toCharArray();
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

    private void encode() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            queue.add(new Node(left, right));
        }
        root = queue.poll();
    }

    private void generateHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf) {
            huffmanCodes.put(((Leaf) node).getLetter(), code);
        }

        if (node.getLeftNode() != null) {
            generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        }

        if (node.getRightNode() != null) {
            generateHuffmanCodes(node.getRightNode(), code.concat("1"));
        }
    }

    public String getEncodedText() {
        StringBuilder string = new StringBuilder();
        for (char character : text.toCharArray()) {
            string.append(huffmanCodes.get(character));
        }
        return string.toString();
    }

    public String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();
        Node current = root;

        for (char character : encodedText.toCharArray()) {
            if (character == '0') {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }

            if (current instanceof Leaf) {
                sb.append(((Leaf) current).getLetter());
                current = root;
            }
        }
        return sb.toString();
    }
}
