import java.util.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Server extends JFrame implements ActionListener,Runnable
{
	JTextField tf1;
	JTextArea ta1;
	JScrollPane p1;
	JButton b1;
	ServerSocket ss;
	Socket s1;
	PrintWriter pw;
	BufferedReader br;
	
public Server() 
{
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tf1=new JTextField();
	ta1=new JTextArea();
	p1=new JScrollPane(ta1);
	b1=new JButton("SEND");
	
	add(tf1);
	add(p1);
	add(b1);
	setResizable(false);
	ta1.setEditable(false);
	tf1.setBounds(30,40,170,30);
	ta1.setBounds(30, 40, 180, 30);
	b1.setBounds(220,40,70,30);
	p1.setBounds(30,80,260,250);
	tf1.setBackground(Color.green);
	ta1.setBackground(Color.blue);
	ta1.setForeground(Color.red);
	setTitle("chat server");
	setSize(350,400);
	setVisible(true);
	
	try
	{
	s1=new Socket(InetAddress.getByName("localhost"),4000);
	
	pw=new PrintWriter(s1.getOutputStream(),true);
	br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
	}
	catch(Exception e)
	{		
	}
	b1.addActionListener(this);
	tf1.addActionListener(this);
	
	new Thread(this).start();
 }
public void run()
{
	while(true)
	{
		try
		{
			String text=br.readLine();
			Date d=new Date();
			int hh=d.getHours();
			int mm=d.getMinutes();
			int ss=d.getSeconds();
			ta1.append(text+"\t-senders"+hh+":"+mm+":"+ss+"\n");
		}
		catch(Exception e)
		{			
		}
	}
}
public void actionPerformed(ActionEvent ae)
{
	String text=tf1.getText();
	Date d=new Date();
	int hh=d.getHours();
	int mm=d.getMinutes();
	int ss=d.getSeconds();
	ta1.append(text+"\t-me"+hh+":"+ss+"\n");
	pw.println(text);
	tf1.setText("");
}
	public static void main(String[] args) 
	{
		new Server();
	}
}
