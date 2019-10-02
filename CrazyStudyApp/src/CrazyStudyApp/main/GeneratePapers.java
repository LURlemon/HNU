package CrazyStudyApp.main;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class GeneratePapers
{
	static int accountType = -1;// 试卷类型
	static String papersType = "";// 试卷类型
	static Map<String, String> userMap = new HashMap<String, String>();// 存储账号密码
	static Map<String, Integer> typeMap = new HashMap<String, Integer>(); // 存储试卷类型
	static String initproblems[] = new String[30]; // 存放所有的题目

	public static String GeneratePrimaryQuestion()
	{
		String question = "";
		int numOfNumbers = (int) (2 + Math.random() * 4);// 通过随机数确定操作数数目
		boolean rightBracket = false; // 有右括号需要打印时
		boolean bracketFlag = true;// 保证括号不会只包含一个数字
		boolean bracket = true;// 只会有一个括号
		int leftBracket = -1;// 记录左括号出现的位置，防止括号包住整个式子
		for (int i = 0; i < numOfNumbers; i++)
		{

			if (numOfNumbers > 2 && i < numOfNumbers - 1 && bracket == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					leftBracket = i;
					question += "(";
					rightBracket = true;
					bracketFlag = false;
					bracket = false;
				}
			}

			int num = (int) (1 + Math.random() * 100);
			question += String.valueOf(num);

			if (rightBracket == true && bracketFlag == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					question += ")";
					rightBracket = false;
				}
			}
			if (i == numOfNumbers - 2 && rightBracket == true && leftBracket == 0)
			{
				question += ")";
				rightBracket = false;
			}
			if (i != numOfNumbers - 1)
			{
				int randSymbol = (int) ((0 + Math.random() * 4));// 通过随机数确定符号
				switch (randSymbol)
				{
				case 0:
					question += "+";
					break;
				case 1:
					question += "-";
					break;
				case 2:
					question += "*";
					break;
				case 3:
					question += "/";
					break;
				default:
					System.out.println("error in generating symbol");
				}
			} else
			{
				if (rightBracket == true)
				{
					question += ")";
					rightBracket = false;
				}
			}
			bracketFlag = true;
		}

		return question;
	}

	public static String GenerateMiddleQuestion()
	{
		String question = "";
		int numOfNumbers = (int) (2 + Math.random() * 5);
		boolean rightBracket = false;
		boolean bracketFlag = true;
		boolean bracket = true;
		int leftBracket = -1;
		for (int i = 0; i < numOfNumbers; i++)
		{
			int randGF = (int) (0 + Math.random() * 4);
			int randGT = (int) (0 + Math.random() * 4);
			int randPF = (int) (0 + Math.random() * 4);
			int randPT = (int) (0 + Math.random() * 4);
			if (numOfNumbers > 2 && i < numOfNumbers - 1 && bracket == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					if (randGF == 1)// 根号出现在数字和左括号之前
					{
						question += "√";
					}
					leftBracket = i;
					question += "(";
					rightBracket = true;
					bracketFlag = false;
					bracket = false;

				}
			}

			int num = (int) (1 + Math.random() * 100);
			if (randGT == 1)// 根号出现在数字和左括号之前
			{
				question += "√";
			}
			question += String.valueOf(num);
			if (randPF == 1)// 平方出现在数字之后
			{
				question += "²";
			}

			if (rightBracket == true && bracketFlag == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					question += ")";
					if (randPT == 1)// 平方出现在括号之后
					{
						question += "²";
					}
					rightBracket = false;
				}
			}
			if (i == numOfNumbers - 2 && rightBracket == true && leftBracket == 0)
			{
				question += ")";
				if (randPT == 1)// 平方出现在括号之后
				{
					question += "²";
				}
				rightBracket = false;
			}
			if (i != numOfNumbers - 1)
			{
				int randSymbol = (int) ((0 + Math.random() * 4));
				switch (randSymbol)
				{
				case 0:
					question += "+";
					break;
				case 1:
					question += "-";
					break;
				case 2:
					question += "*";
					break;
				case 3:
					question += "/";
					break;
				default:
					System.out.println("error in generating symbol");
				}
			} else
			{
				if (rightBracket == true)
				{
					question += ")";
					rightBracket = false;
				}
			}
			bracketFlag = true;
		}
		return question;
	}

	public static String GenerateHighQuestion()

	{
		String question = "";
		int numOfNumbers = (int) (2 + Math.random() * 5);
		boolean rightBracket = false;
		boolean bracketFlag = true;
		boolean bracket = true;
		int leftBracket = -1;
		for (int i = 0; i < numOfNumbers; i++)
		{
			int randCF = (int) (0 + Math.random() * 10);
			int randCT = (int) (0 + Math.random() * 10);
			int randSF = (int) (0 + Math.random() * 10);
			int randST = (int) (0 + Math.random() * 10);
			int randTF = (int) (0 + Math.random() * 10);
			int randTT = (int) (0 + Math.random() * 10);
			if (numOfNumbers > 2 && i < numOfNumbers - 1 && bracket == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					if (randSF == 1)// sin cos出现在其他符号之后,通过随机数确定是否出现
					{
						question += "sin";
					}
					if (randCF == 1)
					{
						question += "cos";
					}
					if (randTF == 1)
					{
						question += "tan";
					}

					leftBracket = i;
					question += "(";
					rightBracket = true;
					bracketFlag = false;
					bracket = false;
				}
			}

			int num = (int) (1 + Math.random() * 100);
			if (randST == 1)// sin cos出现在其他符号之后,通过随机数确定是否出现
			{
				question += "sin";
			}
			if (randCT == 1)
			{
				question += "cos";
			}
			if (randTT == 1)
			{
				question += "tan";
			}
			question += String.valueOf(num);

			if (rightBracket == true && bracketFlag == true)
			{
				int randBrackets = (int) (0 + Math.random() * 2);
				if (randBrackets == 1)
				{
					question += ")";
					rightBracket = false;
				}
			}
			if (i == numOfNumbers - 2 && rightBracket == true && leftBracket == 0)
			{
				question += ")";
				rightBracket = false;
			}
			if (i != numOfNumbers - 1)
			{
				int randSymbol = (int) ((0 + Math.random() * 4));

				switch (randSymbol)
				{
				case 0:
					question += "+";
					break;
				case 1:
					question += "-";
					break;
				case 2:
					question += "*";
					break;
				case 3:
					question += "/";
					break;
				default:
					System.out.println("error in generating symbol");
				}
			} else
			{
				if (rightBracket == true)
				{
					question += ")";
					rightBracket = false;
				}
			}
			bracketFlag = true;
		}
		return question;
	}

	public static boolean check(String question, List<String> questionBank) throws IOException

	{
		if (questionBank.contains(question))// 通过list查重
		{
			return false;
		} else
		{
			questionBank.add(question);
			return true;
		}
	}

	// 生成题目
	public static String generateProblem(String paperType)
	{
		return GeneratePapers.DealQuestion(paperType);
	}

	public static String DealQuestion(String account)// 工厂
	{
		String question = "";
		switch (account)
		{
		case "小学":
			question = GeneratePrimaryQuestion();
			break;
		case "初中":
			question = GenerateMiddleQuestion();
			break;
		case "高中":
			question = GenerateHighQuestion();
			break;
		default:
			System.out.println("error in generating question");
		}
		while (!(question.contains("²") || question.contains("√")) && account.equals("初中"))// 当题目不符合要求时，再次调用GenerateMiddleQuestion()
		{
			question = GenerateMiddleQuestion();
		}
		while (!(question.contains("sin") || question.contains("cos") || question.contains("tan"))
				&& account.equals("高中"))
		{
			question = GenerateHighQuestion();
		}
		return question;
	}

	// 生成试卷
	public static String[] generatethePaper(int problemNum, String paperType)
	{
		for (int i = 0; i < problemNum; i++)
		{
			initproblems[i] = generateProblem(paperType);
		}
		return initproblems;
	}

	// 设置选项
	public static void getProblemoption(String[] problems, int problemNum)
	{
		// 得到计算结果
		for (int i = 0; i < problemNum; i++)
		{
			P4.answers[i] = Double.valueOf(Select.Getanswer(problems[i]));
		}
		// 设置正确选项
		for (int i = 0; i < problemNum; i++)
		{
			long seed = System.nanoTime();
			Random random = new Random(seed);
			int rand = random.nextInt(4);
			if (rand == 0)
			{
				P4.Correctoption[i] = "A";
			} else if (rand == 1)
			{
				P4.Correctoption[i] = "B";
			} else if (rand == 2)
			{
				P4.Correctoption[i] = "C";
			} else
			{
				P4.Correctoption[i] = "D";
			}
		}
		// 设置选项
		for (int i = 0; i < problemNum; i++)
		{
			if (P4.Correctoption[i].equals("A"))
			{
				P4.options[i][0] = P4.answers[i];
				P4.options[i][1] = P4.answers[i] + (int) (1 + Math.random() * (100 - 1 + 1));
				P4.options[i][2] = P4.answers[i] + (int) (1 + Math.random() * (50 - 1 + 1));
				P4.options[i][3] = P4.answers[i] - (int) (1 + Math.random() * (30 - 1 + 1));
			} else if (P4.Correctoption[i].equals("B"))
			{
				P4.options[i][0] = P4.answers[i] + (int) (1 + Math.random() * (100 - 1 + 1));
				P4.options[i][1] = P4.answers[i];
				P4.options[i][2] = P4.answers[i] + (int) (1 + Math.random() * (50 - 1 + 1));
				P4.options[i][3] = P4.answers[i] - (int) (1 + Math.random() * (30 - 1 + 1));
			} else if (P4.Correctoption[i].equals("C"))
			{
				P4.options[i][0] = P4.answers[i] - (int) (1 + Math.random() * (100 - 1 + 1));
				P4.options[i][1] = P4.answers[i] + (int) (1 + Math.random() * (50 - 1 + 1));
				P4.options[i][2] = P4.answers[i];
				P4.options[i][3] = P4.answers[i] - (int) (1 + Math.random() * (30 - 1 + 1));
			} else if (P4.Correctoption[i].equals("D"))
			{
				P4.options[i][0] = P4.answers[i] + (int) (1 + Math.random() * (100 - 1 + 1));
				P4.options[i][1] = P4.answers[i] + (int) (1 + Math.random() * (50 - 1 + 1));
				P4.options[i][2] = P4.answers[i] + (int) (1 + Math.random() * (30 - 1 + 1));
				P4.options[i][3] = P4.answers[i];
			}
		}
	}
}
