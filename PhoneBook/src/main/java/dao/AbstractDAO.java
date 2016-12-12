package main.java.dao;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Session;


public interface AbstractDAO<BaseEntity> {

    BaseEntity create(BaseEntity newInstance);
    
	BaseEntity read(Long id)  throws EntityNotFoundException;
    
    BaseEntity update(BaseEntity transientObject);   

    void delete(BaseEntity persistentObject);
    
	public Session getCurrentSession();

}
