package dao;

import java.util.List;

import entities.Test;


public interface TestDAO {

    public void addPerson(Test test);
    public List<Test> listPersons();
}
