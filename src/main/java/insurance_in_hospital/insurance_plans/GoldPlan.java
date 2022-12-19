package insurance_in_hospital.insurance_plans;

public class GoldPlan extends HealthInsurancePlan {

    private final static double PLATINUM_PLAN_COVERAGE = 0.8;
    private final static int PLATINUM_PLAN_DISCOUNT = 40;
    private final static double PLATINUM_MONTHLY_PERCENTAGE_PAYMENT = 0.07;

    public GoldPlan ( double coverage, double discount){
        super(PLATINUM_PLAN_COVERAGE, PLATINUM_PLAN_DISCOUNT);
    }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return PLATINUM_MONTHLY_PERCENTAGE_PAYMENT * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
