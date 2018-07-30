package ele;

class building {
	static private double[] up_request,down_request,inside_request;
	
	static void init()
	{
		up_request = new double[20];
		down_request = new double[20];
		inside_request = new double[20];
	    int i;
	    for(i=1;i<=10;i++)
	    {
	        up_request[i] = -1.00;
	        down_request[i] = -1.00;
	        inside_request[i] = -1.00;
	    }
	}
	
	static void add_request(int type,int floor,double time)
	{
		if(type == 1)
		{
		     up_request[floor] = time;
		}
		else if(type == 2)
		{
			down_request[floor] = time;
		}
		else if(type == 3)
		{
			inside_request[floor] = time;
		}
	}
	
	
	static double find(int type,int floor)
	{
		if(type == 1)
		{
		     return up_request[floor];
		}
		else if(type == 2)
		{
			return down_request[floor];
		}
		else
		{
			return inside_request[floor];
		}
	}

}
