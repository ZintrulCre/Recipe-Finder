package com.zintrulcre.RecipeFinder.controller;

import com.zintrulcre.RecipeFinder.domain.Ingredient;
import com.zintrulcre.RecipeFinder.domain.Recipe;
import com.zintrulcre.RecipeFinder.repository.RecipeRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/recipe/save")
    public ArrayList<Recipe> save(@RequestBody String recipe_string) throws ParseException {

        ArrayList<Recipe> recipes = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        JSONArray recipes_array = (JSONArray) jsonParser.parse(recipe_string);
        for (int i = 0; i < recipes_array.size(); ++i) {
            JSONObject recipes_object = (JSONObject) (recipes_array.get(i));
            String name = (String) recipes_object.get("name");
            JSONArray ingredients_array = (JSONArray) recipes_object.get("ingredients");

            ArrayList<Ingredient> ingredients = new ArrayList<>();
            for (int j = 0; j < ingredients_array.size(); ++j) {
                JSONObject ingredient_object = (JSONObject) (ingredients_array.get(j));
                String item = (String) ingredient_object.get("item");
                int amount = Integer.parseInt((String) ingredient_object.get("amount"));
                Ingredient.Unit unit = (Ingredient.Unit) Ingredient.Unit.valueOf((String) ingredient_object.get("unit"));
                ingredients.add(new Ingredient(item, amount, unit));
            }

            recipes.add(new Recipe(name, ingredients));
        }

        if (recipeRepository.save(recipes)) {
            System.out.printf("Recipe \"%s\" successfully saved!\n", recipes);
        }
        return recipes;
    }
}
