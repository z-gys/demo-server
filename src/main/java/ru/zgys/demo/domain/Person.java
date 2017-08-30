package ru.zgys.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author U.Goryntsev 29.08.2017
 */
@Entity
@Table(name = "t_person")
public class Person extends BaseEntity{
	@Id
	@SequenceGenerator(name = "t_person_id_seq", sequenceName = "t_person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "t_person_id_seq")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	private LocalDate birthday;

	public Long getId() {
		return id;
	}

	public Person setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Person setEmail(String email) {
		this.email = email;
		return this;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Person setBirthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		return id != null ? id.equals(person.id) : person.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
