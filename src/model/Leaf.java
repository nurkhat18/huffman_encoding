package model;

public class Leaf extends Node {
	
	private char letter;

	public Leaf(int frequency, char letter) {
		super(frequency);
		this.letter = letter;
		// TODO Auto-generated constructor stub
	}
	
	public char getLetter() {
		return letter;
	}
	
	

}
