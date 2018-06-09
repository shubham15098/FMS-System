package fmsprojectfinal;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**@brief leave requests of staff to be accepted/rejected by respective supervisor GUI interface*/
 class leaveReqstaff extends JFrame  // jus put leave_method() = panel to get leave page
{
	private JPanel panel;
	private JTextField days;
	private JTextField reason;
	private JTextField start;
	private JTextField end;
	private JButton b;
	private JLabel ldays;
	private JLabel lreason;
	private JLabel lstart;
	private JLabel lend;
	private JLabel t;
	private int p,q,r,s;
	leave l=new leave();
	
	private int noOfDays; // here the data will be stored
	private String from;
	private String to;
	private String Reason;
	
	handler handle = new handler();
	private JTextField nof;fileHVACstaff fh;file fl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;int att=0;
	dept d=new dept();fileelecstaff fe;
	
	public leaveReqstaff(dept d,file fl,int att)
	{
		this.att=att;this.fl=fl;
		this.d=d;
		panel = new JPanel();
		days = new JTextField();
		reason = new JTextField();
		start = new JTextField();
		end = new JTextField();
		b = new JButton("Submit");
		ldays = new JLabel("Number of Days: ");
		lreason = new JLabel("Reason: ");
		lstart = new JLabel("From: ");
		lend = new JLabel("To: ");
		t = new JLabel("Apply for Leave");
	}
	
	public JPanel leave_method()
	{	
		p = 0;
		q= 0; r= 0; s= 0;
		t.setFont (t.getFont ().deriveFont (25.0f));
		ldays.setFont (ldays.getFont ().deriveFont (15.0f));
		days.setFont (days.getFont ().deriveFont (15.0f));
		start.setFont (start.getFont ().deriveFont (15.0f));
		lstart.setFont (lstart.getFont ().deriveFont (15.0f));
		lend.setFont (lend.getFont ().deriveFont (15.0f));
		end.setFont (end.getFont ().deriveFont (15.0f));
		reason.setFont (reason.getFont ().deriveFont (15.0f));
		lreason.setFont (lreason.getFont ().deriveFont (15.0f));
		b.setFont (b.getFont ().deriveFont (16.0f));
		
		t.setBounds(150,30,250,35);
		ldays.setBounds(75, 110, 200, 25);
		days.setBounds(220,110,100,25);
		lstart.setBounds(75, 160, 200, 25);
		start.setBounds(220,160,100,25);
		end.setBounds(475,160,100,25);
		lend.setBounds(400, 160, 100, 25);
		reason.setBounds(220,220,250,100);
		lreason.setBounds(75, 220, 200, 25);
		b.setBounds(175,370,100,25);
		b.setBackground(Color.orange);
		
		panel.setLayout(null);
		panel.add(t);
		panel.add(ldays);
		panel.add(days);
		panel.add(lstart);
		panel.add(start);
		panel.add(end);
		panel.add(lend);
		panel.add(reason);
		panel.add(lreason);
		panel.add(b);
		
		b.addActionListener(handle);
		start.addActionListener(handle);
		end.addActionListener(handle);
		reason.addActionListener(handle);
		days.addActionListener(handle);
		
		return panel;
	}
	
