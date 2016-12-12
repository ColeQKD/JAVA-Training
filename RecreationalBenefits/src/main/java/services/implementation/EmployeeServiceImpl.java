package services.implementation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.EmployeeDAO;
import dao.implementation.EmployeeDAOImpl;
import entities.Employee;
import services.EmployeeService;

@Service
@ManagedBean(name = "testEmployeeTableService")
@SessionScoped
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao = new EmployeeDAOImpl();

	public EmployeeDAO getEmployeeTableDao() {
		return employeeDao;
	}

	public void setEmployeeTableDao(EmployeeDAO employeeTableDao) {
		this.employeeDao = employeeTableDao;
	}

	@Transactional
	public Contacts create(Contacts employee) {
		this.employeeDao.create(employee);
		return employee;
	}

	@Transactional
	public Contacts findOne(Long id) {
		Contacts employee = this.employeeDao.findOne(id);		
		return employee;
	}

	@Transactional
	public List<Contacts> findAll() {
		return this.employeeDao.findAll();
	}

	@Transactional
	public Contacts findByFirstName(String firstName) {
		Contacts employee = this.employeeDao.findByFirstName(firstName);		
		return employee;
	}

	@Transactional
	public Contacts findByEmail(String email) {
		Contacts employee = this.employeeDao.findByEmail(email);		
		return employee;
	}

	@Transactional
	public Contacts update(Contacts employee) {
		this.employeeDao.update(employee);
		return employee;
	}

	@Transactional
	public void delete(Contacts employee) {
		this.employeeDao.delete(employee);
	}

}
