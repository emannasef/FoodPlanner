package eg.gov.iti.jets.mad.foodplanner.searchScreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.ResultSearchActivity;

public class searchFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView category_recyclerView;
    categoryAdapter categoryAdapter;
    RecyclerView country_recyclerView;
    CountryAdapter countryAdapter;
    IngredientImagesAdapter ingredientAdapter;
    EditText search_editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.ingredient_recycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(layoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        category_recyclerView = view.findViewById(R.id.category_recycleView);
        category_recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager_category = new LinearLayoutManager(getContext());
        layoutManager_category.setOrientation(layoutManager_category.HORIZONTAL);
        category_recyclerView.setLayoutManager(layoutManager_category);

        country_recyclerView = view.findViewById(R.id.country_recycleView);
        country_recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager_country = new LinearLayoutManager(getContext());
        layoutManager_country.setOrientation(layoutManager_country.HORIZONTAL);
        country_recyclerView.setLayoutManager(layoutManager_country);

        ArrayList input = new ArrayList<IngredientImg>();
        IngredientImg ingredient1 = new IngredientImg( R.drawable.welcome_original_img);
        IngredientImg ingredient2 = new IngredientImg( R.drawable.onion);
        IngredientImg ingredient3 = new IngredientImg( R.drawable.garlic);
        IngredientImg ingredient4 = new IngredientImg( R.drawable.garlic);
        IngredientImg ingredient5 = new IngredientImg( R.drawable.onion);
        IngredientImg ingredient6 = new IngredientImg( R.drawable.garlic);
        IngredientImg ingredient7 = new IngredientImg( R.drawable.garlic);
        IngredientImg ingredient8 = new IngredientImg( R.drawable.onion);
        IngredientImg ingredient9 = new IngredientImg( R.drawable.garlic);

        input.add(ingredient1);
        input.add(ingredient2);
        input.add(ingredient3);
        input.add(ingredient4);
        input.add(ingredient5);
        input.add(ingredient6);
        input.add(ingredient7);
        input.add(ingredient8);
        input.add(ingredient9);

        ArrayList categories = new ArrayList<category>();
        category categories1 = new category( R.drawable.welcome_original_img);
        category categories2 = new category( R.drawable.welcome_original_img);
        category categories3 = new category( R.drawable.welcome_original_img);
        category categories4 = new category( R.drawable.welcome_original_img);
        category categories5 = new category( R.drawable.welcome_original_img);
        category categories6 = new category( R.drawable.welcome_original_img);
        category categories7 = new category( R.drawable.welcome_original_img);
        category categories8 = new category( R.drawable.welcome_original_img);
        category categories9 = new category( R.drawable.welcome_original_img);

        categories.add(categories1);
        categories.add(categories2);
        categories.add(categories3);
        categories.add(categories4);
        categories.add(categories5);
        categories.add(categories6);
        categories.add(categories7);
        categories.add(categories8);
        categories.add(categories9);


        ArrayList countries = new ArrayList<country>();
        country country1 = new country( R.drawable.welcome_original_img);
        country country2 = new country( R.drawable.welcome_original_img);
        country country3 = new country( R.drawable.welcome_original_img);
        country country4 = new country( R.drawable.welcome_original_img);
        country country5 = new country( R.drawable.welcome_original_img);
        country country6 = new country( R.drawable.welcome_original_img);
        country country7 = new country( R.drawable.welcome_original_img);
        country country8 = new country( R.drawable.welcome_original_img);
        country country9 = new country( R.drawable.welcome_original_img);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);
        countries.add(country6);
        countries.add(country7);
        countries.add(country8);
        countries.add(country9);
        ingredientAdapter = new IngredientImagesAdapter(getContext(), input, new IngredientImagesAdapter.igredientClickListener() {
            @Override
            public void onIngrediantClick(IngredientImg ingredientImg) {
                Intent i = new Intent(getContext(),ResultSearchActivity.class);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(ingredientAdapter);

        categoryAdapter = new categoryAdapter(getContext(), categories, new categoryAdapter.categoryClickListener() {
            @Override
            public void onCategoryClick(category obj) {
                Intent i = new Intent(getContext(),ResultSearchActivity.class);
                startActivity(i);
            }
        });
        category_recyclerView.setAdapter(categoryAdapter);

        countryAdapter = new CountryAdapter(getContext(), countries, new CountryAdapter.countryClickListener() {
            @Override
            public void onCountryClick(country obj) {
                Intent i = new Intent(getContext(),ResultSearchActivity.class);
                startActivity(i);
            }
        });
        country_recyclerView.setAdapter(countryAdapter);

        search_editText=view.findViewById(R.id.search_EditText);
        search_editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    Intent i =new Intent(getContext(), ResultSearchActivity.class);
                    startActivity(i);
                }
                return false;
            }
        });

    }
}