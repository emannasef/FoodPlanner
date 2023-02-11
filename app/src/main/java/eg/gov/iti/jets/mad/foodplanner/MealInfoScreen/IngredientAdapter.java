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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.R;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<String> ingredientArrayList;
    private ArrayList<String> measureArrayList;
    public IngredientAdapter(Context context, ArrayList<String> ingredientArrayList,ArrayList<String> measureArrayList) {
        this.context = context;
        this.ingredientArrayList = ingredientArrayList;
        this.measureArrayList=measureArrayList;
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
        holder.name.setText(ingredientArrayList.get(position));
        holder.quantity.setText(measureArrayList.get(position));
        Glide.with(context).load("https://www.themealdb.com/images/ingredients/"+ingredientArrayList.get(position)+ "-Small.png").apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return measureArrayList.size();
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
