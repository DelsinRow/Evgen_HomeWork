package Coding_Exercise_6;

import Coding_Exercise_6.Coding_Exercise_7.BronzePlan;
import Coding_Exercise_6.Coding_Exercise_7.HealthInsurancePlan;
import Coding_Exercise_6.Coding_Exercise_7.PlatinumPlan;

public class Staff extends User {
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Staff nurse = new Nurse(1, insurancePlan, 1000);
        System.out.println("Nurse's premium: " + insurancePlan.computeMonthlyPremium(nurse.salary));
    }



    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff (long id, HealthInsurancePlan insurancePlan, double salary) {
        this.staffId = id;
        this.setInsurancePlan(insurancePlan);
        this.salary = salary;
    }
}
