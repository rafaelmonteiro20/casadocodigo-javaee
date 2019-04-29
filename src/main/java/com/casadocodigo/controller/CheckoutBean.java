package com.casadocodigo.controller;

import javax.enterprise.inject.Model;

import com.casadocodigo.model.Customer;
import com.casadocodigo.model.State;

@Model
public class CheckoutBean {
	
	private Customer customer = new Customer();
	
	
	public void checkout() {
		System.out.println("Save customer: " + customer);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public State[] getStates() {
		return State.values();
	}
	
}
