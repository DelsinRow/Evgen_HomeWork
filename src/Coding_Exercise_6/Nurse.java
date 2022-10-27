package Coding_Exercise_6;

import Coding_Exercise_6.Coding_Exercise_7.HealthInsurancePlan;

public class Nurse extends Staff {

    private long nurseId;

    public long getNurseId() {
        return nurseId;
    }
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }

    public Nurse(long nurseId, HealthInsurancePlan insurancePlan, double salary) {
        super(nurseId, insurancePlan, salary);
    }

}
