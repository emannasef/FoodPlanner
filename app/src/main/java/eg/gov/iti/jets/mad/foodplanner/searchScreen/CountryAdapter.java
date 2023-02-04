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

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{

    private final Context context;

    private List<country> countries;


    public CountryAdapter(Context context, List<country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.category_and_country_card, parent, false);
        CountryAdapter.ViewHolder myViewHolder = new CountryAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(countries.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return countries.size();
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

