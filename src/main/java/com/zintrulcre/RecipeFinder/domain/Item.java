package com.zintrulcre.RecipeFinder.domain;

import com.zintrulcre.RecipeFinder.domain.Unit;

import java.util.Comparator;

public class Item implements Comparable {
    private String item;
    private int amount;
    private Unit unit;
    private int year;
    private int month;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;

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

    public Item(String item, int amount, Unit unit, String use_by) {
        this.item = item;
        this.amount = amount;
        this.unit = unit;
        String date[] = use_by.split("/");
        this.year = Integer.parseInt(date[2]);
        this.month = Integer.parseInt(date[1]);
        this.day = Integer.parseInt(date[0]);
    }


    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", amount=" + amount +
                ", unit=" + unit +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.year < ((Item) o).year ? -1 : (this.month < ((Item) o).month ? -1 : (this.day < ((Item) o).day ? -1 : 1));
    }
}
