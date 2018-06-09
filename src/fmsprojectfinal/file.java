package fmsprojectfinal;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;



class filedecidor
{private file fe,fsec,fho,fa,fh;
	public filedecidor()
	{
		
	}
	public void createelec(fileelecstaff fe)
	{
		fe.create(1);
	}
	public void createhvac(fileHVACstaff fh)
	{
		fh.create(1);
	}
	public void createho(filehousekeepingstaff fho)
	{
		fho.create(1);
	}
	public void createsec(filesecstaff fsec)
	{
		fsec.create(1);
	}
	public void createav(fileAVstaff fa)
	{
		fa.create(1);
	}
}

class filesupervisor
{int count=0,k=0,c=0,l=0,z=0,y=0,kk=0;
Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;dept d[]=new dept[10];newuser n[];
	public filesupervisor(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[])
	{
		this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;
	}
	/**@brief reading file from the supervisor database
	 * @param i a counter
	 * @return void
	 */
	void create(int i)
	{ try
	   { FileInputStream fin=new FileInputStream("supervisor.csv");  
	     count = 0; int ch=0;char temp; String str;StringBuilder sb = new StringBuilder();int t=0;  
	     while((t=fin.read())!=-1) {if((char)t != ',' && (char)t != '\n'){
	    	 temp = (char)t;sb.append(temp);}
	     else
    	 {str = sb.toString();
    	 if(count==0)
	     {String dept=str;
 	 	if(str.equals("Electricity")){sup=e.s;d[i]=e;}
 	 	else if(str.equals("HVAC")){sup=h.s;d[i]=h;}
	 	else if(str.equals("AV")){sup=a.s;d[i]=a;}
	 	else if(str.equals("Housekeeping")){sup=ho.s;d[i]=ho;}
	 	else if(str.equals("Security")){sup=sec.s;d[i]=sec;}count++;} 
    	  else if(count==1)
	    	 {sup.Setname(str);count++;} else if(count==2){sup.Setuserid(Integer.parseInt(str));count++;}else if(count==3) {sup.Setusername(str);count++;} else if(count==4) {sup.Setpassword(str);count++;}	
	    	 else if(count==5)
	    	 {StringBuilder sb55=new StringBuilder();int g=0;
	          if(str.charAt(1)=='/'){sb55.append('0');g=1;}
	          if(g==1){
	    		for(int ikk=0;ikk<str.length();ikk++)
	    		 {sb55.append(str.charAt(ikk));}
	    		 str=sb55.toString();
	    		 sb55=new StringBuilder();
	    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2));
	    		 if(str.charAt(4)=='/')
	    			 sb55.append('0');
	    		 for(int ikk=3;ikk<str.length();ikk++)
	    			 sb55.append(str.charAt(ikk));
	    		 str=sb55.toString();
	          }
	          else if(str.charAt(4)=='/')
	    		{ sb55=new StringBuilder();
	    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2)); sb55.append('0');
	    		 for(int ikk=3;ikk<str.length();ikk++)
	    			 sb55.append(str.charAt(ikk));
	    		 str=sb55.toString();
	    			
	    		}
	    		 sup.SetDOB(str);count++;}
	    	
	           else if(count==6)
	    	 {sup.Setaddress(str);count++;}
	           else if(count==7)
	    	 {d[i].nos=Integer.parseInt(str);
	    		 if(d[i].nos==0)
	    	    	 count++;
	    	     c=d[i].nos;
	    	     count++;}
	    		 
	           else if(count==8)
	    	 {k++;
	    	 d[i].arr[k].Setuserid(Integer.parseInt(str));c--;
	    	if(c==0)
	    	count++;}
	    	 else if(count==9)
	    	 {sup.Setnot(Integer.parseInt(str));
	    		 if(sup.not==0)
	    	    	 count++;
	    	    	 c=sup.Getnot();
	    	    	 count++;}
	    	    	else if(count==10)
	    	 {l++;
	    	 sup.t[l].Setid(Integer.parseInt(str));c--;if(c==0)count++;}
	    	    	 else if(count==11)
	    	    	 {
	    	    		 StringBuilder sb55=new StringBuilder();int g=0;
	    	    		 if(str.charAt(1)=='/')
	    	    		 { sb55.append('0');g=1;}
	    	    		 if(g==1){
	    	    		
	    	    		 for(int ikk=0;ikk<str.length();ikk++)
	    	    		 {sb55.append(str.charAt(ikk));}
	    	    		
	    	    		 str=sb55.toString();
	    	    		 sb55=new StringBuilder();
	    	    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2));
	    	    		 
