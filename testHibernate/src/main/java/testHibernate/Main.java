package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory SessionFactory;

	public static void main(String arg[]) {
		SessionFactory = new Configuration().configure().buildSessionFactory();
		// testCode1();
		testCode2();
	}
	
	private static void testCode2() {
		Person person1 = new Person();
		person1.setFirstName("SangHoon");
		person1.setLastName("Lee");
		License license1 = new License();
		license1.setLicenseNumber("1292032");
		license1.setIssue_date(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);
		
		Person person2 = new Person();
		person2.setFirstName("DoYeon");
		person2.setLastName("Park");
		License license2 = new License();
		license2.setLicenseNumber("1492011");
		license2.setIssue_date(new Date());
		license2.setPerson(person2);
		
		person2.setLicense(license2);
		
		Session session = SessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person1); // save parent table(class)
		session.save(person2);
		
		tx.commit();
		session.close();
	}


	private static void testCode1() {
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

		session.save(category1); // save parent table(class)
		session.save(category2);

		tx.commit();
		session.close();
	}
}
