package com.ud.classic.javahub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomPrediction {

	public static void main(String[] args) {
		System.out.println("Stepping into main(String[] args) ..");

		testSkills();

		System.out.println("exist from main(String[] args) ..");

	}

	static void testSkills() {

		var p1 = new TechePerson();
		    p1.setName("James");
		    p1.setCountry("USA");
		    p1.setJavaScore(78);
		    p1.setMlScore(67);
		    p1.setApacheKafkaScore(89);
		    p1.setApacheSparkScore(81);
		    
		var p2 = new TechePerson();
		    p2.setName("Stany");
		    p2.setCountry("USA");
		    p2.setJavaScore(82);
		    p2.setMlScore(67);
		    p2.setApacheKafkaScore(70);
		    p2.setApacheSparkScore(60);
		    
		var p3 = new TechePerson();
			p3.setName("Peter");
		    p3.setCountry("UK");
		    p3.setJavaScore(90);
		    p3.setMlScore(89);
		    p3.setApacheKafkaScore(60);
		    p3.setApacheSparkScore(60);
		    
		    
		var p4 = new TechePerson();
			p4.setName("Deb");
		    p4.setCountry("India");
		    p4.setJavaScore(70);
		    p4.setMlScore(65);
		    p4.setApacheKafkaScore(70);
		    p4.setApacheSparkScore(80);
	    

		var techeList = new ArrayList<TechePerson>();
		techeList.addAll(Arrays.asList(new TechePerson[] { p1, p2 , p3 , p4 }));

		getSkilledPersonName(techeList, isGoodinJava()).forEach(
				p -> System.out.println(p.getName() + " is good in Java and He staying in " + p.getCountry()));
		
		getSkilledPersonName(techeList, isGoodinML()).forEach(
				p -> System.out.println(p.getName() + " is good in Machine Learning and He staying in " + p.getCountry()));

		getSkilledPersonName(techeList, isGoodinSpark()).forEach(
				p -> System.out.println(p.getName() + " is good in Spark and He staying in " + p.getCountry()));

		getSkilledPersonName(techeList, isGoodinKafka()).forEach(
				p -> System.out.println(p.getName() + " is good in Kafka and He staying in " + p.getCountry()));

	}

	static List<TechePerson> getSkilledPersonName(List<TechePerson> techeList,
			PredictionFunctional<TechePerson> prediction) {

		return techeList.stream().filter(techePerson -> prediction.test(techePerson))
				.collect(Collectors.<TechePerson>toList());
	}

	static PredictionFunctional<TechePerson> isGoodinJava() {
		return teche -> teche.getJavaScore() >=  80;
	}

	static PredictionFunctional<TechePerson> isGoodinML() {
		return teche -> teche.getMlScore() >=  80;
	}

	static PredictionFunctional<TechePerson> isGoodinSpark() {
		return teche -> teche.getApacheSparkScore() >=  80;
	}

	static PredictionFunctional<TechePerson> isGoodinKafka() {
		return teche -> teche.getApacheKafkaScore() >=  80;
	}

}
