package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBookTest {

    RecipeBook recipeBook = new RecipeBook();
    List<Page> pages = new ArrayList<>();


    @BeforeEach
    void setUp(){
        //Set up the test
        Recipe recipe1 = new Recipe("Recipe1", new ArrayList<>(), "These are the instructions");
        Page page1 = new Page(1, recipe1);
        Recipe recipe2 = new Recipe("Recipe2", new ArrayList<>(), "These are also the instructions");
        Page page2 = new Page(2, recipe2);
        Recipe recipe3 = new Recipe("Recipe3", new ArrayList<>(), "These are finally the instructions");
        Page page3 = new Page(3, recipe3);

        pages.add(page1);
        pages.add(page2);
        pages.add(page3);

        recipeBook.setPages(pages);
    }

    @Test
    void getTableOfContents() {
        String expected = "Table of Contents\n\nRecipe1\tp.1\nRecipe2\tp.2\nRecipe3\tp.3\n";
        assertEquals(expected, recipeBook.getTableOfContents());

    }

    @Test
    void getPages() {
        assertEquals(pages, recipeBook.getPages());
    }

    @Test
    void setPages() {
        Recipe recipe1 = new Recipe("Recipe4", new ArrayList<>(), "These are the instructions");
        Page page1 = new Page(1, recipe1);
        Recipe recipe2 = new Recipe("Recipe5", new ArrayList<>(), "These are also the instructions");
        Page page2 = new Page(2, recipe2);
        Recipe recipe3 = new Recipe("Recipe6", new ArrayList<>(), "These are finally the instructions");
        Page page3 = new Page(3, recipe3);
        Recipe recipe4 = new Recipe("Recipe7", new ArrayList<>(), "These are finally the instructions");
        Page page4 = new Page(3, recipe4);


        List<Page> pages2 = new ArrayList<>();

        pages2.add(page1);
        pages2.add(page2);
        pages2.add(page3);
        pages2.add(page4);

        recipeBook.setPages(pages2);

        assertEquals(pages2, recipeBook.getPages());

    }

    @Test
    public void testAddRecipeCreatesPageWithCorrectNumberAndRecipe() {
        // Arrange
        RecipeBook book = new RecipeBook("My Book");
        Recipe recipe = new Recipe("Sourdough", new ArrayList<>(), "Mix and bake.");

        // Act
        book.addRecipe(recipe);

        // Assert
        List<Page> pages = book.getPages();
        assertEquals(1, pages.size(), "There should be exactly one page after adding a recipe.");

        Page firstPage = pages.getFirst();
        assertEquals(1, firstPage.getPageNumber(), "First page number should be 1.");
        assertEquals(recipe, firstPage.getRecipe(), "Page should contain the recipe that was added.");
    }


    @Test
    void addRecipe() {
    }
}