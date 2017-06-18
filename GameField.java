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
	//С�˵�����
	int manx;
	int many;
	//���ͼƬ
	Image[] mapImage;
	//��ȡ���µ�ͼ
	int[][] mapUpdate;
	//��ȡ��׼��ͼ
	int[][] mapMode;
	//ĳһ�صĵ�ͼ
	ReadMap levelmap;
	int len = 30;
	//����
	int max = 50;
	//��ÿ�����м�¼
	Stack stack = new Stack();
	int level = 1;
	public GameField()
	{
		setBounds(15,50,600,600);
		setBackground(Color.white);
		//��Ӽ����¼�
		addKeyListener(this);
		mapImage = new Image[10];
		for(int i = 0;i<10;i++)
			mapImage[i] = Toolkit.getDefaultToolkit().getImage("pic\\"+ i +".gif");
		setVisible(true);
		
	}
	void initTuixiangzi(int level)
	{
		this.level = level;
		//ʵ������level�صĵ�ͼ
		levelmap =  new ReadMap(level);
		//��õ�ͼ��λ����Ϣ
		mapUpdate = levelmap.getMap();
		mapMode = levelmap.getMap();
		//���С�˵�λ��
		manx = levelmap.getManx();
		many = levelmap.getMany();
		//�ػ���Ϸ����
		repaint();
	}
	int maxLevel()
	{
		return max;
	}
	//��д��ͼ����
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
		g.setFont(new Font("����",Font.PLAIN,30));
		g.drawString("��"+level+"��", 150,40);
	};
	//������
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
	
	//������
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
	//������
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
	//������
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
	//�Լ��̵Ĵ���
	
	@Override
	public void keyPressed(KeyEvent arg0)
	{System.out.println("dsfsdfds");
		//������
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			
			moveUp();
		}
		//������
		 if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveDown();
		}
		//������
		 if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveLeft();
		}
		//������
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveRight();
		}
		if(iswin())
		{
			
			if(level == max)
			{
				System.out.println("sdfds");
				JOptionPane.showConfirmDialog(this, "��ϲȫ��ͨ��");
				
			}
			else
			{
				String string = "�Ƿ������һ�أ�";
				String title = "����";
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
	//�ǲ����˵������
	public boolean isEmpty()
	{
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	//��ջ
	public int back()
	{
		return (Integer)stack.pop();
	}
	//
	void remove()
	{
		stack.removeAllElements();
	}
	//�ж���Ӯ
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
