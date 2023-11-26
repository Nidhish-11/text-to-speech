import java.io.*;
import java.io.File.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.sun.speech.freetts.*;
import javax.sound.sampled.*;
class T2S1 implements ActionListener
{
	JFrame f;
	JButton b;
	JTextArea t;
	Choice c;
	Calendar cal;
	Voice voice;
	int hr,min,sec;
	VoiceManager vm;
	{
		System.setProperty("mbrola.base","E:/Nidhish/mbrola");
		vm=VoiceManager.getInstance();
		voice=vm.getVoice("mbrola_us3");
		voice.allocate();
	}
	T2S1()
	{
		f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("Good1.jpg")));
		f.setLayout(null);
		Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
		f.setBounds(0,0,ss.width,ss.height);
		f.setUndecorated(true);
		t=new JTextArea("Custom Announcement");
		t.setBounds(50,300,1250,100);
		t.setFont(new Font("Arial",Font.PLAIN,24));
		f.add(t);
		b=new JButton("Speak");
		b.setBounds(570,450,200,50);
		b.setFont(new Font("Arial",Font.PLAIN,24));
		f.add(b);
		//TEACHER NAMES
		c=new Choice();
		c.setBounds(50,210,150,50);
		f.add(c);
		c.addItem("Teachers");
		c.addItem("Nitish");
		c.addItem("B");
		c.addItem("C");
		c.addItem("D");
		c.addItem("E");
		b.addActionListener(this);
		f.setVisible(true);
		for(;;)
		{
			cal=Calendar.getInstance();
			hr=cal.get(Calendar.HOUR);
			min=cal.get(Calendar.MINUTE);
			sec=cal.get(Calendar.SECOND);
			if(hr==04 && min==05 && sec==00)
			voice.speak("Its 3:58");
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			AudioInputStream ais=AudioSystem.getAudioInputStream(new File("C:/Users/ngudbhav/Downloads/bbm.wav").getAbsoluteFile());
			Clip clip=AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e1)
		{
			System.out.print(""+e1);
		}
	}
	public static void main(String z[])
	{
		new T2S1();
	}
}