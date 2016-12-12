package main.java.others;

import java.io.Serializable;
import java.util.Date;

//import java.util.Date;

import org.hibernate.Session;

import main.java.entities.Contact;
import main.java.entities.Other;
import main.persistence.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		Contact contact1 = new Contact();
		Contact contact2 = new Contact();
		Other other1 = new Other();
		Other other2 = new Other();

		other1.setVersion(1);
		other1.setdateCreated(new Date());
		other1.setDescription("test1");

		other2.setVersion(2);
		other2.setdateCreated(new Date());
		other2.setDescription("test2");

		contact1.setdateCreated(new Date());
		contact1.setFirstName("Lucian1");
		contact1.setLastName("Plopeanu1");
		contact1.setNickname("Cole1");
		contact1.setPhonenumber1(0741);
		contact1.setPhonenumber2(0741);
		contact1.setOtherStuff(other1);

		contact2.setdateCreated(new Date());
		contact2.setFirstName("Lucian2");
		contact2.setLastName("Plopeanu2");
		contact2.setNickname("Cole2");
		contact2.setPhonenumber1(0742);
		contact2.setPhonenumber2(0742);
		contact2.setOtherStuff(other2);
		contact2.setTest("test ");

		try {
			 session.beginTransaction();

			session.persist(contact1);
			// session.persist(contact2);
			Serializable id = session.save((contact2));
			System.out.println("created id for contact2 : " + id);
		} catch (Exception ex) {
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}
}