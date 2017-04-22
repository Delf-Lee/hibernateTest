package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory SessionFactory;

	public static void main(String arg[]) {
		SessionFactory = new Configuration().configure().buildSessionFactory();
		
		Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("노트북");
		product1.setPrice(2000);
		product1.setDescription("Awesome Notenook");
		product1.setCategory(category1);
		
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("LG Computer");
		product2.setPrice(1000);
		product2.setDescription("Powerful Notenook");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("소나타");
		product3.setPrice(500000);
		product3.setDescription("대중적인 자동차");
		product3.setCategory(category2);
		
		category2.getProducts().add(product3);
		
		Session session = SessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(category1);
		session.save(category2);
		
		tx.commit();
		session.close();
	}
}
