package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P4 extends JPanel
{
	public static JLabel numLable = new JLabel("");
	public static int problemNum = 0;
	static String problems[] = new String[30]; // 存放所有的题目
	public static double answers[] = new double[30]; // 存放每道题的答案
	public static String Correctoption[] = new String[30]; // 存放所有的正确选项
	public static String Recordoption[] = new String[30]; // 记录选项
	public static double options[][] = new double[30][4]; // 存放题目的选项

	ImageIcon icon;
	Image img;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P4()
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
//		icon=new ImageIcon(getClass().getResource("/img/pic4.jpg"));
//		img=icon.getImage();

		JLabel typeLable = new JLabel("请选择试卷类型");
		typeLable.setBounds(185, 155, 120, 25);
		typeLable.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		this.add(typeLable);

		JComboBox<String> cmb = new JComboBox<String>(); // 创建JComboBox
		cmb.addItem("--请选择--"); // 向下拉列表中添加一项
		cmb.addItem("小学");
		cmb.addItem("初中");
		cmb.addItem("高中");
		cmb.addItemListener(new CmdListener());
		cmb.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		cmb.setBounds(307, 150, 130, 35);
		this.add(cmb);

		JTextField problemNumText = new JTextField("请输入试题数", 20);
		problemNumText.setBounds(455, 150, 100, 35);
		problemNumText.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		problemNumText.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					problemNumText.setText("");
				}
			}
		});
		this.add(problemNumText);

		JLabel tipFour = new JLabel("");
		tipFour.setBounds(50, 60, 130, 25);
		tipFour.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
		this.add(tipFour);

		// JLabel numLable=new JLabel("");
		JButton checkButtonFour = new JButton("确定");
		checkButtonFour.setBounds(330, 250, 130, 35);
		checkButtonFour.setFont(new Font("方正准圆_GDK", Font.PLAIN, 18));
		checkButtonFour.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					if (cmb.getSelectedItem().toString().equals("--请选择--"))
					{
						tipFour.setText("请选择试题类型！");
						tipFour.setForeground(Color.red);
					} else if (problemNumText.getText().equals("") || problemNumText.getText().equals("请输入试题数"))
					{
						tipFour.setText("请输入试题数目！");
						tipFour.setForeground(Color.red);
					} else if (Integer.valueOf(problemNumText.getText()) < 10
							|| Integer.valueOf(problemNumText.getText()) > 30)
					{
						tipFour.setText("试题数目为10-30！");
						tipFour.setForeground(Color.red);
					} else
					{
						Main.paperType = cmb.getSelectedItem().toString();
						Main.problemNum = Integer.valueOf(problemNumText.getText());
						problems = GeneratePapers.generatethePaper(Main.problemNum, Main.paperType);// 生成题目
						GeneratePapers.getProblemoption(problems, Main.problemNum);
						Main.num=1;
						P5.current=0;
						P5.score=0;
						P5.errorNum=1;
						numLable.setText(String.valueOf(Main.num) + "/" + String.valueOf(Main.problemNum));
						Main.p5 = new P5();
						Main.p5.setLayout(null);
						Main.cards.add(Main.p5, "card5");
						Main.cl.show(Main.cards, "card5");
						
						
					}
				}
			}
		});
		this.add(checkButtonFour);

//		JButton modifyButton = new JButton("修改密码");
//		modifyButton.setBounds(545, 370, 130, 33);
//		modifyButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 14));
//		modifyButton.addMouseListener(new MouseAdapter()
//		{
//			public void mouseClicked(MouseEvent e)
//			{
//				if (e.getButton() == MouseEvent.BUTTON1)
//				{
//					Main.cl.show(Main.cards, "card7");
//				}
//			}
//		});
//		this.add(modifyButton);
	}
}
