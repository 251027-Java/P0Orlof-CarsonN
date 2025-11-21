package org.example.Repository;

import org.example.Recipe;
import org.example.RecipeBook;

public interface IRepository {
    public void addRecipe(Recipe recipe);
    public RecipeBook loadBook();
    public void saveBook(RecipeBook recipeBook);
    public void readPage(int pageNum);
    public Recipe getRecipe(int pageNum);
}
