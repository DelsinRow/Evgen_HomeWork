package insurance_in_hospital.insurance_plans;

public class BronzePlan extends HealthInsurancePlan {

    private final static double BRONZE_PLAN_COVERAGE = 0.6;
    private final static int BRONZE_PLAN_DISCOUNT = 25;
    private final static double BRONZE_MONTHLY_PERCENTAGE_PAYMENT = 0.05;

    public BronzePlan() {
        super(BRONZE_PLAN_COVERAGE, BRONZE_PLAN_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return BRONZE_MONTHLY_PERCENTAGE_PAYMENT * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
