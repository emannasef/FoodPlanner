package eg.gov.iti.jets.mad.foodplanner.MealPlan;

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
import eg.gov.iti.jets.mad.foodplanner.R;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.ViewHolder>{

    private final Context context;
    private List<Week> weeks;

    public MealPlanAdapter(Context context, List<Week> weeks) {
        this.context = context;
        this.weeks = weeks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.meal_plan_row, parent, false);
        MealPlanAdapter.ViewHolder myViewHolder = new MealPlanAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thisWeek.setText(weeks.get(position).getMyWeek());

    }

    @Override
    public int getItemCount() {
        return weeks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView thisWeek;
        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            thisWeek = itemView.findViewById(R.id.thisWeek);
            rowLayout=itemView.findViewById(R.id.mealPlanRow);

        }
    }
}
