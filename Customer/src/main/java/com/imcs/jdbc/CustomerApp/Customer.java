package com.imcs.jdbc.CustomerApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
@AllArgsConstructor

public class Customer {
	
	private int customerNumber;
	private long customerId;
	private String customerName;
	private String lastName;
	private double creditLimit;
	public Customer(int customerNumber, long customerId, String customerName, String lastName, double creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerId = customerId;
		this.customerName = customerName;
		this.lastName = lastName;
		this.creditLimit = creditLimit;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerId=" + customerId + ", customerName="
				+ customerName + ", lastName=" + lastName + ", creditLimit=" + creditLimit + "]";
	}

	
}