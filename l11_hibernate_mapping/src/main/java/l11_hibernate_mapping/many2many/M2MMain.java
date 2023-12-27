package l11_hibernate_mapping.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class M2MMain {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-m2m.cfg.xml").buildSessionFactory();
		System.out.println(sf);
		Session s = sf.openSession();
		System.out.println("Session started:" + s);
		Transaction tx = s.beginTransaction();
		
		Cart cart = new Cart();
		cart.setName("Big Billion Day Cart");
		
		Items i1 = new Items("iphone", 20000);
		Items i2 = new Items("macbook", 500000);
		Items i3 = new Items("iphone pro", 200000);
		Items i4 = new Items("macbook pro max", 5000000);
		
		Set<Items>itemSet=new HashSet<Items>();
		itemSet.add(i1);
		itemSet.add(i2);
		
		Set<Items>itemSet2=new HashSet<Items>();
		itemSet2.add(i3);
		itemSet2.add(i4);
		
		cart.setItems(itemSet);
//		cart.setTotal(100*2+50*5);
		
		Cart cart1 = new Cart();
		cart1.setName("Big Billion Day Cart-Amazon");
		cart1.setItems(itemSet2);
//		cart.setTotal(0);
		
		
		Set<Cart>cartSet=new HashSet<Cart>();
		cartSet.add(cart1);
		cartSet.add(cart);
		
		
		;
		s.save(i1);
		s.save(i2);
		s.save(i3);
		s.save(i4);
		s.save(cart);
		s.save(cart1);

		
		s.flush();
		tx.commit();
		System.out.println("Cart is saved with id:"+cart.getId());
	}
}
