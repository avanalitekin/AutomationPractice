package ModelClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Instructor {
	String firstName;
	String lastName;
	int batch;
	String subject;
	
	public Instructor() {}
	public Instructor(String firstName, String lastName, int batch, String subject) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.batch=batch;
		this.subject=subject;
		
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
