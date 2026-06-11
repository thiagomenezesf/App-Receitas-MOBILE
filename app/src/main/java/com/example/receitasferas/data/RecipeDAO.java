package com.example.receitasferas.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.exemplo.appreceitas.model.RecipeEntity;
import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void insertFavorite(RecipeEntity recipe);

    @Delete
    void deleteFavorite(RecipeEntity recipe);

    @Query("SELECT * FROM recipes_favorites")
    List<RecipeEntity> getAllFavorites();

    @Query("SELECT EXISTS(SELECT * FROM recipes_favorites WHERE title = :recipeTitle)")
    boolean isFavorite(String recipeTitle);
}
