package fmsprojectfinal;

import java.text.DateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;


public class gui extends JFrame
{
	private int id = 0;	private String newUsername; // this will save the new registered user name
	private String newName,newPassword,newAddress,newDOB;	
	private String newdept;	private int user; // user = 1 means Gm...user = 2 means supervisor... user=3 means staff
	private JButton fbun1,fbun2,fbun3,Ok,Cancel;
	private JLabel llx,rldept,flabel,flabel2,rlabel1,rlName,rlUsername,rlType,rlAddress,rlPassword,rlDOB;
	private JTextField rDOB,rdept,rAddress,rName,rUsername;
	private JPasswordField rPassword;
	private JRadioButton rb3,rb1,rb2;
	private ButtonGroup group; 
	filegminventory fgi;
	newuser nn=new newuser();fileHVACstaff fh;filehousekeepingstaff fho;fileAVstaff fa;filesecstaff fsec;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;dept d[]=new dept[10];newuser n[];filesupinventory fsi;fileelecstaff fe;filetask ft;taskfile [] tarray;
   filenewuser fnu;fileuseridcount fu;JFrame frl=new JFrame();filesupervisor fs;GM gm;
	public gui(GM gm,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[],filenewuser fnu,fileuseridcount fu,filesupinventory fsi,filegminventory fgi,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,filesupervisor fs,filetask ft,taskfile [] tarray)
	{
		super("First Window");
		this.fh=fh;this.fgi=fgi;
		this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;this.fnu=fnu;this.fu=fu;this.fsi=fsi;this.fe=fe;this.ft=ft;this.tarray=tarray;
		this.fho=fho;this.fsec=fsec;this.fa=fa;this.fs=fs;this.gm=gm;
		setLayout(null);
		
		fbun1 = new JButton("Login");fbun2 = new JButton("Register");fbun3 = new JButton("Exit");
		flabel = new JLabel("Facility Management Services");flabel2 = new JLabel("System");
		flabel.setFont (flabel.getFont ().deriveFont (33.0f));
		flabel.setLocation(170,50);		flabel.setSize(525,50);
		flabel2.setFont (flabel2.getFont ().deriveFont (33.0f));
		flabel2.setLocation(330,90);	flabel2.setSize(400,50);
		fbun1.setLocation(300,175);		fbun1.setSize(175,55);
		fbun1.setFont (fbun1.getFont ().deriveFont (22.0f));
		fbun2.setLocation(300,275);		fbun2.setSize(175,55);
		fbun2.setFont (fbun2.getFont ().deriveFont (22.0f));
		fbun3.setLocation(300,375);		fbun3.setSize(175,55);
		fbun3.setFont (fbun3.getFont ().deriveFont (22.0f));
		fbun1.setBackground(Color.orange);fbun2.setBackground(Color.orange);fbun3.setBackground(Color.orange);		
		llx=new JLabel(new ImageIcon("download.png"));
		llx.setVisible(true);
		this.add(llx);
		llx.setBounds(700,200,200,200);
		this.add(flabel);this.add(fbun1);this.add(fbun2);this.add(fbun3);this.add(flabel2);
		frl=this;		
		// register window
		rlabel1 = new JLabel("Registeration Form");
		rlabel1.setFont (rlabel1.getFont ().deriveFont (33.0f));
		rlUsername = new JLabel("Username: ");rlName = new JLabel("Name: ");
		rlAddress = new JLabel("Address: ");rlType = new JLabel("Type");
		rlPassword = new JLabel("Password: ");rlDOB = new JLabel("DOB: ");
		rldept = new JLabel("Department: ");
		rlUsername.setFont (rlUsername.getFont ().deriveFont (23.0f));
		rlName.setFont (rlName.getFont ().deriveFont (23.0f));
		rlAddress.setFont (rlAddress.getFont ().deriveFont (23.0f));
		rlType.setFont (rlType.getFont ().deriveFont (23.0f));
		rlPassword.setFont (rlPassword.getFont ().deriveFont (23.0f));
		rlDOB.setFont (rlDOB.getFont ().deriveFont (23.0f));
		rldept.setFont (rldept.getFont ().deriveFont (23.0f));
		rlabel1.setLocation(520,30);rlName.setLocation(100,130);
		rlUsername.setLocation(100,280);rlPassword.setLocation(100,355);
		rlAddress.setLocation(100,430);	rlType.setLocation(100,205);
		rlDOB.setLocation(100,505);	rldept.setLocation(100,580);
		rlabel1.setSize(400,50);rlName.setSize(200,55);
		rlUsername.setSize(200,55);rlPassword.setSize(200,55);
		rlAddress.setSize(200,55);rlType.setSize(200,55);
		rlDOB.setSize(200,55);rldept.setSize(200,55);
		rName = new JTextField("Enter your Name");
		rUsername = new JTextField("Enter Desired Username");
		rPassword = new JPasswordField("");		rAddress = new JTextField("Enter Your Address");
		rDOB = new JTextField("Enter Your DOB");rdept = new JTextField("Enter Your Department");
		rName.setSize(275,35);rUsername.setSize(275,35);
		rPassword.setSize(275,35);rAddress.setSize(575,35);
		rDOB.setSize(275,35);rdept.setSize(275,35);
		rName.setLocation(300,130);	rUsername.setLocation(300,280);
		rPassword.setLocation(300,355);	rAddress.setLocation(300,430);
		rDOB.setLocation(300,505);rdept.setLocation(300,580);
		rb1 = new JRadioButton("GM",true);rb2 = new JRadioButton("Supervisor",false);
		rb3 = new JRadioButton("Staff",false);
		rb1.setSize(125,35);rb1.setLocation(330,205);
		rb1.setFont (rb1.getFont ().deriveFont (18.0f));
		rb2.setSize(125,35);rb2.setLocation(456,205);
		rb2.setFont (rb2.getFont ().deriveFont (18.0f));
		rb3.setSize(125,35);rb3.setLocation(632,205);
		rb3.setFont (rb3.getFont ().deriveFont (18.0f));
		this.add(rb1);this.add(rb2);this.add(rb3);
		group = new ButtonGroup();
		group.add(rb1);group.add(rb2);group.add(rb3);
		Ok = new JButton("OK");	Ok.setBackground(Color.orange);
		Cancel = new JButton("Cancel");Cancel.setBackground(Color.orange);
		Ok.setFont (rb1.getFont ().deriveFont (22.0f));
		Cancel.setFont (rb1.getFont ().deriveFont (22.0f));	Ok.setSize(175,40);
		Cancel.setSize(175,40);	Ok.setLocation(200,650);Cancel.setLocation(500,650);
		this.add(rName);this.add(rlabel1);this.add(rUsername);this.add(rPassword);this.add(rAddress);this.add(rlName);
		this.add(rlUsername);this.add(rlPassword);this.add(rlAddress);this.add(rlType);this.add(rlDOB);this.add(rDOB);
		this.add(rldept);this.add(rdept);this.add(Ok);this.add(Cancel);
		rlabel1.setVisible(false);rUsername.setVisible(false);rName.setVisible(false);rPassword.setVisible(false);
		rb1.setVisible(false);rb2.setVisible(false);rb3.setVisible(false);rAddress.setVisible(false);rlName.setVisible(false);
		rlUsername.setVisible(false);rlPassword.setVisible(false);rlAddress.setVisible(false);rlType.setVisible(false);
		rlDOB.setVisible(false);rDOB.setVisible(false);rldept.setVisible(false);rdept.setVisible(false);Ok.setVisible(false);
		Cancel.setVisible(false);
		// event handle
				handler handle = new handler();	
				fbun2.addActionListener(handle);rUsername.addActionListener(handle);rName.addActionListener(handle);
				rPassword.addActionListener(handle);rAddress.addActionListener(handle);rDOB.addActionListener(handle);
				rdept.addActionListener(handle);Ok.addActionListener(handle);Cancel.addActionListener(handle);
				fbun3.addActionListener(handle);fbun1.addActionListener(handle);
				rName.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {rName.setText("");}
				});
				rUsername.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {rUsername.setText("");}
				});
				rAddress.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {rAddress.setText("");}
				});
				rDOB.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {rDOB.setText("");}
				});
				rdept.addMouseListener(new MouseListener() 
				{public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {rdept.setText("");}
				});
				rb1.addItemListener(new handler2(1));rb2.addItemListener(new handler2(2));rb3.addItemListener(new handler2(3));
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);setVisible(true);this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}	
	public void maxSize(){this.setExtendedState(JFrame.MAXIMIZED_BOTH);}
	public void mySize(int a,int b){this.setSize(a,b);}
	public void myTitle(String s){this.setTitle(s);}
		
	private class handler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//register page
			int chk=0;
			if(event.getSource() == fbun2) // To Register
			{
				llx.setVisible(false);flabel.setVisible(false);flabel2.setVisible(false);fbun1.setVisible(false);
				fbun2.setVisible(false);fbun3.setVisible(false);maxSize();myTitle("Register");rlabel1.setVisible(true);
				rUsername.setVisible(true);	rName.setVisible(true);rb1.setVisible(true);rb2.setVisible(true);rb3.setVisible(true);
				rPassword.setVisible(true);rAddress.setVisible(true);rlName.setVisible(true);rlUsername.setVisible(true);
				rlPassword.setVisible(true);rlAddress.setVisible(true);rlType.setVisible(true);	rlDOB.setVisible(true);
				rDOB.setVisible(true);rldept.setVisible(true);rdept.setVisible(true);Ok.setVisible(true);Cancel.setVisible(true);
			}
			else if(event.getSource() == fbun1)//login
			{
				loginPage l = new loginPage(gm,e,h,a,sec,ho,fsi,fgi,fe,fh,fho,fa,fsec,fs,n,frl,fnu,ft,tarray);
				setVisible(false);
			}
			else if(event.getSource() == rName)
			{
				newName = event.getActionCommand();
				if(newName.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				else
				nn.Setname(newName);
			}
			else if(event.getSource() == fbun3)//exit
			{
				dispose();System.exit(0);
			}
			else if(event.getSource() == rUsername)
			{
				chk=0;
				newUsername = event.getActionCommand();
				if(newUsername.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				else
				{
				if(newUsername.equals("abcd"))
				{ chk=1;
				}
				else if(newUsername.equals(e.s.Getusername())||newUsername.equals(a.s.Getusername())||newUsername.equals(h.s.Getusername())||newUsername.equals(ho.s.Getusername())||newUsername.equals(sec.s.Getusername()))
			{
				chk=1;
			}
				else 
				{
					for(int i=1;i<=e.nos;i++)
					{
						if(newUsername.equals(e.arr[i].Getusername()))
							chk=1;
					}
					for(int i=1;i<=h.nos;i++)
					{
						if(newUsername.equals(h.arr[i].Getusername()))
							chk=1;
					}
					for(int i=1;i<=ho.nos;i++)
					{
						if(newUsername.equals(ho.arr[i].Getusername()))
							chk=1;
					}
					for(int i=1;i<=sec.nos;i++)
					{
						if(newUsername.equals(sec.arr[i].Getusername()))
							chk=1;
					}
					for(int i=1;i<=a.nos;i++)
					{
						if(newUsername.equals(a.arr[i].Getusername()))
							chk=1;
					}
				}
				for(newuser nx:n)
				{	
					if(nx.Getusername()!=null)
				{
					if(nx.Getusername().equals(newUsername))
						chk=1;
				}
				}
				if(chk==0)
					nn.Setusername(newUsername);
				else
					 JOptionPane.showMessageDialog(null, "Username exists");
				}	
				
			}
			else if(event.getSource() == rPassword)
			{
				
				newPassword = event.getActionCommand();
				if(newPassword.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				else if(newPassword.length()<5)
					JOptionPane.showMessageDialog(null, "Password can't be less than 5 characters");
				else
					nn.Setpassword(newPassword);
			}
			else if(event.getSource() == rAddress)
			{
				newAddress = event.getActionCommand();
				if(newAddress.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				else
				nn.Setaddress(newAddress);
			}
			else if(event.getSource() == rDOB)
			{	
				String tmp = event.getActionCommand();
				if(tmp.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}"))
				{
					newDOB = event.getActionCommand();
					
					nn.SetDOB(newDOB);
				}
						
				else{JOptionPane.showMessageDialog(null, "Incorrect Date Format");}		
			}
			else if(event.getSource() == rdept)
			{	newdept = event.getActionCommand();
			if(newdept.equals(""))
				JOptionPane.showMessageDialog(null, "Field can't be empty");
			else if(!(newdept.equals("Electricity")||newdept.equals("HVAC")||newdept.equals("AV")||newdept.equals("Security")||newdept.equals("Housekeeping")))
					JOptionPane.showMessageDialog(null, "Not a valid Department");
			else
			nn.Setdept(newdept);
			}
			else if(event.getSource() == Ok )
			{
				//System.out.println(nn.Getaddress()+" "+nn.Getdept());
				if(nn.Getaddress()!=null&&nn.Getdept()!=null&&nn.Getname()!=null&&nn.GetDOB()!=null&&nn.Getpassword()!=null&&nn.Getusername()!=null)
					{
					if(nn.Getmember()==null)
						JOptionPane.showMessageDialog(null, "GM exists");
					else
					{	fnu.add(nn);
					fnu.create(1);
					llx.setVisible(true);flabel.setVisible(true);flabel2.setVisible(true);fbun1.setVisible(true);
				fbun2.setVisible(true);fbun3.setVisible(true);myTitle("First Window");rlabel1.setVisible(false);
				rUsername.setVisible(false);rName.setVisible(false);rb1.setVisible(false);rb2.setVisible(false);
				rb3.setVisible(false);rPassword.setVisible(false);rAddress.setVisible(false);
				rlName.setVisible(false);rlUsername.setVisible(false);rlPassword.setVisible(false);rlAddress.setVisible(false);
				rlType.setVisible(false);rlDOB.setVisible(false);rDOB.setVisible(false);rldept.setVisible(false);
				rdept.setVisible(false);Ok.setVisible(false);Cancel.setVisible(false);
				
					
				rPassword.setText("");rAddress.setText("Enter Your Address");rUsername.setText("Enter Desired Username");
				rName.setText("Enter your Name");rDOB.setText("Enter Your DOB");
				rdept.setText("Enter Your Department");setExtendedState(JFrame.MAXIMIZED_BOTH);}}				
				else{JOptionPane.showMessageDialog(null, "Some fields are empty");}}		
			else if( event.getSource() == Cancel)
			{
				llx.setVisible(true);flabel.setVisible(true);flabel2.setVisible(true);fbun1.setVisible(true);
				fbun2.setVisible(true);fbun3.setVisible(true);myTitle("First Window");rlabel1.setVisible(false);
				rUsername.setVisible(false);rName.setVisible(false);rb1.setVisible(false);rb2.setVisible(false);
				rb3.setVisible(false);rPassword.setVisible(false);rAddress.setVisible(false);rlName.setVisible(false);
				rlUsername.setVisible(false);rlPassword.setVisible(false);rlAddress.setVisible(false);
				rlType.setVisible(false);rlDOB.setVisible(false);rDOB.setVisible(false);rldept.setVisible(false);
				rdept.setVisible(false);Ok.setVisible(false);Cancel.setVisible(false);
						
				rPassword.setText("");rAddress.setText("Enter Your Address");setExtendedState(JFrame.MAXIMIZED_BOTH);
				rUsername.setText("Enter Desired Username");rName.setText("Enter your Name");
				rDOB.setText("Enter Your DOB");rdept.setText("Enter Your Department");}}}
	
	private class handler2 implements ItemListener
	{
		private int temp;
		
			public handler2(int a)
			{
				temp = a;
			}
			public void itemStateChanged(ItemEvent event)
			{
				user = temp;String str=null;
				
				if(user==1)
				{if(gm.Getusername()==null&&gm.Getpassword()==null)
					str="GM";
			
				}
				else if(user==2)
					{str="Supervisor";}
				else if(user==3)
					{str="Staff";}
				
				nn.Setmember(str);}}}


			
		
		
		
		
		
		
		
	        
		

	
	
	
 
 
 
 class ClockPane extends JPanel {

     private JLabel clock;

     public ClockPane() {
         setLayout(new BorderLayout());
         clock = new JLabel();
         clock.setHorizontalAlignment(JLabel.CENTER);
         clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 12f));
         tickTock();
         add(clock);

         Timer timer = new Timer(500, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 tickTock();
             }
         });
         timer.setRepeats(true);
         timer.setCoalesce(true);
         timer.setInitialDelay(0);
         timer.start();
     }

     public void tickTock() {
         clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
     }
 }