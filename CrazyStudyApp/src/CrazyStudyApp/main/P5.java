package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P5 extends JPanel
{
	public static JLabel numOfProblemLabel = new JLabel("");
	public static JLabel scoreLabel = new JLabel("");
//	static String Problems[] = P4.problems;
	public static double Correctnumber = 0; // 正确的题目数量
	public static int current = 0; // 当前题目
	public static double score = 0; // 得分
	static ArrayList<String> errorList = new ArrayList<String>();
	static String str="";
	static int errorNum=1;
	static File errfile = new File("errorData.txt");
	ImageIcon icon;
	Image img;

//	public void paintComponent(Graphics g)
//	{
//		super.paintComponent(g);
//		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
//		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
//	}

	P5()
	{
		errfile.delete();
		try
		{
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
			// BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e)
		{
			System.err.println("set skin fail!");
		}

		// /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
//		icon=new ImageIcon(getClass().getResource("/img/pic5.jpg"));
//		img=icon.getImage();

		numOfProblemLabel.setBounds(217, 135, 400, 40);
		numOfProblemLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 40));

		scoreLabel.setBounds(217, 185, 400, 40);
		scoreLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 40));

		P4.numLable.setBounds(200, 124, 100, 35);
		P4.numLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		this.add(P4.numLable);

		// String problem = "1+1";
		JLabel problemLable = new JLabel(P4.problems[current]);
		problemLable.setBounds(253, 120, 800, 35);
		problemLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 30));
		this.add(problemLable);

		ButtonGroup group = new ButtonGroup();
		JRadioButton AButton = new JRadioButton("A. " + P4.options[current][0]);
		JRadioButton BButton = new JRadioButton("B. " + P4.options[current][1]);
		JRadioButton CButton = new JRadioButton("C. " + P4.options[current][2]);
		JRadioButton DButton = new JRadioButton("D. " + P4.options[current][3]);

		group.add(AButton);
		group.add(BButton);
		group.add(CButton);
		group.add(DButton);

		
		AButton.setBounds(200, 200, 230, 30);
		AButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 28));
		AButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					AButton.setEnabled(false);
					BButton.setEnabled(false);
					CButton.setEnabled(false);
					DButton.setEnabled(false);

					P4.Recordoption[current] = "A";
					if (P4.Recordoption[current].equals(P4.Correctoption[current]))
					{
						AButton.setForeground(Color.green);

					} 
					else
					{
						str=String.valueOf(errorNum)+". "+problemLable.getText()+"  正确答案为："+P4.Correctoption[current];
						errorNum++;
						Writer writer;
						try
						{
							writer = new FileWriter(errfile, true);
							writer.write(str + "\r\n");
							
							writer.close();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						AButton.setForeground(Color.red);
						if(P4.Correctoption[current].equals("B"))
							BButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("C"))
							CButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("D"))
							DButton.setForeground(Color.green);						
					}

					Timer timer = new Timer();
					timer.schedule(new TimerTask()
					{
						public void run()
						{

							Main.num++;

							P4.numLable.setText(String.valueOf(Main.num) + "/" + String.valueOf(Main.problemNum));
							if (P4.Recordoption[current].equals(P4.Correctoption[current]))
							{
								Correctnumber++;

							}
							current++;
							AButton.setText("A. " + String.format("%.2f", P4.options[current][0]));
							BButton.setText("B. " + String.format("%.2f", P4.options[current][1]));
							CButton.setText("C. " + String.format("%.2f", P4.options[current][2]));
							DButton.setText("D. " + String.format("%.2f", P4.options[current][3]));
							AButton.setForeground(Color.BLACK);
							BButton.setForeground(Color.BLACK);
							CButton.setForeground(Color.BLACK);
							DButton.setForeground(Color.BLACK);
							problemLable.setText(P4.problems[current]);

							if (Main.num >= Main.problemNum + 1)
							{
								Main.cl.show(Main.cards, "card6");
								numOfProblemLabel.setText("本次做题数目为：" + String.valueOf(Main.problemNum));

								score = Correctnumber / Main.problemNum * 100;
								current = 0;
								Correctnumber = 0;

								scoreLabel.setText("本次得分为：" + String.valueOf(String.format("%.2f", score)) + "%");
							}
							group.clearSelection();
							problemLable.setForeground(Color.black);
							AButton.setEnabled(true);
							BButton.setEnabled(true);
							CButton.setEnabled(true);
							DButton.setEnabled(true);
						}
					}, 500);
				}
			}

		});
		this.add(AButton);

		BButton.setBounds(430, 200, 230, 30);
		BButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 28));
		BButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					AButton.setEnabled(false);
					BButton.setEnabled(false);
					CButton.setEnabled(false);
					DButton.setEnabled(false);

					P4.Recordoption[current] = "B";
					if (P4.Recordoption[current].equals(P4.Correctoption[current]))
					{
						BButton.setForeground(Color.green);

					} 
					else
					{
						str=String.valueOf(errorNum)+". "+problemLable.getText()+"  正确答案为："+P4.Correctoption[current];
						errorNum++;
						Writer writer;
						try
						{
							writer = new FileWriter(errfile, true);
							writer.write(str + "\r\n");
							
							writer.close();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						BButton.setForeground(Color.red);
						if(P4.Correctoption[current].equals("A"))
							AButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("C"))
							CButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("D"))
							DButton.setForeground(Color.green);						
					}

					Timer timer = new Timer();
					timer.schedule(new TimerTask()
					{
						public void run()
						{

							Main.num++;

							P4.numLable.setText(String.valueOf(Main.num) + "/" + String.valueOf(Main.problemNum));
							if (P4.Recordoption[current].equals(P4.Correctoption[current]))
							{
								Correctnumber++;
							}
							current++;
							problemLable.setText(P4.problems[current]);
							AButton.setText("A. " + String.format("%.2f", P4.options[current][0]));
							BButton.setText("B. " + String.format("%.2f", P4.options[current][1]));
							CButton.setText("C. " + String.format("%.2f", P4.options[current][2]));
							DButton.setText("D. " + String.format("%.2f", P4.options[current][3]));
							AButton.setForeground(Color.BLACK);
							BButton.setForeground(Color.BLACK);
							CButton.setForeground(Color.BLACK);
							DButton.setForeground(Color.BLACK);
							if (Main.num >= Main.problemNum + 1)
							{
								Main.cl.show(Main.cards, "card6");
								numOfProblemLabel.setText("本次做题数目为：" + String.valueOf(Main.problemNum));
								score = Correctnumber / Main.problemNum * 100;
								current = 0;
								Correctnumber = 0;
								scoreLabel.setText("本次得分为：" + String.valueOf(String.format("%.2f", score)) + "%");
							}
							group.clearSelection();
							problemLable.setForeground(Color.black);
							AButton.setEnabled(true);
							BButton.setEnabled(true);
							CButton.setEnabled(true);
							DButton.setEnabled(true);
						}
					}, 500);

				}
			}
		});
		this.add(BButton);

		CButton.setBounds(200, 250, 230, 30);
		CButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 28));
		CButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					AButton.setEnabled(false);
					BButton.setEnabled(false);
					CButton.setEnabled(false);
					DButton.setEnabled(false);

					P4.Recordoption[current] = "C";
					if (P4.Recordoption[current].equals(P4.Correctoption[current]))
					{
						CButton.setForeground(Color.green);

					} 
					else
					{
						str=String.valueOf(errorNum)+". "+problemLable.getText()+"  正确答案为："+P4.Correctoption[current];
						errorNum++;
						Writer writer;
						try
						{
							writer = new FileWriter(errfile, true);
							writer.write(str + "\r\n");
							
							writer.close();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						CButton.setForeground(Color.red);
						if(P4.Correctoption[current].equals("B"))
							BButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("A"))
							AButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("D"))
							DButton.setForeground(Color.green);						
					}

					Timer timer = new Timer();
					timer.schedule(new TimerTask()
					{
						public void run()
						{

							Main.num++;

							P4.numLable.setText(String.valueOf(Main.num) + "/" + String.valueOf(Main.problemNum));
							if (P4.Recordoption[current].equals(P4.Correctoption[current]))
							{
								Correctnumber++;
							}
							current++;
							problemLable.setText(P4.problems[current]);
							AButton.setText("A. " + String.format("%.2f", P4.options[current][0]));
							BButton.setText("B. " + String.format("%.2f", P4.options[current][1]));
							CButton.setText("C. " + String.format("%.2f", P4.options[current][2]));
							DButton.setText("D. " + String.format("%.2f", P4.options[current][3]));
							AButton.setForeground(Color.BLACK);
							BButton.setForeground(Color.BLACK);
							CButton.setForeground(Color.BLACK);
							DButton.setForeground(Color.BLACK);
							if (Main.num >= Main.problemNum + 1)
							{
								Main.cl.show(Main.cards, "card6");
								numOfProblemLabel.setText("本次做题数目为：" + String.valueOf(Main.problemNum));
								score = Correctnumber / Main.problemNum * 100;
								current = 0;
								Correctnumber = 0;
								scoreLabel.setText("本次得分为：" + String.valueOf(String.format("%.2f", score)) + "%");
							}
							group.clearSelection();
							problemLable.setForeground(Color.black);
							AButton.setEnabled(true);
							BButton.setEnabled(true);
							CButton.setEnabled(true);
							DButton.setEnabled(true);

						}
					}, 500);

				}
			}
		});
		this.add(CButton);

		DButton.setBounds(430, 250, 230, 30);
		DButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 28));
		DButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					AButton.setEnabled(false);
					BButton.setEnabled(false);
					CButton.setEnabled(false);
					DButton.setEnabled(false);

					P4.Recordoption[current] = "D";
					if (P4.Recordoption[current].equals(P4.Correctoption[current]))
					{
						DButton.setForeground(Color.green);

					} 
					else
					{
						str=String.valueOf(errorNum)+". "+problemLable.getText()+"  正确答案为："+P4.Correctoption[current];
						errorNum++;
						Writer writer;
						try
						{
							writer = new FileWriter(errfile, true);
							writer.write(str + "\r\n");
							
							writer.close();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						DButton.setForeground(Color.red);
						if(P4.Correctoption[current].equals("B"))
							BButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("C"))
							CButton.setForeground(Color.green);
						else if(P4.Correctoption[current].equals("A"))
							AButton.setForeground(Color.green);						
					}
					
					Timer timer = new Timer();
					timer.schedule(new TimerTask()
					{
						public void run()
						{

							Main.num++;

							P4.numLable.setText(String.valueOf(Main.num) + "/" + String.valueOf(Main.problemNum));
							if (P4.Recordoption[current].equals(P4.Correctoption[current]))
							{
								Correctnumber++;
							}
							current++;
							problemLable.setText(P4.problems[current]);
							AButton.setText("A. " + String.format("%.2f", P4.options[current][0]));
							BButton.setText("B. " + String.format("%.2f", P4.options[current][1]));
							CButton.setText("C. " + String.format("%.2f", P4.options[current][2]));
							DButton.setText("D. " + String.format("%.2f", P4.options[current][3]));
							AButton.setForeground(Color.BLACK);
							BButton.setForeground(Color.BLACK);
							CButton.setForeground(Color.BLACK);
							DButton.setForeground(Color.BLACK);
							if (Main.num >= Main.problemNum + 1)
							{
								Main.cl.show(Main.cards, "card6");
								numOfProblemLabel.setText("本次做题数目为：" + String.valueOf(Main.problemNum));
								score = Correctnumber / Main.problemNum * 100;
								current = 0;
								Correctnumber = 0;
								scoreLabel.setText("本次得分为：" + String.valueOf(String.format("%.2f", score)) + "%");
							}
							group.clearSelection();
							problemLable.setForeground(Color.black);
							AButton.setEnabled(true);
							BButton.setEnabled(true);
							CButton.setEnabled(true);
							DButton.setEnabled(true);
						}
					}, 500);
				}
			}
		});
		this.add(DButton);
	}
}
