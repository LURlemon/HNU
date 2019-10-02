package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P2 extends JPanel
{

	ImageIcon icon;
	Image img;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P2()
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
//		icon=new ImageIcon(getClass().getResource("/img/pic2.jpg"));
//		img=icon.getImage();

		JLabel phoneLable = new JLabel("手机号");
		phoneLable.setBounds(242, 152, 80, 25);
		phoneLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 16));
		this.add(phoneLable);

		JTextField phoneText = new JTextField("请输入手机号", 20);
		phoneText.setBounds(310, 146, 200, 35);
		phoneText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		phoneText.setForeground(Color.LIGHT_GRAY);
		phoneText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				String pswd = new String(phoneText.getText()).trim();
				if (pswd.equals(""))
				{// 如果没有输入密码. 就用明文 提示用户输入密码
					phoneText.setText("请输入手机号");
					phoneText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
					phoneText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				String pswd = new String(phoneText.getText()).trim();
				if (pswd.equals("请输入手机号") || pswd.equals("验证码错误"))
				{// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					phoneText.setText("");
					phoneText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(phoneText);

		JLabel checkLable = new JLabel("验证码");
		checkLable.setBounds(242, 205, 80, 25);
		checkLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 16));
		this.add(checkLable);

		JTextField checkText = new JTextField("请输入验证码", 20);
		checkText.setBounds(310, 200, 105, 35);
		checkText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 13));
		checkText.setForeground(Color.LIGHT_GRAY);
		checkText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// 失去焦点的时候
				String pswd = new String(checkText.getText()).trim();
				if (pswd.equals(""))
				{// 如果没有输入密码. 就用明文 提示用户输入密码
					checkText.setText("请输入验证码");
					checkText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
					checkText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// 获得焦点的时候
				String pswd = new String(checkText.getText()).trim();
				if (pswd.equals("请输入验证码"))
				{// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					checkText.setText("");
					checkText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(checkText);

		JLabel tipLable = new JLabel("");
		tipLable.setBounds(400, 175, 80, 25);
		tipLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		this.add(tipLable);

		JButton checkButton = new JButton("获取验证码");
		checkButton.setBounds(418, 200, 95, 35);
		checkButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 12));
		class myactionlistener implements ActionListener
		{
			Timer timer1 = new Timer(1000, this);

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String phonenum = phoneText.getText();
				if (e.getSource() == checkButton)
				{
					if (SolveAccountClass.loginMap.containsKey(phoneText.getText()))
					{
						tipLable.setVisible(true);
						tipLable.setText("该号码已存在");

						tipLable.setForeground(Color.red);

					} else if (phoneText.getText().equals("") || phoneText.getText().equals("请输入手机号"))
					{
						phoneText.setText("请输入手机号");
						phoneText.setForeground(Color.red);
						tipLable.setVisible(false);
					} else
					{
						timer1.start();
						checkButton.setEnabled(false);
						Main.phoneCode = PhoneCode.getPhonemsg(phonenum);
					}
				}
				if (!phoneText.getText().equals("") && !phoneText.getText().equals("请输入手机号")
						&& !SolveAccountClass.loginMap.containsKey(phoneText.getText()))
				{
					if (CountDownClass.getNum() >= 0)
					{
						checkButton.setText(String.valueOf(CountDownClass.getNum()));
						CountDownClass.numDown();
					} else
					{
						checkButton.setText("获取验证码");
						CountDownClass.initNum();
						timer1.stop();
						checkButton.setEnabled(true);
					}
				}
			}
		}
		checkButton.addActionListener(new myactionlistener());

		this.add(checkButton);

		JButton confirmButton = new JButton("确认");
		confirmButton.setBounds(340, 270, 120, 38);
		confirmButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 18));
		confirmButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					// System.out.println(checkText.getText());
					if (phoneText.getText().equals("") || phoneText.getText().equals("请输入手机号"))
					{
						phoneText.setText("请输入手机号");
						phoneText.setForeground(Color.red);
					} else if (!checkText.getText().equals(Main.phoneCode))
					{
						checkText.setText("验证码错误");
						checkText.setForeground(Color.red);
						tipLable.setVisible(false);
					} 
					else
					{
						Main.phoneNumber = phoneText.getText();
						Main.cl.show(Main.cards, "card3");
					}
					// Main.cl.show(Main.cards, "card3");
				}
			}
		});
		this.add(confirmButton);

		JButton modifyButton = new JButton("返回登录");
		modifyButton.setBounds(545, 370, 130, 33);
		modifyButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		modifyButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					Main.cl.show(Main.cards, "card1");
				}
			}
		});
		this.add(modifyButton);
	}
}
