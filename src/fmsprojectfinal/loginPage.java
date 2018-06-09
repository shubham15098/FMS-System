package fmsprojectfinal;




import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**@brief GUI interface for login page*/
public class loginPage extends JFrame
{
	private JLabel lTitle;
	private JLabel lLogin;
	private JLabel lPassword;
	
	private JTextField login;
	private JPasswordField pass;
	private JButton Ok;
	private JButton Cancel;
	private String newLogin;GM gm;JFrame f=new JFrame();
	private String newPass;fileHVACstaff fh;filenewuser fnu;filesupervisor fs;filegminventory fgi;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;filesupinventory fsi;fileelecstaff fe;newuser [] n=new newuser[100];JFrame frl;filetask ft;taskfile [] tarray;filehousekeepingstaff fho;fileAVstaff fa;filesecstaff fsec;
	public loginPage(GM gm,Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,filesupinventory fsi,filegminventory fgi,fileelecstaff fe,fileHVACstaff fh,filehousekeepingstaff fho,fileAVstaff fa,filesecstaff fsec,filesupervisor fs,newuser[] n,JFrame frl,filenewuser fnu,filetask ft,taskfile [] tarray)
	{
		super("Login Page");
		this.fh=fh;this.fho=fho;this.fsec=fsec;this.fa=fa;this.fgi=fgi;this.gm=gm;
		this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.fsi=fsi;this.fe=fe;this.n=n;this.frl=frl;this.fnu=fnu;this.ft=ft;this.tarray=tarray;this.fs=fs;
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);		this.setVisible(true);
		
		lTitle = new JLabel("Login Page");
		lTitle.setFont (lTitle.getFont ().deriveFont (33.0f));
		lLogin = new JLabel("Username: ");
		lPassword = new JLabel("Password: ");
		lLogin.setFont (lLogin.getFont ().deriveFont (23.0f));
		lPassword.setFont (lPassword.getFont ().deriveFont (23.0f));
		lTitle.setSize(200,50);
		lTitle.setLocation(300,30);
		lLogin.setSize(200,45);
		lPassword.setSize(200,45);
		lLogin.setLocation(200,200);
		lPassword.setLocation(200,300);
		
		login = new JTextField("Enter Your Username");
		pass = new JPasswordField();
		
		login.setSize(200,45);
		pass.setSize(200,45);
		login.setLocation(375,200);
		pass.setLocation(375,300);
		f=this;
		login.addMouseListener(new MouseListener() 
		{public void mouseReleased(MouseEvent e){}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {login.setText("");}
		});
		
		Ok = new JButton("OK");
		Ok.setSize(175,55);
		Ok.setLocation(250,400);
		Ok.setBackground(Color.orange);
		
		 Cancel = new JButton("CANCEL");
		Cancel.setSize(175,55);
		Cancel.setLocation(500,400);
		Cancel.setBackground(Color.orange);
		
		this.add(lTitle);
		this.add(lLogin);
		this.add(lPassword);
		this.add(login);
		this.add(pass);
		this.add(Ok);
		this.add(Cancel);
		
		handler handle = new handler();
		Ok.addActionListener(handle);
		Cancel.addActionListener(handle);
		login.addActionListener(handle);
		pass.addActionListener(handle);
	}
	private class handler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{int k=0,k2=0;
		if(event.getSource() == Cancel)
		{
			f.setVisible(false);frl.setVisible(true);
		}
			if(event.getSource() == Ok)
			{int chh=0;
			
			if(newLogin==null||newPass==null)
				JOptionPane.showMessageDialog(null, "Some fields are empty");
			else
			{
				try

				{if(newLogin.equals(gm.Getusername())&&newPass.equals(gm.Getpassword()))
				{setVisible(false);chh=1;	new gmPage(gm,e,fsi,fgi,fe,fh,fho,fa,fsec,n,frl,fnu,ft,fs,tarray,e,h,a,sec,ho);}
				
				
				else if(e.s.Getusername().equals(newLogin)&&e.s.Getpassword().equals(newPass))
				{setVisible(false);chh=1;	new supervisorPage(e,fs,fsi,fgi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray);}
				else if(h.s.Getusername().equals(newLogin)&&h.s.Getpassword().equals(newPass))
				{	setVisible(false);chh=1;new supervisorPage(h,fs,fsi,fgi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray);}
				else if(ho.s.Getusername().equals(newLogin)&&ho.s.Getpassword().equals(newPass))
				{	setVisible(false);chh=1;new supervisorPage(ho,fs,fsi,fgi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray);}
				else if(sec.s.Getusername().equals(newLogin)&&sec.s.Getpassword().equals(newPass))
				{	setVisible(false);chh=1;new supervisorPage(sec,fs,fsi,fgi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray);}
				else if(a.s.Getusername().equals(newLogin)&&a.s.Getpassword().equals(newPass))
				{	setVisible(false);chh=1;new supervisorPage(a,fs,fsi,fgi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray);}
				
				else
				{
				for(int i=1;i<=e.nos;i++)
				{
					if(e.arr[i].Getusername().equals(newLogin)&&e.arr[i].Getpassword().equals(newPass))
					{
						setVisible(false);chh=1;new staffPage(e,fsi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray,i);
						
					}
				}
				for(int i=1;i<=h.nos;i++)
				{
					if(h.arr[i].Getusername().equals(newLogin)&&h.arr[i].Getpassword().equals(newPass))
					{
						setVisible(false);chh=1;new staffPage(h,fsi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray,i);
						
					}
				}
				for(int i=1;i<=ho.nos;i++)
				{
					if(ho.arr[i].Getusername().equals(newLogin)&&ho.arr[i].Getpassword().equals(newPass))
					{
						setVisible(false);chh=1;new staffPage(ho,fsi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray,i);
						
					}
				}
				for(int i=1;i<=sec.nos;i++)
				{
					if(sec.arr[i].Getusername().equals(newLogin)&&sec.arr[i].Getpassword().equals(newPass))
					{
						setVisible(false);chh=1;new staffPage(sec,fsi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray,i);
						
					}
				}
				for(int i=1;i<=a.nos;i++)
				{
					if(a.arr[i].Getusername().equals(newLogin)&&a.arr[i].Getpassword().equals(newPass))
					{
						setVisible(false);chh=1;new staffPage(a,fsi,fe,fh,fa,fsec,fho,n,frl,fnu,ft,tarray,i);
						
					}
				}
				
				}
				if(chh==0)
	        		
					JOptionPane.showMessageDialog(null, "Invalid username or password"); 
				}
				catch(Exception eh){}
			}
			}
			else if(event.getSource() == login)
			{
				newLogin = event.getActionCommand();
				if(newLogin.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				
			}
			else if(event.getSource() == pass)
			{
				newPass = event.getActionCommand();
				if(newPass.equals(""))
					JOptionPane.showMessageDialog(null, "Field can't be empty");
				
			}
		}
	}
}






