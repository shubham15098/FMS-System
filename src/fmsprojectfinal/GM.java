/**@package fmsprojectfinal
 * 
 */
package fmsprojectfinal;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import java.util.*;
import java.io.*;

/**@brief parent class of all members associated with fms system
 */
class member
{
	private String name=null;
 	 private String username=null;
 	 
 	 private int userid=0;
 	 private String DOB=null;
 	 private String address=null;
	static int useridcount=0;
	
	 public void Setname(String name)
		{this.name=name;
		}


/**@brief
 * getters and setters
 */
public void Setusername(String username)
{
	 this.username=username;
}

public void Setuserid(int userid)
{
	 this.userid=userid;
}
public void SetDOB(String DOB)
{
	 this.DOB=DOB;
}
public void Setaddress(String address)
{
	 this.address=address;
}

public int Getuserid()
{
	 return this.userid;
}

public String Getusername()
{
	 return this.username;
}
public String Getname()
{
	 return this.name;
}
public String GetDOB()
{
	 return this.DOB;
}
public String Getaddress()
{
	 return this.address;
}
}
/**@brief decidor for type of member
 */
class memberdecidor
{Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;
	  public memberdecidor(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho)
	  {
	  this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;
	  }
	  public member mem(String mem)
	  {
		  if(mem == null){
		         return null;
		      }		
		      if(mem.equalsIgnoreCase("GM")){
		         return new GM(e,h,a,sec,ho);
		         
		      } else if(mem.equalsIgnoreCase("supervisor")){
		         return new supervisor();
		         
		      } else if(mem.equalsIgnoreCase("staff")){
		         return new staff();
		      }
		      
		      return null;
	  }
}
/**@brief GM class for GM 
 */
  class GM extends member{
private  String name="abcd";
private  String username="abcd";
private  String password="0";
private  int userid=0;
private  String DOB="01/01/2001";int notif=0;String [] notifs=new String[50];
private  String address="abcd";
String logout="1";
Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;

	 public GM(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho) 
	{
		 this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;
	}
	 /**
	  	 * getter and setter methods
	  	 */
	 public void Setname(String name)
		{this.name=name;
		}



public void Setusername(String username)
{
	 this.username=username;
}
public void Setpassword(String password)
{
	 this.password=password;
}
public void Setuserid(int userid)
{
	 this.userid=userid;
}
public void SetDOB(String DOB)
{
	 this.DOB=DOB;
}
public void Setaddress(String address)
{
	 this.address=address;
}
public String Getpassword()
{
	 return this.password;
}
public int Getuserid()
{
	 return this.userid;
}

public String Getusername()
{
	 return this.username;
}
public String Getname()
{
	 return this.name;
}
public String GetDOB()
{
	 return this.DOB;
}
public String Getaddress()
{
	 return this.address;
}
dept d;
/**@brief add supervisors*/
	 public void addsup(dept d,supervisor sup)
	{d.s=sup;}
	 /**@brief delete supervisors*/
	public void deletesup(dept d)
	{	
		d.s.Setusername("NO SUPERVISOR");d.s.nog=0;d.s.not=0;
		d.s.Setuserid(0);d.s.Setaddress(null);d.s.SetDOB(null);d.s.Setname(null);d.s.Setpassword(null);d.s.Setstatus(null);d.s.Setstatusoftask(null);
	}
	/**@brief add staff*/
	public void addstaff(dept d,staff st)
	{d.arr[d.nos++]=st;}
	/**@brief delete staff*/
	public void deletestaff(dept d,staff st)
	{		int kk,h;
			for(kk=1;kk<=d.nos;kk++)
			{
			if(d.arr[kk].Getusername().equals(st.Getusername())&&d.arr[kk].Getuserid()==st.Getuserid())
			{
			for(h=kk+1;h<=d.nos;h++)
			{
				d.arr[h-1]=d.arr[h];}}}
			d.arr = Arrays.copyOfRange(d.arr, 0, d.nos);
			
			d.nos--;}
			
/**@brief delete the newuser */
	
	public void modifynewuser(newuser [] n,newuser nn)
	{
		int kk,h;
		for(kk=1;kk<=newuser.no;kk++)
		{//System.out.println("p"+p[j].arr2[kk]);	
		if(n[kk].Getusername().equals(nn.Getusername())&&n[kk].Getuserid()==nn.Getuserid())
		{
		for(h=kk+1;h<=newuser.no;h++)
		{
			n[h-1]=n[h];
		}
		
		}
		
		}
		
		n = Arrays.copyOfRange(n, 0, newuser.no);
		newuser.no--;
	}
	/**@brief assign task to supervisor*/
	public void assigntask(dept d,supervisor sup,task tt)
	{			d.s.t[++d.s.not]=tt;}
	/**@brief accept leave of supervisor*/
	public void acceptsupleave(dept d,leave ll)
	{d.s.l=ll;}
	/**@brief accept log request of supervisor*/
	public void acceptlogisticrequests(dept d,gminventory inreq)
	{d.s.g[++d.s.nooflogreq]=inreq;}
	/**@brief reject log request of supervisor*/
	 public void rejectlogisticrequests(dept d,gminventory inreq)
		{
		 int kk,h;
			for(kk=1;kk<=d.s.nooflogreq;kk++)
			{	
			if(d.s.g[kk].Getitemid()==inreq.Getitemid())
			{
			for(h=kk+1;h<=d.s.nooflogreq;h++)
			{d.s.g[h-1]=d.s.g[h];}}}
			d.s.g = Arrays.copyOfRange(d.s.g, 0, d.s.nooflogreq);
			d.s.nooflogreq--;
		}
	}
  /**@brief supervisor class for supervisor
   */
  class supervisor extends member
  {		
  	private String name=null;
  	 private String username=null;
  	 private String password=null;
  	 private int userid=0;
  	 private String DOB=null;
  	 private String address=null;
  	 task t[]=new task[1000];
  	 public int nooflogreq=0;
  	 private String status="Available";
  	 private String statusoftask="Not started";
  	 filesupervisor f1;
  	 gminventory g[]=new gminventory[1000];
  	leave l;int notif=0;String [] notifs=new String[50];String logout=null;
    public int not=0,nog=0;
  	/**
   	 * getter and setter methods
   	 */
  	 public void Setname(String name)
  			{this.name=name;
  			}
  	 public void Setstatus(String status)
  		{this.status=status;
  		}
  	 public void Setstatusoftask(String statusoftask)
  		{this.statusoftask=statusoftask;
  		}
  	 
  	 public void Setnot(int not)
  	 {
  		 this.not=not;
  		
  	 }
  	 
  	 public void Setusername(String username)
  	 {
  		 this.username=username;
  	 }
  	 public void Setpassword(String password)
  	 {
  		 this.password=password;
  	 }
  	 public void Setuserid(int userid)
  	 {
  		 this.userid=userid;
  	 }
  	 public void SetDOB(String DOB)
  	 {
  		 this.DOB=DOB;
  	 }
  	 public void Setaddress(String address)
  	 {
  		 this.address=address;
  	 }
  	 public String Getpassword()
  	 {
  		 return this.password;
  	 }
  	 public int Getuserid()
  	 {
  		 return this.userid;
  	 }
  	 public int Getnot()
  	 {
  		 return this.not;
  	 }
  	 public String Getusername()
  	 {
  		 return this.username;
  	 }
  	 public String Getstatusoftask()
  	 {
  		 return this.statusoftask;
  	 }
  	 public String Getstatus()
  	 {
  		 return this.status;
  	 }
  	 public String Getname()
  	 {
  		 return this.name;
  	 }
  	 public String GetDOB()
  	 {
  		 return this.DOB;
  	 }
  	 public String Getaddress()
  	 {
  		 return this.address;
  	 }
  	 
  	public supervisor()
  	{
  		for(int i=0;i<10;i++)
  			t[i]=new task();
  		for(int i=0;i<10;i++)
  			g[i]=new gminventory();
  		l=new leave();
  		
  	}
  	/**@brief add staff*/ 
  	public void addstaff(dept d,staff st)
  	{
  		d.arr[++d.nos]=st;
  	}
  	/**@brief delete staff*/ 
  	public void deletestaff(dept d,staff st)
  	{
  	int kk,h;
	for(kk=1;kk<=d.nos;kk++)
	{//System.out.println("p"+p[j].arr2[kk]);	
	if(d.arr[kk].Getusername().equals(st.Getusername())&&d.arr[kk].Getuserid()==st.Getuserid())
	{
	for(h=kk+1;h<=d.nos;h++)
	{
		d.arr[h-1]=d.arr[h];
	}
	
	}
	
	}
	
	d.arr = Arrays.copyOfRange(d.arr, 0, d.nos);
	d.nos--;

  	
  	}
  	/**@brief assign task to staff*/ 
  	public void assigntask(dept d,staff st,task tt) //choice of all,some or one staff
  	{
  		for(int j=1;j<=d.nos;j++)
  		{
  			if(d.arr[j].Getuserid()==st.Getuserid())
  				{//System.out.println("hi");
  				d.arr[j].t[++d.arr[j].not]=tt;break;}
  		}
  	
  	}
  	/**@brief accept log request of staff*/ 
  	public void acceptlogisticrequests(dept d,staff st,supinventory inreq)
  	{
  		for(int j=1;j<=d.nos;j++)
  		{
  			if(d.arr[j].Getuserid()==st.Getuserid())
  				{d.arr[j].si[++d.arr[j].nooflogreq]=inreq;break;}
  		}
  	}
  	/**@brief delete new user*/ 
  	public void modifynewuser(newuser [] n,newuser nn)
	{
		int kk,h;
		for(kk=1;kk<=newuser.no;kk++)
		{//System.out.println("p"+p[j].arr2[kk]);	
		if(n[kk].Getusername().equals(nn.Getusername())&&n[kk].Getuserid()==nn.Getuserid())
		{
		for(h=kk+1;h<=newuser.no;h++)
		{
			n[h-1]=n[h];
		}
		
		}
		
		}
		
		n = Arrays.copyOfRange(n, 0, newuser.no);
		newuser.no--;
	}
  	/**@brief reject log request of staff*/ 
  	public void rejectlogisticrequests(dept d,int att,supinventory inreq)
  	{
  		int kk,h;
		for(kk=1;kk<=d.arr[att].nooflogreq;kk++)
		{//System.out.println("p"+p[j].arr2[kk]);	
		if(d.arr[att].si[kk].Getitemid()==inreq.Getitemid())
		{
		for(h=kk+1;h<=d.arr[att].nooflogreq;h++)
		{
			d.arr[att].si[h-1]=d.arr[att].si[h];
		}
		
		}
		
		}
		
		d.arr[att].si = Arrays.copyOfRange(d.arr[att].si, 0, d.arr[att].nooflogreq);
		d.arr[att].nooflogreq--;
  	}
  	
  	public void sendleave(leave ll)
  	{
  		this.l=ll;
  	}
  	
  	
  	/**@brief generation of task report by supervisor
  	 * @param tk task type variable for generating its report
  	 */
  	public void genreport(task tk)  
  	{int count=0;
  		if(tk.Getstatus().equals("Complete"))
  			{try{
  				StringBuilder sb6=new StringBuilder();
  				sb6.append("report"+"userid"+this.Getuserid()+"taskid"+tk.Getid()+".txt");
  				String s=sb6.toString();
  			File f=new File(s);
  			f.createNewFile();
  			f.setWritable(true);
  			PrintWriter fout = new PrintWriter(f);
  			fout.write("Name-");
  			fout.write(this.name);fout.println();
  			fout.write("UserName-");
  			fout.write(this.username);fout.println();
  			fout.write("Userid-");
  			fout.write(String.valueOf(this.userid));fout.println();
  			fout.write("Department-");
  			fout.write(tk.Getdept());fout.println();
  			fout.write("Task-");
  			fout.write(tk.Getname());fout.println();
  			fout.write("Taskid-");
  			fout.write(String.valueOf(tk.Getid()));fout.println();
  			fout.write("Description-");
  			fout.write(tk.Getdesc());fout.println();
  			fout.write("Deadline-");
  			fout.write(tk.Getdeadline());fout.println();
  			
  			
  			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
  			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy"); 
  			
  			String Porsche=tk.todate;
  		
  			StringBuilder sb = new StringBuilder();
  			sb.append(Porsche.charAt(6));
  			sb.append(Porsche.charAt(7));
  			sb.append(Porsche.charAt(8));
  			sb.append(Porsche.charAt(9));
  			String str = sb.toString();
  			
  			StringBuilder sb2 = new StringBuilder();
  			//if(Porsche.charAt(4)!='0')
  			sb2.append(Porsche.charAt(3));
  			sb2.append(Porsche.charAt(4));
  					String str2 = sb2.toString();
  					
  					 sb = new StringBuilder();
  			//if(Porsche.charAt(6)!='0')
  			sb.append(Porsche.charAt(0));
  			
  			sb.append(Porsche.charAt(1));
  					String str3 = sb.toString();
  					
  					sb = new StringBuilder();
  					String ss=tk.Getdeadline();
  					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
  					
  					String str6 = sb.toString();//todate date
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
  					String str5 = sb.toString();//todate month
  					
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
  					String str4 = sb.toString();//todate year
  				System.out.println(str5.compareTo(str2));
  					if(str4.compareTo(str)==0&&str5.compareTo(str2)==0&&str6.compareTo(str3)==0)
  						{fout.write("Status-Completed on ");tk.Setcomment("Completed");fout.write(tk.todate);}
  					else if((str4.compareTo(str)<=0)&&str5.compareTo(str2)<=0&&str6.compareTo(str3)<=0)
  							{fout.write("Deadline passed");tk.Setcomment("Deadline passed");count=1;}
  					else
  								{fout.write("Status-Completed on ");tk.Setcomment("Completed");fout.write(tk.todate);}
  					int ans=0;
  					
  					if(count==0)
  					{fout.println();
  					ss=tk.fromdate;
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
  					String str11 = sb.toString();
  					
  					 ans=(Integer.parseInt(str3)-Integer.parseInt(str11));
  					
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
  					str11 = sb.toString();
  					ans+=(Integer.parseInt(str2)-Integer.parseInt(str11))*30;
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
  					str11 = sb.toString();
  					ans+=(Integer.parseInt(str)-Integer.parseInt(str11))*365;
  					
  					fout.write("Time Taken(in days)-");
  					
  					fout.write(String.valueOf(ans));fout.println();
  					
  					fout.write("Comments-");
  					fout.write(tk.Getcomment().trim());fout.println();
  					
  					}
  					fout.close();
  					fout.flush();
  			}
  					
  			
  			catch(Exception e){}}
  			
  		
  			
  	}
  
  	
  }


