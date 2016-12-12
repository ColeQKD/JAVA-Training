package dao.implementation;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.AbstractDAO;

@Repository
public class AbstractDAOImpl<BaseEntity> implements AbstractDAO<BaseEntity> {

	private Class<BaseEntity> type;

	public BaseEntity create(BaseEntity object) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(object);
		return object;
	}

	public BaseEntity read(Long id) throws EntityNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		BaseEntity object = (BaseEntity) session.get(type, id);
		if (object == null) {
			throw new EntityNotFoundException("The object with the id " + id + " not found!");
		}
		return object;
	}

	public BaseEntity update(BaseEntity object) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(object);
		return object;
	}

	public void delete(BaseEntity object) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != object) {
			session.delete(object);
		}
	}

	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
