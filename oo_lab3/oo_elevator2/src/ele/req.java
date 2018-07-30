package ele;

class req {
	private static int time,floor;
	private static int type1;
	private static int type2;
	static boolean init(String input)
	{
		
		//System.out.println(input);
		String[] st = input.split(",");
		if(st[0].equals("FR"))
		{
			type1 = 1;
			if(st[2].equals("UP"))
			{
				type2 =1;
			}
			else type2 = 0;
			
			
			 try
			  {
				floor = Integer.parseInt(st[1]);
				time = Integer.parseInt(st[3]);
			  }
			  catch (Exception e)
			  {
				   System.out.println("INVALID["+input+"]");
				    return false;
			  }
			
			if(floor == 10 && type2 == 1)
			{
				System.out.println("INVALID["+input+"]");
				return false;
			}
			if(floor == 1 && type2 == 0)
			{
				System.out.println("INVALID["+input+"]");
				return false;
			}
			if(floor > 10 || floor == 0)
			{
				System.out.println("INVALID["+input+"]");
				return false;
			}
		}
		else 
		{
			type1 = 0;
		  try
		  {
			floor = Integer.parseInt(st[1]);
			time = Integer.parseInt(st[2]);
		  }
		  catch (Exception e)
		  {
			  System.out.println("INVALID["+input+"]");
			    return false;
		  }
			if(floor > 10 || floor == 0)
			{
				System.out.println("INVALID["+input+"]");
				return false;
			}
		
		}
		return true;
		
	}
	static int asktype1()
	{
		return type1;
	}
	static int asktype2()
	{
		return type2;
	}
	static int askfloor()
	{
		return floor;
	}
	static int asktime()
	{
		return time;
	}
	

}
