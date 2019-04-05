package com.zintrulcre.RecipeFinder.config;

import com.zintrulcre.RecipeFinder.domain.Recipe;
import com.zintrulcre.RecipeFinder.repository.RecipeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * router function configuration
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * request: ServletRequest or HTTPServletRequest
     * response: ServletResponse or HTTPServletResponse
     */
    @Bean
    public RouterFunction<ServerResponse> FindAllRecipe(RecipeRepository recipeRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/recipe/all"), request -> {
            Collection<Recipe> recipes = recipeRepository.FindAllRecipes();
            Flux<Recipe> recipeFlux = Flux.fromIterable(recipes);
            return ServerResponse.ok().body(recipeFlux, Recipe.class);
        });
    }
}
