package org.example.java8;

import java.util.Optional;

public class OptionalUsage {


    public static void main(String[] args) {

        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
        insuranceOptional.get();
    }

}
