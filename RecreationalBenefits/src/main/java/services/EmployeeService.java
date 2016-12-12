package services;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Employee;

@Component
public interface EmployeeService {
	
	public Contacts create(Contacts employee);

	public Contacts findOne(Long id);

	public List<Contacts> findAll();

	public Contacts findByFirstName(String fullName);

	public Contacts findByEmail(String email);

	public Contacts update(Contacts employee);

	public void delete(Contacts employee);

}
