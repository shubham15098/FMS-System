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

class filetask
{
	int count=0,k=0,c=0,l=0,z=0,y=0,att=0,id=0;fileuseridcount fu;
	Electricity e;HVAC h;AV a;Security sec;Housekeeping ho;supervisor sup;dept d;newuser n[];taskfile tarray[];
		public filetask(Electricity e,HVAC h,AV a,Security sec,Housekeeping ho,taskfile tarray[],fileuseridcount fu)
		{
			this.e=e;this.h=h;this.sec=sec;this.a=a;this.ho=ho;this.n=n;this.tarray=tarray;this.fu=fu;
		}
		/**@brief reading file from the task database
		 * @param i a counter
		 * @return void
		 */
		
		void create(int im)
		{ try
		   { FileInputStream fin=new FileInputStream("task.csv");  
		     count = 0; int ch=0,i=1;
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
		    	// System.out.println("count: " + str+" "+count);
		    	 
		    	// System.out.println("sb: " + sb);
		    	 
		    	 if(count==0)
		    	 {
		    		
		    	 	
		    	 	if(str.equals("Electricity"))
		    	 		d=e;
		    	 	else if(str.equals("HVAC"))
	    	 		d=h;
		    	 	else if(str.equals("AV"))
		    	 		d=a;
		    	 	else if(str.equals("Housekeeping"))
		    	 		d=ho;
		    	 	else if(str.equals("Security"))
		    	 		d=sec;
		    	 	tarray[im].dept=str;
		    	 	
		    	 	count++;
		    	 } 
		    
		    	 
		    	 
		    	 
		    	 else if(count==1)
		    	 {tarray[im].userid=Integer.parseInt(str);
		    	 if(Integer.parseInt(str)==d.s.Getuserid())
		    	 {sup=d.s;ch=1;
		    	 //id=d.s.idforarray;
		    	 }
		    	 else
		    	 {
		    		 for(int tt=1;tt<=d.nos;tt++)
		    		 {
		    			 if(Integer.parseInt(str)==d.arr[tt].Getuserid())
		    				 {att=tt;ch=2;
		    				 //id=d.arr[att].idforarray;
		    				
		    				 }
		    				 
		    		 }
		    	 }
		    	 count++;
		    	 }
		    	 else if(count==2) 
		    		 
		    		 {tarray[im].taskid=Integer.parseInt(str);
		    		 if(ch==1)
		    		 {
		    			 for( i=1;i<=sup.not;i++)
		    			 {
		    				 if(sup.t[i].Getid()==Integer.parseInt(str))
		    				 {
		    					 id=i;
		    				 }
		    			 }
		    		 }
		    		 else
		    		 {
		    			 for( i=1;i<=d.arr[att].not;i++)
		    			 {
		    				 if(d.arr[att].t[i].Getid()==Integer.parseInt(str))
		    				 {
		    					 id=i;
		    				 }
		    			 }
		    		 }
		    		 count++;
		    		 }
		    	 
		    	
		    	 
		    		
		    	
		    	 
		    	 
		    	 else if(count==3)
		    	 {
		    	 tarray[im].name=str;
		    		 if(ch==1){sup.t[id].Setname(str);sup.t[id].Setdept(tarray[im].dept);}
		    		 else{ d.arr[att].t[id].Setname(str);d.arr[att].t[id].Setdept(tarray[im].dept);}count++;
		    		 
		    		 
		    	 }
		    	 else if(count==4)
		    	 {tarray[im].taskdesc=str;
		    		 if(ch==1)sup.t[id].Setdesc(str);
		    		 else d.arr[att].t[id].Setdesc(str);count++;
		    	
		    	 }
		    	
		    	 else if(count==5)
		    	 {tarray[im].status=str;
		    	
		    		 if(ch==1)sup.t[id].Setstatus(str);
		    		 else {d.arr[att].t[id].Setstatus(str);}count++;
		    		 
		    	 }
		    	 
		    	 else if(count==6)
		    	 {
		    		 
		    		 
		    		 tarray[im].deadline=str;
		    	 
		    		 
		    		 if(ch==1)sup.t[id].Setdeadline(str);
		    		 else d.arr[att].t[id].Setdeadline(str);count++;
		    		  
		    	 }
		    	 else if(count==7)
		    	 {
		    		 tarray[im].comment=str;
		    		 if(ch==1)sup.t[id].Setcomment(str);
		    		 else d.arr[att].t[id].Setcomment(str);count++;
		    		 
		    	 }
		    	 else if(count==8)
		    	 {
		    		 
		    		
		    		 tarray[im].fromdate=str;
		    		
		    		 if(ch==1){sup.t[id].fromdate=str.trim();}
		    		 else {d.arr[att].t[id].fromdate=str.trim();}count++;
		    		 
		    	 }
		    	 else if(count==9)
		    	 {
		    		 tarray[im].todate=str;
		    		
		    		 if(ch==1){sup.t[id].todate=str.trim();}
		    		 else {d.arr[att].t[id].todate=str.trim();}count++;
		    		
		    	 }
		    	 else if(count==10)
		    	 {tarray[im].timetaken=str;
		    		 
		    		 if(ch==1){sup.t[id].Settimetaken(str.trim());}
		    		 else {d.arr[att].t[id].Settimetaken(str.trim());}count++;
		    		 count = 0;
		    		
			    	 im++;k=0;l=0; 
		    	 }
		    	 str = null;
		    	 sb.setLength(0);
		      
		     
		     
		    	 }//System.out.println(sup.t[id].Getdeadline());
		    	 }
		     str = sb.toString();
		 
		    
		 
		    
		 str = null;im--;
		 task.tcount=im;
		 System.out.println("kk"+task.tcount);
		 fin.close();
		   }
		   
		   catch(Exception e){System.out.println(e);}  
		 
		 // System.out.println(task.tcount);
		   
		

		}
		/**@brief adding task to the database
		 * @param tk taskfile type to add task to the database.
		 */
		void add(taskfile tk)
		{
			System.out.println(task.tcount);
			tarray[++task.tcount]=tk;
			//tk.taskid=member.useridcount++;
			fu.put();
			System.out.println(member.useridcount);
			try{
				
				int j=0;
				FileWriter fw = new FileWriter("task.csv",true);
				 BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter fout = new PrintWriter(bw);
				  
				fout.append(tk.dept);
				fout.append(',');
				fout.append(String.valueOf(tk.userid));
				fout.append(',');
				fout.append(String.valueOf(tk.taskid));
				fout.append(',');
				fout.append(tk.name);
				fout.append(',');
				fout.append(tk.taskdesc);
				fout.append(',');
				
				
			 	fout.append(tk.status);
			 	fout.append(',');
			 	fout.append(tk.deadline);
			 	fout.append(',');
			 	fout.write(tk.comment);
			 	fout.append(',');
			 	fout.write(tk.fromdate);
			 	fout.append(',');
			 	fout.write(tk.todate);
			 	fout.append(',');
			 	fout.write(tk.timetaken.trim());
			 	
				fout.append('\n');
				fout.flush();
				fout.close();
			}
			catch(Exception e){}
			}
		/**@brief deleting a particular entry from the database based upon the userid.
		 * @param i taskid of the task item to be deleted.
		 * @return void
		 */
		void delete(int i)
		{
			try{
				
				int k=0;
				File inputFile = new File("task.csv");
				File tempFile = new File("task1.csv");
				
				
				
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
				  InputStream in = new FileInputStream("task1.csv");
				  OutputStream out = new FileOutputStream("task.csv", true);

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
		/**@brief putting task to database
		 * @return void
		 */
		void put()
		{
			try
		 	{ 
		 		File inputFile = new File("task.csv");
		 		FileWriter fw = new FileWriter("task.csv",true);
				 BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter fout = new PrintWriter(bw);int j,i=1;
				    BufferedWriter wr = new BufferedWriter(new FileWriter(inputFile));
					wr.write("");
					wr.close();
		 	//System.out.println(task.tcount);
		 	for(k=1;k<=task.tcount;k++)
		 	{
		 	fout.append(tarray[k].dept);
		 	fout.append(',');
		 	fout.append(String.valueOf(tarray[k].userid));fout.append(',');
		 	fout.append(String.valueOf(tarray[k].taskid));fout.append(',');
		 	fout.append(tarray[k].name);fout.append(',');
		 	fout.append(tarray[k].taskdesc);fout.append(',');
		 	
		 	
		 	fout.append(String.valueOf(tarray[k].status));
		 	fout.append(',');
		 	
		 	
		 	fout.append(tarray[k].deadline);
		 	fout.append(',');
		 	
		 	fout.append(tarray[k].comment);
		 	fout.append(',');
		 	fout.append(tarray[k].fromdate);
		 	fout.append(',');
		 	fout.append(tarray[k].todate);
		 	fout.append(',');
		 	
		 	fout.write(tarray[k].timetaken.trim());
		 	
		 	
		 	fout.println();
		 	}fout.close();
		 	
		 	}
		 	catch(Exception e){System.out.println(e);} 
		 	}
			
		}


