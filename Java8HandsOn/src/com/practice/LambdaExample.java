package com.practice;

public class LambdaExample 
{
	public static void main(String[] args) 
	{
		/*int width=10;		
		Drawable withoutLambda =new Drawable()
		{  
		  @Override
		public void draw()
		{
			System.out.println("Drawing "+width);			
		}		
	 };  
	      withoutLambda.draw(); */ 	
				
		int width=100;
		
		Drawable withLambda=()->
		{
			System.out.println("Drawing " +width);
					
		};
		
		withLambda.draw();
		  
	}

}


