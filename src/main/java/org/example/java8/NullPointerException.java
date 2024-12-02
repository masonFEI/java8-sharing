package org.example.java8;

public class NullPointerException {


    public static void main(String[] args) {
//        String insuranceName = getInsuranceName(new Person());
//        System.out.println(insuranceName);
        String insuranceNameByDeepDoubts = getInsuranceNameByDeepDoubts(new Person());
        System.out.println(insuranceNameByDeepDoubts);
    }


    private static String getInsuranceNameByDeepDoubts(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if(null != car){
                Insurance insurance = car.getInsurance();
                if(null != insurance){
                    return insurance.getName();
                }
            }
        }
        return "UNKNOWN";
    }


    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }


}
