package Insurance_in_hospital.Insurance_Plans;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan ( double coverage, double discount){
        super(0.8, 40);
    }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
