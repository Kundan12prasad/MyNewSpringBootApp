import com.practice2.Printable;

 interface Printable 
 
{
	
public void print(String msg);


}


public class lambdaExpressionParameter 
{

	public static void main(String[] args) 
	{
		Printable printable=new Printable()	
		{
		@Override
		public void print(String msg)
		{
			System.out.println(msg);			
		}
		
	};
	
	printable.print(" Print message to console....");

		

	}

}