	    	    		 if(str.charAt(4)=='/')
	    	    			 sb55.append('0');
	    	    		 for(int ikk=3;ikk<str.length();ikk++)
	    	    			 sb55.append(str.charAt(ikk));
	    	    		 str=sb55.toString();}
	    	    		 else if(str.charAt(4)=='/')
	    		    		{ sb55=new StringBuilder();
	    		    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2)); sb55.append('0');
	    		    		 for(int ikk=3;ikk<str.length();ikk++)
	    		    			 sb55.append(str.charAt(ikk));
	    		    		 str=sb55.toString();
	    		    			
	    		    		}
	    	    		 sup.l.Setfromdate(str);count++;
	    	    	 }
	    	    	 else if(count==12)
	    	    	 {
	    	    		 StringBuilder sb55=new StringBuilder();int g=0;
	    	    		 if(str.charAt(1)=='/')
	    	    		 {g=1; sb55.append('0');}
	    	    		 if(g==1){
	    	    		
	    	    		 for(int ikk=0;ikk<str.length();ikk++)
	    	    		 {sb55.append(str.charAt(ikk));}
	    	    		
	    	    		 str=sb55.toString();
	    	    		 sb55=new StringBuilder();
	    	    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2));
	    	    		 
	    	    		 if(str.charAt(4)=='/')
	    	    			 sb55.append('0');
	    	    		 for(int ikk=3;ikk<str.length();ikk++)
	    	    			 sb55.append(str.charAt(ikk));
	    	    		 str=sb55.toString();
	    	    		 }
	    	    		 else if(str.charAt(4)=='/')
	    		    		{ sb55=new StringBuilder();
	    		    		 sb55.append('0'); sb55.append(str.charAt(1)); sb55.append(str.charAt(2)); sb55.append('0');
	    		    		 for(int ikk=3;ikk<str.length();ikk++)
	    		    			 sb55.append(str.charAt(ikk));
	    		    		 str=sb55.toString();
	    		    			
	    		    		}
	    	    		 sup.l.Settodate(str);count++;
	    	    	 }
	    	    	 else if(count==13){sup.l.Setreason(str);count++;}
	    	    	 else if(count==14){sup.l.Setstatus(str);count++;}
	    	    	 else if(count==15){sup.Setstatus(str);count++;count = 0;i++;k=0;l=0;kk=0;}
	    	    	  str = null; sb.setLength(0);}}str = null;i--;fin.close();}catch(Exception e){System.out.println(e);} } 
	/**@brief for writing to the supervisor database
	 * @param ch
	 * @param ik
	 * @return void
	 */
	    	void put(int ch,int ik)
	     	{try
	     	{ 
	     		File inputFile = new File("supervisor.csv");
	     		FileWriter fw = new FileWriter("supervisor.csv",true);
	    		 BufferedWriter bw = new BufferedWriter(fw);
	    		    PrintWriter fout = new PrintWriter(bw);int j,i=1;
	    		    BufferedWriter wr = new BufferedWriter(new FileWriter(inputFile));
	    			wr.write("");
	    			wr.close();
	     	//System.out.println(d[1].s.Getname());
	     	for(k=1;k<=5;k++)
	     	{
	     		if(ch==2&&ik==d[k].s.Getuserid())
	     		{
	     		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
	    		Date date2=new Date();
	    		String Porsche=sdf.format(date2);
	    		//System.out.println(Porsche);
	    		StringBuilder sb = new StringBuilder();
	    		sb.append(Porsche.charAt(0));
	    		sb.append(Porsche.charAt(1));
	    		sb.append(Porsche.charAt(2));
	    		sb.append(Porsche.charAt(3));
	    		String str = sb.toString();
	    		
	    		StringBuilder sb2 = new StringBuilder();
	    		//if(Porsche.charAt(4)!='0')
	    		sb2.append(Porsche.charAt(4));
	    		sb2.append(Porsche.charAt(5));
	    				String str2 = sb2.toString();
	    				
	    				 sb = new StringBuilder();
	    		//if(Porsche.charAt(6)!='0')
	    		sb.append(Porsche.charAt(6));
	    		
	    		sb.append(Porsche.charAt(7));
	    				String str3 = sb.toString();
	    				sb = new StringBuilder();
	    				String ss=d[k].s.l.Gettodate();
	    				sb.append(ss.charAt(0));sb.append(ss.charAt(1));
	    				String str6 = sb.toString();//todate date
	    				sb = new StringBuilder();
	    				sb.append(ss.charAt(3));sb.append(ss.charAt(4));
	    				String str5 = sb.toString();//todate month
	    				sb = new StringBuilder();
	    				sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
	    				String str4 = sb.toString();//todate year
	    				sb = new StringBuilder();
	    				 ss=d[k].s.l.Getfromdate();
	    				 sb.append(ss.charAt(0));sb.append(ss.charAt(1));
	    				String str8 = sb.toString();//fromdate date
	    				sb = new StringBuilder();
	    				sb.append(ss.charAt(3));sb.append(ss.charAt(4));
	    				String str9 = sb.toString();//fromdate month
	    				sb = new StringBuilder();
	    				sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
	    				String str10 = sb.toString();//fromdate year
	    		if(d[k].s.l.Getfromdate().equals(Porsche)||d[k].s.l.Gettodate().equals(Porsche))
	    			d[k].s.Setstatus("on leave");
	    		else if(((str4.compareTo(str)<0)&&(str5.compareTo(str2)<0)&&(str6.compareTo(str3)<0)))
	    		{	d[k].s.Setstatus("Available");}
	    		else if(((str.compareTo(str10)<0)&&(str2.compareTo(str9)<0)&&(str3.compareTo(str8)<0)))
	    		{d[k].s.Setstatus("Available");}
	    		else if(((str4.compareTo(str)<0)))
	    		{	d[k].s.Setstatus("Available");}
	    		else if(((str4.compareTo(str)<=0)&&(str5.compareTo(str2)<0)))
	    		{	d[k].s.Setstatus("Available");}
	    		else if(((str4.compareTo(str)<=0)&&(str5.compareTo(str2)<=0)&&(str6.compareTo(str3)<0)))
	    		{	d[k].s.Setstatus("Available");}
	    		else if(((str.compareTo(str10)<0)))
	    		{d[k].s.Setstatus("Available");}
	    		else if(((str.compareTo(str10)<=0)&&(str2.compareTo(str9)<0)))
	    		{d[k].s.Setstatus("Available");}
	    		else if(((str.compareTo(str10)<=0)&&(str2.compareTo(str9)<=0)&&(str3.compareTo(str8)<0)))
	    		{d[k].s.Setstatus("Available");}
	    		else
	    			d[k].s.Setstatus("on leave");
	     		}
	     	if(d[k] instanceof Electricity)
	     	fout.append("Electricity");
	     	else if(d[k] instanceof HVAC)
	     		fout.append("HVAC");
	     	else if(d[k] instanceof AV)
	     		fout.append("AV");
	     	else if(d[k] instanceof Housekeeping)
	     		fout.append("Housekeeping");
	     	else if(d[k] instanceof Security)
	     		fout.append("Security");
	     	fout.append(',');
	     	fout.append(d[k].s.Getname());fout.append(',');
	     	fout.append(String.valueOf(d[k].s.Getuserid()));fout.append(',');
	        fout.append(d[k].s.Getusername());
	     	 	fout.append(',');
	     	fout.append(d[k].s.Getpassword());
	     	fout.append(',');
	     	fout.append(d[k].s.GetDOB());
	     	fout.append(',');
	     	fout.append(d[k].s.Getaddress());
	     	fout.append(',');
	     	fout.append(String.valueOf(d[k].nos));
	     	fout.append(',');
	     	if(d[k].nos>0){
	     	for(j=1;j<d[k].nos;j++)
	     	{fout.append(String.valueOf(d[k].arr[j].Getuserid()));fout.append(',');}
	     	fout.append(String.valueOf(d[k].arr[d[k].nos].Getuserid()));
	     	fout.append(',');}
	     	System.out.println(k+" "+d[k].s.not);
	     	fout.append(String.valueOf(d[k].s.not));
	     	fout.append(',');
	     	if(d[k].s.not>0){
	     	for(j=1;j<d[k].s.not;j++)
	     	{fout.append(String.valueOf(d[k].s.t[j].Getid()));fout.append(',');}
	     	fout.append(String.valueOf(d[k].s.t[d[k].s.not].Getid()));
	     	fout.append(',');}
	     	fout.append(d[k].s.l.Getfromdate());
	     	fout.append(',');
	     	fout.append(d[k].s.l.Gettodate());
	     	fout.append(',');
	     	fout.write(d[k].s.l.Getreason());
	     	fout.append(',');
	     	fout.write(d[k].s.l.Getstatus());
	     	fout.append(',');
	     	fout.write(d[k].s.Getstatus().trim());
	     	fout.println();
	     	}fout.close();
	     	}
	     	catch(Exception e){System.out.println(e);} 
	     	} 		 
	    	/**@brief deleting a particular entry from the database based upon the userid.
	    	 * @param i Userid of the supervisor to be deleted.
	    	 * @return void
	    	 */
	    	public void delete(int i)
	    	{
	    		try{
	    			
	    			int k=0,id=0;
	    			File inputFile = new File("supervisor.csv");
	    			File tempFile = new File("supervisor1.csv");
	    			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	    			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	    			String currentLine;
	    			String x;
	    			while((x=reader.readLine())!=null)
	    			{k++;
	    			List<String>arr=Arrays.asList(x.split(","));
	    			id=Integer.parseInt(arr.get(2));
	    			if(id==i)
	    			continue;
	    			writer.write(x + System.getProperty("line.separator"));
	    			}
	    			writer.close(); 
	    			reader.close(); 
	    			BufferedWriter wr = new BufferedWriter(new FileWriter(inputFile));
	    			wr.write("");
	    			wr.close();
	    			  InputStream in = new FileInputStream("supervisor1.csv");
	    			  OutputStream out = new FileOutputStream("supervisor.csv", true);
	    			  byte[] buf = new byte[1024];
	    			  int len;
	    			  while ((len = in.read(buf)) > 0){
	    			    out.write(buf, 0, len);
	    			  }
	    			  in.close();
	    			  out.close();
	    			  tempFile.delete();
	    			}
	    			catch(Exception e){}
	    	}
	    }

	        		
	    	 
	    	
	    	
	    	
 	 	
         
	    
	    	 
	    	 
	    	 
	    	
	    	
	    	
	    	
	
	    	
	    		 
	    		 
	    		 
		    	 
	    	 
	    	
	    	
	      
	     
	     
	    	
	   
	 
	 
	   
	   
	   
	 
	
	   
	

	
	

	





class fileuseridcount
{
	public fileuseridcount(){}
	void create()
	{
		try
		{
			File file = new File("useridcount.csv");
			Scanner scanner = new Scanner(file);
		member.useridcount=scanner.nextInt();
		
		scanner.close();
	     }
		catch(Exception e){}
	}
	void put()
	{try
		{
		FileWriter fin = new FileWriter("useridcount.csv"); 
			
			fin.write(String.valueOf(member.useridcount));
			
			fin.close();
			fin.flush();
			}
			catch(Exception e){}
		
	}
}

interface file{
	
	 void create(int i);
	
	void put(int ch,int ch2);
	void add(staff st);
	void delete(int i);
	
}
