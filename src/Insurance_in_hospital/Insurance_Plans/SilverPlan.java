package Insurance_in_hospital.Insurance_Plans;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan ( double coverage, double discount){
        super(0.7, 30);
    }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
