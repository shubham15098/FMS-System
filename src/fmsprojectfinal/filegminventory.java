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

class filegminventory
{
	int count=0,k=0,c=0,l=0,z=0,y=0,id=0;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;newuser n[];fileuseridcount fu;
		public filegminventory(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,newuser n[],fileuseridcount fu)
		{
			this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;this.fu=fu;
		}
		/**@brief reading file from the gm inventory database
		 * @param i a counter
		 * @return void
		 */
		void create(int i)
		{ e.s.nooflogreq=0;h.s.nooflogreq=0;a.s.nooflogreq=0;sec.s.nooflogreq=0;ho.s.nooflogreq=0;
			try
		   { FileInputStream fin=new FileInputStream("gm inventory.csv");  
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
		    		 
		    	 	
		    	 	if(str.equals("Electricity"))
		    	 		sup=e.s;
		    	 	else if(str.equals("HVAC"))
	    	 		sup=h.s;
		    	 	else if(str.equals("AV"))
		    	 		sup=a.s;
		    	 	else if(str.equals("Housekeeping"))
		    	 		sup=ho.s;
		    	 	else if(str.equals("Security"))
		    	 		sup=sec.s;
		    	 	
		    	 	
		    	 	count++;
		    	 } 
		    
		    	 
		    	 
		    	 
		    	 else if(count==1)
		    	 {
		    	
		    	 count++;
		    	 }
		    	 else if(count==2) 
		    		 
		    		 {
		    		
		    			 /*for( i=1;i<=sup.nog;i++)
		    			 {
		    				 if(sup.g[i].Getitemid()==Integer.parseInt(str))
		    				 {
		    					 id=i;
		    				 }
		    			 }*/
		    		 id=++sup.nooflogreq;
		    		 sup.g[id].userid=sup.Getuserid();
		    		 sup.g[id].Setitemid(Integer.parseInt(str));
		    		 count++;
		    		 }
		    	 
		    	
		    	 
		    		
		    	
		    	 
		    	 
		    	 
		    	 else if(count==3)
		    	 {
		    		 sup.g[id].Setnoofitems(Integer.parseInt(str));
		    		 if(sup.g[id].Getnoofitems()==0)
		    	    	 count++;
		    	     c=sup.g[id].Getnoofitems();
		    	     count++;
		    	
		    	 }
		    	 else if(count==4)
		    	 {
		    	
		    		 
		    		 k++;
			    	
		    		 sup.g[id].arrayofitems[k]=str;
			    	 
			    	c--;
			    	if(c==0)
			    	count++;
			    	 
		    	 }
		    	
		    	 else if(count==5)
		    	 {
		    		 
		    		 sup.g[id].Setstatus(str.trim());
		    		 count++;
		    		 count = 0;
			    	 i++;k=0;l=0; 
		    	 }
		    	 str = null;
		    	 sb.setLength(0);
		      
		     
		     
		    	 }//System.out.println(sup.t[id].Getdeadline());
		    	 }
		     str = sb.toString();
		 
		    
		  //  sup.g[id].Setstatus(str);
    		
		    
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
		void add(gminventory gk)
		{
			gk.Setitemid(member.useridcount++);
			fu.put();
			//garray[gminventory.gcount++]=gk;
			
			try{
				
				int j=0;
				
				FileWriter fw = new FileWriter("gm inventory.csv",true);
				 BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter fout = new PrintWriter(bw);
				fout.append(gk.Getdept().trim());
				fout.append(',');
				fout.append(String.valueOf(gk.userid));
				fout.append(',');
				fout.append(String.valueOf(gk.Getitemid()));
				fout.append(',');
				
				
				fout.append(String.valueOf(gk.Getnoofitems()));
			 	fout.append(',');
			 	if(gk.Getnoofitems()>0){
			 	for(j=1;j<gk.Getnoofitems();j++)
			 	{fout.append(gk.arrayofitems[j]);fout.append(',');}
			 	fout.append(gk.arrayofitems[gk.Getnoofitems()]);
			 	fout.append(',');}
			 	fout.append(gk.Getstatus().trim());
			 	
				fout.append('\n');
				fout.flush();
				fout.close();
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
				File inputFile = new File("gm inventory.csv");
				File tempFile = new File("gm inventory1.csv");

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
				  InputStream in = new FileInputStream("gm inventory1.csv");
				  OutputStream out = new FileOutputStream("gm inventory.csv", true);

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