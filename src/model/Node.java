package model;

public class Node  implements Comparable<Node>{
	private Node leftNode;
	private Node rightNode;
	private int frequency;
	
	public Node(Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		
		this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
	}
	
	
	public Node(int frequency) {
		this.frequency = frequency;
	}


	public int getFrequency() {
		return this.frequency;
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}


	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return Integer.compare(frequency, node.getFrequency());
	}
}
