package l10_hibernate_introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmployeePostgressHibernateMain {
	public static void main(String[] args) {
		Configuration c=new Configuration();
		SessionFactory sf=c.configure("hbm-postgres.cfg.xml").buildSessionFactory();
		System.out.println(sf);
		Session session=sf.openSession();
		Employee e=new Employee(0,"Aditya",1000);
		session.save(e);
		session.close();
	}
}
