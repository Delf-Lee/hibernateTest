package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory SessionFactory;

	public static void main(String arg[]) {
		SessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("≥Î∆Æ∫œ");
		product.setPrice(2000);
		product.setDescription("Awesome Notenook");
		
		Session session = SessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();
	}
}
