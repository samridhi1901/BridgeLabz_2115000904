class Patient {
    private static String hospitalName = "Hostpital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total patients admitted: " + totalPatients);
    }

    public void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
        } else {
            System.out.println("Invalid object! Not a Patient.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("alice", 30, "Flu", 101);
        Patient p2 = new Patient("Smith", 45, "Diabetes", 102);

        p1.displayPatientDetails(p1);
        p2.displayPatientDetails(p2);

        Patient.getTotalPatients();
    }
}
