
package fmsprojectfinal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import javax.swing.table.*;

import fmsprojectfinal.staffPage.handler;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

public class supervisorPage extends JFrame 
{
	assignTaskstaff aT = new assignTaskstaff();
	private JScrollPane scroll;
	private JTabbedPane myTab;
	private JPanel homeP;
	private JPanel viewtaskreports;
	private JPanel staffP;
	private JPanel logReq;
	private JPanel leaveReq;
	private JPanel task;
	private JPanel newUsers;
	private JPanel assignTask;
	private JPanel sendLeave;
	private JPanel sendLog;
	int num=0;
	private JLabel a1;
	private JLabel logout;
	JButton b;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	private JLabel a5;
	private JLabel a6;
	private JLabel a7;
	private JLabel a8;
	private JLabel a9;
	sendLogsup sL ;
	private JLabel sendLog_label;
	private JPanel sendLogstaff;
	private JFrame new_frame;
	private JTextField sendLog_field;
	private JLabel nofl;private JTextField nof;fileHVACstaff fh;file fl;
	private JLabel arrl;private JTextField arr;fileelecstaff fe;newuser [] n=new newuser[100];JFrame frl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;
	dept d=new dept();filesupervisor fs;filesupinventory fsi;filegminventory fgi;int kk=0,kx,kkl=0,kxl=0;JFrame f=new JFrame();JPanel pp=new JPanel();filenewuser fnu;filetask ft;taskfile [] tarray;
	public supervisorPage(dept d,filesupervisor fs,filesupinventory fsi,filegminventory fgi,fileelecstaff fe,fileHVACstaff fh,fileAVstaff fa,filesecstaff fsec,filehousekeepingstaff fho,newuser [] n,JFrame frl,filenewuser fnu,filetask ft,taskfile [] tarray)
	{
		super("Supervisor");
		this.fho=fho;this.fsec=fsec;this.fh=fh;this.fs=fs;this.fgi=fgi;
		this.d=d;this.fsi=fsi;this.fe=fe;this.n=n;this.frl=frl;this.fh=fh;this.fnu=fnu;this.ft=ft;this.tarray=tarray;
//		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		sL=new sendLogsup(fgi,d);
		this.setVisible(true);
		
		leaveReqsup lr=new leaveReqsup(d, fs);
		new_frame = new JFrame();
		
		new_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		a1 = new JLabel("1");
		a1.setBounds(50,50,100,100); //loc then size
		a2 = new JLabel("2");
		a3 = new JLabel("3");
		a4 = new JLabel("4");
		a5 = new JLabel("5");
		a6 = new JLabel("6");
		a7 = new JLabel("7");
		a8 = new JLabel("8");
		a9 = new JLabel("9");
		
		viewtaskreports=new JPanel();
		homeP = new JPanel();
		staffP = new JPanel();		sendLogstaff = new JPanel();
		logReq = new JPanel();
		leaveReq = new JPanel();
		sendLogstaff.setLayout(null);
		task = new JPanel();
		newUsers = new JPanel();
		assignTask = new JPanel();
		sendLeave = new JPanel();
		sendLog = new JPanel();
		homeP.setLayout(null);
		staffP.add(a2);
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
		assignTask.add(a7);
		sendLeave.add(a8);
		sendLog.add(a9);
		assignTask = aT.assigntask(d,ft,fl);

		JList<String> j=new JList<>();
		j.setListData(d.s.notifs);
		
		
				    myTab = new JTabbedPane();
		JLabel jxx=new JLabel("Last logout:  "+d.s.logout);
		jxx.setFont(new Font("SansSerif", Font.BOLD, 14));
		pp.add(jxx);
		pp.add(Box.createHorizontalStrut(20));
		JLabel jx=new JLabel("WELCOME");
		jx.setFont(new Font("Elephant", Font.BOLD, 33));
		jx.setPreferredSize(new Dimension(500,50));
		pp.add(Box.createHorizontalStrut(70));
		pp.add(jx);
		
		JTextArea textArea = new JTextArea(10,20);
		scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		textArea.append("Notifications:\n\n");
		for(String v: d.s.notifs)
			{
			if(v!=null)
					textArea.append(v+"\n");
			}
		
		JLabel lol = new JLabel("Notifications:");
		lol.setBounds(1000,50,150,30);
		scroll.setBounds(1000,75,200,200);
		homeP.add(scroll);
		homeP.add(lol);
		
		this.add(myTab);
		myTab.add("Home", homeP);
		myTab.add("View Task Report", viewtaskreports);
		sendLeave = lr.leave_method();
		myTab.add("Staff", staffP);
		myTab.add("Log Request",logReq);
		myTab.add("Leave Request",leaveReq);
		myTab.add("Task",task);
		myTab.add("New Users",newUsers);
		myTab.add("Assign Task",assignTask);
		myTab.add("Send Leave",sendLeave);
		myTab.add("Send Log",sendLogstaff);
		myTab.setLocation(50,50);
		myTab.setPreferredSize(new Dimension(1370, 650));
		myTab.setVisible(true);
		myTab.setEnabled(true);
		f=this;
JButton b1=new JButton("Logout");
b1.setFont(new Font("SansSerif", Font.BOLD, 14));
b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy "+"\n"+" HH:mm:ss"); 
		Date date2=new Date();
		String Porsche=sdf.format(date2);
    	d.s.logout=Porsche;
    	fnu.create(1);
    	f.setVisible(false);
      frl.setVisible(true);
    }
  });

