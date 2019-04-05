package com.zintrulcre.RecipeFinder.domain;

public class Finder {
    Item item;
    Recipe recipe;

    public Finder(Item item, Recipe recipe) {
        this.item = item;
        this.recipe = recipe;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
