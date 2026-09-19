package com.example.practice;

public class Singleton {
	
	private static Singleton singleton = null;
	
	private Singleton(){}
	
	public static Singleton getSingleton() {
		
		if(singleton==null) {
			singleton = new Singleton();
			System.out.println("Object created");
		}
		return singleton;
		
	}
	
	public static void main(String[] args) {

        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 == s2);
    }
	
	
	

}
