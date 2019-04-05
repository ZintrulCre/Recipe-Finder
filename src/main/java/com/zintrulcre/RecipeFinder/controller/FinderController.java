package com.zintrulcre.RecipeFinder.controller;

import com.zintrulcre.RecipeFinder.domain.Finder;
import com.zintrulcre.RecipeFinder.repository.FinderRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class FinderController {

    private final FinderRepository finderRepository;

    @Autowired
    public FinderController(FinderRepository finderRepository) {
        this.finderRepository = finderRepository;
    }

    @PostMapping("/recipe/save")
    public boolean Save(@RequestBody String string) throws ParseException {
        int divide = string.indexOf("\n\n");
        String recipe_string = string.substring(0, divide + 1);
        String fridge_string = string.substring(divide + 2);
        System.out.println(recipe_string);
        System.out.println(fridge_string);
        boolean recipes_saved = this.finderRepository.Save(recipe_string, fridge_string);

//        return recipes_saved && items_saved;
        return true;
    }
}
