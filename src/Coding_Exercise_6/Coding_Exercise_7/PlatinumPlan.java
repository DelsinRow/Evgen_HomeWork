package Coding_Exercise_6.Coding_Exercise_7;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
       super(0.9, 50);
   }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.5 * salary;
    }

}
