package com.example.receitasferas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.receitasferas.R;
import com.example.receitasferas.model.RecipeEntity;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<RecipeEntity> recipeList;

    // Construtor do Adapter que receberá a lista de receitas
    public RecipeAdapter(List<RecipeEntity> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item (list_item_recipe.xml) que criamos antes
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        // Pega a receita na posição atual da lista
        RecipeEntity recipe = recipeList.get(position);

        // Joga o título da receita para o TextView da tela
        holder.txtTitle.setText(recipe.getTitle());

        // Por enquanto, na Entrega 2, a imagem e o coração ficam com o padrão do XML.
        // Na Entrega 3 e 4 mudaremos aqui para carregar as fotos da internet.
    }

    @Override
    public int getItemCount() {
        return recipeList != null ? recipeList.size() : 0;
    }

    // ViewHolder: Classe interna que mapeia os componentes visuais de cada item
    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgRecipe;
        ImageView imgFavorite;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtRecipeTitle);
            imgRecipe = itemView.findViewById(R.id.imgRecipe);
            imgFavorite = itemView.findViewById(R.id.imgFavoriteHeart);
        }
    }
}