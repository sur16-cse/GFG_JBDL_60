package l11_hibernate_mapping.one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2MMain {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2m.cfg.xml").buildSessionFactory();
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:" + s);
		Transaction tx = s.beginTransaction();
		Cart cart = new Cart();
		cart.setName("Big Billion Day Cart");
		Items i1 = new Items("1", 100, 2, cart);

		Items i2 = new Items("2", 50, 5, cart);
		Set<Items>itemSet=new HashSet<Items>();
		itemSet.add(i1);
		itemSet.add(i2);
		
		cart.setItems(itemSet);
		cart.setTotal(100*2+50*5);
		
		s.save(i1);
		s.save(i2);
		s.save(cart);
		
		s.flush();
		tx.commit();
		System.out.println("Cart is saved with id:"+cart.getId());
	}
}
