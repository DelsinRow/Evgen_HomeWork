package Coding_Exercise_6.Coding_Exercise_7;

public class PlatinumPlan extends HealthInsurancePlan {

   public PlatinumPlan( double coverage, double discount){
         setCoverage(coverage / 100);
         setDiscount(discount);
      }

}