pp.add(Box.createHorizontalStrut(20));
pp.add(new ClockPane());
pp.add(Box.createHorizontalStrut(20));
		pp.add(b1);
		pp.add(myTab);
		//this.add(b);
		new guisupchkleave(pp, leaveReq, myTab, d, fl);
		new guisupchklogreq(pp, logReq, myTab, d, fsi);
		new guisupchktask(fs,pp, task, myTab, d, ft,tarray);
		new guisupnewuser(pp, newUsers, myTab, d, n, fl, fnu);
		new viewtaskreports(fl, pp, viewtaskreports, myTab, d, ft);
		new viewstaff(pp, staffP, myTab, d, n, fl, fs);
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

class guisupchkleave 
{int kxl=0;
	public guisupchkleave(JPanel pp,JPanel leaveReq,JTabbedPane myTab,dept d,file fl)
	{
StringBuilder sb;
		String data[][]=new String[100][100];
	    String column[]={"USERID","FROM DATE","TO DATE","REASON","STATUS"};  
	  int i=1;kxl=0;
	  try{
	    for(i=1;i<=d.nos;i++)
	    {
	    	if(d.arr[i].l.Getstatus().equals("Applied"))
	    	{
	    	data[kxl][0]=String.valueOf(d.arr[i].Getuserid());
	    	data[kxl][1]=d.arr[i].l.Getfromdate();
	    	data[kxl][2]=d.arr[i].l.Gettodate();
	    	data[kxl][3]=d.arr[i].l.Getreason();
	    	data[kxl][4]=d.arr[i].l.Getstatus();
	    	kxl++;
	    	}
	    }
	  }catch(Exception e){} 
	  JTable table = new JTable( data, column) ;
	  table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
	    table.setBounds(30,40,200,300);  
	    JScrollPane js=new JScrollPane();
	    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    js.getViewport().add(table, null);
	    //js.add(table,BorderLayout.CENTER);
	    JPanel ap=new JPanel();
	    JPanel rp=new JPanel();
	    JLabel al=new JLabel("ACCEPT");
	    JLabel rl=new JLabel("REJECT");
	    ap.add(al);rp.add(rl);
	    JTextField accept=new JTextField("ACCEPT");
	    JTextField reject=new JTextField("REJECT");
	    ap.add(accept);rp.add(reject);
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
        	for(int i=1;i<=d.nos;i++)
        	{
        		
        		 if(Integer.parseInt(s)==d.arr[i].Getuserid())
        		{
        			 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        			  if(d.arr[i].l.Getstatus().equals("Applied"))
        		
        		{
        			d.arr[i].l.Setstatus("Accepted");fl.put(2,d.arr[i].Getuserid() );fl.create(1);d.arr[i].Setstatus("on leave");
        			int kxk1=0,kxk=0;
        			for( kxk=0;kxk<kxl;kxk++)
        				if(Integer.parseInt(data[kxk][0])==d.arr[i].Getuserid())
        					kxk1=kxk;
        			data[kxk1][4]="Accepted";
        			d.arr[i].notifs[d.arr[i].notif++]="Leave from "+d.arr[i].l.Getfromdate()+" to "+d.arr[i].l.Gettodate()+" accepted";
        			pp.add(myTab);
        			chk=1;
        		}
        			 
        			
        		 else
         			{JOptionPane.showMessageDialog(null, "Already checked"); chk=2;}
        		break;
        		}
        	}
        	if(chk==0)
        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
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
	        		
	        			 
	        		if(Integer.parseInt(s)==d.arr[i].Getuserid())
	        		{
	        			if(d.arr[i].l.Getstatus().equals("Applied"))
	        			{
	        			d.arr[i].l.Setstatus("Rejected");fl.put(2,d.arr[i].Getuserid() );fl.create(1);
	        			int kxk1=0,kxk=0;
	        			for( kxk=0;kxk<kxl;kxk++)
	        				if(Integer.parseInt(data[kxk][0])==d.arr[i].Getuserid())
	        					kxk1=kxk;
	        			data[kxk1][4]="Rejected";
	        			d.arr[i].notifs[d.arr[i].notif++]="Leave from "+d.arr[i].l.Getfromdate()+" to "+d.arr[i].l.Gettodate()+" rejected";
	        			pp.add(myTab);
	        			chk=1;
	        			
	        			}
	        			else
	        				{JOptionPane.showMessageDialog(null, "Already checked");chk=2;}
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
	   
	    leaveReq.add(ap,BorderLayout.SOUTH);leaveReq.add(rp,BorderLayout.SOUTH);
	    leaveReq.add(js);  
	}
}

class guisupchklogreq
{int kk=0;
	public guisupchklogreq(JPanel pp,JPanel logReq,JTabbedPane myTab,dept d,filesupinventory fsi)
	{
		StringBuilder sb;
		
		String data[][]=new String[100][100];
	    String column[]={"ITEM ID","DESCRIPTION","STATUS"};  
	   kk=1;int i=1;
	    for(i=1;i<=d.nos;i++)
	    {int j=1;
	  
	    	for( j=1;j<=d.arr[i].nooflogreq;j++)
	    	{sb=new StringBuilder();
	    	
	    	// if(i==1)kk=j;
	    	 if(d.arr[i].si[j].Getstatus().equals("Applied"))
	    	 {
	    	
	    		for(int k=1;k<=d.arr[i].si[j].Getnoofitems();k++)
	    		{
	    			sb.append(String.valueOf(d.arr[i].si[j].arrayofitems[k]));
	    			if(k!=d.arr[i].si[j].Getnoofitems())
	    			sb.append("	, ");
	    			
	    		}
	    		
	    		data[kk-1][1]=sb.toString();
	    		data[kk-1][0]=String.valueOf(d.arr[i].si[j].Getitemid());
	    		data[kk-1][2]=d.arr[i].si[j].Getstatus().trim();
	    			kk++;
	    	}}
	    }
	
	    JTable table = new JTable( data, column) ;
	    table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
	    table.setBounds(30,40,500,300);  
	    JScrollPane js=new JScrollPane();
	    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    js.getViewport().add(table, null);
	    //js.add(table,BorderLayout.CENTER);
	    JPanel ap=new JPanel();
	    JPanel rp=new JPanel();
	    JLabel al=new JLabel("ACCEPT");
	    JLabel rl=new JLabel("REJECT");
	    ap.add(al);rp.add(rl);
	    JTextField accept=new JTextField("ACCEPT");
	    JTextField reject=new JTextField("REJECT");
	    ap.add(accept);rp.add(reject);
	    
	    accept.setPreferredSize(new Dimension(100,30));
	    reject.setPreferredSize(new Dimension(100,30));int xs;
	    try{
	   accept .addActionListener(new ActionListener() {int sx=0;
	        public void actionPerformed(ActionEvent arg0) {
	        	int ki=0,kj=0,i;int x=0;
	        	String s=arg0.getActionCommand();
	        	
	        	
    	    	if(s.equals(""))
    	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	    	else
    	    	{sx=Integer.parseInt(s);int j=1;int chk=0;
	        	for(i=1;i<=d.nos;i++)
	    	    {
	    	   
	    	    	for( j=1;j<=d.arr[i].nooflogreq;j++)
	    	    	{
	    	    	if(sx==d.arr[i].si[j].Getitemid())
	    	    		
	    	    		{ki=i;kj=j;chk=1;}
	    	    	}
	    	    
	    	    	 
	    	    }
    	    	
	        	if(chk==0)
	        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	        	else
	        	{
	        	chk=0;
	        	
	        	
	        	
	        	 
	        	for(i=0;i<kk;i++)
		         {
		  		   if(Integer.parseInt(data[i][0])==sx)
		  		   { //System.out.println(data[i][2]);
		  			   if(data[i][2].equals("Applied"))
		  			   {
		  			   data[i][2]="Approved";
		  			   pp.add(myTab);
		  			   d.arr[ki].si[kj].Setstatus("Approved");chk=1;
		  			 d.arr[i].notifs[d.arr[i].notif++]="Log request "+d.arr[i].si[kj].Getitemid()+" approved";
		  			   }
		  			   else
		  			   { 
		  			   JOptionPane.showMessageDialog(null, "Already checked"); 
		  			   }
		  			   break;
		  		   }
		  		  
		        } 
	        	
	        	if(chk==1)
	        	{
	        // d.s.acceptlogisticrequests(d, d.arr[ki], d.arr[ki].si[kj]);
	         fsi.delete(sx);}
    	    	}
	        }}
	      });
	    }catch(Exception e){}
	    try{
	   reject .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {int sx=0;
	        int ki=0,kj=0,i;int x=0;
        	String s=arg0.getActionCommand();
        	
        	
	    	if(s.equals(""))
	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
	    	else
	    	{sx=Integer.parseInt(s);int j=1;int chk=0;
        	for(i=1;i<=d.nos;i++)
    	    {
    	   
    	    	for( j=1;j<=d.arr[i].nooflogreq;j++)
    	    	{
    	    	if(sx==d.arr[i].si[j].Getitemid())
    	    		
    	    		{ki=i;kj=j;chk=1;}
    	    	}
    	    
    	    	 
    	    }
	    	
        	if(chk==0)
        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
        	else
        	{
        	chk=0;
        	
        	
        	
        	 
        	for(i=0;i<kk;i++)
	         {
	  		   if(Integer.parseInt(data[i][0])==sx)
	  		   { //System.out.println(data[i][2]);
	  			   if(data[i][2].equals("Applied"))
	  			   {
	  			   data[i][2]="Rejected";
	  			   pp.add(myTab);
	  			   d.arr[ki].si[kj].Setstatus("Rejected");chk=1;
	  			 d.arr[i].notifs[d.arr[i].notif++]="Log request "+d.arr[i].si[kj].Getitemid()+" rejected";
	  			   }
	  			   else
	  			   { 
	  			   JOptionPane.showMessageDialog(null, "Already checked"); 
	  			   }
	  			   break;
	  		   }
	  		  
	        } 
        	
        	if(chk==1)
        	{
         d.s.rejectlogisticrequests(d, ki, d.arr[ki].si[kj]);
         fsi.delete(sx);}
	    	}
        }
	        }
	      });}
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
	   
