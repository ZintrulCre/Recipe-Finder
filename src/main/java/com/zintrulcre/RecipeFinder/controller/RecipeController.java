package com.zintrulcre.RecipeFinder.controller;

import com.zintrulcre.RecipeFinder.domain.Ingredient;
import com.zintrulcre.RecipeFinder.domain.Recipe;
import com.zintrulcre.RecipeFinder.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostMapping("/Recipe/save")
    public Recipe save(@RequestParam String name, @RequestParam ArrayList<Ingredient> ingredients) {
        Recipe recipe = new Recipe(name, ingredients);
        if (recipeRepository.save(recipe)) {
            System.out.printf("Save recipe %s succeed!\n", name);
        }
        return recipe;
    }
}
