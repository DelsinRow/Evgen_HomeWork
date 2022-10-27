package Coding_Exercise_6.Coding_Exercise_7;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super(0.6, 25);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return 0.5 * salary;
    }
}
