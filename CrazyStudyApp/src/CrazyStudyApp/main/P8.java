package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P8 extends JPanel
{
	P8()
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

		// /img/HomeImg.jpg �Ǵ���������ڱ�д����Ŀ��bin�ļ����µ�img�ļ����µ�һ��ͼƬ
//		icon=new ImageIcon(getClass().getResource("/img/pic2.jpg"));
//		img=icon.getImage();

		JLabel phoneLable = new JLabel("�ֻ���");
		phoneLable.setBounds(242, 152, 80, 25);
		phoneLable.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 16));
		this.add(phoneLable);

		JTextField phoneText = new JTextField("�������ֻ���", 20);
		phoneText.setBounds(310, 146, 200, 35);
		phoneText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 14));
		phoneText.setForeground(Color.LIGHT_GRAY);
		phoneText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// ʧȥ�����ʱ��
				String pswd = new String(phoneText.getText()).trim();
				if (pswd.equals(""))
				{// ���û����������. �������� ��ʾ�û���������
					phoneText.setText("�������ֻ���");
					phoneText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 14));
					phoneText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// ��ý����ʱ��
				String pswd = new String(phoneText.getText()).trim();
				if (pswd.equals("�������ֻ���"))
				{// �����������ʾ���� ,��ô���������, ������������ʾ
					phoneText.setText("");
					phoneText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(phoneText);

		JLabel checkLable = new JLabel("��֤��");
		checkLable.setBounds(242, 205, 80, 25);
		checkLable.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 16));
		this.add(checkLable);

		JTextField checkText = new JTextField("��������֤��", 20);
		checkText.setBounds(310, 200, 105, 35);
		checkText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 13));
		checkText.setForeground(Color.LIGHT_GRAY);
		checkText.addFocusListener(new FocusListener()
		{
			@Override
			public void focusLost(FocusEvent e)
			{// ʧȥ�����ʱ��
				String pswd = new String(checkText.getText()).trim();
				if (pswd.equals(""))
				{// ���û����������. �������� ��ʾ�û���������
					checkText.setText("��������֤��");
					checkText.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
					checkText.setForeground(Color.red);
				}
			}

			@Override
			public void focusGained(FocusEvent e)
			{// ��ý����ʱ��
				String pswd = new String(checkText.getText()).trim();
				if (pswd.equals("��������֤��") || pswd.equals("��֤�����"))
				{// �����������ʾ���� ,��ô���������, ������������ʾ
					checkText.setText("");
					checkText.setForeground(Color.BLACK);
				}
			}
		});
		this.add(checkText);

		JLabel tipLable = new JLabel("");
		tipLable.setBounds(400, 165, 80, 25);
		tipLable.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
		this.add(tipLable);

		JButton checkButton = new JButton("��ȡ��֤��");
		checkButton.setBounds(418, 200, 95, 35);
		checkButton.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 12));
		class myactionlistener implements ActionListener
		{
			Timer timer1 = new Timer(1000, this);

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String phonenum = phoneText.getText();
				if (e.getSource() == checkButton)
				{
//					System.out.println(SolveAccountClass.loginMap);
//					System.out.println(phoneText.getText());
					if (!SolveAccountClass.loginMap.containsKey(phoneText.getText()))
					{
						tipLable.setText("�ú��벻����");

						tipLable.setForeground(Color.red);

					} else if (phoneText.getText().equals("") || phoneText.getText().equals("�������ֻ���"))
					{
						phoneText.setText("�������ֻ���");
						phoneText.setForeground(Color.red);
					} else
					{
						timer1.start();
						checkButton.setEnabled(false);
						Main.phoneCode = PhoneCode.getPhonemsg(phonenum);
					}
				}
				if (!phoneText.getText().equals("") && !phoneText.getText().equals("�������ֻ���")
						&& SolveAccountClass.loginMap.containsKey(phoneText.getText()))
				{
					if (CountDownClass.getNum() >= 0)
					{
						checkButton.setText(String.valueOf(CountDownClass.getNum()));
						CountDownClass.numDown();
						System.out.println(CountDownClass.getNum());
					} else
					{
						checkButton.setText("��ȡ��֤��");
						CountDownClass.initNum();
						timer1.stop();
						checkButton.setEnabled(true);
					}
				}
			}
		}
		checkButton.addActionListener(new myactionlistener());

		this.add(checkButton);

		JButton confirmButton = new JButton("ȷ��");
		confirmButton.setBounds(320, 250, 130, 40);
		confirmButton.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 20));
		confirmButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					// System.out.println(checkText.getText());
					if (phoneText.getText().equals("") || phoneText.getText().equals("�������ֻ���"))
					{
						phoneText.setText("�������ֻ���");
						phoneText.setForeground(Color.red);
					} else if (!checkText.getText().equals(Main.phoneCode))
					{
						checkText.setText("��֤�����");
						checkText.setForeground(Color.red);
					} else
					{
						Main.phoneNumber = phoneText.getText();
						Main.cl.show(Main.cards, "card9");
					}
					// Main.cl.show(Main.cards, "card3");
				}
			}
		});
		this.add(confirmButton);

		JButton modifyButton = new JButton("���ص�¼ҳ��");
		modifyButton.setBounds(545, 370, 130, 33);
		modifyButton.setFont(new Font("����׼Բ_GDK", Font.PLAIN, 15));
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
