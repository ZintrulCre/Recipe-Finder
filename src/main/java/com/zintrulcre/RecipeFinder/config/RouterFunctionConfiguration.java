package com.zintrulcre.RecipeFinder.config;

import com.zintrulcre.RecipeFinder.domain.Finder;
import com.zintrulcre.RecipeFinder.domain.Item;
import com.zintrulcre.RecipeFinder.repository.FinderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

public class RouterFunctionConfiguration  {

    @Bean
    public RouterFunction<ServerResponse> FindAllFinder(FinderRepository finderRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/recipe-finder/query"), request -> {
            Collection<Finder> finders = finderRepository.FindAllFinders();
            Flux<Finder> finderFlux = Flux.fromIterable(finders);
            return ServerResponse.ok().body(finderFlux, Finder.class);
        });
    }
}
