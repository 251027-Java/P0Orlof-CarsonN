package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    @Test
    void testToString(){
        //Set up test
        Recipe recipe = new Recipe("Recipe", new ArrayList<>(), "These are the instructions");
        Page page = new Page(1, recipe);

        //Execute test
        String expected = "Page: 1\n" + recipe.toString();
        assertEquals(expected, page.toString());
    }

    @Test
    void getPageNumber() {
        //Set up test
        Recipe recipe = new Recipe("Recipe", new ArrayList<>(), "These are the instructions");
        Page page = new Page(1, recipe);

        //Execute test
        assertEquals(1, page.getPageNumber());
    }

    @Test
    void getRecipe() {
        //Set up test
        Recipe recipe = new Recipe("Recipe", new ArrayList<>(), "These are the instructions");
        Page page = new Page(1, recipe);

        //Execute test
        assertEquals(recipe, page.getRecipe());
    }

    @Test
    void setPageNumber() {
        //Set up test
        Page page = new Page(1);

        //Test criteria
        page.setPageNumber(2);

        //Execute test
        assertEquals(2, page.getPageNumber());
    }

    @Test
    void setRecipe() {
        //Set up test
        Page page = new Page(1);

        //Test criteria
        Recipe recipe = new Recipe("Recipe", new ArrayList<>(), "These are the instructions");
        page.setRecipe(recipe);

        assertEquals(recipe, page.getRecipe());
    }
}