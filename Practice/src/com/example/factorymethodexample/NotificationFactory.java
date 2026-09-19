package com.example.factorymethodexample;

public class NotificationFactory {
	
	public static Notification create(String type) {
		
		if("email".equalsIgnoreCase(type)) {
			return new EmailNotification();
		}
		else if ("sms".equalsIgnoreCase(type)) {
			return new SmsNotification();
		}
		else {
			throw new IllegalArgumentException();
		}
			
	}

}
