package Insurance_in_hospital.Insurance_Plans;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
       super(0.9, 50);
   }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

}
