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
		// testCode2();
		testCode3();
	}

	private static void testCode3() {
		Book springBook = new Book();
		springBook.setTitle("������ ���α׷���");

		Book hibernateBook = new Book();
		hibernateBook.setTitle("���̹�����Ʈ ���α׷���");

		Book htmlBook = new Book();
		htmlBook.setTitle("HTML/CSS/JavaScript");

		Author authorKim = new Author();
		authorKim.setName("�賲��");

		Author authorLee = new Author();
		authorLee.setName("���繮");

		Author authorHwang = new Author();
		authorHwang.setName("Ȳ����");

		springBook.getAuthors().add(authorKim);
		springBook.getAuthors().add(authorLee);
		springBook.getAuthors().add(authorHwang);

		hibernateBook.getAuthors().add(authorKim);
		hibernateBook.getAuthors().add(authorLee);

		htmlBook.getAuthors().add(authorKim);
		htmlBook.getAuthors().add(authorHwang);

		Session session = SessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(springBook);
		session.save(hibernateBook);
		session.save(htmlBook);
		
//		session.save(authorHwang);
//		session.save(authorKim);
//		session.save(authorLee);

		tx.commit();
		session.close();
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
		product1.setName("��Ʈ��");
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
		product3.setName("�ҳ�Ÿ");
		product3.setPrice(500000);
		product3.setDescription("�������� �ڵ���");
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
