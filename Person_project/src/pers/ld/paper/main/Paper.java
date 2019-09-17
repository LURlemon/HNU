package pers.ld.paper.main;

import java.util.*;
import java.io.*;
import java.text.*;
import java.lang.Integer;;

public class Paper 
{
	static String state = "0"; //状态类型
	static int number=0; //题目数量 
	static String username;
	static String password; 
	static String usergrade;
	static int num=0;
	static String[] bank = new String[10000] ;
	
	//定义用户帐号
	static Users pupil1 = new Users("张三1","123","小学");
	static Users pupil2 = new Users("张三2","123","小学");
	static Users pupil3 = new Users("张三3","123","小学");
	static Users junir1 = new Users("李四1","123","初中");
	static Users junir2 = new Users("李四2","123","初中");
	static Users junir3 = new Users("李四3","123","初中");
	static Users high1 = new Users("王五1","123","高中");
	static Users high2 = new Users("王五2","123","高中");
	static Users high3 = new Users("王五3","123","高中");
	static Users users[] = new Users[] {pupil1,pupil2,pupil3,junir1,junir2,junir3,high1,high2,high3};
	
	//检查帐号
	public static boolean Checkuser(String username, String password, Users user )
	{
		if(user.username.equals(username) && user.password.equals(password))
		{
			return true;
		}
		else return false;
	}
	
	//检查题目数量
	public static boolean Checknum(int number)
	{
		if(number >= 10 && number <= 30)
			return true;
		else return false;
	}
	
