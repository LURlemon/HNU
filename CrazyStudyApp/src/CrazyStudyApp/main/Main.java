package CrazyStudyApp.main;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class Main extends JFrame
{
	public static Main frame;
	public static P1 p1;// 登录
	public static P2 p2;// 验证码
	public static P3 p3;// 密码
	public static P4 p4;// 难度
	public static P5 p5;// 做题
	public static P6 p6;// 得分
	public static P7 p7;// 修改密码
	public static P8 p8;// 找回密码验证
	public static P9 p9;// 找回密码change

	public static JPanel cards = new JPanel(new CardLayout());
	public static CardLayout cl = (CardLayout) (cards.getLayout());
	static public String phoneCode = "phoneCode";
	static String phoneNumber;
	static int num = 1;
	static int problemNum = 0;
	static String paperType = "";
	static JMenuBar menuBar = new JMenuBar();
	static boolean loginStatus = false;

	public Main() throws IOException
	{

		SolveAccountClass.func();

		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		// p5.setLayout(null);
		p6.setLayout(null);
		p7.setLayout(null);
		p8.setLayout(null);
		p9.setLayout(null);

		cards.add(p1, "card1");
		cards.add(p2, "card2");
		cards.add(p3, "card3");
		cards.add(p4, "card4");
		// cards.add(p5,"card5");
		cards.add(p6, "card6");
		cards.add(p7, "card7");
		cards.add(p8, "card8");
		cards.add(p9, "card9");

		JMenu fileMenu = new JMenu("菜单");
		menuBar.add(fileMenu);

		JMenuItem chooseItem = new JMenuItem("返回选题页面");
		chooseItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// System.out.println(loginStatus);
				if (loginStatus == true)
				{
					cl.show(cards, "card4");
				} else
				{
					JOptionPane.showMessageDialog(frame, "请先登录", "错误 ", 0);
				}
			}
		});
		fileMenu.add(chooseItem);

		JMenuItem changeItem = new JMenuItem("修改密码");
		changeItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (loginStatus == true)
				{
					cl.show(cards, "card7");
				} else
				{
					JOptionPane.showMessageDialog(frame, "请先登录", "错误 ", 0);
				}
			}
		});
		fileMenu.add(changeItem);

		JMenuItem exitMenuItem = new JMenuItem("退出登录");
		exitMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (loginStatus == true)
				{
					cl.show(cards, "card1");
					loginStatus = false;
				} else
				{
					JOptionPane.showMessageDialog(frame, "请先登录", "错误 ", 0);
				}
			}
		});
		fileMenu.addSeparator(); // 添加一条分割线
		fileMenu.add(exitMenuItem);

		this.setJMenuBar(menuBar);

	}

	public static void main(String[] args) throws IOException
	{
		// new MyFrame();
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

		p1 = new P1();
		p2 = new P2();
		p3 = new P3();
		p4 = new P4();
		p6 = new P6();
		p7 = new P7();
		p8 = new P8();
		p9 = new P9();

		frame = new Main();
		frame.setVisible(true);
		frame.requestFocus();
		frame.setResizable(false);
		frame.setBounds(500, 250, 800, 500);
		frame.add(cards);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int flag = JOptionPane.showConfirmDialog(cards, "Sure to close?", "Care!", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.YES_OPTION == flag)
				{
					System.exit(0);
				} else
				{
					return;
				}
			}
		});
	}

}
