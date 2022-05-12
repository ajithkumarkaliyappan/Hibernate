package com.edubridge.hibernate.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Table;

@Entity  // it has its own mapping table or db
@Table(name= "emphibermaven") // table name is emp
public class Employee {

@Id
@GeneratedValue  // for auto increment
@Column(name="emp_id") // for give/change column name
private int id;

@Column(name="emp_lastname",unique=true,length=25) // for give/change column name
private String firstName;
@Column(name="emp_firstname",length=25,nullable=false) // for give/change column name
private String lastName;


private double salary;

public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getId() {
	return id;
}
public void setId(int id) {
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


}

