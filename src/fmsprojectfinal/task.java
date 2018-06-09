package fmsprojectfinal;

/**@brief task class*/
class task
{
	private String deadline=null;
	private String status=null;
	private String name=null;
	private String desc=null;
	
	private int id=0;
	
	private String dept=null;
	
	private String timetaken=null;
	private String comment=null;
	public String fromdate;
	public String todate;
	static int tcount=1;
	public task()
	{
	}
	public void Setdeadline(String deadline)
	{
		this.deadline=deadline;
	}
	public void Setdesc(String desc)
	{
		this.desc=desc;
	}
	public void Setstatus(String status)
	{
		this.status=status;
	}
	public void Setname(String name)
	{
		this.name=name;
	}
	public void Setdept(String dept)
	{
		this.dept=dept;
	}
	public void Settimetaken(String timetaken)
	{
		this.timetaken=timetaken;
	}
	public void Setcomment(String comment)
	{
		this.comment=comment;
	}
	public void Setid(int id)
	{
		this.id=id;
	}
	public String Getdeadline()
	{
		return this.deadline;
	}
	public String Getdesc()
	{
		return this.desc;
	}
	public String Getname()
	{
		return this.name;
	}
	public String Getcomment()
	{
		return this.comment;
	}
	public String Getstatus()
	{
		return this.status;
	}
	public String Getdept()
	{
		return this.dept;
	}
	public String Gettimetaken()
	{
		return this.timetaken;
	}
	public int Getid()
	{
		return this.id;
	}
	
	
}

class taskfile
{
	  String dept=null,name=null,taskdesc=null,status=null,deadline=null,comment=null,timetaken=null,fromdate=null,todate=null;int userid=0,taskid=0;
	 
}