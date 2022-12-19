package insurance_in_hospital.users;

import insurance_in_hospital.insurance_plans.HealthInsurancePlan;
import insurance_in_hospital.insurance_brands.InsuranceBrand;

public class Nurse extends Staff {

    private long nurseId;

    public long getNurseId() {
        return nurseId;
    }
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }

    public Nurse(long nurseId, InsuranceBrand insuranceBrand, HealthInsurancePlan insurancePlan, double salary) {
        super(nurseId, insuranceBrand, insurancePlan, salary);
    }

}
