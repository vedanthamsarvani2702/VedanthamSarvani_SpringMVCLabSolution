package com.springmvclabsolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id",unique=true)
	private int studentId;
	@Column(name = "Name")
	private String studentName;
	@Column(name = "Department")
	private String studentDept;
	@Column(name = "Country")
	private String studentCountry;
	         
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public Student() {
		super();
	}
	public Student(String studentName, String studentDept, String studentCountry) {
		super();
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentCountry = studentCountry;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDept() {
		return studentDept;
	}
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
	public String getStudentCountry() {
		return studentCountry;
	}
	public void setStudentCountry(String studentCountry) {
		this.studentCountry = studentCountry;
	}
	
	

}
