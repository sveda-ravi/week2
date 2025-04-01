import java.util.*;

// Patient class
class Patient {
    private String name;
    private String patientId;
    private List<Doctor> consultedDoctors;

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        consultedDoctors.add(doctor);
    }

    public void showConsultedDoctors() {
        System.out.println("Patient: " + name + " consulted with:");
        for (Doctor doc : consultedDoctors) {
            System.out.println("  - Dr. " + doc.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting patient " + patient.getName());
        patients.add(patient);
        patient.addDoctor(this);
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

// Hospital class to organize Doctors and Patients
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("  - Dr. " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

// Main class
public class HospitalSystemDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("CityCare Hospital");

        // Create Doctors
        Doctor d1 = new Doctor("Arjun", "Cardiology");
        Doctor d2 = new Doctor("Meera", "Neurology");

        // Create Patients
        Patient p1 = new Patient("Suresh", "P101");
        Patient p2 = new Patient("Anjali", "P102");

        // Add to Hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Show hospital info
        hospital.showHospitalDetails();

        System.out.println("\n--- Consultations ---");
        // Consultations (communication)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println("\n--- Doctor-wise Consultations ---");
        d1.showPatients();
        d2.showPatients();

        System.out.println("\n--- Patient-wise Consultations ---");
        p1.showConsultedDoctors();
        p2.showConsultedDoctors();
    }
}
