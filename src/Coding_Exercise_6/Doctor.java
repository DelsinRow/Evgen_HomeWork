package Coding_Exercise_6;

import Coding_Exercise_6.Coding_Exercise_7.HealthInsurancePlan;

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

    public Doctor(long doctorId, HealthInsurancePlan insurancePlan, double salary) {
        super(doctorId, insurancePlan, salary);
    }
}
