import java.util.*;

class Patient {
    String id;
    String name;
    String dateOfBirth;
    String address;
    String phone;

    public Patient(String id, String name, String dateOfBirth, String address, String phone) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient{id='" + id + "', name='" + name + "', dateOfBirth='" + dateOfBirth + "', address='" + address + "', phone='" + phone + "'}";
    }
}

class Appointment {
    String patientId;
    String doctorName;
    String dateTime;

    public Appointment(String patientId, String doctorName, String dateTime) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Appointment{patientId='" + patientId + "', doctorName='" + doctorName + "', dateTime='" + dateTime + "'}";
    }
}

class ElectronicHealthRecord {
    String patientId;
    String recordDate;
    String diagnosis;
    String treatment;

    public ElectronicHealthRecord(String patientId, String recordDate, String diagnosis, String treatment) {
        this.patientId = patientId;
        this.recordDate = recordDate;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "EHR{patientId='" + patientId + "', recordDate='" + recordDate + "', diagnosis='" + diagnosis + "', treatment='" + treatment + "'}";
    }
}

class Invoice {
    String patientId;
    double amount;
    String date;
    String status; // Paid / Unpaid

    public Invoice(String patientId, double amount, String date, String status) {
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{patientId='" + patientId + "', amount=" + amount + ", date='" + date + "', status='" + status + "'}";
    }
}

class MedicalInventory {
    String itemName;
    int quantity;
    double pricePerUnit;

    public MedicalInventory(String itemName, int quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "MedicalInventory{itemName='" + itemName + "', quantity=" + quantity + ", pricePerUnit=" + pricePerUnit + "}";
    }
}

class Staff {
    String staffId;
    String name;
    String role;
    double salary;

    public Staff(String staffId, String name, String role, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{staffId='" + staffId + "', name='" + name + "', role='" + role + "', salary=" + salary + "}";
    }
}

public class HospitalManagementSystem {
    private Map<String, Patient> patients = new HashMap<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<ElectronicHealthRecord> ehrRecords = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();
    private List<MedicalInventory> inventory = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();

    // Patient Registration
    public void registerPatient(String id, String name, String dob, String address, String phone) {
        Patient patient = new Patient(id, name, dob, address, phone);
        patients.put(id, patient);
    }

    // Appointment Scheduling
    public void scheduleAppointment(String patientId, String doctorName, String dateTime) {
        Appointment appointment = new Appointment(patientId, doctorName, dateTime);
        appointments.add(appointment);
    }

    // EHR Management
    public void addEHR(String patientId, String recordDate, String diagnosis, String treatment) {
        ElectronicHealthRecord ehr = new ElectronicHealthRecord(patientId, recordDate, diagnosis, treatment);
        ehrRecords.add(ehr);
    }

    // Billing and Invoicing
    public void generateInvoice(String patientId, double amount, String date, String status) {
        Invoice invoice = new Invoice(patientId, amount, date, status);
        invoices.add(invoice);
    }

    // Inventory Management
    public void addMedicalItem(String itemName, int quantity, double pricePerUnit) {
        MedicalInventory item = new MedicalInventory(itemName, quantity, pricePerUnit);
        inventory.add(item);
    }

    // Staff Management
    public void addStaff(String staffId, String name, String role, double salary) {
        Staff staff = new Staff(staffId, name, role, salary);
        staffMembers.add(staff);
    }

    // Display Functions
    public void displayPatients() {
        patients.values().forEach(System.out::println);
    }

    public void displayAppointments() {
        appointments.forEach(System.out::println);
    }

    public void displayEHRRecords() {
        ehrRecords.forEach(System.out::println);
    }

    public void displayInvoices() {
        invoices.forEach(System.out::println);
    }

    public void displayInventory() {
        inventory.forEach(System.out::println);
    }

    public void displayStaff() {
        staffMembers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();

        // Register patients
        hms.registerPatient("P001", "John Doe", "01/01/1980", "123 Main St", "123-456-7890");
        hms.registerPatient("P002", "Jane Smith", "15/04/1990", "456 Oak St", "987-654-3210");

        // Schedule appointments
        hms.scheduleAppointment("P001", "Dr. Smith", "2024-12-10 10:00 AM");
        hms.scheduleAppointment("P002", "Dr. Brown", "2024-12-11 11:00 AM");

        // Add Electronic Health Records
        hms.addEHR("P001", "2024-12-05", "Flu", "Rest and hydrate");
        hms.addEHR("P002", "2024-12-06", "Headache", "Pain relievers");

        // Generate invoices
        hms.generateInvoice("P001", 150.00, "2024-12-10", "Unpaid");
        hms.generateInvoice("P002", 200.00, "2024-12-11", "Unpaid");

        // Add medical items to inventory
        hms.addMedicalItem("Bandage", 100, 1.50);
        hms.addMedicalItem("Syringe", 200, 0.80);

        // Add staff members
        hms.addStaff("S001", "Dr. Smith", "Doctor", 5000.00);
        hms.addStaff("S002", "Nurse Mary", "Nurse", 3000.00);

        // Display the data
        System.out.println("\nPatients:");
        hms.displayPatients();

        System.out.println("\nAppointments:");
        hms.displayAppointments();

        System.out.println("\nEHR Records:");
        hms.displayEHRRecords();

        System.out.println("\nInvoices:");
        hms.displayInvoices();

        System.out.println("\nMedical Inventory:");
        hms.displayInventory();

        System.out.println("\nStaff Members:");
        hms.displayStaff();
    }
}
