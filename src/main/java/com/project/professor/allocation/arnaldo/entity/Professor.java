package com.project.professor.allocation.arnaldo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	@Column(name="name", nullable = false)
	private String name;

	@Column(length = 11, unique = true, nullable = false)
	private String cpf;

	@Column(name = "department_id", nullable = false)
	private Long departmentId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "department_id", updatable = false, insertable = false, nullable = false)
	private Departament depart;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Departament getDepart() {
		return depart;
	}

	public void setDepart(Departament depart) {
		this.depart = depart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getDepartamentid() {
		return getDepartamentid();
	}

	public void setDepartamentid(long departamentid) {
		this.departmentId = departamentid;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", departamentid=" + departmentId + "]";
	}

}
