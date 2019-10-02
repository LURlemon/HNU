package CrazyStudyApp.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolveAccountClass
{
	// static List<String> accountPassword = new LinkedList<String>();
	static Map<String, String> loginMap = new HashMap<String, String>();
	static File file = new File("userData.txt");

	static void func() throws IOException
	{

		try
		{
			file.createNewFile();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new FileReader(new File("userData.txt")));// 创建试卷
		try
		{// 读取题库到list
			String line = null;
			boolean APFlag = true;
			String account = "";
			String password = "";
			while ((line = reader.readLine()) != null)
			{
				// accountPassword.add(line);
				if (APFlag == true)
				{
					account = line;
					APFlag = false;
				} else
				{
					password = line;
					loginMap.put(account, password);
					APFlag = true;
				}
				// System.out.println(line);
			}
		} finally
		{
			reader.close();
		}
		// System.out.print(loginMap);
//    	if(loginMap.containsKey("18670787758"))
//    	{
//    		System.out.println("有！！！");
//    	}
	}
}
