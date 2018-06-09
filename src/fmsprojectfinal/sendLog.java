package fmsprojectfinal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
/**@ brief GUI interface for staff to send log request to their respective supervisors*/
 class sendLogstaff extends JFrame
{
	private JTextField[] arrayOfFields = new JTextField[11];
	private JTextField numOfreq;
	private JFrame newFrame;
	private JLabel label1;
	private int n= 0; // to store the number of requests
	private JButton mybun;
	private ArrayList<String> array = new ArrayList<String>(); // here we get an array in which the logistics will be stored
	
	handler handle = new handler();
	filesupinventory fsi;
	dept d;int att;
	public sendLogstaff(filesupinventory fsi,dept d,int att)
	{
		newFrame = new JFrame();
		this.att=att;this.d=d;
		//numOfreq = new JTextField();
		//label1 = new JLabel("Enter the number of requests: ");
		this.fsi=fsi;
		newFrame.setLayout(null);
		
		//label1.setBounds(25,25,250,50);
		//numOfreq.setBounds(300,25,150,50);
		
		//numOfreq.addActionListener(handle);
		
		//newFrame.add(label1);
		//newFrame.add(numOfreq);
	}
	
	public JFrame sendlog(int num)
	{
		newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mybun = new JButton("Request");
		n = num;
		
		if(num>6)
		{
			num = 6;
			n = num;
		}
		
		newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		label1 = new JLabel("Enter the Logistics: ");
		label1.setBounds(25,25,250,50);
		newFrame.add(label1);
		
		
		
		int temp = 100;
		
		for(int i=1; i<=num; i++)
		{
			
			{arrayOfFields[i] = new JTextField();
			arrayOfFields[i].setBounds(100,temp,100,35);
			newFrame.add(arrayOfFields[i]);
			temp = temp + 40;}
			
		}
		
		mybun.setBounds(200,temp+70,100,30);
		newFrame.add(mybun);
		
		mybun.addActionListener(handle);
				
		for(int i=1; i<=num; i++)
		{
			arrayOfFields[i].addActionListener(handle);
		}
		
		return newFrame;
	}
	
	public class handler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) 
		{
			array = new ArrayList<String>();
			//System.out.println(array);
			if(event.getSource() == mybun)
			{
				for(int i=1; i<=n; i++)
				{
					String xx=arrayOfFields[i].getText();
					
						array.add(xx);
						arrayOfFields[i].setText("");
						newFrame.remove(arrayOfFields[i]);
					
				}
				int arr[]=new int[100];
				int k=0;
				for(String val: array)
				{
					if(val.equals(""))
					{
						//array.remove(val);
						arr[k++]=array.indexOf(val);
					}
				}
				
				for(int kk=0;kk<k;kk++)
					array.remove(array.get(arr[kk]));
				
				
				JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
				newFrame.setVisible(false);
				
				int j = 0;
			
				//System.out.println(array);
				
				newFrame.remove(label1);
				newFrame.remove(mybun);
				func(array);
				
			}
			
		}
		
	}
	void func(ArrayList< String> array)
	{
		supinventory  ss=new supinventory();
		ss.Setnoofitems(array.size());
		//System.out.println(array.size());
		for(int xy=1;xy<=array.size();xy++)
		{	ss.arrayofitems[xy]=array.get(xy-1);}
		//System.out.println("kk"+ss.arrayofitems[1]);
		ss.Setdept(d.department.trim());
		ss.userid=d.arr[att].Getuserid();
		
		fsi.add(ss);
		fsi.create(1);
	}
}