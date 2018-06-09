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
import java.util.Arrays;
import java.util.List;

class filenewuser
{
	int count=0,k=0,c=0,l=0,z=0,y=0;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;newuser n[];fileuseridcount fu=new fileuseridcount();
		public filenewuser(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[],fileuseridcount fu)
		{
			this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;this.fu=fu;
		}
		/**@brief reading file from the newuser database
		 * @param i a counter
		 * @return void
		 */
		void create(int i)
		{
			try
			   { FileInputStream fin=new FileInputStream("newuser.csv");  
			     count = 0; int ch=0;
			     char temp;
			     String str;
			     StringBuilder sb = new StringBuilder();
			     newuser.no=1;
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
			    
			    	 if(count==0)
			    	 {
			    		 
			    	 	n[i].Setdept(str);
			 
			    	 	
			    	 	
			    	 	count++;
			    	 } 
			    
			    	 
			    	 
			    	 
			    	 else if(count==1)
			    	 {
			    	 n[i].Setname(str);count++;
			    	 
			    	 }
			    	 else if(count==2)
			    	 {n[i].Setuserid(Integer.parseInt(str));count++;
			    		
			    	 }
			    	 else if(count==3)
			    	 {
			    		 n[i].Setusername(str);count++;
			    		 
			    	
			    	 }
			    	 
			    	 else if(count==4)
			    	 {//System.out.println("yeah " + p[i].username);
			    	 
			    		 n[i].Setpassword(str);count++;
			    	 }
			    	 else if(count==5)
			    	 { 
			    		 n[i].SetDOB(str);count++;
			    	
			    	 }
			    	 else if(count==6)
			    	 {
			    		 n[i].Setaddress(str);count++;
			    	
			    	 
			    	 
			    		 
			    	 }
			    	
			    	 else if(count==7)
			    	 {
			    		 n[i].Setmember(str.trim());count++;
			    	
			    	 
			    	 
			    		 count = 0;
			    		
				    	 i++;k=0;l=0;
			    	 }
			    	 str = null;
			    	 sb.setLength(0);
			      
			     
			     
			    	 }
			    	 }
			    str = sb.toString();
			    i--;
			  
			     newuser.no=i;
			   
			    
			  
			 str = null;
			 fin.close();
			   }
			   
			   catch(Exception e){System.out.println(e);}  
		}
		
		/**@brief adding newuser to the database
		 * @param nn newuser type object for adding a newuser to database
		 */
		void add(newuser nn)
		{
			nn.Setuserid(member.useridcount++);
			fu.put();
			
			n[newuser.no++]=nn;
			
			try{
				
			
			FileWriter fw = new FileWriter("newuser.csv",true);
			 BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter fout = new PrintWriter(bw);
			   
			fout.append(nn.Getdept());
			fout.append(',');
			fout.append(nn.Getname());
			fout.append(',');
			fout.append(String.valueOf(nn.Getuserid()));
			fout.append(',');
			fout.append(nn.Getusername());
			fout.append(',');
			
			fout.append(nn.Getpassword());
			fout.append(',');
			fout.append(nn.GetDOB());
			fout.append(',');
			fout.append(nn.Getaddress());
			fout.append(',');
			
			nn.Setmember(nn.Getmember().trim());
			fout.append(nn.Getmember());
			
			 fout.println();
			fout.flush();
			fout.close();
		}
		catch(Exception e){}
		}
		/**@brief deletion of new user from database
		 * @param i userid of the user to be deleted
		 */
		void delete(int i)
		{int id=0;
try{
				
				int k=0;
				File inputFile = new File("newuser.csv");
				File tempFile = new File("newuser1.csv");

				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				
				String currentLine;
				String x;
				while((x=reader.readLine())!=null)
				{k++;
				List<String>arr=Arrays.asList(x.split(","));
				id=Integer.parseInt(arr.get(2));
				
				if(id==i)
				{continue;}
				writer.write(x + System.getProperty("line.separator"));
				}
				
				writer.close(); 
				reader.close(); 
				BufferedWriter wr = new BufferedWriter(new FileWriter(inputFile));
				wr.write("");
				wr.close();
				  InputStream in = new FileInputStream("newuser1.csv");
				  OutputStream out = new FileOutputStream("newuser.csv", true);

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
