package assign3;
/* File Name: Doctor.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 */

//Class that represent the doctors, with name and specialty
public class Doctor {
	private String firstName;
	private String lastName;
	private String specialty;
	
	
	//default constructor
	public Doctor() {
		this("unknown","unknown","unknown");
		
	}
	
	//overloaded constructor
	public Doctor(String firstName, String lastName, String specialty) {
		setFirstName(firstName);
		setLastName(lastName);
		setSpecialty(specialty);
		
	}
	
	//toString method to return format: "doctor: LastName, FirstName, specialty"
	public String toString() {
		return firstName+" "+lastName+", "+specialty;
	}
	
	//method to set first name
	private void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	//method to set lastName
	private void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	//method to set the doctor specialty
	private void setSpecialty(String specialty) {
		this.specialty=specialty;
	}
	
	//method to get the doctor first name
	
	public String getFirstName() {
		return firstName;
	}
	
	//method to get the doctor last name
	
	public String getLastName() {
		return lastName;
	}
	
	//method to get the doctor specialty
	
	public String getSpecialty() {
		return specialty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
		return result;
	}
	
	//method that verify if two doctors are equals

	@Override
	public boolean equals(Object obj) {
	if (!(obj instanceof Doctor)) {
		return false;
	}
	Doctor d = (Doctor) obj;
	return (this.getFirstName().equals(d.getFirstName()) && this.getLastName().equals(d.getLastName()) && this.getSpecialty().equals(d.getSpecialty()));
	
	}
	
	
	
	
}
