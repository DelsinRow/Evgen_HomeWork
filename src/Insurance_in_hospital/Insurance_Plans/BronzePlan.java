package Insurance_in_hospital.Insurance_Plans;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super(0.6, 25);
    }

    @Override
    public double computeMonthlyPremium (double salary, int age, boolean smoking) {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
