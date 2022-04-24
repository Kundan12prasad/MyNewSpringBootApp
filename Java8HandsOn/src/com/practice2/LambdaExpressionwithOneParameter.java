package com.practice2;

public class LambdaExpressionwithOneParameter 
{
	public static void main(String[] args)
	{
		Printable printable= new Printable()
		{
		 @Override
		public void print(String msg)
		{
			System.out.println(msg);			
		}
		
	};
	
	printable.print(" Print message to console...."); 
		
		Printable withLambda=(msg)->System.out.println(msg);

	}

}