	public class handler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == b)
			{	
				if(p==1 && q==1 && r==1 && s==1)
					{
					d.arr[att].l=l;
					fl.put(0, 0);
					fl.create(1);
					
						JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
						reason.setText("");
						start.setText("");
						end.setText("");
						days.setText("");
						p=q=r=s=0;
					}
				else
					JOptionPane.showMessageDialog(null, "Incomplete Form");
			}
			else if(e.getSource() == days)
			{
				p = 1;
				noOfDays = Integer.parseInt(e.getActionCommand());
			}
			else if(e.getSource() == reason)
			{
				q = 1;
				Reason = e.getActionCommand();
				l.Setreason(Reason);
				
			}
			else if(e.getSource() == end)
			{
				r = 1;
				to = e.getActionCommand();
				 StringBuilder sb55=new StringBuilder();
	    		 if(to.charAt(1)=='/')
	    			 sb55.append('0');
	    		
	    		 for(int ikk=0;ikk<to.length();ikk++)
	    		 {sb55.append(to.charAt(ikk));}
	    		
	    		 to=sb55.toString();
	    		 sb55=new StringBuilder();
	    		 sb55.append('0'); sb55.append(to.charAt(1)); sb55.append(to.charAt(2));
	    		 
	    		 if(to.charAt(4)=='/')
	    			 sb55.append('0');
	    		 for(int ikk=3;ikk<to.length();ikk++)
	    			 sb55.append(to.charAt(ikk));
	    		 to=sb55.toString();
	    		 
				l.Settodate(to);
			}
			else if(e.getSource() == start)
			{
				s = 1;
				from = e.getActionCommand();
				StringBuilder sb55=new StringBuilder();
	    		 if(from.charAt(1)=='/')
	    			 sb55.append('0');
	    		
	    		 for(int ikk=0;ikk<from.length();ikk++)
	    		 {sb55.append(from.charAt(ikk));}
	    		
	    		 from=sb55.toString();
	    		 sb55=new StringBuilder();
	    		 sb55.append('0'); sb55.append(from.charAt(1)); sb55.append(from.charAt(2));
	    		 
	    		 if(from.charAt(4)=='/')
	    			 sb55.append('0');
	    		 for(int ikk=3;ikk<from.length();ikk++)
	    			 sb55.append(from.charAt(ikk));
	    		 from=sb55.toString();
	    		 
				l.Setfromdate(from);
			}
		}
		
	}
}
 /**@brief leave requests of supervisor to be accepted/rejected by GM GUI interface*/
 class leaveReqsup
 {
	 private JPanel panel;
		private JTextField days;
		private JTextField reason;
		private JTextField start;
		private JTextField end;
		private JButton b;
		private JLabel ldays;
		private JLabel lreason;
		private JLabel lstart;
		private JLabel lend;
		private JLabel t;
		private int p,q,r,s;
		leave l=new leave();
		
		private int noOfDays; // here the data will be stored
		private String from;
		private String to;
		private String Reason;
		
		handler handle = new handler();
		private JTextField nof;fileHVACstaff fh;file fl;fileAVstaff fa;filesecstaff fsec;filehousekeepingstaff fho;int att=0;
		dept d=new dept();filesupervisor fs;
		
		public leaveReqsup(dept d,filesupervisor fs)
		{
			this.fs=fs;
			this.d=d;
			panel = new JPanel();
			days = new JTextField();
			reason = new JTextField();
			start = new JTextField();
			end = new JTextField();
			b = new JButton("Submit");
			ldays = new JLabel("Number of Days: ");
			lreason = new JLabel("Reason: ");
			lstart = new JLabel("From: ");
			lend = new JLabel("To: ");
			t = new JLabel("Apply for Leave");
		}
		
		public JPanel leave_method()
		{	
			p = 0;
			q= 0; r= 0; s= 0;
			t.setFont (t.getFont ().deriveFont (25.0f));
			ldays.setFont (ldays.getFont ().deriveFont (15.0f));
			days.setFont (days.getFont ().deriveFont (15.0f));
			start.setFont (start.getFont ().deriveFont (15.0f));
			lstart.setFont (lstart.getFont ().deriveFont (15.0f));
			lend.setFont (lend.getFont ().deriveFont (15.0f));
			end.setFont (end.getFont ().deriveFont (15.0f));
			reason.setFont (reason.getFont ().deriveFont (15.0f));
			lreason.setFont (lreason.getFont ().deriveFont (15.0f));
			b.setFont (b.getFont ().deriveFont (16.0f));
			
			t.setBounds(150,30,250,35);
			ldays.setBounds(75, 110, 200, 25);
			days.setBounds(220,110,100,25);
			lstart.setBounds(75, 160, 200, 25);
			start.setBounds(220,160,100,25);
			end.setBounds(475,160,100,25);
			lend.setBounds(400, 160, 100, 25);
			reason.setBounds(220,220,250,100);
			lreason.setBounds(75, 220, 200, 25);
			b.setBounds(175,370,100,25);
			b.setBackground(Color.orange);
			
			panel.setLayout(null);
			panel.add(t);
			panel.add(ldays);
			panel.add(days);
			panel.add(lstart);
			panel.add(start);
			panel.add(end);
			panel.add(lend);
			panel.add(reason);
			panel.add(lreason);
			panel.add(b);
			
			b.addActionListener(handle);
			start.addActionListener(handle);
			end.addActionListener(handle);
			reason.addActionListener(handle);
			days.addActionListener(handle);
			
			return panel;
		}
		
		public class handler implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == b)
				{	
					if(p==1 && q==1 && r==1 && s==1)
						{
						d.s.l=l;
						fs.put(0, 0);
						fs.create(1);
						
							JOptionPane.showMessageDialog(null, "SUCCESSFULL SUBMISSION");
							reason.setText("");
							start.setText("");
							end.setText("");
							days.setText("");
							p=q=r=s=0;
						}
					else
						JOptionPane.showMessageDialog(null, "Incomplete Form");
				}
				else if(e.getSource() == days)
				{
					p = 1;
					noOfDays = Integer.parseInt(e.getActionCommand());
				}
				else if(e.getSource() == reason)
				{
					q = 1;
					Reason = e.getActionCommand();
					l.Setreason(Reason);
					
				}
				else if(e.getSource() == end)
				{
					r = 1;
					to = e.getActionCommand();
					 StringBuilder sb55=new StringBuilder();
		    		 if(to.charAt(1)=='/')
		    			 sb55.append('0');
		    		
		    		 for(int ikk=0;ikk<to.length();ikk++)
		    		 {sb55.append(to.charAt(ikk));}
		    		
		    		 to=sb55.toString();
		    		 sb55=new StringBuilder();
		    		 sb55.append('0'); sb55.append(to.charAt(1)); sb55.append(to.charAt(2));
		    		 
		    		 if(to.charAt(4)=='/')
		    			 sb55.append('0');
		    		 for(int ikk=3;ikk<to.length();ikk++)
		    			 sb55.append(to.charAt(ikk));
		    		 to=sb55.toString();
		    		 
					l.Settodate(to);
				}
				else if(e.getSource() == start)
				{
					s = 1;
					from = e.getActionCommand();
					 StringBuilder sb55=new StringBuilder();
		    		 if(from.charAt(1)=='/')
		    			 sb55.append('0');
		    		
		    		 for(int ikk=0;ikk<from.length();ikk++)
		    		 {sb55.append(from.charAt(ikk));}
		    		
		    		 from=sb55.toString();
		    		 sb55=new StringBuilder();
		    		 sb55.append('0'); sb55.append(from.charAt(1)); sb55.append(from.charAt(2));
		    		 
		    		 if(from.charAt(4)=='/')
		    			 sb55.append('0');
		    		 for(int ikk=3;ikk<from.length();ikk++)
		    			 sb55.append(from.charAt(ikk));
		    		 from=sb55.toString();
		    		 
					l.Setfromdate(from);
				}
			}
			
		}
 }
