package Coding_Exercise_6;

import Coding_Exercise_6.Coding_Exercise_7.Billing;
import Coding_Exercise_6.Coding_Exercise_7.GoldPlan;
import Coding_Exercise_6.Coding_Exercise_7.HealthInsurancePlan;
import Coding_Exercise_6.Coding_Exercise_7.PlatinumPlan;

public class Patient extends User {
    private long patientId;
    private boolean insured;

    static HealthInsurancePlan insurancePlan = new HealthInsurancePlan();

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan(90,50);
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

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

//    public Patient(String firstName, String lastName, String gender) {
//        this.setFirstName(firstName);
//        this.setLastName(lastName);
//        this.setGender(gender);
//    }
}
