package com.edubridge.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

@Id  
@GeneratedValue(strategy=GenerationType.AUTO)  
int addressId;

String city;

String state;

@OneToOne(targetEntity=Employee.class, cascade=CascadeType.ALL)  
private Employee employee;//mapping 



public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
} 


}
