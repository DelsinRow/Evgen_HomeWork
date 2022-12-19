package insurance_in_hospital.users;


public class Patient extends User {
    private long patientId;

/**
 *Checking
 * public static void main(String[] args) {
 * HealthInsurancePlan insurancePlan = new PlatinumPlan();
 * Patient patient = new Patient();
 * patient.setInsurancePlan(insurancePlan);
 *
 * double[] payments = Billing.computePaymentAmount(patient, 1000.0);
 * System.out.println("For this patient:");
 * System.out.println("Insurance company would pay: " + payments[0]);
 * System.out.println("Patient would pay: " + payments[1]);
 * }
 */



    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

}
