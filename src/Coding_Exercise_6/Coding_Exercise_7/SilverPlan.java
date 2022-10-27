package Coding_Exercise_6.Coding_Exercise_7;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan ( double coverage, double discount){
        super(0.7, 30);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.5 * salary;
    }
}
