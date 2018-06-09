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

class filesupinventory
{
	int count=0,k=0,c=0,l=0,z=0,y=0,id=0;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;dept d;newuser n[];fileuseridcount fu;
		public filesupinventory(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[],fileuseridcount fu)
		{
			this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;this.fu=fu;
		}
		/**@brief reading file from the sup inventory database
		 * @param i a counter
		 * @return void
		 */
		void create(int i)
		{ 
			 for(int j=1;j<=e.nos;j++)
				 e.arr[j].nooflogreq=0;
			 for(int j=1;j<=h.nos;j++)
				h.arr[j].nooflogreq=0;
			 for(int j=1;j<=ho.nos;j++)
				 ho.arr[j].nooflogreq=0;
			 for(int j=1;j<=sec.nos;j++)
				 sec.arr[j].nooflogreq=0;
			 for(int j=1;j<=a.nos;j++)
				 a.arr[j].nooflogreq=0;
			try
		   { FileInputStream fin=new FileInputStream("sup inventory.csv");  
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
		    //	System.out.println("count: " + str+" "+count);
		    	 
		    	// System.out.println("sb: " + sb);
		    	 if(count==0)
		    	 {
		    		 
		    	 	
		    	 	if(str.equals("Electricity"))
		    	 	{	d=e;}
		    	 	else if(str.equals("HVAC"))
	    	 		d=h;
		    	 	else if(str.equals("AV"))
		    	 		d=a;
		    	 	else if(str.equals("Housekeeping"))
		    	 		d=ho;
		    	 	else if(str.equals("Security"))
		    	 		d=sec;
		    	 	
		    	 	count++;
		    	 } 
		    
		    	 
		    	 
		    	 
		    	 else if(count==1)
		    	 {
		    	
		    	 count++;
		    	 for(int j=1;j<=d.nos;j++)
		    		 if(d.arr[j].Getuserid()==Integer.parseInt(str))
		    		 { l=j;}
		    	 
		    	 }
		    	 else if(count==2) 
		    		 
		    		 {
		    		
		    			 /*for( i=1;i<=d.arr[l].nog;i++)
		    			 {
		    				 if(d.arr[l].si[i].Getitemid()==Integer.parseInt(str))
		    				 {
		    					 id=i;
		    				 }
		    			 }*/
		    		 id=++d.arr[l].nooflogreq;
		    		//System.out.println("x"+id);
		    		 d.arr[l].si[id].userid=d.arr[l].Getuserid();
		    		 d.arr[l].si[id].Setitemid(Integer.parseInt(str));
		    		
		    		
		    		 count++;
		    		 }
		    	 
		    	
		    	 
		    		
		    	
		    	 
		    	 
		    	 
		    	 else if(count==3)
		    	 {
		    		 d.arr[l].si[id].Setnoofitems(Integer.parseInt(str));
		    		 
		    		 if(d.arr[l].si[id].Getnoofitems()==0)
		    	    	 count++;
		    	     c=d.arr[l].si[id].Getnoofitems();
		    	     count++;
		    	
		    	 }
		    	 else if(count==4)
		    	 {
		    	
		    		 
		    		 k++;
			    	
		    		 d.arr[l].si[id].arrayofitems[k]=str;
			    	 
			    	c--;
			    	if(c==0)
			    	count++;
			    	 
		    	 }
		    	
		    	 else if(count==5)
		    	 {
		    		 
		    		 d.arr[l].si[id].Setstatus(str.trim());
		    		 count++;
		    		 count = 0;
			    	 i++;k=0;l=0; 
			    	
			 		
		    	 }
		    	 str = null;
		    	 sb.setLength(0);
		      
		     
		     
		    	 }//System.out.println(sup.t[id].Getdeadline());
		    	 }
		     str = sb.toString();
		 
		    
		  // sup.g[id].Setstatus(str);
    		
		    
		 str = null;i--;
		 fin.close();
		   }
		   
		   catch(Exception e){System.out.println(e);}  
		 
		  //System.out.println(i);
		   
		
		

		}
		/**@brief add inventory item to database
		 * @param gminventory type object
		 * return void
		 */
		void add(supinventory sk)
		{sk.Setitemid(member.useridcount++);
			//sarray[supinventory.scount++]=sk;
		fu.put();
			System.out.println(sk.Getitemid());
			try{
				
				int j=0;
				FileWriter fw = new FileWriter("sup inventory.csv",true);
				 BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter fout = new PrintWriter(bw);
				fout.append(sk.Getdept().trim());
				fout.append(',');
				fout.append(String.valueOf(sk.userid));
				fout.append(',');
				fout.append(String.valueOf(sk.Getitemid()));
				fout.append(',');
				
				
				fout.append(String.valueOf(sk.Getnoofitems()));
			 	fout.append(',');
			 	if(sk.Getnoofitems()>0){
			 	for(j=1;j<sk.Getnoofitems();j++)
			 	{System.out.println(sk.arrayofitems[j]);fout.append(sk.arrayofitems[j]);fout.append(',');}
			 	fout.append(sk.arrayofitems[sk.Getnoofitems()]);
			 	fout.append(',');}
			 	fout.append(sk.Getstatus().trim());
			 	
				fout.println();
				
				fout.close();
				fout.flush();
			}
			catch(Exception e){}
			}
		/**@brief deleting a particular entry from the database based upon the userid.
		 * @param i id of the inventory item to be deleted.
		 * @return void
		 */
		void delete(int i)
		{
			try{
				
				int k=0;
				File inputFile = new File("sup inventory.csv");
				File tempFile = new File("sup inventory1.csv");

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
				  InputStream in = new FileInputStream("sup inventory1.csv");
				  OutputStream out = new FileOutputStream("sup inventory.csv", true);

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
