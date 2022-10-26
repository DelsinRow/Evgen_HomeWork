package Coding_Exercise_6.Coding_Exercise_7;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan ( double coverage, double discount){
        setCoverage(coverage / 100);
        setDiscount(discount);
    }
}
