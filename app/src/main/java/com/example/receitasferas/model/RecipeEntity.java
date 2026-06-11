package com.example.receitasferas.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipes_favorites")
public class RecipeEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String imageUrl;
    private String ingredients;
    private String instructions;

    // Construtor
    public RecipeEntity(String title, String imageUrl, String ingredients, String instructions) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Getters e Setters (Necessários para o Room)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}