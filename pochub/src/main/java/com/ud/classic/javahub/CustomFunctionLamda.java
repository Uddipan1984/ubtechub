package com.ud.classic.javahub;

public class CustomFunctionLamda {

	public static void main(String[] args) {
		System.out.println("Start of the application");
		//call testLamdaExpr.
		//Calling static method from static void
		testLamdaExpr();
		System.out.println("End   of the application");
	}
	
	static void testLamdaExpr () {
		/*
		 * Normal interface implementation with Anonymous declaration 
		 */
		
		CustomFuntionalInterface customAnon = new CustomFuntionalInterface() {
			public int testFunction (int i , int j) {
				return i - j;
			}
		};
		System.out.println("Here is testFunction - "+ customAnon.testFunction(3, 4));
		
		/*
		 * Functional interface implementation with Lambda declaration 
		 */
		
		CustomFuntionalInterface customF = (x , y) -> ( x + y);
		System.out.println("Here is testFunction - "+ customF.testFunction(3, 4));
		
		
		/*
		 * Functional interface implementation with Lambda body type declaration 
		 */
		
		CustomFuntionalInterface customF2 = (x , y) -> {
			int hotNumber = 5 ;
			return (x + y) * hotNumber ;
			
		};
		System.out.println("Here is testFunction - "+ customF2.testFunction(3, 4));
		
	}
	
	@FunctionalInterface
	interface CustomFuntionalInterface {
		/*
		 * Functional Interface should have only one abstract type method 
		 * Which will be used to declare lambda expression
		 *  
		 * Functional interface or any normal interface can have one or more default and static method with body 
		 */
		 int testFunction (int i , int j) ;
	}
	

}
