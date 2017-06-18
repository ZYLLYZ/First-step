package com.zhao.box;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap
{
	//�洢��ͼ��λ����Ϣ
	private int[][] Mapxy = new int[20][20];
	//ĳһ��
	private int level = 0;
	//С�˵�λ��
	private int manx,many;
	//ת������
	int[] x = new int[400];
	//��ȡ�ļ�����
	FileReader fileReader;
	BufferedReader bufferedReader;
	//���ж�ȡ�����ַ�
	String bb = "";
	//���췽���������
	public ReadMap(int level)
	{
		this.level = level;
		int c = 0;
		try
		{
			fileReader = new FileReader(new File("maps\\"+level+".map"));
			bufferedReader = new BufferedReader(fileReader);
			String string;
			while((string = bufferedReader.readLine())!=null)
			{
				bb = bb + string;
			}
			byte[] d = bb.getBytes();
			for(int i = 0;i<bb.length();i++)
			{
				x[i] = d[i]-48;
			}
			for(int i = 0;i<20;i++)
			{
				for(int j = 0;j<20;j++)
				{
					Mapxy[i][j] = x[c++];
					if(Mapxy[i][j] == 5)
					{
						manx = j;
						many = i;
					}
				}
			}
		} catch (FileNotFoundException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public int[][] getMap()
	{
		return Mapxy;
	}
	public int getManx()
	{
		return manx;
	}
	public int getMany()
	{
		return many;
	}
}
