package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen;

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
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favoriteMeal;
import eg.gov.iti.jets.mad.foodplanner.searchScreen.category;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{

    private final Context context;

    private List<resultSearch> resultSearches;

    ResultMealClickListener resultMealClickListener;

    public ResultAdapter(Context context, List<resultSearch> resultSearches,ResultMealClickListener resultMealClickListener) {
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
        holder.imageView.setImageResource(resultSearches.get(position).getImageId());
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
        void onresultMealClick(resultSearch obj);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.result_ImageView);
            rowLayout=itemView.findViewById(R.id.result_card);

        }
    }
}

