package com.zintrulcre.RecipeFinder.domain;

import com.zintrulcre.RecipeFinder.domain.Unit;

public class Item {
    private String item;
    private int amount;
    private Unit unit;
    private String use_by;

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

    public String getUse_by() {
        return use_by;
    }

    public void setUse_by(String use_by) {
        this.use_by = use_by;
    }

    public Item(String item, int amount, Unit unit, String use_by) {
        this.item = item;
        this.amount = amount;
        this.unit = unit;
        this.use_by = use_by;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                ", use_by='" + use_by + '\'' +
                '}';
    }
}
