package insurance_in_hospital.insurance_plans;

public class PlatinumPlan extends HealthInsurancePlan {

    private final static double PLATINUM_PLAN_COVERAGE = 0.9;
    private final static int PLATINUM_PLAN_DISCOUNT = 50;
    private final static double PLATINUM_MONTHLY_PERCENTAGE_PAYMENT = 0.08;

    public PlatinumPlan() {
       super(PLATINUM_PLAN_COVERAGE, PLATINUM_PLAN_DISCOUNT);
   }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return PLATINUM_MONTHLY_PERCENTAGE_PAYMENT * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
