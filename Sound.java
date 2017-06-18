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
	//�������ֵ�·��
	String path = "musics\\";
	String file = new String("nor.mid");
	//�������
	Sequence sequence ;
	//��ò�����
	Sequencer miSequencer;
	//�Ƿ����ڲ���
	public boolean sign;
	//����Ҫ���ŵ����ֵ�����
	public void setMusic(String file)
	{
		this.file = file;
	}
	//��������
	public void soundPlay()
	{
		try
		{
			//��������ļ�
			sequence = MidiSystem.getSequence(new File(path + file));
			//��ò�����
			miSequencer = MidiSystem.getSequencer();
			//�򿪲�����
			miSequencer.open();
			//�����ַŵ���������
			miSequencer.setSequence(sequence);
			//��ʼ��������
			miSequencer.start();
			//���ڲ�������
			sign = true;
			//�������ֵĲ��Ŵ���
			miSequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
		} catch (InvalidMidiDataException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		} catch (MidiUnavailableException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	
	}
	//����ֹͣ����
	public void soundStop()
	{
		//ֹͣ��������
		miSequencer.stop();
		//�رղ�����
		miSequencer.close();
		//�����Ѿ�ֹͣ����
		sign = false;
	}
	//���ز�������״̬
	public boolean isplay()
	{
		return sign;
	}
	
}
