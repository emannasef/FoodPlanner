package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen;

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

import eg.gov.iti.jets.mad.foodplanner.R;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder>{

    private final Context context;

    private List<Ingredient> ingredients;


    public IngredientAdapter(Context context, List<Ingredient> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.ingredient_row_layout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quantity.setText(ingredients.get(position).getQuantity());
        holder.name.setText(ingredients.get(position).getName());
        holder.imageView.setImageResource(ingredients.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quantity;
        public TextView name;
        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            quantity = itemView.findViewById(R.id.ingredientQuantity);
            name = itemView.findViewById(R.id.ingredientName);
            imageView=itemView.findViewById(R.id.ingredientImage);
            rowLayout=itemView.findViewById(R.id.ingredientRow);

        }
    }

}
