package com.imcs.test.TestCustomerApp;

import java.sql.SQLException;
import java.util.Scanner;

import com.imcs.jdbc.CustomerApp.Customer;
import com.imcs.jdbc.CustomerApp.CustomerDao;
import com.imcs.jdbc.CustomerApp.CustomerImpl;

public class CustomerApp {
	CustomerDao dao = new CustomerImpl();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		CustomerApp app = new CustomerApp();
		app.doOperations();

	}

	private void doOperations() throws Exception {
		do {
			int select = readOption();
			switch (select) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
			case 4:
				delete();
				break;
			//case 5:
				//readByName();
				//break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("wrong option");

			}

		} while (true);

	}

	/**private void readByName() {

		try {
			System.out.print("Enter the name of the customer===>>");
			String customerName= sc.next();

			List<Customer> customers = dao.findCustomers(customerName);

			for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();) {
				Customer customer = iterator.next();
				System.out.println(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}**/

	private void delete() {
		try {
			System.out.print("Enter customer Id you would like to delete==>>");
			int id = sc.nextInt();

			boolean flag = dao.deleteCustomer(id);
			if (flag) {
				System.out.println("customer deleted!!");
			} else {
				System.out.println("customer not deleted");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void update() throws Exception {

		try {
			Customer cust = readCustomer();
			boolean flag = dao.createCustomer(cust);
			if (flag) {
				System.out.println("updated successfully");
			} else {
				System.out.println("not updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Customer readCustomer()  {

		System.out.println("enter the customer number");
		int customerNumber = Integer.parseInt(sc.next());
		System.out.println(" enter the customer id");
		long customerId = Long.parseLong(sc.next());
		System.out.println("enter the first name");
		String customerName = sc.next();
		System.out.println("enter the last name of the customer");
		String lastName = sc.next();
		System.out.println("enter the credit limit of the customer");
		double creditLimit = Double.parseDouble(sc.next());
		return new Customer(customerNumber, customerId, customerName, lastName, creditLimit);
	}

	private void read() {
		try {
			System.out.println("enter customer id");
			int customerId = sc.nextInt();

			Customer customer = dao.findCustomer(customerId);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void create() {
		try {
			Customer customer = readCustomer();
			boolean flag = dao.createCustomer(customer);
			if (flag) {
				System.out.println("created successfully!");
			} else {
				System.out.println("not created successfully");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int readOption() {
		menu();
		return sc.nextInt();

	}

	private void menu() {
		System.out.println("Employee Operations");
		System.out.println("1. Add \n 2. Read \n 3. Update \n 4. Delete \n 5. Exit");
		System.out.println("Select an option");

	}

}