/**@brief staff class
 * 
 */
  class staff extends member
  { 
  	private String name=null;
  	private String username=null;
  	private String password=null;
  	private int userid=0;
  	private String DOB=null;
  	private String address=null;
  	supinventory si[]=new supinventory[1000];
  	task t[]=new task[1000];
  	public int not=0,nog=0;

  	public int nooflogreq=0;
  	leave l;int notif=0;String [] notifs=new String[50];String logout=null;
  	private String status="Available";
  	private String statusoftask="Not started";
  	
  	/**@brief getter and setter methods*/
  	 
  	public void Setname(String name)
  	 {
  		 this.name=name;
  	 }
  	public void Setusername(String username)
  	 {
  		 this.username=username;
  	 }
  	 public void Setstatus(String status)
  		{this.status=status;
  		}
  	 public void Setstatusoftask(String statusoftask)
  		{this.statusoftask=statusoftask;
  		}
  	 
  	 public void Setpassword(String password)
  	 {
  		 this.password=password;
  	 }
  	 public void Setuserid(int userid)
  	 {
  		 this.userid=userid;
  	 }
  	 public void Setnot(int not)
  	 {
  		 this.not=not;
  	 }
  	 public void SetDOB(String DOB)
  	 {
  		 this.DOB=DOB;
  	 }
  	 public void Setaddress(String address)
  	 {
  		 this.address=address;
  	 }
  	 public String Getpassword()
  	 {
  		 return this.password;
  	 }
  	 public int Getuserid()
  	 {
  		 return this.userid;
  	 }
  	 public int Getnot()
  	 {
  		 return this.not;
  	 }
  	 public String Getusername()
  	 {
  		 return this.username;
  	 }
  	 public String Getname()
  	 {
  		 return this.name;
  	 }
  	 public String GetDOB()
  	 {
  		 return this.DOB;
  	 }
  	 public String Getstatusoftask()
  	 {
  		 return this.statusoftask;
  	 }
  	 public String Getstatus()
  	 {
  		 return this.status;
  	 }
  	 public String Getaddress()
  	 {
  		 return this.address;
  	 }
  	 /**
  	  * a constructor
  	  */
  	public staff()
  	{
  		for(int i=0;i<10;i++)
  			t[i]=new task();
  		for(int i=0;i<10;i++)
  			si[i]=new supinventory();
  		l=new leave();
  	}
  	
  	public void sendlogisticreq(supinventory ss){}
  	
  	/**@brief generating of report on completion of atask
  	 * @param tk task type object
  	 */
  	public void genreport(task tk)  //file writing
  	{int count=0;
  	
  		if(tk.Getstatus().equals("Complete"))
  			{try{
  				
  			StringBuilder sb6=new StringBuilder();
				sb6.append("report"+"userid"+this.Getuserid()+"taskid"+tk.Getid()+".txt");
				String s=sb6.toString();
			File f=new File(s);
			f.createNewFile();
			f.setWritable(true);
  			PrintWriter fout = new PrintWriter(f);
  			fout.write("Name-");
  			fout.write(this.name);fout.println();
  			fout.write("UserName-");
  			fout.write(this.username);fout.println();
  			fout.write("Userid-");
  			fout.write(String.valueOf(this.userid));fout.println();
  			fout.write("Department-");
  			fout.write(tk.Getdept());fout.println();
  			fout.write("Task-");
  			fout.write(tk.Getname());fout.println();
  			fout.write("Taskid-");
  			fout.write(String.valueOf(tk.Getid()));fout.println();
  			fout.write("Description-");
  			fout.write(tk.Getdesc());fout.println();
  			fout.write("Deadline-");
  			fout.write(tk.Getdeadline());fout.println();
  			
  			
  			
  			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
  			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy"); 
  			
  			String Porsche=tk.todate;
  		
  			StringBuilder sb = new StringBuilder();
  			sb.append(Porsche.charAt(6));
  			sb.append(Porsche.charAt(7));
  			sb.append(Porsche.charAt(8));
  			sb.append(Porsche.charAt(9));
  			String str = sb.toString();
  			
  			StringBuilder sb2 = new StringBuilder();
  			//if(Porsche.charAt(4)!='0')
  			sb2.append(Porsche.charAt(3));
  			sb2.append(Porsche.charAt(4));
  					String str2 = sb2.toString();
  					
  					 sb = new StringBuilder();
  			//if(Porsche.charAt(6)!='0')
  			sb.append(Porsche.charAt(0));
  			
  			sb.append(Porsche.charAt(1));
  					String str3 = sb.toString();
  					
  					sb = new StringBuilder();
  					String ss=tk.Getdeadline();
  					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
  					
  					String str6 = sb.toString();//todate date
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
  					String str5 = sb.toString();//todate month
  					
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
  					String str4 = sb.toString();//todate year
  				System.out.println(str5.compareTo(str2));
  					if(str4.compareTo(str)==0&&str5.compareTo(str2)==0&&str6.compareTo(str3)==0)
  						{fout.write("Status-Completed on ");tk.Setcomment("Completed");fout.write(tk.todate);}
  					else if((str4.compareTo(str)<=0)&&str5.compareTo(str2)<=0&&str6.compareTo(str3)<=0)
  							{fout.write("Deadline passed");tk.Setcomment("Deadline passed");count=1;}
  					else
  								{fout.write("Status-Completed on ");tk.Setcomment("Completed");fout.write(tk.todate);}
  					int ans=0;
  					
  					if(count==0)
  					{fout.println();
  					ss=tk.fromdate;
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
  					String str11 = sb.toString();
  					
  					 ans=(Integer.parseInt(str3)-Integer.parseInt(str11));
  					
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
  					str11 = sb.toString();
  					ans+=(Integer.parseInt(str2)-Integer.parseInt(str11))*30;
  					
  					sb = new StringBuilder();
  					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
  					str11 = sb.toString();
  					ans+=(Integer.parseInt(str)-Integer.parseInt(str11))*365;
  					
  					fout.write("Time Taken(in days)-");
  					if(ans==0)
  						fout.write(String.valueOf(0));
  					else
  					fout.write(String.valueOf(ans));fout.println();
  					
  					fout.write("Comments-");
  					fout.write(tk.Getcomment().trim());fout.println();
  					}
  					fout.close();
  					fout.flush();
  					
  			}
  					
  			
  			catch(Exception e){}}
  			
  		
  			
  	}
  	public void sendleave(leave ll)
  	{
  		this.l=ll;
  	}
  	
  	
  	
  }
  
  /**@brief department class
   */
  class dept
  {
  	supervisor s;
  	String department=new String();
  	staff arr[]=new staff[10];
  	public int nos=0;
  	
  }
  /**@brief Electricity class
   */
  class Electricity extends dept
  {
	  private static Electricity instance ;

	  
	   private Electricity()
	   {
		   this.department="Electricity";
		   for(int i=0;i<10;i++)
	  			arr[i]=new staff();
	  		s=new supervisor();
	   }

	   public static Electricity getInstance()
	   {
		   if(instance==null)
			   instance= new Electricity();
	      return instance;
	   }
  	
  	

  }
  /**@brief HVAC class
   */
  class HVAC extends dept
  {
	  private static HVAC instance ;

	  
	   private HVAC()
	   {
		   this.department="HVAC";
		   for(int i=0;i<10;i++)
	  			arr[i]=new staff();
	  		s=new supervisor();
	   }

	   public static HVAC getInstance()
	   {
		   if(instance==null)
			   instance= new HVAC();
	      return instance;
	   }
 	
 	
  }
  /**@brief AV class
   */
  class AV extends dept
  {
	  private static AV instance ;

	  
	   private AV()
	   {
		   this.department="AV";
		   for(int i=0;i<10;i++)
	  			arr[i]=new staff();
	  		s=new supervisor();
	   }

	   public static AV getInstance()
	   {
		   if(instance==null)
			   instance= new AV();
	      return instance;
	   }
	
  }
  /**@brief Security class
   */
  class Security extends dept
  {
	  private static Security instance ;

	  
	   private Security()
	   {
		   this.department="Security";
		   for(int i=0;i<10;i++)
	  			arr[i]=new staff();
	  		s=new supervisor();
	   }

	   public static Security getInstance()
	   {
		   if(instance==null)
			   instance= new Security();
	      return instance;
	   }
	
  }
  /**@brief Housekeeping class
   */
  class Housekeeping extends dept
  {
	  private static Housekeeping instance ;

	  
	   private Housekeeping()
	   {
		   this.department="Housekeeping";
		   for(int i=0;i<10;i++)
	  			arr[i]=new staff();
	  		s=new supervisor();
	   }

	   public static Housekeeping getInstance()
	   {
		   if(instance==null)
			   instance= new Housekeeping();
	      return instance;
	   }
	
  }
