package com.bala.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * A class to store employee data.
 * 
 * @author bala
 **/
@Entity
@Table(name = "employee")
@NamedQueries({ @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"),
		@NamedQuery(name = "Employee.findByName", query = "select e from Employee e " + "where e.firstName like :name "
				+ "or e.lastName like :name") })
public class Employee implements Serializable {

	/**
	 * Entity's unique identifier.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * employee first name.
	 */
	@Column(name = "first_name")
	private String firstName;
	/**
	 * employee last name.
	 */
	@Column(name = "last_name")
	private String lastName;
	/**
	 * employee position.
	 */
	@Column(name = "position")
	private String position;
	/**
	 * employee phone.
	 */
	private String phone;
	/**
	 * employee e-mail.
	 */
	private String email;
	
	/**
	 * A no-argument constructor.
	 */
	public Employee() {
	}
 
	public Employee(String firstName, String lastName, String position, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}

	// Auto-generated equald, hashCode, getters and setters.
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
		hash = 29 * hash + Objects.hashCode(this.firstName);
		hash = 29 * hash + Objects.hashCode(this.lastName);
		hash = 29 * hash + Objects.hashCode(this.position);
		hash = 29 * hash + Objects.hashCode(this.phone);
		hash = 29 * hash + Objects.hashCode(this.email);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Employee other = (Employee) obj;
		if (this.id != other.id) {
			return false;
		}
		if (!Objects.equals(this.firstName, other.firstName)) {
			return false;
		}
		if (!Objects.equals(this.lastName, other.lastName)) {
			return false;
		}
		if (!Objects.equals(this.position, other.position)) {
			return false;
		}
		if (!Objects.equals(this.phone, other.phone)) {
			return false;
		}
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		return true;
	}

	// Getters and setters.
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEail(String e_mail) {
		this.email = email;
	}

}