package insurance_in_hospital.insurance_brands;

import insurance_in_hospital.insurance_plans.HealthInsurancePlan;

public interface InsuranceBrand {

    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);

}
