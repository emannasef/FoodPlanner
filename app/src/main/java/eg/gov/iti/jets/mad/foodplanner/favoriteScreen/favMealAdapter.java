package eg.gov.iti.jets.mad.foodplanner.favoriteScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.searchScreen.category;

public class favMealAdapter extends RecyclerView.Adapter<favMealAdapter.ViewHolder>{

    private final Context context;

    private List<favoriteMeal> favoriteMeals;


    public favMealAdapter(Context context, List<favoriteMeal> favoriteMeals) {
        this.context = context;
        this.favoriteMeals = favoriteMeals;
    }

    @NonNull
    @Override
    public favMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_card, parent, false);
        favMealAdapter.ViewHolder myViewHolder = new favMealAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull favMealAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(favoriteMeals.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return favoriteMeals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.favMeal_ImageView);
            rowLayout=itemView.findViewById(R.id.fav_card);

        }
    }
}

