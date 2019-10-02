package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P9 extends JPanel
{

	ImageIcon icon;
	Image img;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P9()
	{
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
//		icon=new ImageIcon(getClass().getResource("/img/pic3.jpg"));
//		img=icon.getImage();

		JLabel firstPasswordLable = new JLabel("请输入密码");
		firstPasswordLable.setBounds(250, 80, 80, 25);
		firstPasswordLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		this.add(firstPasswordLable);

		JPasswordField firstPasswordText = new JPasswordField(20);
		firstPasswordText.setBounds(330, 80, 200, 25);
		firstPasswordText.setEchoChar('\0');
		firstPasswordText.setText("请输入密码");
		firstPasswordText.setForeground(Color.LIGHT_GRAY);
		firstPasswordText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				String pswd = new String(firstPasswordText.getPassword()).trim();
				if (pswd.equals(""))
				{// 如果没有输入密码. 就用明文 提示用户输入密码
					firstPasswordText.setEchoChar('\0');
					firstPasswordText.setText("请输入密码");
					firstPasswordText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
					firstPasswordText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				String pswd = new String(firstPasswordText.getPassword()).trim();
				if (pswd.equals("请输入密码"))
				{// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					firstPasswordText.setText("");
					firstPasswordText.setEchoChar('*');
					firstPasswordText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(firstPasswordText);

		JLabel tipLable = new JLabel("密码6-10位，必须含大小写字母和数字!");
		tipLable.setBounds(390, 110, 150, 25);
		tipLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 8));
		this.add(tipLable);

		JLabel tipLableT = new JLabel("");
		tipLableT.setBounds(470, 170, 150, 25);
		tipLableT.setFont(new Font("方正准圆_GDK", Font.PLAIN, 8));
		this.add(tipLableT);

		JLabel secondPasswordLable = new JLabel("请确认密码");
		secondPasswordLable.setBounds(250, 140, 80, 25);
		secondPasswordLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		this.add(secondPasswordLable);

		JPasswordField secondPasswordText = new JPasswordField(20);
		secondPasswordText.setBounds(330, 140, 200, 25);
		// secondPasswordText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 10));
		secondPasswordText.setEchoChar('\0');
		secondPasswordText.setText("请输入密码");
		secondPasswordText.setForeground(Color.LIGHT_GRAY);
		secondPasswordText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				String pswd = new String(secondPasswordText.getPassword()).trim();
				if (pswd.equals(""))
				{// 如果没有输入密码. 就用明文 提示用户输入密码
					secondPasswordText.setEchoChar('\0');
					secondPasswordText.setText("请输入密码");
					secondPasswordText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
					secondPasswordText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				String pswd = new String(secondPasswordText.getPassword()).trim();
				if (pswd.equals("请输入密码"))
				{// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					secondPasswordText.setText("");
					secondPasswordText.setEchoChar('*');
					secondPasswordText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(secondPasswordText);

		JButton confirmButtonTwo = new JButton("确认");
		confirmButtonTwo.setBounds(340, 200, 130, 40);
		confirmButtonTwo.setFont(new Font("方正准圆_GDK", Font.PLAIN, 20));
		confirmButtonTwo.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					String password = firstPasswordText.getText();

					if (((password.toLowerCase().equals(password)) || (password.toUpperCase().equals(password))
							|| !(password.contains("0") || password.contains("1") || password.contains("2")
									|| password.contains("3") || password.contains("4") || password.contains("5")
									|| password.contains("6") || password.contains("7") || password.contains("8")
									|| password.contains("9"))))
					{
						tipLable.setText("密码6-10位，必须含大小写字母和数字!");
						tipLable.setForeground(Color.red);
						tipLableT.setForeground(Color.black);

					} else if (!firstPasswordText.getText().equals(secondPasswordText.getText()))
					{
						tipLableT.setText("两次密码不一致!");
						tipLableT.setForeground(Color.red);
						tipLable.setForeground(Color.black);
					} else
					{

						Writer writer;
						try
						{
							writer = new FileWriter(SolveAccountClass.file, true);
							writer.write(Main.phoneNumber + "\r\n");
							writer.write(password + "\r\n");
							writer.close();
						} catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						try
						{
							SolveAccountClass.func();
						} catch (IOException e2)
						{
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						//System.out.println(SolveAccountClass.loginMap);

						Main.cl.show(Main.cards, "card1");
						Main.loginStatus=false;
					}
				}
			}
		});
		this.add(confirmButtonTwo);
	}
}