package insurance_in_hospital.users;

import insurance_in_hospital.insurance_plans.HealthInsurancePlan;
import insurance_in_hospital.insurance_brands.InsuranceBrand;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;



    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(long doctorId, InsuranceBrand insuranceBrand, HealthInsurancePlan insurancePlan, double salary) {
        super(doctorId, insuranceBrand, insurancePlan, salary);
    }
}
