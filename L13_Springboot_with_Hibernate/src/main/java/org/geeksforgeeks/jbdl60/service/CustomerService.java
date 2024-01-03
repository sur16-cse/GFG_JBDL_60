package org.geeksforgeeks.jbdl60.service;

import org.geeksforgeeks.jbdl60.entity.Customer;
import org.geeksforgeeks.jbdl60.model.CreateCustomerRequestModel;
import org.geeksforgeeks.jbdl60.model.CreateCustomerResponseModel;
import org.geeksforgeeks.jbdl60.model.GetCustomerResponseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CustomerService {
	Configuration cfg;
	SessionFactory sessionFactory;

	public CustomerService() {
		// TODO Auto-generated constructor stub
		cfg = new Configuration();
		sessionFactory = cfg.configure("hbm.cfg.xml").buildSessionFactory();
	}

	public CreateCustomerResponseModel createCustomer(CreateCustomerRequestModel customerRequestModel) {
		Session session = sessionFactory.openSession();
		CreateCustomerResponseModel customerResponseModel;
		Transaction transaction;

		if (customerRequestModel.getName() == null || customerRequestModel.getName().equals("null")
				|| customerRequestModel.getName().equals("")) {
			customerResponseModel = new CreateCustomerResponseModel(301, "Name cannot be null");
			return customerResponseModel;
		}
		try {
			transaction = session.beginTransaction();

			Customer c = new Customer();
			c.setName(customerRequestModel.getName());
			c.setAddress(customerRequestModel.getAddress());
			c.setEmail(customerRequestModel.getUsername() + "@" + customerRequestModel.getDomain());
			session.save(c);
			session.flush();
			transaction.commit();

			customerResponseModel = new CreateCustomerResponseModel(c.getId(), c.getName(), c.getEmail(), 200,
					"SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception

			customerResponseModel = new CreateCustomerResponseModel(300, "Error while saving customer" + e);
		}

		return customerResponseModel;

	}

	public GetCustomerResponseModel getEmployeeByID(int id) {
		Session session = sessionFactory.openSession();
		GetCustomerResponseModel getResponseModel;
		Transaction transaction;
		if (id <= 0) {
			getResponseModel = new GetCustomerResponseModel(301, "Id must be a number");
			return getResponseModel;
		}
		Customer c = session.get(Customer.class, id);
		getResponseModel = new GetCustomerResponseModel(c.getId(), c.getName(), c.getEmail(), 200, "SUCCESS");
		return getResponseModel;
	}
}
