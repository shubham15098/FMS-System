/**
 * @mainpage fmsprojectfinal
 * @author Sarthika Dhawan(2015170)
 * @author Shubham Kumar(2015098)
 * This project focuses on implementing a facility management services(FMS) system.
*/


package fmsprojectfinal;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int newuserid=100; 
		
		fileuseridcount fu=new fileuseridcount();
		fu.create();
		
		//singleton design pattern
		Electricity e = Electricity.getInstance();
		HVAC h = HVAC.getInstance();
		AV a = AV.getInstance();
		Security sec = Security.getInstance();
		Housekeeping ho = Housekeeping.getInstance();
		
		
		//factory design pattern
		memberdecidor mem=new memberdecidor(e, h, a, sec, ho);
		member gm=mem.mem("GM");
		member sta=mem.mem("Staff");
		member supe=mem.mem("Supervisor");
		
		
		newuser n[]=new newuser[1000];
		for(int i=0;i<1000;i++)
  			n[i]=new newuser();
		
		taskfile tarray[]=new taskfile[1000];
		for(int i=0;i<1000;i++)
  			tarray[i]=new taskfile();
		
		
		
		filedecidor ff=new filedecidor();
		
		
		filesupervisor fs=new filesupervisor(e,h,a,sec,ho,n);
		fs.create(1);
		fs.put(1, 0);
		
		
		
		//facade design pattern
		fileelecstaff fe=new fileelecstaff(e,h,a,sec,ho,n);
		ff.createelec(fe);
		fe.put(1, 0);
		filesecstaff fsec=new filesecstaff(e,h,a,sec,ho,n);
		ff.createsec(fsec);
		
		fsec.put(1, 0);
		filehousekeepingstaff fho=new filehousekeepingstaff(e,h,a,sec,ho,n);
		ff.createho(fho);
		
		fho.put(1, 0);
		fileAVstaff fa=new fileAVstaff(e,h,a,sec,ho,n);
		ff.createav(fa);
		fa.put(1, 0);
		fileHVACstaff fh=new fileHVACstaff(e,h,a,sec,ho,n);
		ff.createhvac(fh);
		fh.put(1, 0);
		
		filetask ft=new filetask(e,h,a,sec,ho,tarray,fu);
		ft.create(1);
		ft.put();
		
		
		
		filegminventory fgi=new filegminventory(e,h,a,sec,ho,n,fu);
		fgi.create(1);
	
		
		filesupinventory fsi=new filesupinventory(e,h,a,sec,ho,n,fu);
		fsi.create(1);
		
		
		
		
		filenewuser fnu=new filenewuser(e,h,a,sec,ho,n,fu);
		fnu.create(1);
		
		gui g=new gui((GM)gm,e,h,a,sec,ho,n,fnu,fu,fsi,fgi,fe,fh,fho,fa,fsec,fs,ft,tarray);
		
		
	}

}
