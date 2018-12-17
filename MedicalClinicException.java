package assign3;
/* File Name: MedicalClinicException.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 * Class to define a personalized Excetion that is a sublcass of RuntimeException
 */
public class MedicalClinicException extends RuntimeException{
	
	
	//default constructor
	public MedicalClinicException() {
		
	}
	
	//overloaded parameter constructor
	public MedicalClinicException(String message) {
		super(message);
	}

	//Existing method getMessage - class RunTimeException

}//END CLASS

