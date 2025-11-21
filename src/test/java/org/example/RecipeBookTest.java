package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBookTest {

    RecipeBook recipeBook = new RecipeBook("New Book");
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
    void getTitle(){
        assertEquals("New Book", recipeBook.getTitle());
    }

    @Test
    void setTitle(){
        recipeBook.setTitle("Another Book");
        assertEquals("Another Book", recipeBook.getTitle());
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
    public void testAddRecipeAtSpecificPageRenumbersFollowingPages() {
        RecipeBook book = new RecipeBook("My Book");

        Recipe recipe1 = new Recipe("Sourdough", new ArrayList<>(), "Step 1");
        Recipe recipe2 = new Recipe("Focaccia", new ArrayList<>(), "Step 1");
        Recipe recipeNew = new Recipe("Inserted Recipe", new ArrayList<>(), "Step X");

        book.addRecipe(recipe1);
        book.addRecipe(recipe2);

        book.addRecipe(recipeNew, 2);

        List<Page> pages = book.getPages();
        assertEquals(3, pages.size(), "There should be 3 pages after insertion.");

        assertEquals(1, pages.get(0).getPageNumber());
        assertEquals(recipe1, pages.get(0).getRecipe());

        assertEquals(2, pages.get(1).getPageNumber());
        assertEquals(recipeNew, pages.get(1).getRecipe());

        assertEquals(3, pages.get(2).getPageNumber());
        assertEquals(recipe2, pages.get(2).getRecipe());
    }


}