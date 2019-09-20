package com.ud.classic.javahub;

public class CustomFunctionLamda {

	public static void main(String[] args) {
		System.out.println("Start of the application");
		//call testLamdaExpr.
		//Calling static method from static void
		testLamdaExpr();
		
		testLamdaExpr("Uddipan");
		
		
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
	
	static void testLamdaExpr (String name) {
		
		CustomFuntionalInterfaceTwo cusLambda = () -> System.out.println("Void type method in Functional Interface");
		cusLambda.testVoid();
		
		CustomFuntionalInterfaceTwo cusLambda2 = () -> {
			System.out.println("Void type method in Functional Interface and object create with Lambda body type");
		};
		cusLambda2.testVoid();
		
		cusLambda2.testDefault(name);
		
		cusLambda2.testDefault(name, CustomFuntionalInterfaceTwo.returnRandomNum  ());
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
	@FunctionalInterface
	interface CustomFuntionalInterfaceTwo {
		
		void testVoid () ;
		
		default void testDefault (String name) {
			System.out.println("Hi, this is "+ name);
		}
		
		default void testDefault (String name , double myFavNum) {
			System.out.println("Hi, this is "+ name + " and My fav number is "+ myFavNum);
		}
		
		static double returnRandomNum () {
			return Math.random();
		}
		
	}
	

}
