package views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entities.Employee;
import services.EmployeeService;
import services.implementation.EmployeeServiceImpl;

@ManagedBean(name="registerView")
public class RegisterView {
	
	EmployeeService employeeService = new EmployeeServiceImpl();

	private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String email;    
    

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmployeeService getEmployeeTableService() {
		return employeeService;
	}

	public void setEmployeeTableService(EmployeeService employeeTableService) {
		this.employeeService = employeeTableService;
	}

	public void save() {
    	Contacts employee = new Contacts();
    	employee.setId(1L);
    	employee.setFirstName(firstName);
    	employee.setLastName(lastName);
    	employee.setPassword(password);
    	employee.setUsername(username);
    	employee.setEmail(email);

    	employeeService.create(employee);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Record saved !",null));
    }
     
}
