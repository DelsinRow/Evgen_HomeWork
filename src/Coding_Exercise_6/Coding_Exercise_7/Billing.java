package Coding_Exercise_6.Coding_Exercise_7;

import Coding_Exercise_6.Patient;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        payments[0] = amount * patientInsurancePlan.getCoverage();
        payments[1] = amount - payments[0] - patientInsurancePlan.getDiscount();
        return payments;
    }

}
