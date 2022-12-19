package insurance_in_hospital.insurance_brands;

import insurance_in_hospital.insurance_plans.GoldPlan;
import insurance_in_hospital.insurance_plans.PlatinumPlan;
import insurance_in_hospital.insurance_plans.SilverPlan;
import insurance_in_hospital.insurance_plans.BronzePlan;
import insurance_in_hospital.insurance_plans.HealthInsurancePlan;


public class BlueCrossBlueShield implements InsuranceBrand{
    private int id;
    private String name;
    final static int OLD_AGE = 55;

    final static int OLD_PLATINUM_PREMIUM = 200;
    final static int OLD_GOLD_PREMIUM = 150;
    final static int OLD_SILVER_PREMIUM = 100;
    final static int OLD_BRONZE_PREMIUM = 50;

    final static int SMOKING_PLATINUM_PREMIUM = 100;
    final static int SMOKING_GOLD_PREMIUM = 90;
    final static int SMOKING_SILVER_PREMIUM = 80;
    final static int SMOKING_BRONZE_PREMIUM = 70;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking){
        double smokingPremium = 0;
        double agePremium = 0;


        if(smoking){
            if (insurancePlan instanceof PlatinumPlan){
                smokingPremium = SMOKING_PLATINUM_PREMIUM;
            } else if (insurancePlan instanceof GoldPlan){
                smokingPremium = SMOKING_GOLD_PREMIUM;
            } else if (insurancePlan instanceof SilverPlan){
                smokingPremium = SMOKING_SILVER_PREMIUM;
            } else if (insurancePlan instanceof BronzePlan){
                smokingPremium = SMOKING_BRONZE_PREMIUM;
            }
        }
        if(age > OLD_AGE){
            if (insurancePlan instanceof PlatinumPlan){
                agePremium = OLD_PLATINUM_PREMIUM;
            } else if (insurancePlan instanceof GoldPlan){
                agePremium = OLD_GOLD_PREMIUM;
            } else if (insurancePlan instanceof SilverPlan){
                agePremium = OLD_SILVER_PREMIUM;
            } else if (insurancePlan instanceof BronzePlan){
                agePremium = OLD_BRONZE_PREMIUM;
            }
        }
        return smokingPremium + agePremium;
    }
}
