package Coding_Exercise_6.Coding_Exercise_7;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan ( double coverage, double discount){
        super(0.8, 40);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.5 * salary;
    }
}
