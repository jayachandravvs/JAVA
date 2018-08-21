 package com.imcs.jdbc.CustomerApp;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

	boolean createCustomer(Customer customer) throws SQLException;
	boolean updateCustomer(Customer customer) throws SQLException;
	
	Customer findCustomer(int id) throws SQLException;
	List<Customer> findCustomers(String name) throws SQLException;
	boolean deleteCustomer(int id) throws SQLException;
	
	
	//List<Customer> deleteCustomer(int id) throws SQLException;
	
	
}



