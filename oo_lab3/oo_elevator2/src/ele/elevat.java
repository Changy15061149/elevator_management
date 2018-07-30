package ele;

class elevat implements ele_strong{
	static private int nowpos = 1;
	public double reset()
	{
		double ans = ((nowpos-1))*0.5;
		nowpos = 1;
		return ans;
	}
	public double answer_request(int floor)
	{
		double ans = (nowpos-floor)*0.5;
		if(ans < 0.000) ans = 0.000-ans;
		nowpos = floor;
		return ans;
	}
	public int asknowpos()
	{
		return nowpos;
	}

}
