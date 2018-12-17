package assign3;
/* File Name: MaternityPatient.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 */

//Class is a subclass of Patient
public class MaternityPatient extends Patient {
	private OurDate dueDate;
	private boolean nutritionTesting;
	
	
	//default constructor
	public MaternityPatient() {
		this("unkown","unkown",new HealthCardNumber(),new OurDate(1, 1, 1901),new OurDate(1,1,1901), false);

	}

	//overloaded constructor
	public MaternityPatient(String firstName, String lastName, HealthCardNumber healthNumber, OurDate birthDate, OurDate dueDate,
			boolean nutritionTesting) {
		super(firstName, lastName, healthNumber, birthDate);
		setDueDate(dueDate);
		setNutritionTesting(nutritionTesting);

	}


	//method that returns the dueDate
	public OurDate getDueDate() {
		return dueDate;
	}

	//method that sets the dueDate
	private void setDueDate(OurDate dueDate) {
		this.dueDate = dueDate;
	}

	//method that returns the nutrition testing
	public boolean getNutritionTesting() {
		return nutritionTesting;
	}

	//method that sets the nutrition testing
	private void setNutritionTesting(boolean done) {
		this.nutritionTesting = done;
	}

	//method that return MaternityPatient in a string format.
	public String toString() {
		return this.getLastName()+ ", " + this.getFirstName() + ", Health Card Number: " + this.getHealthCardNumber() + ", dob: "
				+ this.getBirthDate().toString()+ ", dueDate: "+dueDate.toString()+" , nutrition testing: "+nutritionTesting;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + (nutritionTesting ? 1231 : 1237);
		return result;
	}

	//method that verify if two MaternityPatient are equals
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MaternityPatient)) {
			return false;
		}
		MaternityPatient m = (MaternityPatient) obj;
		return (this.getFirstName().equals(m.getFirstName()) && this.getLastName().equals(m.getLastName())
				&& this.getHealthCardNumber().equals(m.getHealthCardNumber()) && this.getBirthDate().equals(m.getBirthDate()) && this.dueDate.equals(m.dueDate)) 
				&& this.nutritionTesting==m.nutritionTesting;
	
	}



}
