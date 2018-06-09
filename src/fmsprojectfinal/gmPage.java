
/**
 * @mainpage fmsprojectfinal
 * @author Sarthika Dhawan(2015170)
 * @author Shubham Kumar(2015098)
 * This project focuses on implementing a facility management services(FMS) system.
*/
package fmsprojectfinal;



import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

/**@brief gmPage which provides interface for the GM of the FMS system*/
public class gmPage extends JFrame
{
	private JTabbedPane myTab;
	private JPanel homeP;
	
	assigntasksup aT = new assigntasksup();
	private JPanel supervisorP;
	private JPanel staffP;
	private JPanel logReq;
	private JPanel leaveReq;
	private JPanel newUsers;
	private JPanel assignTask;
	
	

	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	private JLabel a5;
	private JLabel a6;
	GM gm;
	private JLabel nofl;private JTextField nof;fileHVACstaff fh;file fl;filehousekeepingstaff fho;fileAVstaff fa;filesecstaff fsec;
	private JLabel arrl;private JTextField arr;fileelecstaff fe;newuser [] n=new newuser[100];JFrame frl;int att=0;Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;filesupervisor fs;
	dept d=new dept();filesupinventory fsi;int kk=0,kx,kkl=0,kxl=0;JFrame f=new JFrame();JPanel pp=new JPanel();filenewuser fnu;filetask ft;taskfile [] tarray;
	public gmPage(GM gm,dept d,filesupinventory fsi,filegminventory fgi,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,newuser [] n,JFrame frl,filenewuser fnu,filetask ft,filesupervisor fs,taskfile [] tarray,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	{
		super("GM");	
		this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.fho=fho;this.fsec=fsec;this.fa=fa;this.fs=fs;
//		setLayout(null);
		this.d=d;this.fsi=fsi;this.fe=fe;this.n=n;this.fh=fh;this.fnu=fnu;this.ft=ft;this.tarray=tarray;this.frl=frl;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gm=gm;
		this.setSize(1500,400);
		
		this.setVisible(true);
		
		a1 = new JLabel("Hi!    "+gm.Getname());
		a1.setFont(new Font("SansSerif", Font.BOLD, 14));

		a1.setBounds(10,10,100,100); //loc then size
		a2 = new JLabel("2");
		a3 = new JLabel("3");
		a4 = new JLabel("4");
		a5 = new JLabel("5");
		a6 = new JLabel("6");
		

		
		homeP = new JPanel();
		staffP = new JPanel();
		supervisorP = new JPanel();
		logReq = new JPanel();
		leaveReq = new JPanel();
		newUsers = new JPanel();
		assignTask = new JPanel();
		homeP.setLayout(null);
		
		
		homeP.add(a1);
		//supervisorP.add(a2);
		
		logReq.add(a3);
		leaveReq.add(a4);
		newUsers.add(a5);
		assignTask.add(a6);
		assignTask = aT.assigntask(gm, d, ft, fs, e, h, a, sec, ho);
		myTab = new JTabbedPane();
		myTab.add("Home", homeP);
		myTab.add("Supervisors", supervisorP);
		myTab.add("Log Request",logReq);
		myTab.add("Leave Request",leaveReq);
		myTab.add("New Users",newUsers);
		myTab.add("Assign Task",assignTask);
		myTab.add("Staff",staffP);
		myTab.setLocation(50,50);
		myTab.setPreferredSize(new Dimension(1370, 650));
		myTab.setVisible(true);
		myTab.setEnabled(true);
	
		JLabel jxx=new JLabel("Last logout:  "+d.s.logout);
		jxx.setFont(new Font("SansSerif", Font.BOLD, 14));
		//jxx.setFont (jxx.getFont ().deriveFont (13.0f));jxx.setPreferredSize(new Dimension(400,50));
		pp.add(jxx);
		
		pp.add(Box.createHorizontalStrut(20));
		JLabel jx=new JLabel("WELCOME");
		jx.setFont(new Font("Elephant", Font.BOLD, 33));
		jx.setPreferredSize(new Dimension(500,50));
		pp.add(Box.createHorizontalStrut(70));
		pp.add(jx);
		pp.add(Box.createVerticalStrut(100));

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		 
		f=this;
		
		JButton b=new JButton("Logout");
		b.setFont(new Font("SansSerif", Font.BOLD, 14));
		b.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	//fnu.create(1);
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd "+"\n"+" HH:mm:ss"); 
				Date date2=new Date();
				String Porsche=sdf.format(date2);
		    	gm.logout=Porsche;
		    	
		    	f.setVisible(false);
		      frl.setVisible(true);
		    }
		  });
		//pp.setLayout(new BorderLayout());
		pp.add(Box.createHorizontalStrut(20));
		 pp.add(new ClockPane());
		 pp.add(Box.createHorizontalStrut(20));
		pp.add(b);
		
		
		
				pp.add(myTab);
				
				new guigmchkleave(pp, leaveReq, myTab, fe, fh, fho, fa, fsec,fs, e, h, a, sec, ho);
				new guigmchklog(gm,pp, logReq, myTab, fe, fh, fho, fa, fsec,fgi, e, h, a, sec, ho);
				new guigmchknewusers(gm, pp, newUsers, myTab, n, fs, fe, fh, fho, fa, fsec, fnu, e, h, a, sec, ho);
				new viewstaffgm(gm, pp, staffP, myTab, n, fs, fe, fh, fho, fa, fsec, e, h, a, sec, ho);
				new viewsup(d, gm, pp, supervisorP,  myTab, n, fs, fe, fh, fho, fa, fsec, e, h, a, sec, ho);
				this.add(pp);
				
				this.setVisible(true);
				
	}
}



