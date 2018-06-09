package fmsprojectfinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class fileAVstaff implements file
{int count=0,k=0,c=0,l=0,z=0,y=0,kk=0;
Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;newuser n[];
	public fileAVstaff(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[])
	{
		this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;
	}
	/**@brief reading file from the AVstaff database
	 * @param i a counter
	 * @return void
	 */
	public void create(int i)
	{ try
	   { FileInputStream fin=new FileInputStream("AVstaff.csv");  
	     count = 0; int ch=0;
	     char temp;
	     String str;
	     StringBuilder sb = new StringBuilder();
	     
	     int t=0;  
	     while((t=fin.read())!=-1)
	     { 
	    	 if((char)t != ',' && (char)t != '\n')
	    	 {
	    	 
	    	 temp = (char)t;
	    	 sb.append(temp);
	    	 
	    	 	    	 
	    	 }
	    	 else
	    	 {
	    	 str = sb.toString();
	    	 //System.out.println("count: " + str+" "+count);
	    	 
	    	 //System.out.println("sb: " + sb);
	    	 if(count==0)
	    	 {
	    		 
	    	 	a.arr[i].Setname(str);
	    	 	
	    	 	count++;
	    	 } 
	    
	    	 
	    	 
	    	 
	    	 else if(count==1)
	    	 {
	    		 a.arr[i].Setusername(str);count++;
	    	 
	    	 }
	    	 else if(count==2)
	    	 {a.arr[i].Setuserid(Integer.parseInt(str));count++;
	    	 }
	    	 else if(count==3)
	    	 {
	    	 
	    		 a.arr[i].Setpassword(str);count++;
	    	
	    	 }
	    	 
	    	 
	    	 else if(count==4)
	    	 {
	    		 
	    		 
	    		 a.arr[i].SetDOB(str);count++;
	    	
	    	 }
	    	 else if(count==5)
	    	 {
	    		 a.arr[i].Setaddress(str);count++;
	    	
	    	 }
	    	 
	    	 
	    	 else if(count==6)
	    	 {
	    		 
	    		 a.arr[i].Setnot(Integer.parseInt(str));
	    		 if(a.arr[i].not==0)
	    	    	 count++;
	    	    	 c=a.arr[i].Getnot();
	    	    	 count++;
	    	    	
	    		 
	    	 }
	    	 else if(count==7)
	    	 {//System.out.println("yeah " + p[i].username);
	    	
	    		 
	    	 l++;
	    	 a.arr[i].t[l].Setid(Integer.parseInt(str));
	    	//System.out.println( e.arr[i].t[l].Getid());
	    	 
	    	c--;
	    	if(c==0)
	    	count++;
	    	 
	    	 }

	    	 else if(count==8)
	    	 {
	    		
	    		 
	    		 a.arr[i].l.Setfromdate(str);count++;
	    	 }
	    	 else if(count==9)
	    	 {
	    		 
	    		
	    		 a.arr[i].l.Settodate(str);count++;
	    		
	    	 }
	    	 else if(count==10)
	    	 {
	    		 
	    		 a.arr[i].l.Setreason(str);count++;
	    		
	    	 }
	    	 else if(count==11)
	    	 {
	    		 
	    		 a.arr[i].l.Setstatus(str);count++;
	    		
	    	 }
	    	 else if(count==12)
	    	 {
	    		 
	    		 a.arr[i].Setstatus(str.trim());
	    		
	    		 count++;
	    		 count = 0;
		    	 i++;k=0;l=0;kk=0;
	    	 }
	    	 str = null;
	    	 sb.setLength(0);
	      
	     
	     
	    	 }
	    	 }
	     str = sb.toString();
	    // System.out.println(i);
	    
	     a.arr[i].Setstatus(str.trim());
	    
		    
	 str = null;i--;
	 
	 fin.close();
	   }
	   
	   catch(Exception e){System.out.println(e);}  
	 
	  
	   
	
	

	}
	/**@brief for writing to the AVstaff database
	 * @param ch2 userid whose leave status is to be updated
	 * @param ch whether update of leave status is required
	 * @return void
	 */
	public void put(int ch,int ch2)
	{
		try
	 	{ 
	 		File inputFile = new File("AVstaff.csv");
	 		FileWriter fw = new FileWriter("AVstaff.csv",true);
			 BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter fout = new PrintWriter(bw);int j,i=1;
			    BufferedWriter wr = new BufferedWriter(new FileWriter(inputFile));
				wr.write("");
				wr.close();
	 	
	 	for(k=1;k<=a.nos;k++)
	 	{
	 	
	 		if(ch==2&&ch2==a.arr[k].Getuserid()){
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
					String ss=a.arr[k].l.Gettodate();
					sb.append(ss.charAt(0));sb.append(ss.charAt(1));
					
					String str6 = sb.toString();//todate date
					
					sb = new StringBuilder();
					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
					String str5 = sb.toString();//todate month
					
					sb = new StringBuilder();
					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
					String str4 = sb.toString();//todate year
					
					//System.out.println(str4+" "+str5+" "+str6);	
					sb = new StringBuilder();
					 ss=a.arr[k].l.Getfromdate();
					 sb.append(ss.charAt(0));sb.append(ss.charAt(1));
					
					String str8 = sb.toString();//fromdate date
					
					sb = new StringBuilder();
					sb.append(ss.charAt(3));sb.append(ss.charAt(4));
					String str9 = sb.toString();//fromdate month
					
					sb = new StringBuilder();
					sb.append(ss.charAt(6));sb.append(ss.charAt(7));sb.append(ss.charAt(8));sb.append(ss.charAt(9));
					String str10 = sb.toString();//fromdate year
					//System.out.println(str5+" "+str2);
				
			if(a.arr[k].l.Getfromdate().equals(Porsche)||a.arr[k].l.Gettodate().equals(Porsche))
				a.arr[k].Setstatus("on leave");
			else if(((str4.compareTo(str)<0)&&(str5.compareTo(str2)<0)&&(str6.compareTo(str3)<0)))
			{	a.arr[k].Setstatus("Available");}
			else if(((str.compareTo(str10)<0)&&(str2.compareTo(str9)<0)&&(str3.compareTo(str8)<0)))
			{a.arr[k].Setstatus("Available");}
			else if(((str.compareTo(str10)<0)))
			{a.arr[k].Setstatus("Available");}
			else if(((str.compareTo(str10)<=0)&&(str2.compareTo(str9)<0)))
			{a.arr[k].Setstatus("Available");}
			else if(((str.compareTo(str10)<=0)&&(str2.compareTo(str9)<=0)&&(str3.compareTo(str8)<0)))
			{a.arr[k].Setstatus("Available");}
			else if(((str4.compareTo(str)<0)))
			{	a.arr[k].Setstatus("Available");}
			else if(((str4.compareTo(str)<=0)&&(str5.compareTo(str2)<0)))
			{	a.arr[k].Setstatus("Available");}
			else if(((str4.compareTo(str)<=0)&&(str5.compareTo(str2)<=0)&&(str6.compareTo(str3)<0)))
			{	a.arr[k].Setstatus("Available");}
			else
				a.arr[k].Setstatus("on leave");
	 		}
	 	fout.append(a.arr[k].Getname());
	 		
	 	fout.append(',');
	 	fout.append(a.arr[k].Getusername());
	 	fout.append(',');
	 	fout.append(String.valueOf(a.arr[k].Getuserid()));
	 	fout.append(',');
	 	fout.append(a.arr[k].Getpassword());
	 	fout.append(',');
	 	fout.append(a.arr[k].GetDOB());
	 	fout.append(',');
	 	fout.append(a.arr[k].Getaddress());
	 	fout.append(',');
	 	
	 	
	 	
	 	fout.append(String.valueOf(a.arr[k].not));
	 	fout.append(',');
	 	if(a.arr[k].not>0){
	 	for(j=1;j<a.arr[k].not;j++)
	 	{fout.append(String.valueOf(a.arr[k].t[j].Getid()));fout.append(',');}
	 	fout.append(String.valueOf(a.arr[k].t[a.arr[k].not].Getid()));
	 	fout.append(',');}
	 	
	 	
	 	fout.append(a.arr[k].l.Getfromdate());
	 	fout.append(',');
	 	fout.append(a.arr[k].l.Gettodate());
	 	fout.append(',');
	 	fout.write(a.arr[k].l.Getreason());
	 	fout.append(',');
	 	fout.write(a.arr[k].l.Getstatus());
	 	fout.append(',');
	 	
	 	if(a.arr[k].Getstatus()!=null)
	 	fout.write(a.arr[k].Getstatus());
	 	
	 	
	 	
	 	fout.println();
	 	}fout.close();
	 	
	 	}
	 	catch(Exception a){System.out.println(a);} 
	 	}
	/**@brief add staff member to database
	 * @param st staff type object
	 * return void
	 */
	public void add(staff st)
	{
				
		try{
			
		int j=0;
		FileWriter fw = new FileWriter("AVstaff.csv",true);
		 BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter fout = new PrintWriter(bw);
		
		fout.append(st.Getname());
		fout.append(',');
		fout.append(st.Getusername());
		fout.append(',');
		fout.append(String.valueOf(st.Getuserid()));
		fout.append(',');
		fout.append(st.Getpassword());
		fout.append(',');
		fout.append(st.GetDOB());
		fout.append(',');
		fout.append(st.Getaddress());
		fout.append(',');
		fout.append(String.valueOf(st.not));
	 	fout.append(',');
	 	if(st.not>0){
	 	for(j=1;j<st.not;j++)
	 	{fout.append(String.valueOf(st.t[j].Getid()));fout.append(',');}
	 	fout.append(String.valueOf(st.t[st.not].Getid()));
	 	fout.append(',');}
	 	fout.append(st.l.Getfromdate());
	 	fout.append(',');
	 	fout.append(st.l.Gettodate());
	 	fout.append(',');
	 	fout.append(st.l.Getreason());
	 	fout.append(',');
	 	fout.append(st.l.Getstatus());
	 	fout.append(',');
	 	fout.append(st.Getstatus().trim());
		fout.println();
		fout.flush();
		fout.close();
	}
	catch(Exception a){}
	}
	/**@brief deleting a particular entry from the database based upon the userid.
	 * @param i Userid of the staff to be deleted.
	 * @return void
	 */
	public void delete(int i)
	{
		try{
			
			int k=0,id=0;
			File inputFile = new File("AVstaff.csv");
			File tempFile = new File("AVstaff1.csv");

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
			  InputStream in = new FileInputStream("AVstaff1.csv");
			  OutputStream out = new FileOutputStream("AVstaff.csv", true);

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