	//检查输入题目数量
	public static void Inputnum()
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			number = sc.nextInt();
			if(Checknum(number) == true)
			{
				System.out.println("已生成"+number+"道"+usergrade+"题目，请查看\n请输入需要的题目数量(10-30)，或者输入“切换为xx”更改出题对象");
				break;
			}
//			else if(number == -1)
//			{
//				System.out.println("退出当前用户，请重新登陆");
//				Loginuser();
//				break;
//			}
			else if(number != -1)
				System.out.println("请重新输入题目数");
		}
	}
	
	//用户输登陆信息并反馈年级
	public static void Loginuser()throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int flag=0;
		System.out.println("试卷输出路径为： D:\\Papers ");
		while(true)
		{
			System.out.println("请输入用户名：");
			username = sc.next();
			System.out.println("请输入密码：");
			password = sc.next();
			for(int i=0; i<users.length; i++) //检查账户
			{
				if(Checkuser(username, password, users[i] ))
				{
					usergrade = users[i].grade;
					flag=1;
					System.out.println("当前选择为"+usergrade+"出题\n请输入需要的题目数量(10-30)，或者输入-1退出当前用户，或者输入“切换为xx”更改出题对象");
					
					while(true) //循环出题
					{
						state = sc.next();
						if(state.equalsIgnoreCase("-1")) //用户退出
						{
							System.out.println("退出当前用户，请重新登陆");
							break;
						}
						else if(state.equalsIgnoreCase("切换为小学"))
						{
							usergrade = "小学";
							System.out.println("准备生成"+usergrade+"数学题目，请输入生成题目的数量(10-30)：");
							Inputnum();
							Getpaper();
						}
						else if(state.equalsIgnoreCase("切换为初中"))
						{
							usergrade = "初中";
							System.out.println("准备生成"+usergrade+"数学题目，请输入生成题目的数量(10-30)：");
							Inputnum();
							Getpaper();
						}
						else if(state.equalsIgnoreCase("切换为高中"))
						{
							usergrade = "高中";
							System.out.println("准备生成"+usergrade+"数学题目，请输入生成题目的数量(10-30)：");
							Inputnum();
							Getpaper();
						}
						else
						{
							number = Integer.valueOf(state);
							if(Checknum(number) == true)
								System.out.println("已生成"+number+"道"+usergrade+"题目，请查看\n请输入需要的题目数量(10-30)，或者输入-1退出当前用户，或者输入“切换为xx”更改出题对象");
							Getpaper();
						}		
					}
					break;
				}
				else flag=0; //帐号不正确
			}
			if(flag==0) 
			{
				System.out.println("请输入正确的用户名、密码");
			}
			else if(!state.equalsIgnoreCase("-1"))
			{
				break; //输入正确时跳出一直输入账户密码的循环
			}
		}
		sc.close();
	}

	//判断初中高中是否存在要求的运算符
	public static boolean Judgeoperatorj(int n,String oper)
	{
		for(int i=0;i<n;i++)
		{
			if(oper.equalsIgnoreCase("²") || oper.equalsIgnoreCase("√"))
			{
				return true;
			}
		}
		return false;
	}
	public static boolean Judgeoperatorh(int n,String oper)
	{
		if(oper.equalsIgnoreCase("sin") || oper.equalsIgnoreCase("cos") || oper.equalsIgnoreCase("tan"))
		{
			return true;
		}
		return false;
	}
	
	//生成题目
	static String Getproblems() 
	{
		String sign[] = new String[] {"+","-","×","÷","²","√","sin","cos","tan"};
		
		//每个算式有number_num个数字，有number_num-1个运算符号，最多有number_num-2组括号
		int number_num = (int)(2+Math.random()*(5-2+1));
		int numbers[] = new int[number_num];
		int signs[] = new int[number_num-1];
		String problem = "";
		
		//随机数字
		for(int i = 0; i < number_num; i++) 
		{
			numbers[i] = (int)(1+Math.random()*(100-1+1));
		}
		//随机运算符号
		if(usergrade.equals("小学")) 
		{
			for(int i = 0; i < number_num - 1; i++) 
			{
				signs[i] = (int)(0+Math.random()*(3-0+1));
			}
		}else if(usergrade.equals("初中")) 
		{
			signs[0] = (int)(4+Math.random()*(5-4+1));
			for(int i = 1; i < number_num - 1; i++) 
			{
				signs[i] = (int)(0+Math.random()*(5-0+1));
			}
		}else if(usergrade.equals("高中")) 
		{
			signs[0] = (int)(6+Math.random()*(8-6+1));
			for(int i = 1; i < number_num - 1; i++) 
			{
				signs[i] = (int)(0+Math.random()*(8-0+1));
			}
		}
		
		int numa=0,numb=0;
		boolean flag=false;
		if(number_num>=3)
		{
			while(numa==numb)
			{
				numa = new Random().nextInt(number_num);
				numb = new Random().nextInt(number_num);
			}
			int c;
			if(numa>numb)
			{
				c=numa;
				numa=numb;
				numb=c;
			}
		}
		else
		{
			flag=true;
		}
		
		//合并
		for(int i = 0; i < number_num - 1; i++) 
		{
			if(i==numa && number_num>=3)
			{
				problem +="(";
			}
			problem += numbers[i];
			if(i==numb && number_num>=3) 
			{
				problem += ")";
				flag=true;
			}
			if(signs[i] >= 4 && signs[i] <= 8) 
			{
				problem += sign[(int)(0+Math.random()*(3-0+1))];
			}
			problem += sign[signs[i]];
			
		}
		problem += numbers[number_num - 1];
		if(flag==false)
		{
			problem+=")";
		}
		problem += "=";
		
		//处理格式
		char p[] = problem.toCharArray();
		for(int i = 0; i < p.length-1; i++) 
		{
			if(p[i] == '²' && Character.isDigit(p[i+1])) 
			{
				p[i] = p[i+1];
				p[i+1] = '²';
			}
			if(p[i] == '²' && p[i+1]=='(')
			{
				p[i] = '√';
			}
		}
		problem = String.valueOf(p);
		if(problem.charAt(0)=='('&&problem.charAt(problem.length()-1)==')')
		{
			problem = problem.substring(1, problem.length()-2);
		}
		return problem;
	}
	
	//文件夹储存试卷
	public static void Getpaper()throws IOException
	{ 
		//获取时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String filename = format.format(new Date()).toString();
		
		String[] problems = new String[number];
		
		for(int i=0;i<number;i++)
		{
			problems[i] = Getproblems();
			if(itemIsExist(problems[i],username)) 
			{
				i--;
				System.out.println("存在重复的题目，已删去~");
			}
		}
		
		File file = new File("D:\\Papers\\"+username+"\\"+usergrade+"\\");
		if(!file.exists()) //如果路径不存在，创立文件夹
		{
			file.mkdirs();
		}
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Papers\\"+username+"\\"+usergrade+"\\"+filename+".txt"));
			for(int i=0;i<problems.length;i++)
			{
				bw.write((i+1)+". "+problems[i]+"\r\n"+"\r\n");		
			}
			bw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//试卷查重
	static boolean itemIsExist(String problem, String username) throws IOException 
	{
		File folder = new File("D:\\Papers\\"+username+"\\"+usergrade+"\\");
		if(!folder.exists()) //如果路径不存在，创立文件夹
		{
			folder.mkdirs();
		}
		String all = "";
		File files[] = folder.listFiles();
		for(File f : files) 
		{
			InputStream is = null;
			try 
			{
				is = new FileInputStream(f);
			} catch (FileNotFoundException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			byte content[] = new byte[1024];
			try 
			{
				is.read(content);
			} catch (IOException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try 
			{
				is.close();
			} catch (IOException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				all += new String((content),"utf-8");
			} catch (UnsupportedEncodingException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(all.indexOf(problem) == -1) 
		{
			return false;
		}else {
			return true;
		}
	}

	
	public static void main(String[] args)throws IOException
	{
		Loginuser();
	}
}
