package org.example.java8;

import java.util.Optional;

public class OptionalUsage {


    public static void main(String[] args) {

        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//        insuranceOptional.get();

        Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
//        insuranceOptional1.get();
//
//        Optional<Insurance> objectOptional1 = Optional.ofNullable(null);
//        objectOptional1.orElseGet(Insurance::new);
//
//        objectOptional1.orElse(new Insurance());
//
//        objectOptional1.orElseThrow(RuntimeException::new);
//
//        objectOptional1.orElseThrow(()->new RuntimeException("not have reference"));

//        Insurance insurance = insuranceOptional1.filter(i -> i.getName() == null).get();
//        System.out.println(insurance);
        Optional<String> nameOptional = insuranceOptional1.map(i -> i.getName());
        System.out.println(nameOptional.orElse("empty value"));
        System.out.println(nameOptional.isPresent());
        nameOptional.ifPresent(System.out::println);

        System.out.println(getInsuranceByOptional(null));

    }


    private static String getInsuranceName(Insurance insurance) {
        if (null == insurance) {
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceByOptional(Insurance insurance){
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }

}
