/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import java.util.Optional;

/**
 * OptionalInAction
 *
 * @author ccjohnny.fei
 * @version 1.0.0
 * @since 2024-12-08 21:01
 */
public class OptionalInAction {


    public static void main(String[] args) {
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);
    }


    private static String getInsuranceNameByOptional(Person person){
        return Optional.ofNullable(person)
                .flatMap(Person::getCar).flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
    }

}