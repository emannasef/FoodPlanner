package eg.gov.iti.jets.mad.foodplanner.searchScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.Ingredient;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.IngredientAdapter;
import eg.gov.iti.jets.mad.foodplanner.MealPlan.Week;
import eg.gov.iti.jets.mad.foodplanner.R;

public class IngredientImagesAdapter extends RecyclerView.Adapter<IngredientImagesAdapter.ViewHolder>{

    private final Context context;

    private List<IngredientImg> ingredients;

    igredientClickListener igredientClickListener;

    public IngredientImagesAdapter(Context context, List<IngredientImg> ingredients,igredientClickListener igredientClickListener) {
        this.context = context;
        this.ingredients = ingredients;
        this.igredientClickListener=igredientClickListener;
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
        holder.imageView.setImageResource(ingredients.get(position).getImageId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                igredientClickListener.onIngrediantClick(ingredients.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public interface igredientClickListener{
        void onIngrediantClick(IngredientImg ingredientImg);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.ingredient_imageView);
            rowLayout=itemView.findViewById(R.id.ingredientCard);

        }
    }
}

