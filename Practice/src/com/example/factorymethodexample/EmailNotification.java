package com.example.factorymethodexample;

public class EmailNotification implements Notification {

	@Override
	public void send() {
			System.out.println("Send Email Notification");
		}
		

}
