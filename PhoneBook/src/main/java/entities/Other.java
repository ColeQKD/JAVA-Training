package main.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.entities.BaseEntity;

	@Entity
	@Table(name = "OTHER")

public class Other extends BaseEntity{
		
		@Transient
		private static final long serialVersionUID = 1L;
		
	@Column(name = "DESCRIPTION")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
