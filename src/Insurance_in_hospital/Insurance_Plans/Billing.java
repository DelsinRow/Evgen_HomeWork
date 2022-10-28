package Insurance_in_hospital.Insurance_Plans;

import Insurance_in_hospital.Users.Patient;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        payments[0] = amount * patientInsurancePlan.getCoverage();
        payments[1] = amount - payments[0] - patientInsurancePlan.getDiscount();
        return payments;
    }

}
