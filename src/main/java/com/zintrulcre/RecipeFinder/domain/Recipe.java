package com.zintrulcre.RecipeFinder.domain;

// item model

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int id;

    private enum Unit {of, grams, ml, slices}

    private String name;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, String ingredients) {
        this.name = name;
        this.ingredients = StringtoIngredient(ingredients);
    }

    private ArrayList<Ingredient> StringtoIngredient(String string) {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        String[] elements = string.split("\n");
        for (int i = 0; i < string.length() / 3; ++i)
            ingredients.add(new Ingredient(elements[i * 3], Integer.parseInt(elements[i * 3 + 1]), Unit.valueOf(elements[i * 3 + 2])));
        return ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    private class Ingredient {

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
}

