package org.example;

public class Page {
    //Fields
    private int pageNumber;
    private Recipe recipe;

    //Constructors
    public Page(int pageNumber, Recipe recipe){
        this.pageNumber = pageNumber;
        this.recipe = recipe;
    }

    public Page(int pageNumber){
        this.pageNumber = pageNumber;
        this.recipe = null;
    }

    //Methods

    public String toString(){
        return "Page: " + this.pageNumber + "\n" + this.recipe.toString();
    }

    public int getPageNumber(){return this.pageNumber;}

    public Recipe getRecipe(){return this.recipe;}

    public void setPageNumber(int pageNumber){this.pageNumber = pageNumber;}

    public void setRecipe(Recipe recipe) {this.recipe = recipe;}
}
