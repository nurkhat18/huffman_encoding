package model;

import java.util.HashMap;

public class Huffman {
	
	private String text;
	private HashMap<Character, Integer> charFrequencies;
	private HashMap<Character, String> huffmanCodes;
	private Node root;
	
	
	public Huffman(String text) {
		this.text = text;
		getFrequencies();
	}


	private void getFrequencies() {
		// TODO Auto-generated method stub
		char[] characters = text.toCharArray();
		for(char character: characters){
			Integer count = charFrequencies.get(character);
			if (count != null) {
				charFrequencies.put(character, count + 1);
			}
			else {
				count = 1;
				charFrequencies.put(character, count);
			}
			
		}
		
		
	}
	
	private void encode() {
		PriorityQueue queue = new PriorityQueue(charFrequencies.size());
		
		charFrequencies.forEach((character, frequency) -> queue.enqueue(new Leaf(character, frequency)));
		
		while(queue.size() > 1) {
			queue.enqueue(new Node(queue.dequeue(), queue.dequeue()));
		}
		root = queue.dequeue();
	}
	
	private void generateHuffmanCodes(Node node, String code) {
		if (node instanceof Leaf) {
			huffmanCodes.put(((Leaf) node).getLetter(), code);
		}
		
		generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
		generateHuffmanCodes(node.getRightNode(), code.concat("1"));
	}
	
	private String getEncodedText() {
		StringBuilder string = new StringBuilder();
		for (char character: text.toCharArray()) {
			string.append(huffmanCodes.get(character));
		}
		
		return string.toString();
	}
	
	private String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		Node current = root;
		for (char character: encodedText.toCharArray()) {
			if (character == '0') {
				current = current.getLeftNode();
			}
			else {
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