/**@brief leave class
 */
  class leave
  {
  	private String fromdate=null;
  	private String todate=null;
  	private String reason=null;
  	private String status="Applied";
  	public leave( )
  	{
  		
  		
  	}
  	/**@brief getter and setter methods*/
  	public void Setfromdate(String fromdate)
  	{
  		this.fromdate=fromdate;
  	}
  	public void Setstatus(String status)
  	{
  		this.status=status;
  	}
  	public void Settodate(String todate)
  	{
  		this.todate=todate;
  	}
  	public void Setreason(String reason)
  	{
  		this.reason=reason;
  	}
  	public  String Getfromdate()
  	{
  		return this.fromdate;
  	}
  	public String Gettodate()
  	{
  		return this.todate;
  	}
  	public String Getstatus()
  	{
  		return this.status;
  	}
  	public String Getreason()
  	{
  		return this.reason;
  	}
  }


  
  
/**
 * @brief newuser class
 */
  
  class newuser
  {
	  static int no=1;
  	private String name=null;
  	private String username=null;
  	private String password=null;
  	private int userid=0;
  	private String DOB=null;
  	private String address=null;
  	private String dept=null;
  	private String member=null;
  	String status="Applied";
  	int choice=0;
  	
  	public newuser()
  	{
  		
  	}
  	/**@brief getter and setter methods*/
  	public void Setname(String name)
  	 {
  		 this.name=name;
  	 }
  	public void Setmember(String member)
  	 {
  		 this.member=member;
  	 }
  	
  	public void Setusername(String username)
  	 {
  		 this.username=username;
  	 }
  	
  	 
  	 public void Setpassword(String password)
  	 {
  		 this.password=password;
  	 }
  	 public void Setuserid(int userid)
  	 {
  		 this.userid=userid;
  	 }
  	 public void Setdept(String dept)
  		{
  			this.dept=dept;
  		}
  	 public void SetDOB(String DOB)
  	 {
  		 this.DOB=DOB;
  	 }
  	 public void Setaddress(String address)
  	 {
  		 this.address=address;
  	 }
  	 public String Getpassword()
  	 {
  		 return this.password;
  	 }
  	 public int Getuserid()
  	 {
  		 return this.userid;
  	 }
  	 public String Getdept()
  	 {
  		 return this.dept;
  	 }
  	 public String Getusername()
  	 {
  		 return this.username;
  	 }
  	 public String Getname()
  	 {
  		 return this.name;
  	 }
  	 public String Getmember()
  	 {
  		 return this.member;
  	 }
  	 public String GetDOB()
  	 {
  		 return this.DOB;
  	 }
  	 
  	 public String Getaddress()
  	 {
  		 return this.address;
  	 }
  }
  
