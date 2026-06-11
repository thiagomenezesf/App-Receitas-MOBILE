package com.example.receitasferas;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.receitasferas.data.AppDatabase;
import com.example.receitasferas.data.RecipeDao;
import com.example.receitasferas.model.RecipeEntity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Vincula a Activity ao layout padrão (activity_main.xml)
        setContentView(R.layout.activity_main);

        // Testando a Entrega 1 em uma Thread separada (obrigatório para o Room)
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Inicializa o banco de dados
                    AppDatabase db = AppDatabase.getDatabase(MainActivity.this);
                    RecipeDao recipeDao = db.recipeDao();

                    // 1. Cria uma receita de teste
                    RecipeEntity testeReceita = new RecipeEntity(
                            "Bolo de Cenoura",
                            "url_da_imagem",
                            "Cenoura, Farinha, Ovo",
                            "Bata tudo no liquidificador e asse."
                    );

                    // 2. Insere no banco SQLite
                    recipeDao.insertFavorite(testeReceita);

                    // 3. Busca do banco para validar se foi salvo
                    List<RecipeEntity> favoritos = recipeDao.getAllFavorites();

                    // 4. Printa o resultado no Logcat do Android Studio
                    for (RecipeEntity r : favoritos) {
                        Log.d("ROOM_TESTE", "Receita Salva no SQLite: " + r.getTitle());
                    }
                } catch (Exception e) {
                    Log.e("ROOM_TESTE", "Erro ao acessar o banco: ", e);
                }
            }
        }).start();
    }
}