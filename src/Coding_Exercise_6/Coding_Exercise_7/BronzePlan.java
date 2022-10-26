package Coding_Exercise_6.Coding_Exercise_7;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan ( double coverage, double discount){
        setCoverage(coverage / 100);
        setDiscount(discount);
    }
}
