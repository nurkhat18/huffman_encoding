/*
 * Gijeong Lee and Swarn
 * It is for text.
 * It has user, title, time, and huffman object
 */
package application;

import model.Huffman;

public class text {
	private String user;
	private String title;
	private String time;
	private Huffman huffman;

	/*
	 * This is a constructon
	 */
	public text(String user, String title, String time, Huffman huffman) {
		this.user = user;
		this.title = title;
		this.time = time;
		this.huffman = huffman;
	
	}
	
	public String getUser()
	{
		return user;
	}
	
	public String getTitle()
	{
		return title;
	}

	public String getTime()
	{
		return time;
	}
	
	public Huffman getHuffman()
	{
		return huffman;
	}
	
	
}
