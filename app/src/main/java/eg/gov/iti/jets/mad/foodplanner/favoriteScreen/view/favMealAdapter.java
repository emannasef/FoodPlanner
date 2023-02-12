package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view;

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

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.R;

public class favMealAdapter extends RecyclerView.Adapter<favMealAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> favoriteMeals;
    OnFavoriteClickListener onFavoriteClickListener;
   public void setList(List<Meal> updatedMeals)
   {
       this.favoriteMeals = updatedMeals;
   }
    public favMealAdapter(Context context,OnFavoriteClickListener onFavoriteClickListener) {
        this.context = context;
        this.onFavoriteClickListener =onFavoriteClickListener;
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
        Meal meal=favoriteMeals.get(position);
        Glide.with(context)
                .load(favoriteMeals.get(position).strMealThumb)
                .apply(new RequestOptions()
                        .override(150, 150)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.imageView);
        holder.name_TextView.setText(favoriteMeals.get(position).strMeal);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFavoriteClickListener.onImageClick(holder.name_TextView.getText().toString());
            }
        });
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFavoriteClickListener.ondeleteClick(meal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteMeals.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ConstraintLayout rowLayout;
        public View v;
        TextView name_TextView;
        ImageView deleteImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.favMeal_ImageView);
            rowLayout=itemView.findViewById(R.id.fav_card);
            deleteImageView=itemView.findViewById(R.id.deleteFromFav_imageView);
            name_TextView=itemView.findViewById(R.id.favName_textView);
        }
    }
}

