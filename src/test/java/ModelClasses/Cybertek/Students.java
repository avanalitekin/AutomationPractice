package ModelClasses.Cybertek;

import java.util.List;

public class Students {
	Contact contact;
	Company company;
	Address address;
	int id;
	String firstName;
	String lastName;
	int batch;

	List<Students> students;
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}

	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	
	

}
