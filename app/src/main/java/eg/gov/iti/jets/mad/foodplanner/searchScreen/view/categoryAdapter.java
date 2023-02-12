package eg.gov.iti.jets.mad.foodplanner.searchScreen.view;

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

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.R;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder>{

    private final Context context;

    private List<Category> categoryArrayList;

    CategoryClickListener categoryClickListener;

    public categoryAdapter(Context context, List<Category> categoryArrayList,CategoryClickListener categoryClickListener) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
        this.categoryClickListener=categoryClickListener;
    }

    @NonNull
    @Override
    public categoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.category_and_country_card, parent, false);
        categoryAdapter.ViewHolder myViewHolder = new categoryAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter.ViewHolder holder, int position) {
        Category catecoryMeal=categoryArrayList.get(position);
        Glide.with(context).load(categoryArrayList.get(position).strCategoryThumb).apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(holder.imageView);
        holder.textView.setText(categoryArrayList.get(position).strCategory);
        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickListener.onCategoryClick(catecoryMeal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public ConstraintLayout rowLayout;
        public View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.category_contry_ImageView);
            textView=itemView.findViewById(R.id.category_contry_textView);
            rowLayout=itemView.findViewById(R.id.category_country_card);

        }
    }
}

