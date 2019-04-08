package com.zintrulcre.RecipeFinder.repository;

import com.zintrulcre.RecipeFinder.domain.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link Finder} {@link Repository}
 */
@Repository
public class FinderRepository {

    // memory storage
    private final ConcurrentMap<Integer, Finder> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * save Item object
     *
     * @param item_part {@link Recipe} object
     * @return <code>true</code> if succeed
     * <code>false</code> if failed
     */
    private Item ParseItemPart(String item_part) {
        String[] part = item_part.split(",");
        Item item = new Item(part[0], Integer.parseInt(part[1]), Unit.valueOf(part[2]), part[3]);
        return item;
    }

    /**
     * save Item objects
     *
     * @param item_strings {@link Recipe} object
     * @return <code>true</code> if succeed
     * <code>false</code> if failed
     */
    public ArrayList<Item> SaveItems(String item_strings) {
        ArrayList<Item> items = new ArrayList<>();
        String[] item_string = item_strings.split("\n");
        for (String item_part : item_string) {
            Item item = ParseItemPart(item_part);
            items.add(item);
        }
        return items;
    }


    /**
     * save Recipe object
     *
     * @param recipe_object {@link Recipe} object
     * @return <code>true</code> if succeed
     * <code>false</code> if failed
     */
    private Recipe ParseRecipeObject(JSONObject recipe_object) {

        String name = (String) recipe_object.get("name");
        JSONArray ingredients_array = (JSONArray) recipe_object.get("ingredients");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        for (int j = 0; j < ingredients_array.size(); ++j) {
            JSONObject ingredient_object = (JSONObject) (ingredients_array.get(j));
            String item = (String) ingredient_object.get("item");
            int amount = Integer.parseInt((String) ingredient_object.get("amount"));
            Unit unit = (Unit) Unit.valueOf((String) ingredient_object.get("unit"));
            ingredients.add(new Ingredient(item, amount, unit));
        }
        Recipe recipe = new Recipe(name, ingredients);
        int id = idGenerator.incrementAndGet();
        recipe.setId(id);
        return recipe;
    }


    /**
     * save Recipe objects
     *
     * @param recipes_array {@link Recipe} object
     * @return <code>true</code> if succeed
     * <code>false</code> if failed
     */
    public ArrayList<Recipe> SaveRecipes(JSONArray recipes_array) throws ParseException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < recipes_array.size(); ++i) {
            JSONObject recipe_object = (JSONObject) (recipes_array.get(i));
            recipes.add(ParseRecipeObject(recipe_object));
        }
        return recipes;
    }

    public Pack Find(JSONObject jsonObject) throws ParseException {
        ArrayList<Recipe> recipes = SaveRecipes((JSONArray)jsonObject.get("recipes"));
        ArrayList<Item> items = SaveItems((String) jsonObject.get("items_in_fridge"));
        Collections.sort(items);
        System.out.println(recipes);
        System.out.println(items);

        return new Pack(recipes, items);
    }

    public Collection<Finder> FindAllFinders() {
        return repository.values();
    }
}