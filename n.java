/*package
containers
components
predefined classes
predefined methods
Networking
socket programming
class and interfaces
exception handling
ported
IP addresses
EventHandling
Action Listener*/
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;

public class Client extends JFrame implements ActionListener,Runnable
{
	JTextField f1;
	JTextArea a1;
	JScrollPane p1;
	JButton b1;
	ServerSocket ss;
	Socket s1;
	BufferedReader br;
	PrintWriter pw;
public Client
{
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tf1=new JTextField();
	ta1=new JTextArea();
	p1=new JScrollPane(ta1);
	b1=new JButton("SEND");

	add(p1);
	add(b1);
	add(tf1);
	
}
}