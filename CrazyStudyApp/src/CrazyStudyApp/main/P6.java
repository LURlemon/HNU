package CrazyStudyApp.main;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class P6 extends JPanel
{

	ImageIcon icon;
	Image img;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	P6()
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
//		icon=new ImageIcon(getClass().getResource("/img/pic6.jpg"));
//		img=icon.getImage();

		P5.numOfProblemLabel.setBounds(70, 30, 200, 25);
		P5.numOfProblemLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 20));
		this.add(P5.numOfProblemLabel);

		P5.scoreLabel.setBounds(70, 30, 200, 25);
		P5.scoreLabel.setFont(new Font("方正准圆_GDK", Font.PLAIN, 20));
		this.add(P5.scoreLabel);

		JButton restartButton = new JButton("开心心，再来一套！");
		restartButton.setBounds(570, 275, 160, 40);
		restartButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		restartButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					Main.num = 1;
					Main.cl.show(Main.cards, "card4");
				}
			}
		});
		this.add(restartButton);

//        //JFrame frame=new JFrame();
//        JPanel panel=new JPanel();
//        this.add(panel);

		// frame.setBounds(750, 450, 200, 100);

		JButton confirmButton = new JButton("残忍离开");
		confirmButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 10));
		confirmButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					System.exit(1);
				}
			}
		});
		this.add(confirmButton);

		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 10));
		cancelButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{

				}
			}
		});
		this.add(cancelButton);

		JButton[] bs =
		{ confirmButton, cancelButton };

		JButton exitButton = new JButton("生气气，不做了！");
		exitButton.setBounds(570, 325, 160, 40);
		exitButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		exitButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int r = JOptionPane.showConfirmDialog(Main.cards, "确定残忍退出吗", "退出", JOptionPane.YES_NO_CANCEL_OPTION);
				if (r == JOptionPane.YES_OPTION)
				{
					System.exit(1);
				} else
				{
					return;
				}
			}
		});

		this.add(exitButton);
		
		JButton errorButton = new JButton("看看我错了啥！");
		errorButton.setBounds(570, 375, 160, 40);
		errorButton.setFont(new Font("方正准圆_GDK", Font.PLAIN, 15));
		errorButton.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				P5.errorNum=1;
				try {
					Desktop.getDesktop().open(P5.errfile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		this.add(errorButton);

	}

}
