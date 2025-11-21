package org.example.Service;

import org.example.Page;
import org.example.Recipe;
import org.example.RecipeBook;
import org.example.Repository.IRepository;

import java.util.List;

public class RecipeBookService {

    //Fields
    private final IRepository repository;
    private RecipeBook recipeBook;

    public RecipeBookService(IRepository repository){
        this.repository = repository;
        this.recipeBook = new RecipeBook("My Sourdough Recipe Book");
    }

    public void loadBook(){
        RecipeBook loaded = repository.loadBook();
        if(loaded != null){
            this.recipeBook = loaded;
        }
    }

    public void setRecipeBook(RecipeBook book){
        this.recipeBook = book;
        repository.saveBook(recipeBook);
    }

    public void printBook(){
        IO.println(this.recipeBook.toString());
    }

    public void saveBook(){
        repository.saveBook(recipeBook);
    }

    public void addRecipe(Recipe recipe)
    {
        validateRecipe(recipe);

        repository.addRecipe(recipeBook, recipe);
    }

    public void addRecipeAtPage(int pageNumber, Recipe recipe){
        validateRecipe(recipe);
        validatePage(pageNumber);

        recipeBook.addRecipe(recipe, pageNumber);
        repository.saveBook(recipeBook);
    }

    public List<Page> getPages(){
        return recipeBook.getPages();
    }


    public Recipe getRecipe(int PageNumber){
        return recipeBook.getRecipe(PageNumber);
    }


    //Validation
    public void validateRecipe(Recipe recipe){
        if(recipe == null){
            throw new IllegalArgumentException("Recipe cannot be empty.");
        }
        if (recipe.getTitle() == null){
            throw new IllegalArgumentException("Recipe must have a title");
        }
    }

    public void validatePage(int pageNum){
        if (pageNum < 1 || pageNum > recipeBook.getPages().size()) {
            throw new IllegalArgumentException("Invalid page number: " + pageNum);
        }
    }

}
