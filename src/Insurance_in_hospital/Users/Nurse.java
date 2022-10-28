package Insurance_in_hospital.Users;

import Insurance_in_hospital.Insurance_Plans.HealthInsurancePlan;
import Insurance_in_hospital.Insurance_Brands.InsuranceBrand;

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
