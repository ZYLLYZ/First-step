package com.zhao.box;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap
{
	//存储地图的位置信息
	private int[][] Mapxy = new int[20][20];
	//某一关
	private int level = 0;
	//小人的位置
	private int manx,many;
	//转换数字
	int[] x = new int[400];
	//读取文件的流
	FileReader fileReader;
	BufferedReader bufferedReader;
	//按行读取数字字符
	String bb = "";
	//构造方法传入关数
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO 自动生成的 catch 块
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
