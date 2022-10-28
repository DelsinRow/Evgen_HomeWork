package Insurance_in_hospital.Users;

import Insurance_in_hospital.Insurance_Plans.HealthInsurancePlan;
import Insurance_in_hospital.Insurance_Plans.PlatinumPlan;
import Insurance_in_hospital.Insurance_Brands.BlueCrossBlueShield;
import Insurance_in_hospital.Insurance_Brands.InsuranceBrand;

public class Staff extends User {
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;

    //Checking
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        Staff nurse = new Nurse(1, insuranceBrand, insurancePlan, 1000);
        nurse.setInsurancePlan(insurancePlan);
        insurancePlan.setOfferedBy(insuranceBrand);

        System.out.println("Nurse's premium: " + insurancePlan.computeMonthlyPremium(nurse.salary, 22, true));
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

    public Staff (long id, InsuranceBrand insuranceBrand, HealthInsurancePlan insurancePlan, double salary) {
        this.staffId = id;
        this.setInsuranceBrand(insuranceBrand);
        this.setInsurancePlan(insurancePlan);
        this.salary = salary;
    }
}
