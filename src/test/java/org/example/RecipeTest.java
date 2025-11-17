package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testToStringFull() {
        Ingredient flour = new Ingredient("flour", "cups", 2.5);
        Ingredient water = new Ingredient("water", "grams", 120.0);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(flour);
        ingredientList.add(water);
        String instructions = "These are the instructions.";

        Recipe recipe = new Recipe("Simple", ingredientList, instructions);

        String result = recipe.toString();

        assertEquals("Simple\n\nFlour: 2.5c, 300g\nWater: 0.51c, 120g\n\nThese are the instructions.", result);
    }

    @Test
    void getIngredients() {

        //Defining the recipe
        Ingredient flour = new Ingredient("flour", "cups", 2.5);
        Ingredient water = new Ingredient("water", "grams", 120.0);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(flour);
        ingredientList.add(water);
        String instructions = "These are the instructions.";
        Recipe recipe = new Recipe("Simple", ingredientList, instructions);

        //Setting up the test
        List <Ingredient> result = recipe.getIngredients();
        List <Ingredient> expected = new ArrayList<>();
        expected.add(flour);
        expected.add(water);

        //Executing the test
        assertEquals(expected, result);
    }

    @Test
    void getTitle() {
        //Defining the recipe
        List<Ingredient> ingredientList = new ArrayList<>();
        String instructions = "These are the instructions.";
        Recipe recipe = new Recipe("Simple", ingredientList, instructions);

        //Set up test
        String result = recipe.getTitle();
        String expected = "Simple";

        //Execute the test
        assertEquals(expected, result);
    }

    @Test
    void getInstructions() {
        //Defining the recipe
        List<Ingredient> ingredientList = new ArrayList<>();
        String instructions = "These are the instructions.";
        Recipe recipe = new Recipe("Simple", ingredientList, instructions);

        //Set up test
        String result = recipe.getInstructions();
        String expected = "These are the instructions.";

        //Execute the test
        assertEquals(expected, result);
    }
    @Test
    void setTitle(){
        Recipe recipe = new Recipe();
        recipe.setTitle("This Title");
        assertEquals("This Title", recipe.getTitle());
    }

    @Test
    void setIngredients(){
        Recipe recipe = new Recipe();
        List<Ingredient> ingredientList = new ArrayList<>();
        recipe.setIngredients(ingredientList);

        assertEquals(ingredientList, recipe.getIngredients());
    }
    @Test
    void setInstructions(){
        Recipe recipe = new Recipe();
        recipe.setInstructions("These are the instructions");
        assertEquals("These are the instructions", recipe.getInstructions());
    }

}