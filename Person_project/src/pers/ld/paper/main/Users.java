package pers.ld.paper.main;

/* �����û���*/
public class Users 
{
	String username;
	String password;
	String grade;
	
	public Users(String username, String password, String grade)
	{
		this.username = username;
		this.password = password;
		this.grade = grade;
	}
	
	String setgrade()
	{
		return this.grade;
	}
	
		
}