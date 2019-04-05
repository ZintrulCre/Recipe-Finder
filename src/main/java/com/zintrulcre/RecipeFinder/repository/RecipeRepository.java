package com.zintrulcre.RecipeFinder.repository;

import com.zintrulcre.RecipeFinder.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link Recipe} {@link Repository}
 */

@Repository
public class RecipeRepository {

    // memory storage
    private final ConcurrentMap<Integer, Recipe> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * save Recipe object
     *
     * @param recipe {@link Recipe} object
     * @return <code>true</code> if succeed
     * <code>false</code> if failed
     */
    public boolean save(Recipe recipe) {
        int id = idGenerator.incrementAndGet();
        recipe.setId(id);
        return repository.put(id, recipe) == null;
    }
}
