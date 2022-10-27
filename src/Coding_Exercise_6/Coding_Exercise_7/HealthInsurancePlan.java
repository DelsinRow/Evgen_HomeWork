package Coding_Exercise_6.Coding_Exercise_7;

public abstract class HealthInsurancePlan {
    private double coverage;
    private double discount;
    private InsuranceBrand offeredBy;

    public abstract double computeMonthlyPremium(double salary);

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public HealthInsurancePlan () {}

    public HealthInsurancePlan(double coverage, int discount){
        this.coverage = coverage;
        this.discount = discount;
    }
}
