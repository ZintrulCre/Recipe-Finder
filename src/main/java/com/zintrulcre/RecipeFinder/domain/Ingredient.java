package com.zintrulcre.RecipeFinder.domain;

public class Ingredient {

    public enum Unit {of, grams, ml, slices}

    private String item;
    private int amount;
    private Unit unit;

    public Ingredient(String item, int amount, Unit unit) {
        this.item = item;
        this.amount = amount;
        this.unit = unit;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "item='" + item + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }
}