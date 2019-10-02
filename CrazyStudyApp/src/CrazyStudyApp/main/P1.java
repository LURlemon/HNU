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
		// ����������Ϊ�˱���ͼƬ���Ը��洰�����е�����С�������Լ����óɹ̶���С
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P1()
	{


		JLabel userNameLable = new JLabel("�û���");
		userNameLable.setBounds(242, 146, 80, 25);
		userNameLable.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 16));

		this.add(userNameLable);

		JLabel passwordLable = new JLabel("��   ��");
		passwordLable.setBounds(242, 205, 80, 25);
		passwordLable.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 16));
		this.add(passwordLable);

		JTextField userNameText = new JTextField("�������û���", 20);
		userNameText.setBounds(305, 144, 200, 32);
		userNameText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 13));
		userNameText.setForeground(Color.LIGHT_GRAY);
		userNameText.addFocusListener(new FocusListener()
		{

			@Override
			public void focusLost(FocusEvent e)
			{// ʧȥ�����ʱ��
				if (userNameText.getText().trim().equals(""))
				{// ���û���κ����� ,����ʾ�û�����
					userNameText.setText("�������û���");
					userNameText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// ��ý����ʱ��
				if (userNameText.getText().trim().equals("�������û���"))
				{// �������ʾ���� ,�������ʾ����
					userNameText.setText("");
					userNameText.setForeground(Color.BLACK);
				}
			}
		});
		// userNameText.setOpaque(false);
		// userNameText.setBorder(null);
		this.add(userNameText);

		JPasswordField passwordText = new JPasswordField(15);
		passwordText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 13));
		passwordText.setEchoChar('\0');
		passwordText.setText("����������");
		passwordText.setBounds(305, 200, 200, 32);
		passwordText.setForeground(Color.LIGHT_GRAY);
		passwordText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// ʧȥ�����ʱ��
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals(""))
				{// ���û����������. �������� ��ʾ�û���������
					passwordText.setEchoChar('\0');
					passwordText.setText("����������");
					passwordText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 13));
					passwordText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// ��ý����ʱ��
				String pswd = new String(passwordText.getPassword()).trim();
				if (pswd.equals("����������"))
				{// �����������ʾ���� ,��ô���������, ������������ʾ
					passwordText.setText("");
					passwordText.setEchoChar('*');
					passwordText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(passwordText);

		JLabel tipLable2 = new JLabel("");
		tipLable2.setBounds(510, 206, 80, 25);
		tipLable2.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
		this.add(tipLable2);

		JLabel tipLable1 = new JLabel("");
		tipLable1.setBounds(510, 146, 80, 25);
		tipLable1.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
		this.add(tipLable1);

		JButton loginButton = new JButton("��¼");
		loginButton.setBounds(336, 270, 125, 32);
		loginButton.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 15));
		loginButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					if (userNameText.getText().equals("�������û���"))
					{
						userNameText.setText("�������û���");
						userNameText.setForeground(Color.red);
					} else if (passwordText.getText() == "����������")
					{
						passwordText.setEchoChar('\0');
						passwordText.setText("����������");
						// passwordText.setForeground(Color.red);
					} else if (!SolveAccountClass.loginMap.containsKey(userNameText.getText()))
					{
						tipLable1.setText("�û�������");
						tipLable1.setForeground(Color.red);
					} else if (!SolveAccountClass.loginMap.get(userNameText.getText()).equals(passwordText.getText()))
					{
						tipLable2.setText("�������");
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

		JLabel noAccountLabel = new JLabel("û���˻���");
		noAccountLabel.setBounds(250, 315, 80, 30);
		noAccountLabel.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
		this.add(noAccountLabel);

		JLabel registerNowLabel = new JLabel("����ע��");
		registerNowLabel.setBounds(310, 315, 80, 30);
		registerNowLabel.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
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

		JLabel forgetLabel = new JLabel("<html><u>��������</u><html>");
		forgetLabel.setBounds(450, 235, 80, 25);
		forgetLabel.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
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
