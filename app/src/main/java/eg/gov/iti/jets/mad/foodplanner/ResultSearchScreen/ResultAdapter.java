package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen;

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
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.R;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{

    private final Context context;

    private ArrayList<Meal> resultSearches;

    ResultMealClickListener resultMealClickListener;

    public ResultAdapter(Context context, ArrayList<Meal> resultSearches, ResultMealClickListener resultMealClickListener) {
        this.context = context;
        this.resultSearches = resultSearches;
        this.resultMealClickListener=resultMealClickListener;
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
        Glide.with(context).load(resultSearches.get(position).strMealThumb).apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(holder.imageView);
        holder.mealName.setText(resultSearches.get(position).strMeal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultMealClickListener.onresultMealClick(resultSearches.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultSearches.size();
    }
    public interface ResultMealClickListener{
        void onresultMealClick(Meal obj);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView mealName;
        public ConstraintLayout rowLayout;
        public View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            mealName=itemView.findViewById(R.id.resultName_textView);
            imageView=itemView.findViewById(R.id.result_ImageView);
            rowLayout=itemView.findViewById(R.id.result_card);

        }
    }
}

