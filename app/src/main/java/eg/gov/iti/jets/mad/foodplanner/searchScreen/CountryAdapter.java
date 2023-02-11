package eg.gov.iti.jets.mad.foodplanner.searchScreen;

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

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.R;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private final Context context;
    private List<Meal> countries;
    private CountryClickListener countryClickListener;

    public CountryAdapter(Context context, List<Meal> countries, CountryClickListener countryClickListener) {
        this.context = context;
        this.countries = countries;
        this.countryClickListener = countryClickListener;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.country_card, parent, false);
        CountryAdapter.ViewHolder myViewHolder = new CountryAdapter.ViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Meal country = countries.get(position);
        holder.countryName.setText(countries.get(position).strArea);

        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryClickListener.onCountryClick(country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;
        public ConstraintLayout rowLayout;
        public View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            rowLayout = itemView.findViewById(R.id.country_card);
            countryName = itemView.findViewById(R.id.country_textView);
        }
    }
}

