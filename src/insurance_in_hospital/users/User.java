package insurance_in_hospital.users;

import insurance_in_hospital.insurance_plans.HealthInsurancePlan;
import insurance_in_hospital.insurance_brands.InsuranceBrand;

public abstract class User {

    private long id;
    private int age;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private boolean smoking;
    private boolean insured;

    private HealthInsurancePlan insurancePlan;
    private InsuranceBrand insuranceBrand;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public InsuranceBrand getInsuranceBrand() {
        return insuranceBrand;
    }

    public void setInsuranceBrand(InsuranceBrand insuranceBrand) {
        this.insuranceBrand = insuranceBrand;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}


