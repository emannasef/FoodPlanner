package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view;

import static androidx.core.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{

    private final Context context;
    SharedPref sharedPref;
    private List<Meal> resultSearches;

    ResultMealClickListener resultMealClickListener;

    public ResultAdapter(Context context, List<Meal> resultSearches,ResultMealClickListener resultMealClickListener) {
        this.context = context;
        this.resultSearches = resultSearches;
        this.resultMealClickListener=resultMealClickListener;
        sharedPref=new SharedPref(context);
    }

    @NonNull
    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.search_result_card, parent, false);
        ResultAdapter.ViewHolder myViewHolder = new ResultAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ViewHolder holder, int position) {
        Meal result = resultSearches.get(position);
        Glide.with(context).load(resultSearches.get(position).strMealThumb).apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(holder.imageView);
        holder.nameResultTextView.setText(resultSearches.get(position).strMeal);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultMealClickListener.onImageClick(holder.nameResultTextView.getText().toString());
            }
        });


        holder.addToMealPlanImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.addToMealPlanImage.setImageResource(R.drawable.baseline_backup_24);
                PopupMenu popup = new PopupMenu(context, holder.addToMealPlanImage);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.days_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                        if (item.getTitle().equals("Sunday")) {
                         MealPlan myMealPlan= convertMeal("Sunday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }
                        else if (item.getTitle().equals("Monday")) {
                            MealPlan myMealPlan= convertMeal("Monday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }else if (item.getTitle().equals("Tuesday")) {
                            MealPlan myMealPlan= convertMeal("Tuesday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }else if (item.getTitle().equals("Wednesday")) {
                            MealPlan myMealPlan= convertMeal("Wednesday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }else if (item.getTitle().equals("Thursday")) {
                            MealPlan myMealPlan= convertMeal("Thursday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }else if (item.getTitle().equals("Friday")) {
                            MealPlan myMealPlan= convertMeal("Friday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }else if (item.getTitle().equals("Saturday")) {
                            MealPlan myMealPlan= convertMeal("Saturday",result);
                            Toast.makeText(context, myMealPlan.strMeal, Toast.LENGTH_SHORT).show();
                            resultMealClickListener.onAddToMealPlanClick(myMealPlan);
                        }
                        holder.addToMealPlanImage.setImageResource(R.drawable.add_icon);
                        return true;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultSearches.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameResultTextView;
        public ConstraintLayout rowLayout;
        public View v;

        public ImageView addToMealPlanImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.result_ImageView);
            rowLayout=itemView.findViewById(R.id.result_card);
            nameResultTextView= itemView.findViewById(R.id.resultName_textView);
            addToMealPlanImage=itemView.findViewById(R.id.addToMealPlan);
        }
    }


    MealPlan convertMeal(String day , Meal result){
        MealPlan mealPlan = new MealPlan();
        mealPlan.setDay(day);
        mealPlan.setStrArea(result.strArea);
        mealPlan.setStrInstructions(result.strInstructions);
        mealPlan.setStrIngredient1(result.strIngredient1);
        mealPlan.setStrIngredient1(result.strIngredient2);
        mealPlan.setStrIngredient1(result.strIngredient3);
        mealPlan.setStrIngredient1(result.strIngredient4);
        mealPlan.setStrIngredient1(result.strIngredient5);
        mealPlan.setStrIngredient1(result.strIngredient6);
        mealPlan.setStrIngredient1(result.strIngredient7);
        mealPlan.setStrIngredient1(result.strIngredient8);
        mealPlan.setStrIngredient1(result.strIngredient9);
        mealPlan.setStrIngredient1(result.strIngredient10);
        mealPlan.setStrMeasure1(result.strMeasure1);
        mealPlan.setStrMeasure1(result.strMeasure2);
        mealPlan.setStrMeasure1(result.strMeasure3);
        mealPlan.setStrMeasure1(result.strMeasure4);
        mealPlan.setStrMeasure1(result.strMeasure5);
        mealPlan.setStrMeasure1(result.strMeasure6);
        mealPlan.setStrMeasure1(result.strMeasure7);
        mealPlan.setStrMeasure1(result.strMeasure8);
        mealPlan.setStrMeasure1(result.strMeasure9);
        mealPlan.setStrMeasure1(result.strMeasure10);
        mealPlan.setUserEmail(sharedPref.read());
        mealPlan.setIdMeal(result.idMeal+day);
        mealPlan.setStrMeal(result.strMeal);
        mealPlan.setStrMealThumb(result.strMealThumb);
    return mealPlan;
    }
}

