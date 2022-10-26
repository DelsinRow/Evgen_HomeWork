package Coding_Exercise_6.Coding_Exercise_7;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan ( double coverage, double discount){
        setCoverage(coverage / 100);
        setDiscount(discount);
    }
}
