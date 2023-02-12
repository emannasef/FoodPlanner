package eg.gov.iti.jets.mad.foodplanner.searchScreen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.R;

public class IngredientImagesAdapter extends RecyclerView.Adapter<IngredientImagesAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> ingredients;

    IngredientClickListener ingredientClickListener;

    public IngredientImagesAdapter(Context context, List<Meal> ingredients,IngredientClickListener ingredientClickListener) {
        this.context = context;
        this.ingredients = ingredients;
        this.ingredientClickListener=ingredientClickListener;
    }

    @NonNull
    @Override
    public IngredientImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.ingredient_card, parent, false);
        IngredientImagesAdapter.ViewHolder myViewHolder = new IngredientImagesAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientImagesAdapter.ViewHolder holder, int position) {
        Meal ingredient= ingredients.get(position);

        Glide.with(context).load("https://www.themealdb.com/images/ingredients/"+ingredients.get(position).strIngredient+ "-Small.png").apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(holder.ingredientImageView);
        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ingredientClickListener.onIngredientClick(ingredient);
           }
       });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ingredientImageView;
        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            ingredientImageView=itemView.findViewById(R.id.ingredient_imageView);
            rowLayout=itemView.findViewById(R.id.ingredientCard);
        }
    }
}

