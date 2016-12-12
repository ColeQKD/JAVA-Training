package services.implementation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.TestDAO;
import dao.implementation.TestDAOImpl;
import entities.Test;
import services.TestService;

@Service
@ManagedBean(name="testTableService")
@SessionScoped
public class TestServiceImpl implements TestService {
	
	private TestDAO testDao = new TestDAOImpl();
	
	public TestDAO getTestTableDao() {
		return testDao;
	}

	public void setTestTableDao(TestDAO testTableDao) {
		this.testDao = testTableDao;
	}
	 
    @Transactional
    public void addPerson(Test test) {
        this.testDao.addPerson(test);
    }
 
    @Transactional
    public List<Test> listPersons() {
        return this.testDao.listPersons();
    }


}
