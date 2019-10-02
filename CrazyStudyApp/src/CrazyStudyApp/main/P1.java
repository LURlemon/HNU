package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.Image;
import java.awt.Graphics;

public class P1 extends JPanel
{

	ImageIcon icon;
	Image img;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P1()
	{


		JLabel userNameLable = new JLabel("用户名");
		userNameLable.setBounds(242, 146, 80, 25);
		userNameLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 16));

		this.add(userNameLable);

		JLabel passwordLable = new JLabel("密   码");
		passwordLable.setBounds(242, 205, 80, 25);
		passwordLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 16));
		this.add(passwordLable);

		JTextField userNameText = new JTextField("请输入用户名", 20);
		userNameText.setBounds(305, 144, 200, 32);
		userNameText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 13));
		userNameText.setForeground(Color.LIGHT_GRAY);
		userNameText.addFocusListener(new FocusListener()
		{

			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				if (userNameText.getText().trim().equals(""))
				{// 如果没有任何输入 ,就提示用户输入
					userNameText.setText("请输入用户名");
					userNameText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				if (userNameText.getText().trim().equals("请输入用户名"))
				{// 如果是提示文字 ,就清空提示文字
					userNameText.setText("");
					userNameText.setForeground(Color.BLACK);
				}
			}
		});
		// userNameText.setOpaque(false);
		// userNameText.setBorder(null);
		this.add(userNameText);

		JPasswordField passwordText = new JPasswordField(15);
		passwordText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 13));
		passwordText.setEchoChar('\0');
		passwordText.setText("请输入密码");
		passwordText.setBounds(305, 200, 200, 32);
		passwordText.setForeground(Color.LIGHT_GRAY);
		passwordText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals(""))
				{// 如果没有输入密码. 就用明文 提示用户输入密码
					passwordText.setEchoChar('\0');
					passwordText.setText("请输入密码");
					passwordText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 13));
					passwordText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals("请输入密码"))
				{// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					passwordText.setText("");
					passwordText.setEchoChar('*');
					passwordText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(passwordText);

		JLabel tipLable2 = new JLabel("");
		tipLable2.setBounds(510, 206, 80, 25);
		tipLable2.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		this.add(tipLable2);

		JLabel tipLable1 = new JLabel("");
		tipLable1.setBounds(510, 146, 80, 25);
		tipLable1.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		this.add(tipLable1);

		JButton loginButton = new JButton("登录");
		loginButton.setBounds(336, 270, 125, 32);
		loginButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		loginButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					if (userNameText.getText().equals("请输入用户名"))
					{
						userNameText.setText("请输入用户名");
						userNameText.setForeground(Color.red);
					} else if (passwordText.getText() == "请输入密码")
					{
						passwordText.setEchoChar('\0');
						passwordText.setText("请输入密码");
						// passwordText.setForeground(Color.red);
					} else if (!SolveAccountClass.loginMap.containsKey(userNameText.getText()))
					{
						tipLable1.setText("用户不存在");
						tipLable1.setForeground(Color.red);
					} else if (!SolveAccountClass.loginMap.get(userNameText.getText()).equals(passwordText.getText()))
					{
						tipLable2.setText("密码错误");
						tipLable2.setForeground(Color.red);
					} else
					{
						Main.phoneNumber = userNameText.getText();
						Main.cl.show(Main.cards, "card4");
						Main.loginStatus=true;
						//System.out.println(Main.loginStatus);
					}
					// System.out.println(passwordText.getText());

				}
			}
		});
		this.add(loginButton);

		JLabel noAccountLabel = new JLabel("没有账户，");
		noAccountLabel.setBounds(250, 315, 80, 30);
		noAccountLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		this.add(noAccountLabel);

		JLabel registerNowLabel = new JLabel("立即注册");
		registerNowLabel.setBounds(310, 315, 80, 30);
		registerNowLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		registerNowLabel.setForeground(Color.BLUE);
		registerNowLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					Main.cl.show(Main.cards, "card2");
					
				}
			}
		});
		this.add(registerNowLabel);

		JLabel forgetLabel = new JLabel("<html><u>忘记密码</u><html>");
		forgetLabel.setBounds(450, 235, 80, 25);
		forgetLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		forgetLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					Main.cl.show(Main.cards, "card8");
				}
			}
		});
		this.add(forgetLabel);
	}

}
