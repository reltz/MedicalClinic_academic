package assign3;
/* File Name: OutPatient.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 */

//This class is a subclass of Patient
public class OutPatient extends Patient {
	private double distanceFromClinic;
	private boolean mobility;
	
	//default constructor
	public OutPatient() {
		this("unknown","unknown",new HealthCardNumber(), new OurDate(1,1,1901),0.0, false);
		}
	
	//overloaded constructor
	public OutPatient(String firstName, String lastName, HealthCardNumber healthNumber, OurDate birthDate, double distanceFromClinic, boolean mobility) {
		super(firstName, lastName, healthNumber, birthDate);
		setDistanceFromClinic(distanceFromClinic);
		setMobility(mobility);
	}
	
		
	//method that returns the distance from the clinic
	public double getDistanceFromClinic() {
		return distanceFromClinic;
	}
	
	
	//method that sets the distance to the clinic
	private void setDistanceFromClinic(double d) {
		this.distanceFromClinic=d;
	}
	
	//method that returns true if the patient has mobility
	public boolean getMobility() {
		return mobility;
	}
	
	//method that sets the mobility for the patient
	private void setMobility(boolean m) {
		this.mobility=m;
	}
	
	//method that returns the OutPatient in string format
	public String toString() {
		return this.getLastName()+ ", " + this.getFirstName() + ", Health Card Number: " + this.getHealthCardNumber() + ", dob: "
			+this.getBirthDate().toString() +", distanceFromClinic: "+distanceFromClinic+", mobility: "+mobility;

		
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(distanceFromClinic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (mobility ? 1231 : 1237);
		return result;
	}
	//method that compares if two outpatient are equals
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OutPatient)) {
			return false;
		}
		OutPatient p = (OutPatient) obj;
		return (this.getFirstName().equals(p.getFirstName()) && this.getLastName().equals(p.getLastName())
				&& this.getHealthCardNumber().equals(p.getHealthCardNumber()) && this.getBirthDate().equals(p.getBirthDate()) && this.mobility==p.mobility 
				&& this.distanceFromClinic==p.distanceFromClinic);
	}
	

}
