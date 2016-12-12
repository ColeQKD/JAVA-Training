package dao.implementation;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import dao.TestDAO;
import entities.Test;

@Repository
public class TestDAOImpl implements TestDAO {

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addPerson(Test test) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery insertQuery = session.createSQLQuery("INSERT INTO TEST(ID,FIRSTNAME,LASTNAME) VALUES(?,?,?)");
		insertQuery.setParameter(0, test.getId());
		insertQuery.setParameter(1, test.getFirstName());
		insertQuery.setParameter(2, test.getLastName());
		insertQuery.executeUpdate();
		transaction.commit();
	}

	public List<Test> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Test> personsList = session.createQuery("from Person").list();
		return personsList;
	}

}
