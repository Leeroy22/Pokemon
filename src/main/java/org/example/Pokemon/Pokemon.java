package org.example.Pokemon;



import java.util.List;

public class Pokemon {
    private String name;
    private int height ;
    private int weight ;
    private int moves;
    private int baseExperience;


    public Pokemon(String name, int height, int weight, int moves, int baseExperience) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExperience =baseExperience ;
        this.moves = moves;
    }
    public Pokemon() {
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", moves=" + moves +
                '}';
    }
}
