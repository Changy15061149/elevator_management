package ele;

public class elemain {
	static controller_strong t;
	public static void main(String[] args)
	{
	 try{
	  boolean a = t.sc_pre();
	   t.sc_sol(a); 
	 }catch (Exception e)
	 {
		 System.out.println("ERROR!");
	 }
	}

}
