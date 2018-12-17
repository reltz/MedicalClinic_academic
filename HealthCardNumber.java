package assign3;
/* File Name: HealthCardNumber.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 25/10/2018
 */

//Class that stores the healthcard number and control data entry to fit the appropriate format.
public class HealthCardNumber {
	private String healthCardNumber;

	//default chained constructor
	public HealthCardNumber() {

		this("999999999");
	}

	//initializing constructor
	public HealthCardNumber(String card) {
		setHealthCardNumber(card);
	}

	//setter method that handles exception and sets the value for healthcard Number
	private void setHealthCardNumber(String card) {
		// exception handling
		for (int i = 0; i < card.length(); i++) {
			if (card.charAt(i) < 48 || card.charAt(i) > 57) {
				System.out.println(card.charAt(i) + " is not a number!");
				throw new MedicalClinicException("The health card number must contain only numbers!");
			}
		}
		if (card.length() != 9) {
			throw new MedicalClinicException("The health card number must have 9 digits!");
		} else
			this.healthCardNumber = card;
	} // END SET

	
	//getter method that returns the healthcardNumber
	public String getHealthCardNumber() {
		return healthCardNumber;
	}

	//method that returns the string with the value of healthcard number
	public String toString() {
		return healthCardNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthCardNumber == null) ? 0 : healthCardNumber.hashCode());
		return result;
	}

	//overriden equals method.
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HealthCardNumber)) {
			return false;
		}
		else {
			HealthCardNumber n = (HealthCardNumber) obj;
			return (this.healthCardNumber.equals(n.getHealthCardNumber()));

		}
	}

} // end class
