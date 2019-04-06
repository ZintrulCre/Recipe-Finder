package com.zintrulcre.RecipeFinder.domain;

import java.util.ArrayList;

public class Pack {
    private ArrayList<Recipe> recipes;
    private ArrayList<Item> items;

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public Pack(ArrayList<Recipe> recipes, ArrayList<Item> items) {
        this.recipes = recipes;
        this.items = items;
    }
}
