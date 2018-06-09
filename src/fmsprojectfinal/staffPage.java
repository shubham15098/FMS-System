package fmsprojectfinal;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import java.util.*;
import java.io.*;
public class staffPage extends JFrame
{
	JButton b;
	private JScrollPane scroll;
	private JTabbedPane myTab;
	private JPanel homeP;
	private JPanel task;
   private JPanel sendLeave;
	private JPanel sendLogstaff;
	private int num = 0; //get the num of items
	private JLabel sendLog_label;
	private JTextField sendLog_field;
	private JFrame new_frame;
	sendLogstaff sL ;
	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	private JLabel nofl;private JTextField nof;fileHVACstaff fh;file fl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;
	private JLabel arrl;private JTextField arr;fileelecstaff fe;newuser [] n=new newuser[100];JFrame frl;int att=0;
	dept d=new dept();filesupinventory fsi;int kk=0,kx,kkl=0,kxl=0;JFrame f=new JFrame();JPanel pp=new JPanel();filenewuser fnu;filetask ft;taskfile [] tarray;
	
	public staffPage(dept d,filesupinventory fsi,fileelecstaff fe,fileHVACstaff fh,fileAVstaff fa,filesecstaff fsec,filehousekeepingstaff fho,newuser [] n,JFrame frl,filenewuser fnu,filetask ft,taskfile [] tarray,int att)
	{
		super("Staff");	
//		this.fho=fho;this.fsec=fsec;this.fh=fh;
		this.att=att;
		this.fa=fa;this.fho=fho;this.fsec=fsec;
		this.d=d;this.fsi=fsi;this.fe=fe;this.n=n;this.frl=frl;this.fh=fh;this.fnu=fnu;this.ft=ft;this.tarray=tarray;
//		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sL=new sendLogstaff(fsi,d,att);
		if(d instanceof Electricity)
			fl=fe;
		else if(d instanceof HVAC)
			fl=fh;
		else if(d instanceof AV)
			fl=fa;
		else if(d instanceof HVAC)
			fl=fsec;
		else if(d instanceof HVAC)
			fl=fho;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setVisible(true);
		
		leaveReqstaff lR = new leaveReqstaff(d,fl, att);
		
		new_frame = new JFrame();
		
		new_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		a1 = new JLabel("1");
		a1.setBounds(50,50,100,100); //loc then size
		a2 = new JLabel("2");
		a3 = new JLabel("3");
		a4 = new JLabel("4");
		
		
		homeP = new JPanel();
		task = new JPanel();

		sendLeave = new JPanel();
		sendLogstaff = new JPanel();
		homeP.setLayout(null);
		

		sendLogstaff.setLayout(null);
		
		b = new JButton("Request Logistic");
		sendLog_field = new JTextField();
		sendLog_label = new JLabel("Enter number of items: ");
		sendLog_label.setFont (sendLog_label.getFont ().deriveFont (15.0f));
		sendLog_label.setBounds(50,50,200,35);
		sendLog_field.setBounds(250,50,200,35);
		
		
		b.setBounds(150,150,135,30);
		
		
		sendLogstaff.add(b);
		sendLogstaff.add(sendLog_label);
		sendLogstaff.add(sendLog_field);
		
	
		
		JTextArea textArea = new JTextArea(10,20);
		scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		textArea.append("Notifications:\n\n");
		for(String v: d.arr[att].notifs)
			{
				if(v!=null)
					textArea.append(v+"\n");
			}
		
		JLabel lol = new JLabel("Notifications:");
		lol.setBounds(1000,50,150,30);
		scroll.setBounds(1000,75,200,200);
		
		homeP.add(scroll);
		homeP.add(lol);
		
		//homeP.add(a1);
		task.add(a2);
		sendLeave = lR.leave_method();
		
		
		
		myTab = new JTabbedPane();
		myTab.add("Home", homeP);
		myTab.add("Task",task);
		myTab.add("Send Leave",sendLeave);
		myTab.add("Send Log",sendLogstaff);
		myTab.setLocation(50,50);
		myTab.setPreferredSize(new Dimension(1370, 900));
		myTab.setVisible(true);
		myTab.setEnabled(true);
		
		//JScrollPane js=new JScrollPane();
		
		
		JLabel jxx=new JLabel("Last logout:  "+d.arr[att].logout);
		jxx.setFont(new Font("SansSerif", Font.BOLD, 14));
		pp.add(jxx);
		//pp.add(Box.createHorizontalStrut(70));
		
		JLabel jx=new JLabel("WELCOME");
		jx.setFont(new Font("Elephant", Font.BOLD, 33));
		jx.setPreferredSize(new Dimension(500,50));
		pp.add(Box.createHorizontalStrut(70));
		pp.add(jx);
		pp.add(Box.createVerticalStrut(100));

		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		f=this;
		JButton b1=new JButton("Logout");
		b1.setFont(new Font("SansSerif", Font.BOLD, 14));
		b1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy "+"\n"+" HH:mm:ss"); 
				Date date2=new Date();
				String Porsche=sdf.format(date2);
		    	d.arr[att].logout=Porsche;
		    	
		    	f.setVisible(false);
		      frl.setVisible(true);
		    }
		  });
		pp.add(Box.createHorizontalStrut(20));
		 pp.add(new ClockPane());
		 pp.add(Box.createHorizontalStrut(20));
		pp.add(b1);
		pp.add(myTab);
		new guistaffchktask(fl,pp, task, myTab, d, ft, tarray, att);
		this.add(pp);

		handler handle = new handler();
		b.addActionListener(handle);
		this.setVisible(true);
	}
	public class handler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == b)
			{
				num = Integer.parseInt(sendLog_field.getText());
				new_frame = sL.sendlog(num);
				new_frame.setVisible(true);
			}
			
		}
		
	}
	
}