	    logReq.add(ap,BorderLayout.SOUTH);logReq.add(rp,BorderLayout.SOUTH);
	    logReq.add(js);  
		
	}
}

class guisupchktask
{int kxx=0;
	public guisupchktask(filesupervisor fs,JPanel pp,JPanel Task,JTabbedPane myTab,dept d,filetask ft,taskfile [] tarray)
		{
				StringBuilder sb;
				String data[][]=new String[100][100];
	    String column[]={"TASK ID","NAME","DESCRIPTION","DEADLINE","STATUS"};  
	  int i=1; kxx=0;
	  	  try{
		    for(i=1;i<=d.s.not;i++)
		    {		    	
		    	data[kxx][0]=String.valueOf(d.s.t[i].Getid());
		    	data[kxx][1]=d.s.t[i].Getname();
		    	data[kxx][2]=d.s.t[i].Getdesc();
		    	data[kxx][3]=d.s.t[i].Getdeadline();
		    	data[kxx][4]=d.s.t[i].Getstatus();
		    	kxx++;
		     }
		  }catch(Exception e){} 
	  	  JTable table = new JTable( data, column) ;
	  table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
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
	        	for(int i=1;i<=d.s.not;i++)
	        	{
	  	        		 if(Integer.parseInt(s)==d.s.t[i].Getid())
	        		{
	        			 if(d.s.t[i].Getstatus().equals("Not started"))
	        			     {
	        				 for(int jj=1;jj<task.tcount;jj++)
	        				 {
	        					 if(Integer.parseInt(s)==tarray[jj].taskid)
	        					 {
	        						 tarray[jj].status="Ongoing";
	        						 Date dd=new Date();
	                				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	                				 String Porsche=sdf.format(dd);
	                				
	                				 d.s.t[i].fromdate=Porsche;
	        						 tarray[jj].fromdate=Porsche;
	        					 }
	        				 }
	        				 d.s.t[i].Setstatus("Ongoing");
	        				 d.s.Setstatusoftask("Ongoing");
	        				 d.s.Setstatus("Busy till "+d.s.t[i].Getdeadline());
	        				 fs.put(2, d.s.Getuserid());
	        				 //System.out.println(d.s.t[i].Getid());
	        			int kxk1=0,kxk=0;
	        			for( kxk=0;kxk<kxx;kxk++)
	        				if(Integer.parseInt(data[kxk][0])==d.s.t[i].Getid())
	        					kxk1=kxk;
	        			data[kxk1][4]="Ongoing";
	        			ft.put();
	        			ft.create(1);
	        			pp.add(myTab);
	        			chk=1;}
	        			 else if(d.s.t[i].Getstatus().equals("Ongoing"))
	        				 {JOptionPane.showMessageDialog(null, "Already Ongoing");chk=2;}
	        		 else
	         			{JOptionPane.showMessageDialog(null, "Already Completed"); chk=2;}
	        		break;}}
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
	    	        		 if(Integer.parseInt(s)==d.s.t[i].Getid())
	    	        		{
	    	        			 if(d.s.t[i].Getstatus().equals("Ongoing"))
	    	        		
	    	        		{
	    	        				 for(int jj=1;jj<task.tcount;jj++)
	    	        				 {
	    	        					 if(Integer.parseInt(s)==tarray[jj].taskid)
	    	        					 {
	    	        						 tarray[jj].status="Complete";
	    	        						 Date dd=new Date();
	    	    	        				 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	    	    	        				 String Porsche=sdf.format(dd);
	    	    	        				 d.s.t[i].todate=Porsche;
	    	    	        				
	    	    	        				 tarray[jj].todate=Porsche;
	    	        					 }
	    	        				 }
	    	        				 d.s.t[i].Setstatus("Complete");
	    	        				 d.s.Setstatusoftask("Complete");
	    	        				 d.s.Setstatus("Available");
	    	        				 if(d.s.l.Getstatus()=="Accepted")
	    	        				 { fs.put(2,d.s.Getuserid());
	    	        				 fs.create(1);}
	   	    	        			int kxk1=0,kxk=0;
	    	        			for( kxk=0;kxk<kxx;kxk++)
	    	        				if(Integer.parseInt(data[kxk][0])==d.s.t[i].Getid())
	    	        					kxk1=kxk;
		        			data[kxk1][4]="Complete";
		        			pp.add(myTab);
		        			ft.put();
		        			ft.create(1);
		        			chk=1;
		        			}
	    	        			 else if(d.s.t[i].Getstatus().equals("Complete"))
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
		        	if(s.equals(""))
	    	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
	    	    	else
	    	    	{
	    	    		for(int i=1;i<=d.s.not;i++)
	    	        	{
	    	        		 if(Integer.parseInt(s)==d.s.t[i].Getid())
	    	        		{
	    	        			 if(d.s.t[i].Getstatus().equals("Complete"))
	    	        			 {
	    	        			int kxk1=0,kxk=0;
		        			d.s.genreport(d.s.t[i]);
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
			}
}


class guisupnewuser
{int kk=0,kx=0;private static int HEADER_HEIGHT = 32;
	public guisupnewuser(JPanel pp,JPanel newUsers,JTabbedPane myTab,dept d,newuser [] n,file fl,filenewuser fnu)
	{
		StringBuilder sb;
		kk=0;
		String data[][]=new String[100][100];
	    String column[]={"USERID","NAME","DEPARTMENT","MEMBER","DOB","ADDRESS","STATUS"};  
		int k=1;newuser[] arr=new newuser[100];
		
		try{
		for(int i=1;i<=newuser.no;i++)
		{
			if(n[i].Getdept().equals(d.department)&&n[i].Getmember().equals("Staff"))
			{ 
				kk++;
				
				arr[kk]=n[i];
				
			}
		}
		}catch(Exception e){}
		// System.out.println("kk"+String.valueOf(arr[2].Getuserid()));
JTable table = new JTable( data, column) ;
table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

	    table.setBounds(30,40,1000,300);  
	    
    	
	    JScrollPane js=new JScrollPane();
	    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    js.getViewport().add(table, null);
	    //js.add(table,BorderLayout.CENTER);
	    JPanel ap=new JPanel();
	    JPanel rp=new JPanel();
	    JLabel al=new JLabel("ACCEPT");
	    JLabel rl=new JLabel("REJECT");
	    ap.add(al);rp.add(rl);
	    JTextField accept=new JTextField("ACCEPT");
	    JTextField reject=new JTextField("REJECT");
	    ap.add(accept);rp.add(reject);
	    
	     kx=0;
	   
	    for(int i=1;i<=kk;i++)
	    	{
	    	
	    	data[kx][0]=String.valueOf(arr[i].Getuserid());
	    	data[kx][1]=arr[i].Getname();
	    	data[kx][2]=arr[i].Getdept();
	    	data[kx][3]=arr[i].Getmember();
	    	
	    	data[kx][4]=arr[i].GetDOB();
	    	
	    	data[kx][5]=arr[i].Getaddress();
	    	kx++;
	    	
	    	}
	    
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
        	for(int i=1;i<=kk;i++)
        	{
        	
        		 if(Integer.parseInt(s)==arr[i].Getuserid())
        		{
        			 if(arr[i].status.equals("Applied"))
        		
        		{
        				 arr[i].status="Accepted";
        			int kxk1=0,kxk=0;
        			for( kxk=0;kxk<kx;kxk++)
        				if(Integer.parseInt(data[kxk][0])==arr[i].Getuserid())
        					kxk1=kxk;
        			data[kxk1][6]="Accepted";
        			fnu.delete(arr[i].Getuserid());
        			
        			staff st=new staff();
        			st.Setnot(0);st.Setstatus("Available");st.Setstatusoftask("Not started");
        			st.Setname(arr[i].Getname());st.Setaddress(arr[i].Getaddress());st.SetDOB(arr[i].GetDOB());st.Setpassword(arr[i].Getpassword());st.Setuserid(arr[i].Getuserid());st.Setusername(arr[i].Getusername());
        			d.s.addstaff(d, st);
        			fl.add(st);
        			fl.create(1);
        			pp.add(myTab);
        			chk=1;
        			d.s.modifynewuser(n, arr[i]);
        		}
        		 else
         			{JOptionPane.showMessageDialog(null, "Already checked"); chk=2;}
        		break;
        		}
        	}
        	if(chk==0)
        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	    	}
        } });
	    
	    reject .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String s=arg0.getActionCommand();int chk=0;
	        	if(s.equals(""))
    	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	    	else
    	    	{
    	    		
    	    		for(int i=1;i<=kk;i++)
    	        	{
    	        	
    	        		 if(Integer.parseInt(s)==arr[i].Getuserid())
    	        		{
    	        			 if(arr[i].status.equals("Applied"))
    	        		
    	        		{
    	        				 arr[i].status="Rejected";
    	        			int kxk1=0,kxk=0;
    	        			for( kxk=0;kxk<kx;kxk++)
    	        				if(Integer.parseInt(data[kxk][0])==arr[i].Getuserid())
    	        					kxk1=kxk;
	        			data[kxk1][6]="Rejected";
	        			fnu.delete(arr[i].Getuserid());
	        			
	        			pp.add(myTab);
	        			chk=1;
	        			d.s.modifynewuser(n, arr[i]);
	        			}
	        			else
	        				{JOptionPane.showMessageDialog(null, "Already checked");chk=2;}
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
	   
	    newUsers.add(ap,BorderLayout.SOUTH);newUsers.add(rp,BorderLayout.SOUTH);
	    newUsers.add(js);  
	}
}

class viewtaskreports 
{int kxx=0;
	public viewtaskreports(file fl,JPanel pp,JPanel Task,JTabbedPane myTab,dept d,filetask ft)
	{
		
		
					StringBuilder sb;
					String data[][]=new String[100][100];
		    String column[]={"TASK ID","NAME","DESCRIPTION","DEADLINE","STATUS"};  
		  int i=1; kxx=0;
		  	  try{
			    for(i=1;i<=d.nos;i++)
			    { 
			    	for(int j=1;j<=d.arr[i].not;j++)
			    	{
			    	data[kxx][0]=String.valueOf(d.arr[i].t[j].Getid());
			    	data[kxx][1]=d.arr[i].t[j].Getname();
			    	data[kxx][2]=d.arr[i].t[j].Getdesc();
			    	data[kxx][3]=d.arr[i].t[j].Getdeadline();
			    	data[kxx][4]=d.arr[i].t[j].Getstatus();
			    	kxx++;
			     }
			    }
			  }catch(Exception e){} 
		  	  JTable table = new JTable( data, column) ;
		  table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		    table.setBounds(30,40,500,300);  
		    JScrollPane js=new JScrollPane();
		    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    js.getViewport().add(table, null);
		   
		    JPanel gp=new JPanel();
		   
		    JLabel gl=new JLabel("GENERATE REPORT");
		    gp.add(gl);
		   
		    JTextField genre=new JTextField("GENERATE REPORT");
		   gp.add(genre);
		     try
			    {
		    	 genre .addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent arg0) {
				        	String s=arg0.getActionCommand();int chk=0;
				        	if(s.equals(""))
			    	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
			    	    	else
			    	    	{
			    	    		for(int i=1;i<=d.nos;i++)
			    	        	{
			    	    			for(int j=1;j<=d.arr[i].not;j++)
			    			    	{
			    	        		 if(Integer.parseInt(s)==d.arr[i].t[j].Getid())
			    	        		{
			    	        			 if(d.arr[i].t[j].Getstatus().equals("Complete"))
			    	        			 {
			    	        			int kxk1=0,kxk=0;
				        			d.arr[i].genreport(d.arr[i].t[j]);
				        			ft.put();
				        			ft.create(1);
				        			fl.put(1, 0);
				        			fl.create(1);
				        			pp.add(myTab);
				        			chk=1;
				        			}
				        			else
				        				{JOptionPane.showMessageDialog(null, "Not yet completed");chk=2;}
				        			break;
				        		}
				        	}}
				        	if(chk==0)
				        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
				        }
				        } });
			    
			    } catch(Exception e){}
		     genre.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {genre.setText("");}
				});
			  Task.add(gp,BorderLayout.SOUTH);
			    Task.add(js);  
			    
	}
}

