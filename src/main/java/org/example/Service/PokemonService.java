package org.example.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Pokemon.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;


import java.net.URL;

public class PokemonService {
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";

    public static Pokemon getPokemonData(String pokemonName) throws IOException {
        String pokemonURL= API_URL+pokemonName;

        URL url = new URL(pokemonURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        if (connection.getResponseCode()!=200){
            throw new RuntimeException("Failed to fetch data: HTTP error code"+ connection.getResponseCode());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

         while((line= reader.readLine())!=null){
                response.append(line);
            }
            reader.close();

         ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response.toString());

        String name =node.get("name").asText();
        int height =node.get("height").asInt();
        int weight= node.get("weight").asInt();
        int baseExperience = node.get("base_experience").asInt();
        int moves = node.get("moves").size();

        return new Pokemon(name,height,weight,baseExperience,moves);
    }


}
