package application;

public class text {
	private String user;
	private String title;
	private String time;
	private String context;

	public text(String user, String title, String time, String context) {
		this.user = user;
		this.title = title;
		this.time = time;
		this.context = context;
	
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
	
	public String getContext()
	{
		return context;
	}
	
	
}
