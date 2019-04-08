package com.zintrulcre.RecipeFinder.controller;

import com.zintrulcre.RecipeFinder.domain.*;
import com.zintrulcre.RecipeFinder.repository.FinderRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
public class FinderController {

    private final FinderRepository finderRepository;
    private ArrayList<Recipe> recipes;

    @Autowired
    public FinderController(FinderRepository finderRepository) {
        this.finderRepository = finderRepository;
    }

    @PostMapping(value = "/recipe-finder/query", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {"application/json; charset=UTF-8"})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String Save(@RequestBody String jsonString) throws ParseException {
        System.out.println(jsonString);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        Pack pack = this.finderRepository.Find(jsonObject);
        String recipe = Match(pack);
        if (!recipe.equals(""))
            return recipe;
        return "Order Takeout";
    }

    private String Match(Pack pack) {
        ArrayList<Recipe> recipes = pack.getRecipes();
        ArrayList<Item> items = pack.getItems();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String[] dates = dateFormat.format(date).split("-");
        String year = dates[2], month = dates[1], day = dates[0];

        HashMap<String, Integer> item_map = new HashMap<String, Integer>();
        for (Item item : items) {
            if (CompareDate(item, dates)) {
                item_map.put(item.getItem(), item.getAmount());
                String recipe = CheckAvailability(recipes, item_map);
                if (!recipe.equals(""))
                    return recipe;
            }
        }
        return "";
    }

    private String CheckAvailability(ArrayList<Recipe> recipes, HashMap<String, Integer> item_map) {
        for (Recipe recipe : recipes) {
            boolean flag = true;
            for (Ingredient ingredient : recipe.getIngredients()) {
                boolean storage = item_map.containsKey(ingredient.getItem());
                if (!storage || ingredient.getAmount() > item_map.get(ingredient.getItem())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return recipe.getName();
        }
        return "";
    }

    private boolean CompareDate(Item item, String[] dates) {
        if (item.getYear() < Integer.parseInt(dates[2]))
            return false;
        if (item.getMonth() < Integer.parseInt(dates[1]))
            return false;
        if (item.getDay() < Integer.parseInt(dates[0]))
            return false;
        return true;
    }


}
