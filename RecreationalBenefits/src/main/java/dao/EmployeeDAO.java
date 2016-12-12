package dao;

import java.util.List;

import base.AbstractDAO;
import entities.Employee;

//CRUD operations

public interface EmployeeDAO extends AbstractDAO<Contacts>{


	public Contacts findOne(Long id);

	public List<Contacts> findAll();

	public Contacts findByFirstName(String firstName);

	public Contacts findByEmail(String email);

}
