package com.ud.classic.javahub;


@FunctionalInterface
public interface PredictionFunctional <U> {
	
	Object objectType = null;

	boolean test (U  object) ;
	
	@Override
	String toString();
}
