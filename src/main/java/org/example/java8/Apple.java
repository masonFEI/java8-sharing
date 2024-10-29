package org.example.java8;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;


@Data
public class Apple {

    private String color;

    private long weight;

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
