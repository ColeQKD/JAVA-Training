package dao.implementation;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import dao.EmployeeDAO;
import entities.Employee;

@Repository
public class EmployeeDAOImpl extends AbstractDAOImpl<Contacts> implements EmployeeDAO {

	Configuration configuration = new Configuration().configure();
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

//	public Employee create(Employee employee) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//		SQLQuery insertQuery = session.createSQLQuery(
//				"INSERT INTO T_EMPLOYEE(generator.NextVal,FIRSTNAME,LASTNAME,PASSWORD,USERNAME,EMAIL,CLUSTERID,PROJECTID) VALUES(?,?,?,?,?,?,?,?)");
//		int idx = 0;
//		insertQuery.setParameter(idx++, employee.getId());
//		insertQuery.setParameter(idx++, employee.getFirstName());
//		insertQuery.setParameter(idx++, employee.getLastName());
//		insertQuery.setParameter(idx++, employee.getPassword());
//		insertQuery.setParameter(idx++, employee.getUsername());
//		insertQuery.setParameter(idx++, employee.getEmail());
//		insertQuery.setParameter(idx++, employee.getClusterId());
//		insertQuery.setParameter(idx++, employee.getProjectId());
//		insertQuery.executeUpdate();
//		transaction.commit();
//
//		return employee;
//	}

	public Contacts findOne(Long id) {
		Contacts employee = (Contacts) this.sessionFactory.getCurrentSession().get(Contacts.class, id);

		if (employee == null) {
			throw new EntityNotFoundException("The employee with the id " + id + " not found!");
		}

		return (Contacts) this.sessionFactory.getCurrentSession().get(Contacts.class, id);
	}

	public List<Contacts> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Contacts> employeeList = session.createQuery("from Employee").list();
		return employeeList;
	}

	public Contacts findByFirstName(String firstName) throws EntityNotFoundException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contacts.class);
		Contacts employee = (Contacts) criteria.add(Restrictions.eq("firstName", firstName)).uniqueResult();

		if (employee == null) {
			throw new EntityNotFoundException("The employee with the name " + firstName + " not found!");
		}

		return employee;
	}

	public Contacts findByEmail(String email) throws EntityNotFoundException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contacts.class);
		Contacts employee = (Contacts) criteria.add(Restrictions.eq("email", email)).uniqueResult();

		if (employee == null) {
			throw new EntityNotFoundException("The employee with the email " + email + " not found!");
		}

		return employee;
	}

	public Contacts update(Contacts employee) {
		Session session = this.sessionFactory.getCurrentSession();

		session.update(employee);
		return employee;
	}

	public void delete(Contacts employee) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != employee) {
			session.delete(employee);
		}

	}

}
