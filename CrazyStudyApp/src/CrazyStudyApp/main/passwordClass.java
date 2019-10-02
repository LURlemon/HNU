package CrazyStudyApp.main;
public class passwordClass
{
	static String password;
	static String checkPassword;

	static void setPassword(String str)
	{
		password = str;
	}

	static String getPassword()
	{
		return password;
	}

	static void setCheckPassword(String str)
	{
		checkPassword = str;
	}

	static String getCheckPassword()
	{
		return checkPassword;
	}
}