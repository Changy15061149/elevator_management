package ele;

class request_queue {
	static private String[] queue;
	static private int pos = 0;
	
	static void init(String input)
	{
		queue = input.split("[()]");
		
	}
	static void initint(int po)
	{
		pos = po;
	}
	
	static String next()
	{
		if(pos >= queue.length)
			return "end";
		while(queue[pos].equals("") )
		{
			pos++;
			if(pos == queue.length)
			return "end";
		}
		if(pos == queue.length)
			return "end";
		pos=pos+1;
		return queue[pos-1];
	}
	static int checknow()
	{
		return pos-1;
	}
	static void modify(int pos)
	{
		///queue[pos] = "FIN" + queue[pos];
		queue[pos] = "";
	}
	

}
