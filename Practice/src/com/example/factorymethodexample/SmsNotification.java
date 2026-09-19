package com.example.factorymethodexample;

public class SmsNotification implements Notification{

	@Override
	public void send() {
		System.out.println("Send SMS Notification");
		
	}

}
