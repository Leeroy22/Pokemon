package org.example.PokemonController;

import org.example.Pokemon.Pokemon;
import org.example.Service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name){
        try {
            return PokemonService.getPokemonData(name);
        }catch (Exception e){
            throw new RuntimeException("failed to fetch Pokemon data");
        }
    }
}
