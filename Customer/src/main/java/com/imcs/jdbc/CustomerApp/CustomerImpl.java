package com.imcs.jdbc.CustomerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("**************DataBase connection successful**************");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean createCustomer(Customer customer) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"insert into customer(customerNumber,customerId,firstName,lastName,creditLimit) values (?,?,?,?,?) ");
			ps.setInt(1, customer.getCustomerNumber());
			ps.setLong(2, customer.getCustomerId());
			ps.setString(3, customer.getCustomerName());
			ps.setString(4, customer.getLastName());
			ps.setDouble(5, customer.getCreditLimit());

			int noOfRowsUpdated = ps.executeUpdate();
			return noOfRowsUpdated >= 1 ? true : false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"update customer set customerId = ?, firstName = ?,lastName = ?,creditLimit = ? where customerNumber = ?");
			ps.setDouble(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getLastName());
			ps.setDouble(4, customer.getCreditLimit());

			int noOfRowsUpdated = ps.executeUpdate();
			return noOfRowsUpdated >= 1 ? true : false;

		}

	}

	@Override
	public Customer findCustomer(int id) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"select customerId,firstName,lastName,creditLimit from customer where customerId=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return prepareCustomer(rs);
			}

		}

		return null;
	}

	@Override
	public List<Customer> findCustomers(String name) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"select customerId,firstName,lastName,creditLimit from customer where firstName=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//List<Customer> customerList = new ArrayList<>();
			List<Customer> customers = new ArrayList<>();
			while (rs.next()) {
				customers.add(prepareCustomer(rs));

			}

			return customers;
		}
	}

	@Override
	public boolean deleteCustomer(int id) throws SQLException {
		try (Connection connection = getConnection()) {
			PreparedStatement ps = connection.prepareStatement("delete from customer where customerNumber= ?");
			ps.setInt(1, id);

			int noOfRowsUpdated = ps.executeUpdate();
			return noOfRowsUpdated >= 1 ? true : false;

		}

	}

	private Customer prepareCustomer(ResultSet rs) throws SQLException {

		int customerNumber = rs.getInt(1);
		long customerId = rs.getLong(2);
		String customerName = rs.getString(3);
		String lastName = rs.getString(4);

		double creditLimit = rs.getDouble(5);

		return new Customer(customerNumber, customerId, customerName, lastName, creditLimit);
	}

	private Connection getConnection() throws SQLException { 
		
		String url ="jdbc:mysql://localhost:3306/classicmodels";
		String user="root";
		String password="root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
