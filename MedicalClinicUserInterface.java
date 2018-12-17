package assign3;

/* File Name: MedicalClinicUserInterface.java
 * Course Name: Object-Oriented Programming (Java)
 * Lab Section: 314
 * Student Name: Rodrigo Eltz
 * Date: 20/11/2018
 * Class that interacts with the user
 */
import java.util.Scanner;

public class MedicalClinicUserInterface {
	// variables that work as the menu options
	private final int ADD_PATIENT = 1;
	private final int ADD_APPOINTMENT = 2;
	private final int CANCEL_APPOINTMENT = 3;
	private final int LIST_APPOINTMENT = 4;
	private final int QUIT = 5;
	private MedicalClinic clinic;
	private Scanner in;

	// default constructor
	public MedicalClinicUserInterface() {
		clinic = new MedicalClinic();
		in = new Scanner(System.in);
	}

	// menu method that prompts the user with the options
	public void menu() {
		int choice = 0;
		while (choice != 5) {
			System.out.println("\nPlease make a choice: ");
			System.out.println("1 Enter a new patient");
			System.out.println("2 Make an appointment for a patient");
			System.out.println("3 Cancel an appointment for a patient");
			System.out.println("4 List all appointments");
			System.out.println("5 Quit");
			choice = in.nextInt();
			if (choice == ADD_PATIENT) {
				addPatient();
			} else if (choice == ADD_APPOINTMENT) {
				addAppointment();
			} else if (choice == CANCEL_APPOINTMENT) {
				cancelAppointment();
			}

			else if (choice == LIST_APPOINTMENT) {
				listAppointment();
			} else if (choice == QUIT) {
				System.out.println("Goodbye");
				in.close(); // closing scanner
			} else if (choice == 9) {
				printPatients();
			} else {
				System.out.println("Your choice is invalid, please enter again. ");
			}
		}

	}

