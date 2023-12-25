package com.example.freefood.classes;

public class DataProduct {
    float proteins;
    float fats;
    float carb;
    float cal;
    float gram;

    public DataProduct( float proteins, float fats, float carb, float cal, float gram) {
        this.proteins = proteins;
        this.fats = fats;
        this.carb = carb;
        this.cal = cal;
        this.gram = gram;
    }



    public float getProteins() {
        return proteins;
    }

    public float getFats() {
        return fats;
    }

    public float getCarb() {
        return carb;
    }

    public float getCal() {
        return cal;
    }

    public float getGram() {
        return gram;
    }
}
