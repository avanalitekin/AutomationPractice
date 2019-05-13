package ModelClasses.Cybertek;

import java.util.List;

public class Instructors {
	int id;
	String  firstName;
	String lastName;
	int batch;
	String subject;
	List<Instructors> instructors;
	
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Instructors> getInstructors() {
		return instructors;
	}
	public void setInstructors(List<Instructors> instructors) {
		this.instructors = instructors;
	}
	

}
