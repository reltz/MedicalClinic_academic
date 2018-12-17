package assign3;
/* File Name: Patient.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 25/10/2018
 */

// Class that defines a patient with first name, last name, health card number, birth date and appointment
public class Patient {
	private String firstName;
	private String lastName;
	private HealthCardNumber healthNumber;
	private OurDate birthDate;

	// default constructor
	public Patient() {

		this("unknown", "unknown", new HealthCardNumber(), new OurDate(1,1,1901));

	}

	// initializing/input constructor
	public Patient(String firstName, String lastName, HealthCardNumber healthCardNumber, OurDate birthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setHealthCardNumber(healthCardNumber);
		setBirthDate(birthDate);

	}

	//copy constructor
	public Patient(Patient p) {
		setFirstName(p.getFirstName());
		setLastName(p.getLastName());
		setHealthCardNumber(p.getHealthCardNumber());
		setBirthDate(p.getBirthDate());
	}

	// toString method 
	public String toString() {
		return lastName + ", " + firstName + ", Health Card Number: " + healthNumber.toString() + ", dob: " +birthDate.toString();
	}

	// setter method for patient first name
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// setter method for patient last name
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	// setter mehtod for birth date with exception handling
	private void setBirthDate(OurDate birthdate) {
		//data control!
		if (birthdate.getYear()>birthdate.presentYear) {
			throw new MedicalClinicException("The birthdate cannot be more recent than the present.");//FIX THIS
		}
		
		else if (birthdate.getYear()<1900) {
			throw new MedicalClinicException("The year of birth cannot be before 1900! ");
		}
		else {
			
			if (birthdate.getMonth()>=birthdate.presentMonth) {
				if (birthdate.getDay()>=birthdate.presentDay) {
					throw new MedicalClinicException("The birthdate cannot be more be more recent than the present date!");
				}
				else {
					this.birthDate=birthdate;
				}
			}
			else {
				this.birthDate=birthdate;
			}
		}
		
		
	
		
	}
	//setter method for healthCardNumber
	private void setHealthCardNumber(HealthCardNumber healthNumber) {
		this.healthNumber=healthNumber;
	}

	// getter method for first name
	public String getFirstName() {
		return firstName;
	}

	// getter method for lastName
	public String getLastName() {
		return lastName;
	}

	// getter method for health card number
	public HealthCardNumber getHealthCardNumber() {
		return healthNumber;
	}

	// getter method for birth date
	public OurDate getBirthDate() {
		return birthDate;
	}

		
	//method that verify if two patients are equals

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient p = (Patient) obj;
		return (this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName)
				&& this.healthNumber.equals(p.getHealthCardNumber()) && this.birthDate.equals(p.birthDate));

	}

}
