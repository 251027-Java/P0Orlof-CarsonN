package org.example.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Recipe;
import org.example.RecipeBook;

public class JSONRepository implements IRepository{
    //Fields
    private String filename;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //Constructor
    public JSONRepository(){}

    //Methods

    @Override
    public void addRecipe(RecipeBook recipeBook, Recipe recipe) {

    }

    @Override
    public RecipeBook loadBook() {
        return null;
    }

    @Override
    public void saveBook(RecipeBook recipeBook) {

    }

    @Override
    public void readPage(int pageNum) {

    }

    @Override
    public Recipe getRecipe(int pageNum) {
        return null;
    }
}
