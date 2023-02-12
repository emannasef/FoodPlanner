package eg.gov.iti.jets.mad.foodplanner.MealPlan.view;

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

import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.R;


public class ThursdayAdapter extends RecyclerView.Adapter<ThursdayAdapter.ViewHolder>{

    private final Context context;
    private List<MealPlan> thursdayMeals;
    OnDayClickListener onDayClickListener;

    public void setThursdayList(List<MealPlan> updatedThursdayMeals)
    {
        this.thursdayMeals = updatedThursdayMeals;
    }

    public ThursdayAdapter(Context context, OnDayClickListener onDayClickListener) {
        this.context = context;
        this.onDayClickListener = onDayClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.plan_card_row, parent, false);
        ThursdayAdapter.ViewHolder myViewHolder = new ThursdayAdapter.ViewHolder(v);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealPlan mealPlan=thursdayMeals.get(position);
        Glide.with(context)
                .load(thursdayMeals.get(position).strMealThumb)
                .apply(new RequestOptions()
                        .override(150, 150)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.mealImageView);

        holder.mealNameTextView.setText(thursdayMeals.get(position).strMeal);
        holder.deleteMealImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayClickListener.onDayDeleteClick(mealPlan);
            }
        });
        holder.mealImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayClickListener.onImageClick(holder.mealNameTextView.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return thursdayMeals.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public View v;
        public ConstraintLayout rowLayout;
        public ImageView mealImageView;
        public TextView mealNameTextView;
        public ImageView deleteMealImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v=itemView;
            rowLayout = itemView.findViewById(R.id.plan_card_row);
            mealImageView = itemView.findViewById(R.id.mealPlan_ImageView);
            mealNameTextView=itemView.findViewById(R.id.mealNameInMealPlan_textView);
            deleteMealImageView=itemView.findViewById(R.id.deleteFromMealPlan_imageView);

        }
    }
}
