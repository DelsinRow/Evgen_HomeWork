package Coding_Exercise_6;


import Coding_Exercise_6.Coding_Exercise_7.HealthInsurancePlan;
import Coding_Exercise_6.Coding_Exercise_7.PlatinumPlan;
import Coding_Exercise_6.Coding_Exercise_7.GoldPlan;
import Coding_Exercise_6.Coding_Exercise_7.SilverPlan;
import Coding_Exercise_6.Coding_Exercise_7.BronzePlan;
import Coding_Exercise_6.Coding_Exercise_7.Billing;


public class Patient extends User {
    private long patientId;


    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        System.out.println("For this patient:");
        System.out.println("Insurance company would pay: " + payments[0]);
        System.out.println("Patient would pay: " + payments[1]);
    }



    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }



//    public Patient(String firstName, String lastName, String gender) {
//        this.setFirstName(firstName);
//        this.setLastName(lastName);
//        this.setGender(gender);
//    }
}
