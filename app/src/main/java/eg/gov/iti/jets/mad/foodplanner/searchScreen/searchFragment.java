package eg.gov.iti.jets.mad.foodplanner.searchScreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.Ingredient;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.IngredientAdapter;
import eg.gov.iti.jets.mad.foodplanner.R;

public class searchFragment extends Fragment {

    EditText search;
    RecyclerView recyclerView;
    RecyclerView category_recyclerView;
    categoryAdapter categoryAdapter;
    RecyclerView country_recyclerView;
    CountryAdapter countryAdapter;
    IngredientImagesAdapter ingredientAdapter;
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
        IngredientImg ingredient1 = new IngredientImg( R.drawable.garlic);
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
        ingredientAdapter = new IngredientImagesAdapter(getContext(), input);
        recyclerView.setAdapter(ingredientAdapter);

        categoryAdapter = new categoryAdapter(getContext(), categories);
        category_recyclerView.setAdapter(categoryAdapter);

        countryAdapter = new CountryAdapter(getContext(), countries);
        country_recyclerView.setAdapter(countryAdapter);
        search=view.findViewById(R.id.search_EditText);

    }
}