/**@brief check leave of supervisors
*/

class guigmchkleave
{int kxl=0;
	public guigmchkleave(JPanel pp,JPanel leaveReq,JTabbedPane myTab,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,filesupervisor fs,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	{
	StringBuilder sb;
	
	String data[][]=new String[100][100];
    String column[]={"USERID","FROM DATE","TO DATE","REASON","STATUS"};  
  int i=1;kxl=0;
  try{
	  if(e.s.Getuserid()!=0)
	kxl=chksup(e, h, a, sec, ho, e, data, kxl);
	  if(h.s.Getuserid()!=0)
	kxl=chksup(e, h, a, sec, ho, h, data, kxl);
	  if(a.s.Getuserid()!=0)
	kxl=chksup(e, h, a, sec, ho, a, data, kxl);
	  if(sec.s.Getuserid()!=0)
	kxl=chksup(e, h, a, sec, ho, sec, data, kxl);
	  if(ho.s.Getuserid()!=0)
	kxl=chksup(e, h, a, sec, ho, ho, data, kxl);
	  }catch(Exception ee){} 
JTable table =new JTable(data,column);

 
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
    	String s=arg0.getActionCommand();
    	
    		int chk=chksupaccept(pp, myTab, fs, e, data, s, kxl);
    	if(chk==0)
    		chk=chksupaccept(pp, myTab, fs, h, data, s, kxl);
    	if(chk==0)
    		chk=chksupaccept(pp, myTab, fs, ho, data, s, kxl);
    	if(chk==0)
    		chk=chksupaccept(pp, myTab, fs, a, data, s, kxl);
    	if(chk==0)
    		chk=chksupaccept(pp, myTab, fs, sec, data, s, kxl);
    	
    	if(chk==0)
    		JOptionPane.showMessageDialog(null, "Invalid userid"); 
    } });
    
    reject .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        	String s=arg0.getActionCommand();
        	int chk=0;
        	 if(e.s.Getuserid()!=0)
        		 chk=chksupreject(pp, myTab, fs, e, data, s, kxl);
        	if(chk==0&&h.s.Getuserid()!=0)
        		chk=chksupreject(pp, myTab, fs, h, data, s, kxl);
        	if(chk==0&&ho.s.Getuserid()!=0)
        		chk=chksupreject(pp, myTab, fs, ho, data, s, kxl);
        	if(chk==0&&a.s.Getuserid()!=0)
        		chk=chksupreject(pp, myTab, fs, a, data, s, kxl);
        	if(chk==0&&sec.s.Getuserid()!=0)
        		chk=chksupreject(pp, myTab, fs, sec, data, s, kxl);
        	
        	if(chk==0)
        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
        	
        }
        });
    }
    catch(Exception ee){}
    
  
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
	/**@brief
	 * 
	 * @param e electricity department object
	 * @param h HVAC department object
	 * @param a AV department object
	 * @param sec Security department object
	 * @param ho Housekeeping department object
	 * @param d department object
	 * @param data table data
	 * @param kxl 
	 * @return int
	 */
	int chksup(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,dept d,String [][]data,int kxl)
	{
		  
		if(d.s.l.Getstatus().equals("Applied"))
		{data[kxl][0]=String.valueOf(d.s.Getuserid());
		data[kxl][1]=d.s.l.Getfromdate();
		data[kxl][2]=d.s.l.Gettodate();
		data[kxl][3]=d.s.l.Getreason();
		kxl++;
		}
		return kxl;
	}
	
	/**@brief accept supervisor leave
	 
	 * @param pp
	 * @param myTab
	 * @param fs
	 * @param d
	 * @param data
	 * @param s
	 * @param kxl
	 * @return
	 */
	int chksupaccept(JPanel pp,JTabbedPane myTab,filesupervisor fs,dept d,String [][]data,String s,int kxl)
	{
		int chk=0;
    	if(s.equals(""))
    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	else
    	{
    		
    	
    			 
    		if(Integer.parseInt(s)==d.s.Getuserid())
    		{
    			  if(d.s.l.Getstatus().equals("Applied"))
    			{
    				d.s.l.Setstatus("Accepted");fs.put(2,d.s.Getuserid() );fs.create(1);
    			int kxk1=0,kxk=0;
    			for( kxk=0;kxk<kxl;kxk++)
    				if(Integer.parseInt(data[kxk][0])==d.s.Getuserid())
    					kxk1=kxk;
    			data[kxk1][4]="Accepted";
    			d.s.Setstatus("on leave");
    			d.s.notifs[d.s.notif++]="Leave from "+d.s.l.Getfromdate()+" to "+d.s.l.Gettodate()+" accepted";
    			pp.add(myTab);
    			chk=1;
    			
    			}
    			 else
      			{JOptionPane.showMessageDialog(null, "Already checked"); chk=2;}
    			
    		}
    	}
    	
    
    	return chk;
	}
	/** @brief reject supervisor leave
	 * 
	 * @param pp
	 * @param myTab
	 * @param fs
	 * @param d
	 * @param data
	 * @param s
	 * @param kxl
	 * @return
	 */
	int chksupreject(JPanel pp,JTabbedPane myTab,filesupervisor fs,dept d,String [][]data,String s,int kxl)
	{
		int chk=0;
		if(s.equals(""))
    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	else
    	{
    		
    	
    		
    			 
    		if(Integer.parseInt(s)==d.s.Getuserid())
    		{
    			
    			if(d.s.l.Getstatus().equals("Applied"))
    			{
    				d.s.l.Setstatus("Rejected");fs.put(2,d.s.Getuserid() );fs.create(1);
    			int kxk1=0,kxk=0;
    			for( kxk=0;kxk<kxl;kxk++)
    				if(Integer.parseInt(data[kxk][0])==d.s.Getuserid())
    					kxk1=kxk;
    			data[kxk1][4]="Rejected";
    			d.s.notifs[d.s.notif++]="Leave from "+d.s.l.Getfromdate()+" to "+d.s.l.Gettodate()+" rejected";
    			pp.add(myTab);
    			chk=1;
    			
    			}
    			
    			
    		}
    	
    	
    }return chk;
	}
}



