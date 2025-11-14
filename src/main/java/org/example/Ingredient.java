package org.example;

import java.util.Map;

public class Ingredient {

    private static final Map<String, Double> DEFAULT_RATIOS = Map.of(
            "flour", 120.0,
            "water", 237.0,
            "salt", 288.0,
            "starter", 240.0,
            "sugar", 200
    );

    //Fields
    private String name;

    private float cups;

    private float grams;

    private double gramsToCupRatio;

    //Constructor
    private Ingredient (String name, String measurement, float amount){
        this.name = name;
        Double ratio = DEFAULT_RATIOS.get(name.toLowerCase());

        if (measurement.equalsIgnoreCase("cups")){
            this.cups = amount;
            this.grams = (float) (amount*ratio);
        } else if (measurement.equalsIgnoreCase("grams")){
            this.grams = amount;
            this.cups = (float) (amount/ratio);
        }
    }

    //Methods

    public String toString(){
        return null;
    }

    public float getCups(){
        return 0;
    }

    public float getGrams(){
        return 0;
    }
}
