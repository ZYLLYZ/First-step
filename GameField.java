package com.zhao.box;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.NonWritableChannelException;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameField extends JPanel implements KeyListener
{
	//小人的坐标
	int manx;
	int many;
	//获得图片
	Image[] mapImage;
	//读取更新地图
	int[][] mapUpdate;
	//读取基准地图
	int[][] mapMode;
	//某一关的地图
	ReadMap levelmap;
	int len = 30;
	//最大关
	int max = 50;
	//对每步进行记录
	Stack stack = new Stack();
	int level = 1;
	public GameField()
	{
		setBounds(15,50,600,600);
		setBackground(Color.white);
		//添加键盘事件
		addKeyListener(this);
		mapImage = new Image[10];
		for(int i = 0;i<10;i++)
			mapImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\"+ i +".gif");
		setVisible(true);
		
	}
	void initTuixiangzi(int level)
	{
		this.level = level;
		//实例化第level关的地图
		levelmap =  new ReadMap(level);
		//获得地图的位置信息
		mapUpdate = levelmap.getMap();
		mapMode = levelmap.getMap();
		//获得小人的位置
		manx = levelmap.getManx();
		many = levelmap.getMany();
		//重画游戏界面
		repaint();
	}
	int maxLevel()
	{
		return max;
	}
	//重写画图方法
	public void paint(java.awt.Graphics g)
	{
		for(int i = 0;i<20;i++)
		{
			for(int j = 0;j<20;j++)
			{
				g.drawImage(mapImage[mapMode[j][i]], i*len, j*len, this);
			}
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("楷体",Font.PLAIN,30));
		g.drawString("第"+level+"关", 150,40);
	};
	//向上走
	public void moveUp()
	{
		if(mapUpdate[many-1][manx] == 2||mapUpdate[many-1][manx] == 4)
		{
			mapUpdate[many-1][manx] = 8;
			
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
			repaint();
			many--;
			stack.push(10);
		}
		else if(mapUpdate[many-1][manx] == 3)
		{
			if(mapUpdate[many-2][manx] == 2)
			{
				mapUpdate[many-1][manx] = 8;
				mapUpdate[many-2][manx] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many--;
				stack.push(11);
			}
			else if(mapUpdate[many-2][manx] == 4)
			{
				mapUpdate[many-1][manx] = 8;
				mapUpdate[many-2][manx] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many--;
				stack.push(11);
			}
			else {
				mapUpdate[many][manx] = 8;
				repaint();
			}
		}
		else if(mapUpdate[many-1][manx] == 9)
		{
			if(mapUpdate[many-2][manx] == 2)
			{
				mapUpdate[many-1][manx] = 8;
				mapUpdate[many-2][manx] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many--;
				stack.push(11);
			}
			else if(mapUpdate[many-2][manx] == 4)
			{
				mapUpdate[many-1][manx] = 8;
				mapUpdate[many-2][manx] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many--;
				stack.push(11);
			}
			else {
				mapUpdate[many][manx] = 8;
				repaint();
			}
		}
		if(mapUpdate[many][manx] == 1)
		{
			mapUpdate[many][manx] = 8;
			repaint();
		}
	}
	public void backUp(int t)
	{
		if(t == 10)
		{
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		else if(t == 11)
		{
			if(mapMode[many][manx] == 3)
			{
				mapUpdate[many][manx] = 3;
				
			}
			else
				mapUpdate[many][manx] = 4;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		many++;
		mapUpdate[many][manx] = 8;
		repaint();
	}
	
	//向下走
	public void moveDown()
	{
		if(mapUpdate[many+1][manx] == 2||mapUpdate[many+1][manx] == 4)
		{
			mapUpdate[many+1][manx] = 5;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
			repaint();
			many++;
			stack.push(20);
		}
		else if(mapUpdate[many+1][manx] == 3)
		{
			if(mapUpdate[many+2][manx] == 2)
			{
				mapUpdate[many+1][manx] = 5;
				mapUpdate[many+2][manx] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many++;
				stack.push(21);
			}
			else if(mapUpdate[many+2][manx] == 4)
			{
				mapUpdate[many+1][manx] = 5;
				mapUpdate[many+2][manx] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many++;
				stack.push(21);
			}
			else {
				mapUpdate[many][manx] = 5;
				repaint();
			}
		}
		else if(mapUpdate[many+1][manx] == 9)
		{
			if(mapUpdate[many+2][manx] == 2)
			{
				mapUpdate[many+1][manx] = 5;
				mapUpdate[many+2][manx] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many++;
				stack.push(21);
			}
			else if(mapUpdate[many+2][manx] == 4)
			{
				mapUpdate[many+1][manx] = 5;
				mapUpdate[many+2][manx] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				many++;
				stack.push(21);
			}
			else {
				mapUpdate[many][manx] = 5;
				repaint();
			}
		}
		if(mapUpdate[many][manx] == 1)
		{
			mapUpdate[many][manx] = 5;
			repaint();
		}

	}
	public void backDown(int t)
	{
		if(t == 20)
		{
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		else if(t == 21)
		{
			if(mapMode[many][manx] == 3)
			{
				mapUpdate[many][manx] = 3;
				
			}
			else
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
		}
		many--;
		mapUpdate[many][manx] = 5;
		repaint();

	}
	//向左走
	public void moveLeft()
	{

		if(mapUpdate[many][manx-1] == 2||mapUpdate[many][manx-1] == 4)
		{
			mapUpdate[many][manx-1] = 6;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
			repaint();
			manx--;
			stack.push(30);
		}
		else if(mapUpdate[many][manx-1] == 3)
		{
			if(mapUpdate[many][manx-2] == 2)
			{
				mapUpdate[many][manx-1] = 6;
				mapUpdate[many][manx-2] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx--;
				stack.push(31);
			}
			else if(mapUpdate[many][manx-2] == 4)
			{
				mapUpdate[many][manx-1] = 6;
				mapUpdate[many][manx-2] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx--;
				stack.push(31);
			}
			else {
				mapUpdate[many][manx] = 6;
				repaint();
			}
		}
		else if(mapUpdate[many][manx-1] == 9)
		{
			if(mapUpdate[many][manx-2] == 2)
			{
				mapUpdate[many][manx-1] = 6;
				mapUpdate[many][manx-2] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx--;
				stack.push(31);
			}
			else if(mapUpdate[many][manx-2] == 4)
			{
				mapUpdate[many][manx-1] = 6;
				mapUpdate[many][manx-2] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx--;
				stack.push(31);
			}
			else {
				mapUpdate[many][manx] = 6;
				repaint();
			}
		}
		if(mapUpdate[many][manx] == 1)
		{
			mapUpdate[many][manx] = 6;
			repaint();
		}


	}
	public void backLeft(int t)
	{

		if(t == 30)
		{
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		else if(t == 31)
		{
			if(mapMode[many][manx] == 3)
			{
				mapUpdate[many][manx] = 3;
				
			}
			else
				mapUpdate[many][manx] = 4;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		manx++;
		mapUpdate[many][manx] = 6;
		repaint();


	}
	//向右走
	public void moveRight()
	{

		if(mapUpdate[many][manx+1] == 2||mapUpdate[many][manx+1] == 4)
		{
			mapUpdate[many][manx+1] = 7;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
			repaint();
			manx++;
			stack.push(40);
		}
		else if(mapUpdate[many][manx+1] == 3)
		{
			if(mapUpdate[many][manx+2] == 2)
			{
				mapUpdate[many][manx+1] = 7;
				mapUpdate[many][manx+2] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx++;
				stack.push(41);
			}
			else if(mapUpdate[many][manx+2] == 4)
			{
				mapUpdate[many][manx+1] = 7;
				mapUpdate[many][manx+2] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx++;
				stack.push(41);
			}
			else {
				mapUpdate[many][manx] = 6;
				repaint();
			}
		}
		else if(mapUpdate[many][manx+1] == 9)
		{
			if(mapUpdate[many][manx+2] == 2)
			{
				mapUpdate[many][manx+1] = 7;
				mapUpdate[many][manx+2] = 3;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx++;
				stack.push(41);
			}
			else if(mapUpdate[many][manx+2] == 4)
			{
				mapUpdate[many][manx+1] = 7;
				mapUpdate[many][manx+2] = 9;
				if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
				{
					mapUpdate[many][manx] = 4;
				}
				else
				{
					mapUpdate[many][manx] = 2;
				}
				repaint();
				manx++;
				stack.push(41);
			}
			else {
				mapUpdate[many][manx] = 7;
				repaint();
			}
		}
		if(mapUpdate[many][manx] == 1)
		{
			mapUpdate[many][manx] = 7;
			repaint();
		}


	}
	public void backRight(int t)
	{

		if(t == 40)
		{
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		else if(t == 41)
		{
			if(mapMode[many][manx] == 3)
			{
				mapUpdate[many][manx] = 3;
				
			}
			else
				mapUpdate[many][manx] = 4;
			if(mapMode[many][manx] == 4||mapMode[many][manx] == 9)
			{
				mapUpdate[many][manx] = 4;
			}
			else
			{
				mapUpdate[many][manx] = 2;
			}
		}
		manx--;
		mapUpdate[many][manx] = 7;
		repaint();

	}
	//对键盘的处理
	
	@Override
	public void keyPressed(KeyEvent arg0)
	{System.out.println("dsfsdfds");
		//向上走
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			
			moveUp();
		}
		//向下走
		 if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveDown();
		}
		//向左走
		 if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveLeft();
		}
		//向右走
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveRight();
		}
		if(iswin())
		{
			
			if(level == max)
			{
				System.out.println("sdfds");
				JOptionPane.showConfirmDialog(this, "恭喜全部通关");
				
			}
			else
			{
				String string = "是否进入下一关？";
				String title = "过关";
				int choice = JOptionPane.showConfirmDialog(null,string,title,JOptionPane.YES_NO_OPTION);
				if(choice == 0)
				{
					level++;
					initTuixiangzi(level);
				}
				else
					System.exit(0);
					
				
			}
			stack.removeAllElements();
		}
	}
	//是不是退到了最初
	public boolean isEmpty()
	{
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	//出栈
	public int back()
	{
		return (Integer)stack.pop();
	}
	//
	void remove()
	{
		stack.removeAllElements();
	}
	//判断输赢
	public boolean iswin()
	{
		for(int i = 0;i<20;i++)
		{
			for(int j = 0;j<20;j++)
			{
				
				if(mapMode[i][j] == 4 || mapMode[i][j] == 9 )
				{
					if(mapUpdate[i][j] == 9)
						continue;
					else
						return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}

	
	
}
