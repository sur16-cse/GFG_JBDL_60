package l11_hibernate_mapping.one2one.Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2OAnnotationMain {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2o-annotation.cfg.xml").buildSessionFactory();
		System.out.println(sf);
		Session s=sf.openSession();
		System.out.println("Session started:"+s);
		Transaction tx=s.beginTransaction();
		CustomerTransaction ctx = new CustomerTransaction();
		ctx.setTotal(100);
		Customer customer=new Customer();
		customer.setName("surbhi");
		customer.setEmail("surbhiks615@gmail.com");
		customer.setAddress("bangalore");
		ctx.setCustomer(customer);
		customer.setTransaction(ctx);
		
		s.save(ctx);
		s.flush();
		tx.commit();
		s.close();
		sf.close();
	}
}
