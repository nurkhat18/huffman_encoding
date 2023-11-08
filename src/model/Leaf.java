package model;

public class Leaf extends Node {
	
	private char letter;

	public Leaf(char letter, int frequency) {
		super(frequency);
		this.letter = letter;
		// TODO Auto-generated constructor stub
	}
	
	public char getLetter() {
		return letter;
	}
	
	

}
