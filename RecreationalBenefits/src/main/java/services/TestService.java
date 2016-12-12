package services;

import java.util.List;

import org.springframework.stereotype.Component;
import entities.Test;

@Component
public interface TestService {
	
    public void addPerson(Test test);
    public List<Test> listPersons();

}
