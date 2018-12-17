package assign3;
/* File Name: MedicalClinic.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: Date: 20/11/2018
 */

import java.util.ArrayList;

/* File Name: OurDate.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 19/09/2018
 */

import java.util.Scanner;

//class that creates the arrays to storage the doctors, patients and appointments.
public class MedicalClinic {
	private ArrayList<Appointment> appointments;
	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;

	// ArrayList<Patient> patients = new ArrayList<Patient>(); OR?
	// ArrayList<Patient> patients = new ArrayList<>();

	private static final int MAXAPPOINTMENTS = 5;
	private static final int MAXPATIENTS = 5;
	private static final int MAXDOCTORS = 5;
	private static final int MAXPATTIENTS = 0;

	private static int numberAppointments;
	private static int numberPatients;
	private static int numberDoctors;

	
	// default constructor that initializes the three arrays.
	public MedicalClinic() {
		appointments = new ArrayList<>(MAXAPPOINTMENTS);
		patients = new ArrayList<>(MAXPATIENTS);
		doctors = new ArrayList<>(MAXDOCTORS);
		numberAppointments = 0;
		numberPatients = 0;
		numberDoctors = 0;
		
		//method that populates the doctor ArrayList
		populateDoctors();

	}

		//method that inputs the existing doctors
	public void populateDoctors() {
		doctors.add(new Doctor("Vikash", "Singh", "endocrinologist"));
		doctors.add(new Doctor("Susan", "Miller", "cardiologist"));
		doctors.add(new Doctor("Thanh", "Do", "neurologist"));
		doctors.add(new Doctor("Francois", "DaSilva", "internist"));
		doctors.add(new Doctor("Judy", "Chin", "Family Physician"));
	}

	// creates an instance of Patient and allocates each field to the object
	public void addPatient(String firstName, String lastName, HealthCardNumber healthCardNumber, OurDate date) {
		Patient anotherPatient;
		anotherPatient = new Patient(firstName, lastName, healthCardNumber, date);
		patients.add(anotherPatient);
		numberPatients+=1; //increase number of patients by 1.
	}
	
	//creates a new MathernityPatient
	public void addPatient(String firstName, String lastName, HealthCardNumber healthCardNumber, OurDate birthDate, OurDate dueDate,
			boolean nutritionTesting) {
		MaternityPatient anotherPatient;
		anotherPatient = new MaternityPatient(firstName, lastName, healthCardNumber, birthDate, dueDate, nutritionTesting);
		patients.add(anotherPatient);
		numberPatients++;
	}
	
	//creates a new OutPatient
	public void addPatient(String firstName, String lastName, HealthCardNumber healthCardNumber, OurDate birthDate, double distanceFromClinic, boolean mobility) {
		OutPatient anotherPatient = new OutPatient(firstName, lastName, healthCardNumber, birthDate, distanceFromClinic, mobility);
		patients.add(anotherPatient);
		numberPatients++;
	}



	// Adds a new appointment to the array
	public void addAppointment(Patient patient, Doctor doctor, OurDate date) { 
		Appointment anotherAppointment = new Appointment(patient, doctor, date);
		appointments.add(anotherAppointment);
		numberAppointments+=1; //increase total number of appointments by 1.

	}

	public void cancelAppointment(int index) {
		appointments.remove(index);
		numberAppointments-=1;
	}

	//Method that return the values of MedicalClinic atributes

	public int getNumberAppointments() {
		return numberAppointments;
	}

	public int getNumberPatients() {
		return numberPatients;
	}

	public int getNumberDoctors() {
		return numberDoctors;
	}

	public int getMaxAppointments() {
		return MAXAPPOINTMENTS;
	}

	public int getMaxPatients() {
		return MAXPATTIENTS;
	}

	public int getMaxDoctors() {
		return MAXDOCTORS;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}


}
