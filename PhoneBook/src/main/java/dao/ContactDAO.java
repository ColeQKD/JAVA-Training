package main.java.dao;

import java.util.List;

import main.java.entities.Contact;

public interface ContactDAO extends AbstractDAO<Contact> {

	// CRUD operations

	public Contact create(Contact contact);

	public Contact findOne(Long id);

	public List<Contact> findAll();

	public Contact findByFirstName(String firstName);

	public Contact findByEmail(String email);

	public Contact update(Contact contact);

	public void delete(Contact contact);
}
