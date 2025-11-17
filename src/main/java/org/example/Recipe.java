package org.example;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    //Fields
    private String title;
    private List<Ingredient> ingredients;
    private String instructions;
    //Constructors
    public Recipe(String title, List<Ingredient> ingredients, String instructions){
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.title = title;
    }

    public Recipe(List<Ingredient> ingredients){
        this.title = "Untitled Recipe";
        this.ingredients = ingredients;
        this.instructions = "";
    }

    public  Recipe(){
        this.title = "Untitled Recipe";
        this.ingredients = new ArrayList<>();
        this.instructions = "";
    }

    //Methods
    public String toString(){
        StringBuilder toString = new StringBuilder(this.title + "\n\n");
        if (this.instructions != null){
            for (Ingredient ingredient : this.ingredients){
                toString.append(ingredient.toString()).append("\n");
            }
        }
        else{
            toString.append("No ingredients listed.\n");
        }
        toString.append("\n").append(this.instructions);
        return toString.toString();
    }

    public List<Ingredient> getIngredients(){return ingredients;}

    public String getTitle(){return title;}

    public String getInstructions(){return instructions;}

    public void setTitle(String title){this.title = title;}

    public void setIngredients(List <Ingredient> ingredients){this.ingredients = ingredients;}

    public void setInstructions(String instructions) {this.instructions = instructions;}
}