/**@brief checking log requests by supervisors(accept/reject)*/

class guigmchklog
{
	int kk=0;
	public guigmchklog(GM gm,JPanel pp,JPanel logReq,JTabbedPane myTab,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,filegminventory fgi,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	{
		StringBuilder sb;
		
		String data[][]=new String[100][100];
	    String column[]={"ITEM ID","DESCRIPTION","STATUS"};  
	   kk=1;int i=1;
	   
	   try
	    {
		  if( e.s.Getuserid()!=0)
	    kk=chksup(e, h, a, sec, ho, e, data, kk);
		  if( h.s.Getuserid()!=0)
	    kk=chksup(e, h, a, sec, ho, h, data, kk);
		  if( ho.s.Getuserid()!=0)
	    kk=chksup(e, h, a, sec, ho, ho, data, kk);
		  if( sec.s.Getuserid()!=0)
	    kk=chksup(e, h, a, sec, ho, sec, data, kk);
		  if( a.s.Getuserid()!=0)
	    kk=chksup(e, h, a, sec, ho, a, data, kk);
	    }
	    catch(Exception ee){}
	   JTable table = new JTable( data, column) ;
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
	    	String s=arg0.getActionCommand();
	    	
	    		int chk=0;
	    		 if( e.s.Getuserid()!=0)
	    		chk=chksupaccrej(gm,pp, myTab, fgi, e, data, s, kk,1);
	    	if(chk==0&&h.s.Getuserid()!=0)
	    		chk=chksupaccrej(gm,pp, myTab,fgi , h, data, s, kk,1);
	    	if(chk==0&&ho.s.Getuserid()!=0)
	    		chk=chksupaccrej(gm,pp, myTab, fgi, ho, data, s, kk,1);
	    	if(chk==0&&a.s.Getuserid()!=0)
	    		chk=chksupaccrej(gm,pp, myTab, fgi, a, data, s, kk,1);
	    	if(chk==0&&sec.s.Getuserid()!=0)
	    		chk=chksupaccrej(gm,pp, myTab, fgi, sec, data, s, kk,1);
	    	if(chk==0)
	    		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	    } });  
	    reject .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String s=arg0.getActionCommand();
	        		int chk=0;
	        		 if( e.s.Getuserid()!=0)
	        		chk=chksupaccrej(gm,pp, myTab, fgi, e, data, s, kk,2);
	        		 if(chk==0&&h.s.Getuserid()!=0)
	        		chk=chksupaccrej(gm,pp, myTab, fgi, h, data, s, kk,2);
	        		 if(chk==0&&ho.s.Getuserid()!=0)
	        		chk=chksupaccrej(gm,pp, myTab, fgi, ho, data, s, kk,2);
	        		 if(chk==0&&a.s.Getuserid()!=0)
	        		chk=chksupaccrej(gm,pp, myTab, fgi, a, data, s, kk,2);
	        		 if(chk==0&&sec.s.Getuserid()!=0)
	        		chk=chksupaccrej(gm,pp, myTab, fgi, sec, data, s, kk,2);
	        	
	        	if(chk==0)
	        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	        	
	        }
	        });
	    }
	    catch(Exception ee){}
	    
	    
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
	
	/**@brief display all data in the JTable
	 * @param e Electricity object
	 * @param h HVAC object
	 * @param a AV object
	 * @param sec Security object
	 * @param ho Housekeeping object
	 * @param d dept object
	 * @param data 2D array of string conatining data to be stored in the table
	 * @param kk a counter
	 * @return int
	 */
	int chksup(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,dept d,String [][]data,int kk)
	{
		
		for( int j=1;j<=d.s.nooflogreq;j++)
    	{
			StringBuilder sb=new StringBuilder();
			
    	
    	 if(d.s.g[j].Getstatus().equals("Applied"))
    	 {
    	
    		for(int k=1;k<=d.s.g[j].Getnoofitems();k++)
    		{
    			sb.append(String.valueOf(d.s.g[j].arrayofitems[k]));
    			if(k!=d.s.g[j].Getnoofitems())
    			sb.append("	, ");
    			
    		}
    		
    		data[kk-1][1]=sb.toString();
    		
    		data[kk-1][0]=String.valueOf(d.s.g[j].Getitemid());
    		data[kk-1][2]=d.s.g[j].Getstatus().trim();
    		kk++;}}
		return kk;
	}
	/**@ brief
	 * accept and reject log request
	 * @param gm GM object
	 * @param pp JPanel
	 * @param myTab JTabbedPane
	 * @param fgi filegminventory object
	 * @param d dept object
	 * @param data 2D array of string
	 * @return int
	 */
	int chksupaccrej(GM gm,JPanel pp,JTabbedPane myTab,filegminventory fgi,dept d,String [][]data,String s,int kk,int ch)
	{int ki=0,kj=0,i=0,chk=0;
		if(s.equals(""))
    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	else
    	{int sx=Integer.parseInt(s);int j=1;
    	
	   
	    	for( j=1;j<=d.s.nooflogreq;j++)
	    	{
	    	if(sx==d.s.g[j].Getitemid())
	    		
	    		{kj=j;chk=1;}
	    	}
    	if(chk!=0)
    		
    	{
    	chk=0;
    	for(i=0;i<kk;i++)
         {
  		   if(Integer.parseInt(data[i][0])==sx)
  		   { 
  			   if(data[i][2].equals("Applied"))
  			   {
  				if(ch==1)
  				{ data[i][2]="Approved"; d.s.notifs[d.s.notif++]="Log request "+d.s.g[kj].Getitemid()+" approved"; d.s.g[kj].Setstatus("Approved");}
  				else
  				{ data[i][2]="Rejected"; d.s.notifs[d.s.notif++]="Log request "+d.s.g[kj].Getitemid()+" rejected"; d.s.g[kj].Setstatus("Rejected");}	
  			   pp.add(myTab);
  			  chk=1;
  			
  			   }
  			   else
  			   { 
  			   JOptionPane.showMessageDialog(null, "Already checked"); chk=2;
  			   }
  			   break;}}
    	if(chk==1)
    	{fgi.delete(sx);
     if(ch==2)gm.rejectlogisticrequests(d, d.s.g[kj]);
     }
    	}
    }
		return chk;	}}


