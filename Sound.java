package com.zhao.box;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Sound
{
	//设置音乐的路径
	String path = "musics\\";
	String file = new String("nor.mid");
	//获得音乐
	Sequence sequence ;
	//获得播放器
	Sequencer miSequencer;
	//是否正在播放
	public boolean sign;
	//传入要播放的音乐的名字
	public void setMusic(String file)
	{
		this.file = file;
	}
	//播放音乐
	public void soundPlay()
	{
		try
		{
			//获得音乐文件
			sequence = MidiSystem.getSequence(new File(path + file));
			//获得播放器
			miSequencer = MidiSystem.getSequencer();
			//打开播放器
			miSequencer.open();
			//将音乐放到播放器里
			miSequencer.setSequence(sequence);
			//开始播放音乐
			miSequencer.start();
			//正在播放音乐
			sign = true;
			//设置音乐的播放次数
			miSequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
		} catch (InvalidMidiDataException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		} catch (MidiUnavailableException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
	}
	//音乐停止播放
	public void soundStop()
	{
		//停止播放音乐
		miSequencer.stop();
		//关闭播放器
		miSequencer.close();
		//音乐已经停止播放
		sign = false;
	}
	//返回播放器的状态
	public boolean isplay()
	{
		return sign;
	}
	
}
