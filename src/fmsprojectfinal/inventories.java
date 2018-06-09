package fmsprojectfinal;

/**@brief supinventory class.Contains log requests by staff members*/
class supinventory
{
	  static int scount=1;
	  int userid=0;
	private int itemid=0;
	private int noofitems=0;
	private String dept;
	public String []arrayofitems=new String[1000];
	private String status="Applied";
	//public int idforarray=0;
	public supinventory()
	{
		
	}
	public void Setitemid(int itemid)
	{
		this.itemid=itemid;
	}
	public void Setnoofitems(int noofitems)
	{
		this.noofitems=noofitems;
		//this.idforarray=noofitems;
	}
	public void Setstatus(String status)
	{
		this.status=status;
	}
	public void Setdept(String dept)
	{
		this.dept=dept;
	}
	public int Getitemid()
	{
		return this.itemid;
	}
	public int Getnoofitems()
	{
		return this.noofitems;
		
	}
	public String Getstatus()
	{
		return this.status;
	}
	public String Getdept()
	{
		return this.dept;
	}
	
}
/**@brief gminventory class.Contains log request by supervisors*/
class gminventory
{
	  static int gcount=1;
	private int itemid;
	private int noofitems;
	public String []arrayofitems=new String[1000];
	private String status="Applied";
	int userid=0;private String dept;
	//public int idforarray=0;
	public gminventory()
	{
		
	}
	public void Setitemid(int itemid)
	{
		
		this.itemid=itemid;
		// System.out.println(this.itemid);
	}
	public void Setnoofitems(int noofitems)
	{
		this.noofitems=noofitems;
		//this.idforarray=noofitems;
	}
	public void Setstatus(String status)
	{
		this.status=status;
	}
	public int Getitemid()
	{
		return this.itemid;
	}
	public int Getnoofitems()
	{
		return this.noofitems;
	}
	public String Getstatus()
	{
		return this.status;
	}
	public void Setdept(String dept)
	{
		this.dept=dept;
	}
	public String Getdept()
	{
		return this.dept;
	}
	
}