	// method that prompts the user to add a new patient to the clinic
	public void addPatient() {
		boolean flagBirth = false;
		boolean flagCard = false;
		String firstName = "";
		String lastName = "";
		String healthNumber = "";
		String birthDate = "";
		int type = 0;
		HealthCardNumber healthCardNumber = null;
		OurDate realBirthDate = null;

		System.out.println("Enter first name: ");
		firstName = in.next();
		System.out.println("Enter last name: ");
		lastName = in.next();
		do {
			try {
				System.out.println("\nEnter health card number: ");
				healthNumber = in.next();
				healthCardNumber = new HealthCardNumber(healthNumber);
				flagCard = true;
			} catch (MedicalClinicException e) {
				System.out.println(e.getMessage());
			}
		} while (flagCard == false);

		boolean validData = false;
		do {
			boolean validOurDate=false;
			do {
			System.out.println("Enter bith date DDMMYYYY: ");
			birthDate = in.next();
			System.out.println("Enter the type of patient: ");
			System.out.println("1.Maternity Patient \n2.OutPatient \n3.Regular Patient\n");
			type = in.nextInt();

			// retrieving int day, month and year from user string input
			Integer day = Integer.parseInt(birthDate.substring(0, 2));
			Integer month = Integer.parseInt(birthDate.substring(2, 4));
			Integer year = Integer.parseInt(birthDate.substring(4));
			try {
			realBirthDate = new OurDate(day, month, year); // NOT CHECKING BIRTH DATE, JUST DATE!
			validOurDate=true;
			
			} catch (MedicalClinicException e) { //catches if OurDate is in proper format!
				System.out.println(e.getMessage());
			} } while (validOurDate==false);
			
			int nutrition;
			boolean nutritionTesting = false;
			OurDate dueDate = null;
			boolean mobility = false;
			int mobile = 0;
			double distance = 0.0;
			MaternityPatient mp = null;
			OutPatient op = null;
			Patient p = null;

			// create temporary patient | must verify if already exists
			try {
				if (type == 1) {
					System.out.println("Enter the dueDate of the patient in the format: DDMMYYY");
					String due = in.next();
					Integer dueDay = Integer.parseInt(due.substring(0, 2));
					Integer dueMonth = Integer.parseInt(due.substring(2, 4));
					Integer dueYear = Integer.parseInt(due.substring(4));
					dueDate = new OurDate(dueDay, dueMonth, dueYear);
					System.out.println("Is the nutrition test done? 1.Yes, 2.No ");
					nutrition = in.nextInt();

					if (nutrition == 1) {
						nutritionTesting = true;
					}

					mp = new MaternityPatient(firstName, lastName, healthCardNumber, realBirthDate, dueDate,
							nutritionTesting);
					validData = true;
				} // END TYPE1

				else if (type == 2) {
					// double distanceFromClinic, boolean mobility
					System.out.println("What is the current distance of the patient from the clinic? ");
					distance = in.nextDouble();
					System.out.println("Does the patient has mobility? 1.yes 2.no ");
					mobile = in.nextInt();
					if (mobile == 1) {
						mobility = true;
					}
					op = new OutPatient(firstName, lastName, healthCardNumber, realBirthDate, distance, mobility);
					validData = true;

				} // END TYPE 2
				else {
					p = new Patient(firstName, lastName, healthCardNumber, realBirthDate);
					validData = true;
				} // end type 3
					// check if array patients is empty

				if (clinic.getPatients().size() == 0) {
					if (type == 1) {
						clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate, dueDate,
								nutritionTesting);
					} else if (type == 2) {
						clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate, distance, mobility);
					} else {
						clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate);
					}
				} else {

					// if not empty, then check if exists
					boolean patientExists = false;
					for (Patient each : clinic.getPatients()) {
						if (type == 1) {
							if (each.equals(mp)) {
								System.out.println("This patient already exists!");
								patientExists = true;
								break;
							}
						} // end maternity patient
						else if (type == 2) {
							if (each.equals(op)) {
								System.out.println("This patient already exists!");
								patientExists = true;
								break;
							}
						} // end outpatient
						else {
							if (each.equals(p)) {
								System.out.println("This patient already exists!");
								patientExists = true;
								break;
							}
						} // end patient

					}
					if (patientExists == false) {
						if (type == 1) {
							clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate, dueDate,
									nutritionTesting);
						} else if (type == 2) {
							clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate, distance, mobility);
						} else {
							clinic.addPatient(firstName, lastName, healthCardNumber, realBirthDate);
						}

					} // end if

				} // end else

			} catch (MedicalClinicException e) {
				System.out.println(e.getMessage());
			}
		} while (validData == false);
	}// END ADD PATIENT

	// method that prompts the user to schedule a new appointment
	public void addAppointment() {

		// choose patient
		boolean flagCardNumber = false;
		HealthCardNumber cardNumber = null;
		do {
			try {
				System.out.print("\nEnter health card number: ");
				String card = in.next();
				cardNumber = new HealthCardNumber(card);
				flagCardNumber = true;
			} catch (MedicalClinicException e) {
				System.out.println(e.getMessage());
			}
		} while (flagCardNumber == false);
		Patient p = new Patient();

		boolean flagPatientExist = false;
		for (Patient each : clinic.getPatients()) {

			if (cardNumber.equals(each.getHealthCardNumber())) {
				System.out.println(each.toString());
				p = each; // assign the found patient to the temporary patient.
				flagPatientExist = true;

			} else {
				System.out.println("There is no such patient.");
			}

		}
		if (flagPatientExist == true) {
			// choose Doctor
			System.out.println("");
			for (int i = 0; i < clinic.getDoctors().size(); i++) {
				System.out.println((i + 1) + " " + clinic.getDoctors().get(i).toString());
			}
			System.out.print("\nEnter number for doctor selection: \n");
			int doctorNumber = in.nextInt();
			Doctor d;
			d = clinic.getDoctors().get(doctorNumber - 1);

			// Choose date
			boolean flagDate = false;
			OurDate appointmentDate = null;
			do {
				try {
					System.out.print("\nEnter desired appointment date DDMMYYYY: ");
					String date = in.next();
					Integer day = Integer.parseInt(date.substring(0, 2));
					Integer month = Integer.parseInt(date.substring(2, 4));
					Integer year = Integer.parseInt(date.substring(4));

					appointmentDate = new OurDate(day, month, year);

					// checks if the appointments arrayList is empty
					boolean flagDate2 = false;

					if (clinic.getAppointments().size() == 0) {
						clinic.addAppointment(p, d, appointmentDate);
					}

					else {// if not empty, then check for existing appointments.
						boolean flagTaken = false; // flag to check if appointment is taken.
						for (Appointment each : clinic.getAppointments()) {
							if (each.getDoctor().equals(d) && each.getAppointmentDate().equals(appointmentDate)) {
								System.out.println("Doctor already has an appointment that day");
								flagTaken = true;
								break;
							}
						}
						if (flagTaken == false) {
							clinic.addAppointment(p, d, appointmentDate); // THIS LINES ADDS THE APPOINTMENT
							System.out.println("\nAppointment confirmed!");
						}
					}

					// if patient healthCardNumber is not found, then alerts the user that patient
					// does not exist in record.
					if (flagPatientExist == false) {
						System.out.println("This patient does not exists");
					}
					flagDate = true;
				} catch (MedicalClinicException e) {
					System.out.println(e.getMessage());
				}
			} while (flagDate == false);
		} // END if patientexists

	}// END addAppointment

	// method to cancel an existing appointment
	public void cancelAppointment() {
		// choose patient
		boolean validCard = false;
		HealthCardNumber cardNumber = null;
		do {
			System.out.print("\nEnter health card number: ");
			try {
				cardNumber = new HealthCardNumber(in.next());
				validCard = true;
			} catch (MedicalClinicException e) {
				System.out.println(e.getMessage());
			}
		} while (validCard == false);

		// String cardNumber = in.next();
		Patient p = new Patient();
		boolean flagPatientExist = false;
		for (Patient each : clinic.getPatients()) {
			if (cardNumber.getHealthCardNumber().equals(each.getHealthCardNumber().getHealthCardNumber())) {
				System.out.println(each.toString());
				p = each; // assign the found patient to the temporary patient.
				flagPatientExist = true;
				break;
			}
		}
		if (flagPatientExist == false) {
			System.out.println("This patient does not exists");
		}

		for (int i = 0; i < clinic.getDoctors().size(); i++) {
			System.out.println((i + 1) + " " + clinic.getDoctors().get(i).toString());
		}

		// choose Doctor
		System.out.print("\nEnter number for doctor selection: ");
		int doctorNumber = in.nextInt();
		Doctor d;
		d = clinic.getDoctors().get(doctorNumber - 1);

		// Choose date
		System.out.print("\nEnter appointment date DDMMYYYY: ");
		String date = in.next();
		Integer day = Integer.parseInt(date.substring(0, 2));
		Integer month = Integer.parseInt(date.substring(2, 4));
		Integer year = Integer.parseInt(date.substring(4));
		OurDate appointmentDate = new OurDate(day, month, year);

		Appointment inputAppointment = new Appointment(p, d, appointmentDate);

		for (int i = 0; i < clinic.getAppointments().size(); i++) {
			if (inputAppointment.equals(clinic.getAppointments().get(i))) {
				clinic.cancelAppointment(i);
				System.out.println("\nAppointment canceled!");
				break;
			} // end if
		} // end for

	} // end cancelappointment

	// method that lists the appointments on the screen
	public void listAppointment() {
		if (clinic.getAppointments().size() == 0) {
			System.out.println("No appointments.");
		} else {
			for (Appointment a : clinic.getAppointments()) {
				System.out.println(a.toString());
			}
		}
	}

	// displays the existing doctors on the screen
	public void printDoctors() {
		System.out.println("");
		for (Doctor each : clinic.getDoctors()) {
			System.out.println(each.toString());
		}
	}

	// displays the existing patients on the screen
	public void printPatients() {
		for (Patient each : clinic.getPatients()) {
			System.out.println(each.toString());
		}
	}

	// Running the program!
	public static void main(String[] args) {

		MedicalClinicUserInterface myClinic = new MedicalClinicUserInterface();
		myClinic.menu();

	}

}
