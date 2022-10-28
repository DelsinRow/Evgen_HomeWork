package Insurance_in_hospital.Insuranse_Brands;

import Insurance_in_hospital.Insurance_Plans.HealthInsurancePlan;

public interface InsuranceBrand {

    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);

}
