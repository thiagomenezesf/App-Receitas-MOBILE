package com.example.receitasferas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.receitasferas.adapter.RecipeAdapter;
import com.example.receitasferas.model.RecipeEntity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecipeAdapter adapter;
    private List<RecipeEntity> recipeList;    // CORRIGIDO: Era aqui o erro do List duplo!
    private List<RecipeEntity> temporaryList;   // Lista que usaremos para filtrar na busca

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Vincular componentes do XML
        RecyclerView recyclerView = findViewById(R.id.recyclerViewRecipes);
        SearchView searchView = findViewById(R.id.searchView);

        // 2. Criar dados Fictícios (Mock) para testar a interface da Entrega 2
        temporaryList = new ArrayList<>();
        temporaryList.add(new RecipeEntity("Bolo de Cenoura", "", "Cenoura...", "Asse..."));
        temporaryList.add(new RecipeEntity("Lasanha de Carne", "", "Massa, Carne...", "Monte..."));
        temporaryList.add(new RecipeEntity("Panqueca de Frango", "", "Frango, Farinha...", "Frite..."));
        temporaryList.add(new RecipeEntity("Brigadeiro Gourmet", "", "Leite condensado, Cacau...", "Mexa..."));

        // Guardamos uma cópia na lista original para a busca funcionar
        recipeList = new ArrayList<>(temporaryList);

        // 3. Configurar o RecyclerView com o Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(temporaryList);
        recyclerView.setAdapter(adapter);

        // 4. Configurar a Lógica de Busca (SearchView)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarReceitas(newText);
                return true;
            }
        });
    }

    // Método simples para filtrar a lista conforme o usuário digita
    private void filtrarReceitas(String texto) {
        temporaryList.clear();
        if (texto.isEmpty()) {
            temporaryList.addAll(recipeList);
        } else {
            for (RecipeEntity recipe : recipeList) {
                if (recipe.getTitle().toLowerCase().contains(texto.toLowerCase())) {
                    temporaryList.add(recipe);
                }
            }
        }
        adapter.notifyDataSetChanged(); // Atualiza a lista na tela
    }
}