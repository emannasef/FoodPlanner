package eg.gov.iti.jets.mad.foodplanner.searchScreen;

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

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder>{

    private final Context context;

    private List<category> categories;


    public categoryAdapter(Context context, List<category> categories) {
        this.context = context;
        this.categories = categories;
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
        holder.imageView.setImageResource(categories.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ConstraintLayout rowLayout;
        public View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView=itemView.findViewById(R.id.category_contry_ImageView);
            rowLayout=itemView.findViewById(R.id.category_country_card);

        }
    }
}

