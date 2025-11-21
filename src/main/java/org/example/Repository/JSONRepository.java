package org.example.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Page;
import org.example.Recipe;
import org.example.RecipeBook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONRepository implements IRepository{
    //Fields
    private String filename;
    private final Gson gson;

    //Constructor
    public JSONRepository() {
        this("recipes.json");   // default JSON file
    }

    public JSONRepository(String filename) {
        this.filename = filename;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    //Methods
    @Override
    public RecipeBook loadBook(){
        try(FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, RecipeBook.class);
        }catch(FileNotFoundException e){
            return null;
        }catch(IOException e){
            throw new RuntimeException("Error saving recipe book.");
        }
    }

    @Override
    public void saveBook(RecipeBook recipeBook){
        try(FileWriter writer = new FileWriter(filename)){
            gson.toJson(recipeBook, writer);
        }catch(IOException e){
            throw new RuntimeException("Error saving the recipe book.");
        }
    }


    @Override
    public void addRecipe(RecipeBook recipeBook, Recipe recipe) {
        recipeBook.addRecipe(recipe);
        saveBook(recipeBook);
    }

    @Override
    public void readPage(int pageNum) {
        RecipeBook book = loadBook();
        if(book == null ||  pageNum < 1 || pageNum>book.getPages().size()){
            IO.println("Invalid page number");
            return;
        }
        Page page = book.getPages().get(pageNum-1);
        IO.println(page.toString());
    }

    @Override
    public Recipe getRecipe(int pageNum) {
        RecipeBook book = loadBook();
        if(book == null || pageNum <1 || pageNum > book.getPages().size()){
            return null;
        }
        return book.getPages().get(pageNum-1).getRecipe();
    }
}