class guistaffchktask
{int kxx=0;
	public guistaffchktask(file fl,JPanel pp,JPanel Task,JTabbedPane myTab,dept d,filetask ft,taskfile [] tarray,int att)
	{
StringBuilder sb;
		
		String data[][]=new String[100][100];
	    String column[]={"TASK ID","NAME","DESCRIPTION","DEADLINE","STATUS"};  
	  int i=1; kxx=0;
	  try{
		    for(i=1;i<=d.arr[att].not;i++){
		    	data[kxx][0]=String.valueOf(d.arr[att].t[i].Getid());
		    	data[kxx][1]=d.arr[att].t[i].Getname();
		    	data[kxx][2]=d.arr[att].t[i].Getdesc();
		    	data[kxx][3]=d.arr[att].t[i].Getdeadline();
		    	data[kxx][4]=d.arr[att].t[i].Getstatus();
		    	kxx++;  }}catch(Exception e){} 
	  JTable table = new JTable( data, column) ;
	  table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
	    table.setBounds(30,40,500,300);  
	    JScrollPane js=new JScrollPane();
	    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    js.getViewport().add(table, null);
	    JPanel ap=new JPanel();
	    JPanel gp=new JPanel();
	    JPanel rp=new JPanel();
	    JLabel al=new JLabel("ONGOING");
	    JLabel rl=new JLabel("COMPLETE");
	    JLabel gl=new JLabel("GENERATE REPORT");
	    ap.add(al);rp.add(rl);gp.add(gl);
	    JTextField accept=new JTextField("ONGOING");
	    JTextField reject=new JTextField("COMPLETE");
	    JTextField genre=new JTextField("GENERATE REPORT");
	    ap.add(accept);rp.add(reject);gp.add(genre);
	    try
	    {
	    accept.setPreferredSize(new Dimension(100,30));
	    reject.setPreferredSize(new Dimension(100,30));
	    accept .addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
       	String s=arg0.getActionCommand();int chk=0;
       	if(s.equals(""))
	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
	    	else
	    	{
       	for(int i=1;i<=d.arr[att].not;i++)
       	{
       		 if(Integer.parseInt(s)==d.arr[att].t[i].Getid())
       		{
       			 if(d.arr[att].t[i].Getstatus().equals("Not started"))
       		{
       				 for(int jj=1;jj<task.tcount;jj++)
       				 {
       					 if(Integer.parseInt(s)==tarray[jj].taskid)
       					 {
       						 tarray[jj].status="Ongoing";
       						 Date dd=new Date();
               				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
               				 String Porsche=sdf.format(dd);
               				 d.arr[att].t[i].fromdate=Porsche;
       						 tarray[jj].fromdate=Porsche;
       					 }
       				 }
       				 d.arr[att].t[i].Setstatus("Ongoing");
       				 d.arr[att].t[i].Setstatus("Ongoing");
       				 d.arr[att].Setstatusoftask("Ongoing");
       				 d.arr[att].Setstatus("Busy till "+d.arr[att].t[i].Getdeadline());
       				 fl.put(2,  d.arr[att].Getuserid());
       			int kxk1=0,kxk=0;
       			for( kxk=0;kxk<kxx;kxk++)
       				if(Integer.parseInt(data[kxk][0])==d.arr[att].t[i].Getid())
       					kxk1=kxk;
       			data[kxk1][4]="Ongoing";
       			ft.put();
       			ft.create(1);
       			pp.add(myTab);
       			chk=1;
       		}
       			 else if(d.arr[att].t[i].Getstatus().equals("Ongoing"))
       				 {JOptionPane.showMessageDialog(null, "Already Ongoing");chk=2;}
       		 else
        			{JOptionPane.showMessageDialog(null, "Already Completed"); chk=2;}
       		break;
       		}
       	}
       	if(chk==0)
       		JOptionPane.showMessageDialog(null, "Invalid taskid"); 
	    	}
       } });
	    
	    reject .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String s=arg0.getActionCommand();int chk=0;
	        	if(s.equals(""))
   	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
   	    	else
   	    	{
   	    		for(int i=1;i<=d.nos;i++)
   	        	{
   	        		 if(Integer.parseInt(s)==d.arr[att].t[i].Getid())
   	        		{
   	        			 if(d.arr[att].t[i].Getstatus().equals("Ongoing"))
   	        		{
   	        				 for(int jj=1;jj<task.tcount;jj++)
   	        				 {
   	        					 if(Integer.parseInt(s)==tarray[jj].taskid)
   	        					 {
   	        						 tarray[jj].status="Complete";
   	        						 Date dd=new Date();
   	    	        				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
   	    	        				 String Porsche=sdf.format(dd);
   	    	        				 d.arr[att].t[i].todate=Porsche;
   	    	        				 tarray[jj].todate=Porsche;
   	        					 }
   	        				 }
   	        				 d.arr[att].t[i].Setstatus("Complete");
   	        			int kxk1=0,kxk=0;
   	        			for( kxk=0;kxk<kxx;kxk++)
   	        				if(Integer.parseInt(data[kxk][0])==d.arr[att].t[i].Getid())
   	        					kxk1=kxk;
	        			data[kxk1][4]="Complete";
	        			 d.arr[att].t[i].Setstatus("Complete");
       				 d.arr[att].Setstatusoftask("Complete");
       				 d.arr[att].Setstatus("Available");
       				 if(d.arr[att].l.Getstatus()=="Accepted")
       				 { fl.put(2,d.arr[att].Getuserid());
       				 fl.create(1);}
	        			pp.add(myTab);
	        			ft.put();
	        			ft.create(1);
	        			chk=1;
	        			}
   	        			 else if(d.arr[att].t[i].Getstatus().equals("Complete"))
   	        				 {JOptionPane.showMessageDialog(null, "Already Completed");chk=2;}
	        			else
	        				{JOptionPane.showMessageDialog(null, "Not yet started");chk=2;}
	        			break;
	        		}
	        	}
	        	if(chk==0)
	        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	        }}
	        });
	    genre .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String s=arg0.getActionCommand();int chk=0;
	        	System.out.println(d.arr[att].t[1].todate);
	        	if(s.equals(""))
   	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
   	    	else
   	    	{
   	    		for(int i=1;i<=d.nos;i++)
   	        	{
   	        		 if(Integer.parseInt(s)==d.arr[att].t[i].Getid())
   	        		{
   	        			 if(d.arr[att].t[i].Getstatus().equals("Complete"))
   	        		{
   	        				
   	        			int kxk1=0,kxk=0;
	        			d.arr[att].genreport(d.arr[att].t[i]);
	        			ft.put();
	        			ft.create(1);
	        			pp.add(myTab);
	        			chk=1;
	        			}
	        			else
	        				{JOptionPane.showMessageDialog(null, "Not yet completed");chk=2;}
	        			break;
	        		}
	        	}
	        	if(chk==0)
	        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	        }}
	        });
	    }
	    catch(Exception e){}
	  accept.addMouseListener(new MouseListener() 
		{public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {accept.setText("");}
		});
	    reject.addMouseListener(new MouseListener() 
		{public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {reject.setText("");}
		});
	    genre.addMouseListener(new MouseListener() 
		{public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {genre.setText("");}
		});
	   Task.add(ap,BorderLayout.SOUTH);Task.add(rp,BorderLayout.SOUTH);Task.add(gp,BorderLayout.SOUTH);
	    Task.add(js);  
		}}
	     
	
