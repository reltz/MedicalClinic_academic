package assign3;
/* File Name: Appointment.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 */

//class that creates the Appointment objects with doctor, respective patient and the date of the appointment
public class Appointment {

	private Doctor doctor;
	private Patient patient;
	private OurDate date;

	// default constructor
	public Appointment() {
		this(new Patient(),new Doctor(), new OurDate());
				
	}
	
	//parameterized constructor
	public Appointment(Patient patient, Doctor doctor, OurDate appointmentDate) {
		setPatient(patient);
		setDoctor(doctor);
		setAppointmentDate(appointmentDate);
	}

	// setter method to define the doctor
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	// method to retrieve a Patient
	public Patient getPatient() {
		return patient;
	}

	// setter method to define a patient to an appointment
	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	// method to retrieve the appointment date
	public OurDate getAppointmentDate() {
		return date;
	}

	// setter method to define the date of the appointment
	private void setAppointmentDate(OurDate date) {
		//data control
		if (date.getYear()<=date.presentYear) {
			if (date.getMonth()<=date.presentMonth) {
				if (date.getDay()<=date.presentDay) {
					throw new MedicalClinicException("The appointment cannot be schedueled for the present date or a prior date to today!");
				}
				else {
					this.date=date;
				}
			}
		}
		
		
	}

	// method to retrieve the Doctor of the appointment
	public Doctor getDoctor() {
		return doctor;
	}
	
	//returns a organized string with all the fields of the object
	public String toString() {
		return "Appointment date: "+date.toString()+", Dr. "+doctor.toString()+", Patient: "+patient.toString()+" ";
					
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	//overriden method that verify if appointments are equal
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Appointment)) {
			return false;
		}
		Appointment a = (Appointment) obj;
		return (this.getAppointmentDate().equals(a.getAppointmentDate()) && this.getDoctor().equals(a.getDoctor()) && this.getPatient().equals(a.getPatient()));
		
	}
	
	
}
