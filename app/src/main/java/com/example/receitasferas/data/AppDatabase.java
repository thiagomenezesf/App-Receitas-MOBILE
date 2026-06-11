package com.example.receitasferas.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.receitasferas.model.RecipeEntity;

@Database(entities = {RecipeEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract RecipeDao recipeDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "recipe_database")
                            .fallbackToDestructiveMigration() // Recria o banco se mudar a estrutura
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}