package ele;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class cntroller {
	static building building1;
	static request_queue rq;
	static request_queue rq1;
	static ele_strong elev;
	static req request;
	static String inputs;
	static String matched_input="";
	static double time = 0.000;
	static long tim = 0L;
	static req rrr;
	static Scanner sos = new Scanner(System.in);
	
	static void input()
	{
		
		inputs = sos.nextLine();
		inputs = inputs.replaceAll("\\s","");
	}
	
	static int match(String input1)///////////////////////need_modify
	{
		String s1 = "\\(FR,\\+?\\d+,(UP|DOWN),\\+?\\d+\\)";
		String s2 = "\\(ER,\\+?\\d+,\\+?\\d+\\)";
		Pattern p1,p2;
		p1 = Pattern.compile(s1);
		p2 = Pattern.compile(s2);
		Matcher m1,m2;
		m1 = p1.matcher(input1);
		m2 = p2.matcher(input1);
		boolean ans1,ans2,ans;
		ans1 = m1.find();
		ans2 = m2.find();
		ans = ans1|ans2;
		if(ans1)
		{
			//System.out.println(m1.start()+" "+m1.end()+" "+input1.length());
			if(m1.start() != 0 || m1.end() != input1.length())
				return -1;
		}
		if(ans2)
		{
			if(m2.start() != 0 || m2.end() != input1.length())
				return -1;
		}
		if(ans)
		   return 1;
		else return -1;
	}
	static boolean sc_pre() {
		//try{
		building1.init();
		elev = new elevat();
		time = time + elev.reset();
		double last_time=-1.0;
		double time1 = -1.0;
		boolean tag = false;
		long line = 0;
		while(true)
		{
			input();
			line = line + 1;
			if(inputs.equals("end"))
				break;
			else if(match(inputs) == 1)
				{String sss = inputs.replaceAll("[()+]","");
				 boolean redd = rrr.init(sss);
				 if(redd)
				 {
					 int type1,type2,floor,titi,tyty;
						type1 = rrr.asktype1();
						type2 = rrr.asktype2();
						floor = rrr.askfloor();
						titi  = rrr.asktime();
					 if(time1 == -1)
					 {
						 if(titi == 0 && type1 == 1 && type2 == 1 && floor == 1)
						 {
							 time1 = 0;
							 last_time = 0;
							 matched_input = matched_input + inputs;
							 tag = true;
						 }
						 else System.out.println("INVALID["+sss+"]");
					 }
					 else
					 {
						 if(titi < last_time)
							 System.out.println("INVALID["+sss+"]");
						 else 
						 {
							 last_time = titi;
							 matched_input = matched_input + inputs;
						 }
					 }
					 
				 }
				 //else
				// {
				// matched_input = matched_input + inputs;
				// tag = true;
				//}
				}
			else 
			{
			   System.out.println("INVALID["+inputs+"]");
			}
		}
		return tag;
		
		
	//}catch(Exception e)
	//{
	//	System.out.println("Error!");
	//	return false;
	//}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void sc_sol(boolean tag)
	{
		double last_time=-1.0;
		double time1 = -1.0;
		//boolean tag = false;
		long line = 0;
		rq.init(matched_input);
		while(tag)
		{
		 String ss = rq.next();
			if(ss == "end")
			       break;
			else 
			{
				boolean redd = rrr.init(ss);
				if(redd)
				{
				int type1,type2,floor,titi,tyty;
				type1 = rrr.asktype1();
				type2 = rrr.asktype2();
				floor = rrr.askfloor();
				titi  = rrr.asktime();
				if(type1 == 0) tyty = 3;
				else if(type2 == 1) tyty = 1;
				else tyty = 2;
				if(titi >= last_time || time1 == -1)
				{
					
				
				last_time = titi;
				if(time1==-1)
					time1 = titi;
				//System.out.println(titi+ss);
				if((time1 != 0 && time1 != -1)|| (time1 == 0 && tyty != 1))
				{
					System.out.println("First request time illegal!" + titi);
					//System.exit(0);
					time1 = -1;
				}
				//	
				if(titi>building1.find(tyty,floor) && time1 == 0)
					{
						double hell = 0.000;
						System.out.print("("+floor+',');
						if(elev.asknowpos()>floor)
						{
							System.out.print("DOWN,");
						}
						else if((elev.asknowpos()<floor))
						{
							System.out.print("UP,");
						}
						else 
						{
							System.out.print("STILL,");
							hell = 1.0000;
						}
						if(time<titi)time=titi;
						time = time+elev.answer_request(floor)+hell;
						System.out.print(time-time1+")\n");
						time = time - hell + 1.00000;
						building1.add_request(tyty,floor,time);
					}
				}if(time1!= -1 && titi < last_time)
					System.out.println("Time error!");
				}
			}
		}
	}

	
}
