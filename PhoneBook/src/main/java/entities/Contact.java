package main.java.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.entities.BaseEntity;

@Entity
@Table(name = "CONTACTS")
public class Contact extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "PHONENUMBER1")
	private int phonenumber1;

	@Column(name = "PHONENUMBER2")
	private int phonenumber2;

	@Column(name = "NICKNAME")
	private String nickname;

	@OneToOne(cascade = CascadeType.ALL)
	private Other oId;
	
	@Column
	private String test;

		

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

	public int getPhonenumber1() {
		return phonenumber1;
	}

	public void setPhonenumber1(int phonenumber1) {
		this.phonenumber1 = phonenumber1;
	}

	public int getPhonenumber2() {
		return phonenumber2;
	}

	public void setPhonenumber2(int phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Other getOtherStuff() {
		return oId;
	}

	public void setOtherStuff(Other oId) {
		this.oId = oId;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	

}
