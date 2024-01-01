
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class O2OAnnotationMain {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2o-annotation.cfg.xml").buildSessionFactory();
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:" + s);
		Transaction tx = s.beginTransaction();
		Customer customer = new Customer();
		customer.setName("surbhi");
		customer.setEmail("surbhiks615@gmail.com");
		customer.setAddress("bangalore");

		for (int i = 0; i < 100; i++) {
			customer = new Customer();
			customer.setName("surbhi");
			customer.setEmail("surbhiks615@gmail.com");
			customer.setAddress("bangalore");
			s.save(customer);
		}

		s.flush();
		tx.commit();

		// query to select multiple rows from a database
		Transaction tx2 = s.beginTransaction();
		Query query = s.createQuery("from Customer");
		List<Customer> customerList = query.list();

		for (Customer customer1 : customerList) {
			System.out.println(customer);
		}

		tx2.commit();

		// query data on the basis of id
		Transaction tx3 = s.beginTransaction();
		Query query1 = s.createQuery("from Customer where id= :id");
		query1.setParameter("id", 1);
		Customer cus = (Customer) query1.uniqueResult();
		System.out.println(cus);

		tx3.commit();

		// query data on the basis of id
		Transaction tx4 = s.beginTransaction();
		Query query2 = s.createQuery("delete from Customer where id= :id");
		query2.setParameter("id", 4);
		int result = query2.executeUpdate();
		System.out.println("Deleted docs count: " + result);

		tx4.commit();

		// query data on the basis of id
		Transaction tx5 = s.beginTransaction();
		Query query3 = s.createQuery("update Customer set name=:name where id=:id");
		query3.setParameter("id", 95);
		query3.setParameter("name", "Surbhi Kumari");
		result = query3.executeUpdate();
		System.out.println("Updated docs count: " + result);

		tx5.commit();
		s.close();
		sf.close();
	}
}
