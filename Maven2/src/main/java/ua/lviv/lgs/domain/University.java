package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private Integer levelAccreditation;
	
	@Column
	private Integer amountInstitutions;
	
	@Column
	private Integer amountStudents;
	
	@Column
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLevelAccreditation() {
		return levelAccreditation;
	}

	public void setLevelAccreditation(Integer levelAccreditation) {
		this.levelAccreditation = levelAccreditation;
	}

	public Integer getAmountInstitutions() {
		return amountInstitutions;
	}

	public void setAmountInstitutions(Integer amountInstitutions) {
		this.amountInstitutions = amountInstitutions;
	}

	public Integer getAmountStudents() {
		return amountStudents;
	}

	public void setAmountStudents(Integer amountStudents) {
		this.amountStudents = amountStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", title=" + title + ", levelAccreditation=" + levelAccreditation
				+ ", amountInstitutions=" + amountInstitutions + ", amountStudents=" + amountStudents + ", address="
				+ address + "]";
	}

}
