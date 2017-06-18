package com.zhao.box;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.transform.Source;

public class MainGamePic extends JFrame implements ActionListener, ItemListener
{
	
	private static final long serialVersionUID = -3104200748928540570L;
	//定义主界面上的各个控件
	public MenuBar jmbTool;
	public Menu jmselect;
	public MenuItem jmlrenew ,jmlup,jmldown,jmlselect,jmlreset,jmlexit;
	public Menu jmmusic;
	public MenuItem jmlqin,jmlpom,jmlguang,jmlnor,jmleye;
	Menu jmabout;
	public 	MenuItem jmlabout;
	public JLabel jlbl1,jlbl2;
	public GameField panel;
	public Sound sound;
	public JComboBox jc;
	public Container cont;
	public JButton btnrenew,btnlast,btnnext,btnchoose,btnfirst,btnover,btnmuc,btnback;
	public void reinit()
	{
		jmlrenew = new MenuItem("重新开始");
		jmlup = new MenuItem("上一关");
		jmldown = new MenuItem("下一关");
		jmlselect = new MenuItem("选择关卡");
		jmlreset = new MenuItem("悔一步");
		jmlexit = new MenuItem("退出");
		
		jmlrenew.addActionListener(this);
		jmlup.addActionListener(this);
		jmldown.addActionListener(this);
		jmlselect.addActionListener(this);
		jmlreset.addActionListener(this);
		jmlexit.addActionListener(this);
		
		
		jmselect = new Menu("菜单");
		jmselect.add(jmlrenew);
		jmselect.add(jmlup);
		jmselect.add(jmldown);
		jmselect.add(jmlreset);
		jmselect.add(jmlexit);
		
		jmlnor = new MenuItem("默认");
		jmlqin = new MenuItem("琴箫合奏");
		jmlpom = new MenuItem("泡泡堂");
		jmlguang = new MenuItem("灌篮高手");
		jmleye = new MenuItem("eyes on me");
		
		jmlnor.addActionListener(this);
		jmlqin.addActionListener(this);
		jmlpom.addActionListener(this);
		jmlguang.addActionListener(this);
		jmleye.addActionListener(this);
		
		jmmusic = new Menu("设置音乐");
		jmmusic.add(jmlnor);
		jmmusic.add(jmlqin);
		jmmusic.add(jmlpom);
		jmmusic.add(jmlguang);
		jmmusic.add(jmleye);
		jmlabout = new MenuItem("关于推箱子");
		jmlabout.addActionListener(this);
		jmabout = new Menu("关于");
		jmabout.add(jmlabout);
		jmbTool = new MenuBar();
		jmbTool.add(jmselect);
		jmbTool.add(jmmusic);
		jmbTool.add(jmabout);
		setMenuBar(jmbTool);
		jmlnor.setEnabled(false);
		jlbl1 = new JLabel("        JAVA推箱子v2.0");
		jlbl1.setFont(new Font("楷体",Font.PLAIN,25));
		jlbl1.setForeground(Color.lightGray);
		
		jlbl2 = new JLabel("更换音乐",SwingConstants.CENTER);
		add(jlbl1);
		add(jlbl2);
		jlbl1.setBounds(100,20,400,20);
		jlbl1.setForeground(Color.white);
		jlbl2.setBounds(625,500,55,20);
		jlbl2.setForeground(Color.white);
		panel.requestFocus();
	}
	public MainGamePic()
	{
		super("推箱子v2.0");
		init();
		reinit();
		
	}
	public void init()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		setSize(720,720);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.BLACK);
		//设置边上的按钮
				btnrenew=new JButton("重来");
				btnback=new JButton("悔一步");
				btnlast=new JButton("上一关");
				btnnext=new JButton("下一关");
				btnchoose=new JButton("选关");
				btnfirst=new JButton("第１关");
				btnover=new JButton("最终关");
				btnmuc=new JButton("音乐关");
				//添加按钮并设置事件监听
				add(btnrenew);add(btnlast);add(btnnext);add(btnchoose);add(btnfirst);add(btnover);add(btnmuc);add(btnback);
				btnrenew.setBounds(625,100,80,30);
				btnrenew.addActionListener(this);
				btnback.setBounds(625,150,80,30);
				btnback.addActionListener(this);
				btnfirst.setBounds(625,200,80,30);
				btnfirst.addActionListener(this);
				btnlast.setBounds(625,250,80,30);
				btnlast.addActionListener(this);
				btnnext.setBounds(625,300,80,30);
				btnnext.addActionListener(this);
				btnover.setBounds(625,350,80,30);
				btnover.addActionListener(this);
				btnchoose.setBounds(625,400,80,30);
				btnchoose.addActionListener(this);
				btnmuc.setBounds(625,450,80,30);
				btnmuc.addActionListener(this);
				jc = new JComboBox<>();
				//列表选择框并设置事件监听
				jc.setBounds(625,530,80,20);
				jc.addItem("默认");
				jc.addItem("琴萧合奏");
				jc.addItem("泡泡堂");
				jc.addItem("灌篮高手");
				jc.addItem("eyes on me");
				jc.addItemListener(this);
				cont = getContentPane();
				cont.add(jc);
				sound = new Sound();
				sound.soundPlay();
				panel = new GameField();
				add(panel);
				panel.initTuixiangzi(panel.level);
				panel.requestFocus();
				
				validate();
	}
	//事件处理
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		switch(jc.getSelectedIndex())
		{
		case 0:
			sound.setMusic("nor.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
			break;
		case 1:
			sound.setMusic("qin.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
			break;
		case 2:
			sound.setMusic("popo.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
			break;
		case 3:
			sound.setMusic("guang.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
			break;
		case 4:
			sound.setMusic("eyes on me.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
			break;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object sourece = arg0.getSource();
		if(sourece == btnmuc)
		{
			if(sound.sign)
			{
				sound.soundStop();
				btnmuc.setText("音乐关");
			}
			
			else
			{
				sound.soundPlay();
				btnmuc.setText("音乐开");
			}
				
		}
		if(sourece == btnchoose)
		{
			String string = JOptionPane.showInputDialog("请输入1-50:");
			panel.level = Integer.valueOf(string);
			panel.remove();
			if(panel.level>panel.max||panel.level<=0)
			{
				JOptionPane.showMessageDialog(this, "没有这一关！！");
			}
			else
			{
				panel.initTuixiangzi(panel.level);
				panel.requestFocus();
			}
		}
		if(sourece == btnlast)
		{
			panel.level = 50;
			panel.remove();
			panel.initTuixiangzi(panel.level);
			panel.requestFocus();
		}
		if(sourece == btnfirst)
		{
			panel.level = 1;
			panel.remove();
			panel.initTuixiangzi(panel.level);
			panel.requestFocus();
		}
		if(sourece == btnnext||sourece == jmldown)
		{
			panel.level ++;
			panel.remove();
			panel.initTuixiangzi(panel.level);
			panel.requestFocus();
		}
		if(sourece == btnover||sourece == jmlup)
		{
			panel.level --;
			panel.remove();
			panel.initTuixiangzi(panel.level);
			panel.requestFocus();
		}
		if(sourece == btnrenew||sourece == jmlrenew)
		{
			
			panel.remove();
			panel.initTuixiangzi(panel.level);
			panel.requestFocus();
		}
		if(sourece == jmlexit)
		{
			System.exit(0);
		}
		if(sourece == jmlnor)
		{
			sound.setMusic("nor.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
		}
		if(sourece == jmlpom)
		{
			sound.setMusic("popo.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
		}
		if(sourece == jmlguang)
		{
			sound.setMusic("guang.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
		}
		if(sourece == jmlqin)
		{
			sound.setMusic("qin.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
		}
		if(sourece == jmleye)
		{
			sound.setMusic("eyes on me.mid");
			if(sound.sign)
			sound.soundStop();
			btnmuc.setText("音乐关");
			sound.soundPlay();
			btnmuc.setText("音乐开");
			jmlnor.setEnabled(true);
		}
		if(sourece == jmlabout)
		{
			JOptionPane.showMessageDialog(this, "感谢支持!");
		}
		if(sourece == btnback||sourece == jmlreset)
		{
			if(panel.stack.isEmpty())
				JOptionPane.showMessageDialog(this, "未移动");
			else
			{
				switch(panel.back())
				{
				case 10:
					panel.backUp(10);
					break;
				case 11:
					panel.backUp(11);
					break;
				case 20:
					panel.backDown(20);
					break;
				case 21:
					panel.backDown(21);
					break;
				case 30:
					panel.backLeft(30);
					break;
				case 31:
					panel.backLeft(31);
					break;
				case 40:
					panel.backRight(40);
					break;
				case 41:
					panel.backRight(41);
					break;
					
				}
			}
		}
	}
	//
}
