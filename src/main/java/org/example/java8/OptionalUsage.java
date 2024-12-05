package org.example.java8;

import java.util.Optional;

public class OptionalUsage {


    public static void main(String[] args) {

        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//        insuranceOptional.get();

        Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
        insuranceOptional1.get();

        Optional<Insurance> objectOptional1 = Optional.ofNullable(null);
        objectOptional1.orElseGet(Insurance::new);

        objectOptional1.orElse(new Insurance());

        objectOptional1.orElseThrow(RuntimeException::new);

        objectOptional1.orElseThrow(()->new RuntimeException("not have reference"));


    }

}
