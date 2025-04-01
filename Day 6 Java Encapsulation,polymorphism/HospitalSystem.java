interface MedicalRecord {
    void addRecord(String diagnosis);
    String viewRecords();
}
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosisHistory = "";


    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    protected void addToDiagnosisHistory(String diagnosis) {
        diagnosisHistory += diagnosis + "; ";
    }


    protected String getDiagnosisHistory() {
        return diagnosisHistory;
    }


    public String getPatientDetails() {
        return String.format("ID: %s | Name: %s | Age: %d", patientId, name, age);
    }


    public abstract double calculateBill();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private double treatmentCharges;


    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate, double treatmentCharges) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.treatmentCharges = treatmentCharges;
    }


    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyRate) + treatmentCharges;
    }


    @Override
    public void addRecord(String diagnosis) {
        addToDiagnosisHistory(diagnosis);
    }


    @Override
    public String viewRecords() {
        return "Diagnosis History (InPatient): " + getDiagnosisHistory();
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private double testCharges;


    public OutPatient(String patientId, String name, int age, double consultationFee, double testCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }


    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }


    @Override
    public void addRecord(String diagnosis) {
        addToDiagnosisHistory(diagnosis);
    }


    @Override
    public String viewRecords() {
        return "Diagnosis History (OutPatient): " + getDiagnosisHistory();
    }
}
public class HospitalSystem {
    public static void processPatients(Patient[] patients) {
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.printf("Total Bill: ₹%.2f\n", p.calculateBill());


            if (p instanceof MedicalRecord) {
                System.out.println(((MedicalRecord) p).viewRecords());
            }


            System.out.println("------------------------------");
        }
    }


    public static void main(String[] args) {
        Patient[] patients = {
                new InPatient("P101", "John Doe", 45, 5, 2000.0, 15000.0),
                new OutPatient("P102", "Jane Smith", 30, 500.0, 1200.0)
        };
        ((MedicalRecord) patients[0]).addRecord("Fracture treatment");
        ((MedicalRecord) patients[1]).addRecord("General check-up");
        processPatients(patients);
    }
}