class guigmchknewusers
{int kx=0;
	public guigmchknewusers(GM gm,JPanel pp,JPanel newUsers,JTabbedPane myTab,newuser [] n,filesupervisor fs,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,filenewuser fnu,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	{
		StringBuilder sb;
		int kk=0;
		String data[][]=new String[100][100];
	    String column[]={"USERID","NAME","DEPARTMENT","MEMBER","DOB","ADDRESS","STATUS"};  
		int k=1;
		 
		try
		{
		for(int i=1;i<=newuser.no;i++)
		{
			data[kx][0]=String.valueOf(n[i].Getuserid());
	    	data[kx][1]=n[i].Getname();
	    	data[kx][2]=n[i].Getdept();
	    	data[kx][3]=n[i].Getmember();
	    	data[kx][4]=n[i].GetDOB();
	    	data[kx][5]=n[i].Getaddress();
	    	kx++;
		}
		
	}catch(Exception ee){}
		
JTable table = new JTable( data, column) ;
		
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
        	 chk=chkstaff(gm, pp, myTab, e, n, fe, data, s, kx, fnu,1);
        	 if(chk==0)
        		 chk=chkstaff(gm, pp, myTab, h, n, fh, data, s, kx, fnu,1);
        	 if(chk==0)
        		 chk=chkstaff(gm, pp, myTab, ho, n, fho, data, s, kx, fnu,1);
        	 if(chk==0)
        		 chk=chkstaff(gm, pp, myTab, sec, n, fsec, data, s, kx, fnu,1);
        	 if(chk==0)
        		 chk=chkstaff(gm, pp, myTab, a, n, fa, data, s, kx, fnu,1);
        	 if(chk==0)
        		 chk=chksup(gm, pp, myTab, e, n, fs, data, s, kx, fnu, 1);
        	 if(chk==0)
        		 chk=chksup(gm, pp, myTab, h, n, fs, data, s, kx, fnu, 1);
        	 if(chk==0)
        		 chk=chksup(gm, pp, myTab, ho, n, fs, data, s, kx, fnu, 1);
        	 if(chk==0)
        		 chk=chksup(gm, pp, myTab, sec, n, fs, data, s, kx, fnu, 1);
        	 if(chk==0)
        		 chk=chksup(gm, pp, myTab, a, n, fs, data, s, kx, fnu, 1);
        	 if(chk==0)
        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	    	}
        } });
	    
	    reject .addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	String s=arg0.getActionCommand();int chk=0;
	        	
	        	chk=chkstaff(gm, pp, myTab, e, n, fe, data, s, kx, fnu,2);
	        	 if(chk==0)
	        		 chk=chkstaff(gm, pp, myTab, h, n, fh, data, s, kx, fnu,2);
	        	 if(chk==0)
	        		 chk=chkstaff(gm, pp, myTab, ho, n, fho, data, s, kx, fnu,2);
	        	 if(chk==0)
	        		 chk=chkstaff(gm, pp, myTab, sec, n, fsec, data, s, kx, fnu,2);
	        	 if(chk==0)
	        		 chk=chkstaff(gm, pp, myTab, a, n, fa, data, s, kx, fnu,2);
	        	 if(chk==0)
	        		 chk=chksup(gm, pp, myTab, e, n, fs, data, s, kx, fnu, 2);
	        	 if(chk==0)
	        		 chk=chksup(gm, pp, myTab, h, n, fs, data, s, kx, fnu, 2);
	        	 if(chk==0)
	        		 chk=chksup(gm, pp, myTab, ho, n, fs, data, s, kx, fnu, 2);
	        	 if(chk==0)
	        		 chk=chksup(gm, pp, myTab, sec, n, fs, data, s, kx, fnu, 2);
	        	 if(chk==0)
	        		 chk=chksup(gm, pp, myTab, a, n, fs, data, s, kx, fnu, 2);
	        	 if(chk==0)
	        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
	        }
	        });
	    }
	    catch(Exception ee){}
	    
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
	int chkstaff(GM gm,JPanel pp,JTabbedPane myTab,dept d,newuser [] n,file fl,String [][] data,String s,int kx,filenewuser fnu,int ch)
	{int chk=0,g=0;
		for(int kk=1;kk<=newuser.no;kk++)
		{
			if(Integer.parseInt(s)==n[kk].Getuserid())
			{
				
    			if(n[kk].status.equals("Applied"))
    		
    		{	
    				dept dd=d;

    				int kxk1=0,kxk=0;
    			
    			for( kxk=0;kxk<kx;kxk++)
    				if(Integer.parseInt(data[kxk][0])==n[kk].Getuserid())
    					kxk1=kxk;
    			
    			if(dd.department.equals(data[kxk1][2])){d=dd;g=1;}
    			System.out.println("value of g"+g);
    			if(g==1)
    			{
    				if(ch==1)	 n[kk].status="Accepted";
        			else		 n[kk].status="Rejected";
    				
    				if(ch==1)	 data[kxk1][6]="Accepted";
        			else		 data[kxk1][6]="Rejected";
        			
    			fnu.delete(n[kk].Getuserid());
    			
    			if(ch==1)
    			{
    			staff st=new staff();
    			st.Setnot(0);st.Setstatus("Available");st.Setstatusoftask("Not started");
    			st.Setname(n[kk].Getname());st.Setaddress(n[kk].Getaddress());st.SetDOB(n[kk].GetDOB());st.Setpassword(n[kk].Getpassword());st.Setuserid(n[kk].Getuserid());st.Setusername(n[kk].Getusername());
    			d.s.addstaff(d, st);
    			fl.add(st);
    			fl.create(1);
    			}
    			gm.modifynewuser(n, n[kk]);
    			pp.add(myTab);
    			chk=1;
    			}
    		}
    		 else
     			{JOptionPane.showMessageDialog(null, "Already checked"); chk=2;}
    		break;
		}
			
		}
		System.out.println("v of chk"+chk);
		return chk;
	}
	
	int chksup(GM gm,JPanel pp,JTabbedPane myTab,dept d,newuser [] n,filesupervisor fs,String [][] data,String s,int kx,filenewuser fnu,int ch)
	{int chk=0,g=0;
		for(int kk=1;kk<=newuser.no;kk++)
		{
			if(Integer.parseInt(s)==n[kk].Getuserid())
			{
    			if(n[kk].status.equals("Applied"))
    		
    		{
    				dept dd=d;
    				
    				
    			
    			int kxk1=0,kxk=0;
    			for( kxk=0;kxk<kx;kxk++)
    				if(Integer.parseInt(data[kxk][0])==n[kk].Getuserid())
    					kxk1=kxk;
    			
    			if(d.department.equals(data[kxk1][2])){dd=d;g=1;}
    			if(g==1)
    			{
    				if(ch==1)	 n[kk].status="Accepted";
        			else		 n[kk].status="Rejected";
    				
    				
        			if(ch==1)	 data[kxk1][6]="Accepted";
        			else		 data[kxk1][6]="Rejected";
    			
    			
    			fnu.delete(n[kk].Getuserid());
    			
    			if(ch==1)
    			{
    			supervisor st=new supervisor();
    			st.Setnot(0);st.Setstatus("Available");st.Setstatusoftask("Not started");
    			st.Setname(n[kk].Getname());st.Setaddress(n[kk].Getaddress());st.SetDOB(n[kk].GetDOB());st.Setpassword(n[kk].Getpassword());st.Setuserid(n[kk].Getuserid());st.Setusername(n[kk].Getusername());
    			gm.addsup(d, st);
    			
    			}
    			else
    			{
    				gm.deletesup(d);
    			}
    			gm.modifynewuser(n, n[kk]);
    			pp.add(myTab);
    			chk=1;
    			}
    		}
    		 else
     			{JOptionPane.showMessageDialog(null, "Already checked"); chk=2;}
    		break;
		}
			
		}
		return chk;
	}
}
/**@ brief view all staff members*/
class viewstaffgm
{int kx=0,kxk=0,kxk1=0,kk=0;
	public viewstaffgm(GM gm,JPanel pp,JPanel staffP,JTabbedPane myTab,newuser [] n,filesupervisor fs,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
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
			   
			     kx=chkstaff(e, data,kx);kx=chkstaff(sec, data,kx);kx=chkstaff(a, data,kx);kx=chkstaff(ho, data,kx);kx=chkstaff(h, data,kx);
			    
			    
			    try{
			    accept .addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent arg0) {
			        	String s=arg0.getActionCommand();int chk=0;
			        	chk=chkstaffchk(s, e, data, fs, fe, chk);
			        	if(chk==0)
			        		chk=chkstaffchk(s, h, data, fs, fh, chk);
			        	if(chk==0)
			        		chk=chkstaffchk(s, ho, data, fs, fho, chk);
			        	if(chk==0)
			        		chk=chkstaffchk(s, sec, data, fs, fsec, chk);
			        	if(chk==0)
			        		chk=chkstaffchk(s, a, data, fs, fa, chk);
			        	
			        	if(chk==0)
			        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
			        	
			        	}
			        });
			    }
			    catch(Exception ee){}
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
	/**@brief delete supervisors*/
	int chkstaff(dept d,String [][]data,int kx)
	{
		for(int i=1;i<=d.nos;i++)
    	{
    	
    	data[kx][0]=String.valueOf(d.arr[i].Getuserid());
    	data[kx][1]=d.arr[i].Getname();
    	data[kx][2]=d.department;
    	
    	
    	data[kx][3]=d.arr[i].GetDOB();
    	
    	data[kx][4]=d.arr[i].Getaddress();
    	kx++;
    	
    	}
		return kx;
	}
	int chkstaffchk(String s,dept d,String [][]data,filesupervisor fs,file fl,int chk)
	{

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
    	
    	
    	}return chk;
	}
	
}
/**@brief view all supervisors */
class viewsup
{int kk=0,kx=0,kxk=0,kxk1=0;
	public viewsup(dept d,GM gm,JPanel pp,JPanel supervisorP,JTabbedPane myTab,newuser [] n,filesupervisor fs,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
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
			     for(int i=1;i<=5;i++)
			    	{if(i==1)d=e;else if(i==2)d=h;else if(i==3)d=a;else if(i==4)d=ho;else d=sec;
			    	if(d.s.Getuserid()!=0)
			    	{
			    	data[kx][0]=String.valueOf(d.s.Getuserid());
			    	data[kx][1]=d.s.Getname();
			    	data[kx][2]=d.department;
			    	
			    	
			    	data[kx][3]=d.s.GetDOB();
			    	
			    	data[kx][4]=d.s.Getaddress();
			    	kx++;
			    	}
			    	}
			     try{
					    accept .addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent arg0) {
					        	String s=arg0.getActionCommand();int chk=0;
					        	if(chk==0&&e.s.Getuserid()!=0)
					        	chk=chksup(gm,s, e, data, chk, fs, fe);
					        	if(chk==0&&h.s.Getuserid()!=0)
					        		chk=chksup(gm,s, h, data, chk, fs, fh);
					        	if(chk==0&&ho.s.Getuserid()!=0)
					        		chk=chksup(gm,s, ho, data, chk, fs, fho);
					        	if(chk==0&&sec.s.Getuserid()!=0)
					        		chk=chksup(gm,s, sec, data, chk, fs, fsec);
					        	if(chk==0&&a.s.Getuserid()!=0)
					        		chk=chksup(gm,s, a, data, chk, fs, fa);
					        	if(chk==0)
					        		JOptionPane.showMessageDialog(null, "Invalid userid"); 
					        	
					        	}
					        });
					    }
					    catch(Exception ee){}
					    accept.addMouseListener(new MouseListener() 
						{public void mouseReleased(MouseEvent e){}
						public void mousePressed(MouseEvent e) {}
						public void mouseExited(MouseEvent e) {}
						public void mouseEntered(MouseEvent e) {}
						public void mouseClicked(MouseEvent e) {accept.setText("");}
						});
					  supervisorP.add(ap,BorderLayout.SOUTH);
					  supervisorP.add(js); 
	}
	/**@brief delete supervisors*/
	int chksup(GM gm,String s,dept d,String [][]data,int chk,filesupervisor fs,file fl)
	{
		if(s.equals(""))
    		JOptionPane.showMessageDialog(null, "Field can't be empty"); 
    	else
    	{
    		
    		
        	
        		 if(Integer.parseInt(s)==d.s.Getuserid())
        		 { 
        			 for( kxk=0;kxk<kx;kxk++)
	        				if(Integer.parseInt(data[kxk][0])==d.s.Getuserid())
	        					kxk1=kxk;
        			
        					if(data[kxk1][5]==null)
        				 {
        					 data[kxk1][5]="DELETED";
        					
        					 fs.delete(d.s.Getuserid());
        					 gm.deletesup(d);
        				 
        				
        				
        				 chk=1;
        				 }
        		 
        			 
        				 else
        				 {JOptionPane.showMessageDialog(null, "Already checked");chk=2;}
    			}
    		}
    	
    	
    	
		return chk;
	}
	}