class viewstaff
{int kk=0,kx=0;int kxk=0,kxk1=0;
	public viewstaff(JPanel pp,JPanel staffP,JTabbedPane myTab,dept d,newuser [] n,file fl,filesupervisor fs)
	{
		StringBuilder sb;
		kk=0;
		String data[][]=new String[100][100];
	    String column[]={"USERID","NAME","DEPARTMENT","DOB","ADDRESS","STATUS"};  
		int k=1;newuser[] arr=new newuser[100];
		JTable table = new JTable( data, column) ;
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

			    table.setBounds(30,40,1000,300);  
			    
		    	
			    JScrollPane js=new JScrollPane();
			    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			    js.getViewport().add(table, null);
			    //js.add(table,BorderLayout.CENTER);
			    JPanel ap=new JPanel();
			   
			    JLabel al=new JLabel("DELETE");
			    
			    ap.add(al);
			    JTextField accept=new JTextField("DELETE");
			   
			    ap.add(accept);
			    
			     kx=0;
			   
			    for(int i=1;i<=d.nos;i++)
			    	{
			    	
			    	data[kx][0]=String.valueOf(d.arr[i].Getuserid());
			    	data[kx][1]=d.arr[i].Getname();
			    	data[kx][2]=d.department;
			    	
			    	
			    	data[kx][3]=d.arr[i].GetDOB();
			    	
			    	data[kx][4]=d.arr[i].Getaddress();
			    	kx++;
			    	
			    	}
			    try{
			    accept .addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent arg0) {
			        	String s=arg0.getActionCommand();int chk=0;
			        	
			        	if(s.equals(""))
		    	    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
		    	    	else
		    	    	{
		    	    		
		    	    		for(int i=1;i<=d.nos;i++)
		    	        	{
		    	        	
		    	        		 if(Integer.parseInt(s)==d.arr[i].Getuserid())
		    	        		 { 
		    	        			 for( kxk=0;kxk<kx;kxk++)
		     	        				if(Integer.parseInt(data[kxk][0])==d.arr[i].Getuserid())
		     	        					kxk1=kxk;
		    	        			
		    	        					if(data[kxk1][5]==null)
		    	        				 {
		    	        					 data[kxk1][5]="DELETED";
		    	        					
		    	        					 fl.delete(d.arr[i].Getuserid());
		    	        					 d.s.deletestaff(d, d.arr[i]);
		    	        				 
		    	        				 fs.put(1, 0);
		    	        				
		    	        				 chk=1;
		    	        				 }
		    	        		 
		    	        			 
		    	        				 else
		    	        				 {JOptionPane.showMessageDialog(null, "Already checked");chk=2;}
			        			break;}
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
			  staffP.add(ap,BorderLayout.SOUTH);
			  staffP.add(js); 
	}
}
/*class guisupallstaff

{int i=0;
	public guisupallstaff(JFrame f,JTabbedPane myTab,JPanel staffP,dept d,file fl,filesupervisor fs)
	{
		/*staffP.add(Box.createHorizontalStrut(100));
		staffP.setLayout(new BoxLayout(staffP, BoxLayout.Y_AXIS));
		JButton[] barray=new JButton[100];
		
		for( i=1;i<=d.nos;i++)
			{barray[i]=new JButton("USERID : "+String.valueOf(d.arr[i].Getuserid()));
			barray[i].setFont(new Font("SansSerif", Font.BOLD, 16));
			barray[i].setPreferredSize(new Dimension(100,700));
			 staffP.add(Box.createVerticalStrut(20));
			staffP.add(barray[i]);
			  barray[i].addActionListener(new ActionListener()
	          {
	          public void actionPerformed(ActionEvent e) 
	          {
	        	  
	        	  Object[] options = {"Yes","No"};
	        	  int n = JOptionPane.showOptionDialog(f,"Would you like to delete the staff member ","Information",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
	        	  if(n==1)
	        		  d.s.deletestaff(d, d.arr[i]);
	          }
			}
	          );
		
		 
	

	
	
			}
			
		
		 DefaultTableModel dm = new DefaultTableModel();
		 
		 String data[][]=new String[100][100];
		    String column[]={"USERID"}; 
		
		 JTable jt=new JTable(dm);  
		 jt.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

		 for(int i=1;i<=d.nos;i++)
			 data[i-1][0]=String.valueOf(d.arr[i].Getuserid());
		 dm.setDataVector(data,column);
		 jt.getColumn("USERID").setCellEditor(
			        new ButtonEditor(new JCheckBox(),f,i,d,fl,fs));
		    jt.setBounds(30,40,50,300);  
		      
		    JScrollPane js=new JScrollPane(jt);  
		    js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    js.getViewport().add(jt, null);
		    staffP.add(js);
		   // myTab.add(staffP);		    
			}
			}
class ButtonEditor extends DefaultCellEditor {
	  protected JButton button;
	  private String    label;
	  private boolean   isPushed;
	  JFrame f;dept d;int i=0;file fl;filesupervisor fs;
	  public ButtonEditor(JCheckBox checkBox,JFrame f,int i,dept d,file fl,filesupervisor fs) {
	    super(checkBox);
	    this.f=f;this.d=d;this.i=i;this.fl=fl;this.fs=fs;
	    button = new JButton();
	    button.setOpaque(true);
	    
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });
	  }
	  
	  public Component getTableCellEditorComponent(JTable table, Object value,
	                   boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else{
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    label = (value ==null) ? "" : value.toString();
	    if(value==null)
		JOptionPane.showMessageDialog(null, "No user exists");
	    else{
	    button.setText( label );
	  
	   
	    i+=1;
	    System.out.println(i);
	  
	    isPushed = true;
	    }
	    return button;
	  }
	 
	  public Object getCellEditorValue() {
	    if (isPushed)  {
	    	 Object[] options = {"Yes","No"};
     	  int n = JOptionPane.showOptionDialog(f,"Would you like to delete the staff member ","Information",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
	    if(n==1)
	    { d.s.deletestaff(d, d.arr[i]);fs.put(1,0);fl.put(1,0);}
	    }
	    isPushed = false;
	    return new String( label ) ;
	  }


	
	}


*/