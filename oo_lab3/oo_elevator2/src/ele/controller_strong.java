package ele;

public class controller_strong extends cntroller {
	static void toString(String a,double time,int type,int floor)
	{
		if(type != 4)
		{
		String s = "["+a+"]"+"/(";
		System.out.print(s+floor+",");
		if(type == 1)
			System.out.println("UP,"+(time-1.0)+")");
		if(type == 2)System.out.println("DOWN,"+(time-1.0)+")");
		if(type == 3)System.out.println("STILL,"+time+")");
		}
		else if(type == 4)System.out.println("SAME["+a+"]");
	
	}
	static int find_UP(int floor,double time)
	{
		if(floor > 10) return -1;
		String ss_find;
		double time_find = -1.0;
		int floor_find;
		int type1_find,type2_find;
		while(time_find<time)
		{
		    ss_find= rq1.next();
		    if(ss_find == "end")break;
			boolean bbb = rrr.init(ss_find);
			time_find = rrr.asktime();
			floor_find = rrr.askfloor();
			type1_find = rrr.asktype1();
			type2_find = rrr.asktype2();
			if(floor_find >= floor && time_find < time && type1_find == 0&&time_find > building1.find(0,floor_find))
				return rq1.checknow();
		}
		return -1;
	}
			
	static int find_DOWN(int floor,double time)
	{
		if(floor < 1) return -1;
		String ss_find;
		double time_find = -1.0;
		int floor_find;
		int type1_find,type2_find;
		while(time_find<time)
		{
		    ss_find= rq1.next();
		    if(ss_find == "end")break;
			boolean bbb = rrr.init(ss_find);
			time_find = rrr.asktime();
			floor_find = rrr.askfloor();
			type1_find = rrr.asktype1();
			type2_find = rrr.asktype2();
			if(floor_find <= floor && time_find < time && type1_find == 0&&time_find > building1.find(0,floor_find))
			{
				//System.out.println(floor_find+" "+time+" "+time_find);
				return rq1.checknow();
			}
		}
		return -1;
	}
	static void sc_sol(boolean tag)
	{
		double last_time=-1.0;
		double time1 = -1.0;
		//boolean tag = false;
		long line = 0;
		rq.init(matched_input);
		rq1 = new request_queue();
		rq1.init(matched_input);
		while(tag)
		{
		 String ss = rq.next();
		// System.out.println(rq.checknow()+" "+ss);
			if(ss == "end")
			       break;
			else 
			{
				boolean redd = rrr.init(ss);
				int type1,type2,floor,titi,tyty;
				type1 = rrr.asktype1();
				type2 = rrr.asktype2();
				floor = rrr.askfloor();
				titi  = rrr.asktime();
				if(time < titi) time = titi;
				//System.out.println(ss + "wow");
				int mem_pos;
				if(type1 == 0) tyty = 3;
				else if(type2 == 1) tyty = 1;
				else tyty = 2;
				last_time = titi;
				if(titi>building1.find(tyty,floor) )
					{
						mem_pos = rq.checknow();
						//rq1.initint(mem_pos);
						int i;
						int nowpos = elev.asknowpos();
						double ttt = -1.0000;
						if(floor > nowpos)
						{
							//if(type1 == 0)floor = 10;
							for(i = nowpos + 1;i <= floor; i++)
							{
								time += 0.5;
								rq1.initint(mem_pos);
								double time_find = -1.0;
								int floor_find;
								int type1_find,type2_find;
								int popop;
								String ss_find = "",ss_ans = "";
								boolean tt = false;
								while (time_find <= time)
								{
									ss_find = rq1.next();
								//	System.out.println(ss_find+" " + time+" "+floor+" "+i);
									if(ss_find == "end")break;
									boolean bbb = rrr.init(ss_find);
									time_find = rrr.asktime();
									floor_find = rrr.askfloor();
									type1_find = rrr.asktype1();
									type2_find = rrr.asktype2();
									int typ_find;
									if(type1_find == 1)
									{
										if(type2_find == 1)typ_find = 1;
										else typ_find = 2;
									}
									else typ_find = 3;
									if(time_find < time - (tt?1:0) && floor_find == i && time_find > building1.find(typ_find,floor_find) && (typ_find != 2||ss_find.equals(ss) ))
									{
										
										if(!tt)
										{
										//building1.add_request(3,floor_find,time);
										time += 1.0;
										}
										building1.add_request(typ_find,floor_find,time);
										toString(ss_find,time,1,floor_find);
										tt = true;
										popop = rq1.checknow();
										rq1.modify(popop);
										rq.modify(popop);
										double sbxd = elev.answer_request(floor_find);
										//if(ss_find.equals(ss))ttt = time;
									}
									
								}
							}
							int UP_floor;
							rq1.initint(mem_pos);
							UP_floor = find_UP(i,time-1);
							
							while(UP_floor != -1)
							{//System.out.println(UP_floor);
								time += 0.5;
								rq1.initint(mem_pos);
								double time_find = -1.0;
								int floor_find;
								int type1_find,type2_find;
								int popop;
								String ss_find = "",ss_ans = "";
								boolean tt = false;
								while (time_find <= time)
								{
									ss_find = rq1.next();
								//	System.out.println(ss_find+" " + time+" "+floor+" "+i);
									if(ss_find == "end")break;
									boolean bbb = rrr.init(ss_find);
									time_find = rrr.asktime();
									floor_find = rrr.askfloor();
									type1_find = rrr.asktype1();
									type2_find = rrr.asktype2();
									int typ_find;
									if(type1_find == 1)
									{
										if(type2_find == 1)typ_find = 1;
										else typ_find = 2;
									}
									else typ_find = 3;
									if(time_find < time - (tt?1:0)&& floor_find == i && time_find > building1.find(typ_find,floor_find) && typ_find != 2)
									{
										
										//building1.add_request(3,floor_find,time);
										if(!tt)
										{
										time += 1.0;
										}building1.add_request(typ_find,floor_find,time);
										toString(ss_find,time,1,floor_find);
										tt = true;
										popop = rq1.checknow();
										rq1.modify(popop);
										rq.modify(popop);

										double sbxd = elev.answer_request(floor_find);
										//if(ss_find.equals(ss))ttt = time;
									}
									
								}
								
								i++;
								rq1.initint(mem_pos);
								UP_floor = find_UP(i,time- (tt?1.0:0.0));
								//System.out.println(time+" "+(i-1));
							}
							rq.initint(mem_pos+1);
						}
						else if(floor < nowpos)
						{
							//if(type1 == 0) floor = 0;
							for(i = nowpos - 1;i >= floor; i--)
							{
								time += 0.5;
								//rq1.initint(rq.checknow());
								rq1.initint(mem_pos);
								double time_find = -1.0;
								int floor_find;
								int type1_find,type2_find;
								int popop;
								String ss_find = "",ss_ans = "";
								boolean tt = false;
								while (time_find <= time)
								{
									
									ss_find = rq1.next();
									if(ss_find == "end")break;
									boolean bbb = rrr.init(ss_find);
									time_find = rrr.asktime();
									floor_find = rrr.askfloor();
									type1_find = rrr.asktype1();
									type2_find = rrr.asktype2();
									int typ_find;
									if(type1_find == 1)
									{
										if(type2_find == 1)typ_find = 1;
										else typ_find = 2;
									}
									else typ_find = 3;
									if(time_find < time- (tt?1:0) &&floor_find == i && time_find > building1.find(typ_find,floor_find) &&( typ_find != 1|| ss_find.equals(ss)))
									{
										
										//building1.add_request(1,floor_find,time);
										if(!tt)
										{
										time += 1.0;
										}building1.add_request(typ_find,floor_find,time);
										toString(ss_find,time,2,floor_find);
										tt = true;
										popop = rq1.checknow();
										rq1.modify(popop);
										rq.modify(popop);
										//System.out.println(floor_find+"*   *"+time_find);

										double sbxd = elev.answer_request(floor_find);
										//if(ss_find.equals(ss))ttt=time;
									}
									
								}
							}
							int DOWN_floor;
							rq1.initint(mem_pos);
							DOWN_floor = find_DOWN(i,time-1);
							while(DOWN_floor != -1)
							{
								time += 0.5;
								rq1.initint(mem_pos);
								double time_find = -1.0;
								int floor_find;
								int type1_find,type2_find;
								int popop;
								String ss_find = "",ss_ans = "";
								boolean tt = false;
								while (time_find <= time)
								{
									ss_find = rq1.next();
								//	System.out.println(ss_find+" " + time+" "+floor+" "+i);
									if(ss_find == "end")break;
									boolean bbb = rrr.init(ss_find);
									time_find = rrr.asktime();
									floor_find = rrr.askfloor();
									type1_find = rrr.asktype1();
									type2_find = rrr.asktype2();
									int typ_find;
									if(type1_find == 1)
									{
										if(type2_find == 1)typ_find = 1;
										else typ_find = 2;
									}
									else typ_find = 3;
									if(time_find < time- (tt?1:0) && floor_find == i && time_find > building1.find(typ_find,floor_find) && typ_find != 1)
									{
										
										//building1.add_request(3,floor_find,time);
										if(!tt)
										{
										time += 1.0;
										}building1.add_request(typ_find,floor_find,time);
										toString(ss_find,time,2,floor_find);
										//System.out.println(floor_find+"*   *"+time_find+"# "+(time-(tt?1:0)));
										tt = true;
										popop = rq1.checknow();
										rq1.modify(popop);
										rq.modify(popop);
										double sbxd = elev.answer_request(floor_find);
										//if(ss_find.equals(ss))ttt = time;
									}
									
								}
								i--;
								rq1.initint(mem_pos);
								DOWN_floor = find_DOWN(i,time- (tt?1.0:0.0));
								//System.out.println(DOWN_floor);
							}
							
							rq.initint(mem_pos+1);
							//System.out.println(rq.next());
							rq.initint(mem_pos+1);
						}
						else
						{
						double save = elev.answer_request(floor);
						time += 1.0;
						toString(ss,time,(floor == nowpos)?3:((floor>nowpos)?1:2),floor);
						building1.add_request(tyty,floor,time);
						//building1.add_request(3,floor,time);

						double sbxd = elev.answer_request(floor);
						}
						
						
					}
				else toString(ss,0,4,floor);
				}
		}
	}
}
