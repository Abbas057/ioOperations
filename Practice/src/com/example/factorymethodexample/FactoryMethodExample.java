package com.example.factorymethodexample;

/*
The key idea to remember
Don't think:

"Factory is just a class that creates objects."

Think of the whole combination:

Interface
   ↓
provides common contract

Implementations
   ↓
provide different behavior

Factory
   ↓
decides which implementation object to create

Polymorphism
   ↓
allows us to use all implementations through the interface

Q: "Why does a factory return an interface type rather than a concrete class?"

You can answer:

"Because multiple concrete classes can implement the same interface. 
Returning the interface hides the concrete implementation from the client and allows the factory to return 
different implementations while the client works with the common contract. 
This provides loose coupling and supports polymorphism."
 */

public class FactoryMethodExample {

	public static void main(String[] args) {
		
		Notification notification = NotificationFactory.create("sms");
		
		notification.send();

	}

}
