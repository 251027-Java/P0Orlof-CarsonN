package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
    //Fields
    private String title;
    private List<Page> pages;

    //Constructors
    public RecipeBook(String title, List<Page> pages){
        this.title = title;
        this.pages = pages;
    }

    //Constructors
    public RecipeBook(String title){
        this.title = title;
        this.pages = new ArrayList<>();
    }

    public RecipeBook(){
        this.title = "Untitled Book";
        this.pages = new ArrayList<>();
    }

    //Methods

    public String getTableOfContents(){
        StringBuilder tableOfContents = new StringBuilder("Table of Contents\n\n");
        if (this.pages == null){
            return tableOfContents.toString();
        }
        else{
            for (Page page : this.pages){
                tableOfContents.append(page.getName()).append("\tp.").append(page.getPageNumber()).append("\n");
            }
            return tableOfContents.toString();
        }
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addRecipe(Recipe recipe, int pageNumber){
        if (pageNumber < 1 || pageNumber > pages.size() + 1) {
            throw new IllegalArgumentException("Invalid page number.");
        }
        Page newPage = new Page(pageNumber, recipe);
        this.pages.add(pageNumber-1, newPage);

        for (int i = pageNumber; i < pages.size(); i++) {
            pages.get(i).setPageNumber(i + 1);
        }
    }

    public void addRecipe(Recipe recipe){
        int pageNum = this.pages.size() + 1;
        Page newPage = new Page(pageNum, recipe);
        this.pages.add(newPage);
    }

    public Recipe getRecipe(int pageNum){
        if (pageNum < 1 || pageNum > pages.size()) {
            throw new IllegalArgumentException("Invalid page number.");
        }
        return this.pages.get(pageNum - 1).getRecipe();
    }

}
