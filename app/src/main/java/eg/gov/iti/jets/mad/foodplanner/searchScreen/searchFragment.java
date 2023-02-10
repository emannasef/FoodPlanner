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
import android.widget.Toast;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.ResultSearchActivity;

public class searchFragment extends Fragment implements Network_Delegate, CountryClickListener, IngredientClickListener {

    RecyclerView recyclerView;
    RecyclerView category_recyclerView;
    categoryAdapter categoryAdapter;
    RecyclerView country_recyclerView;
    CountryAdapter countryAdapter;
    IngredientImagesAdapter ingredientAdapter;
    EditText search_editText;

    Api_Client api_client;
    ArrayList<Meal> countries = new ArrayList();
    ArrayList<Meal> ingredients = new ArrayList();

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
        api_client = Api_Client.getInstance();

        api_client.getAreaCall(this);
        api_client.getIngredientCall(this);

        recyclerView = view.findViewById(R.id.ingredient_recycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager ingredientLayoutManager = new LinearLayoutManager(getContext());
        ingredientLayoutManager.setOrientation(ingredientLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(ingredientLayoutManager);

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


        ArrayList categories = new ArrayList<category>();
        category categories1 = new category(R.drawable.welcome_original_img);
        category categories2 = new category(R.drawable.welcome_original_img);
        category categories3 = new category(R.drawable.welcome_original_img);
        category categories4 = new category(R.drawable.welcome_original_img);
        category categories5 = new category(R.drawable.welcome_original_img);
        category categories6 = new category(R.drawable.welcome_original_img);
        category categories7 = new category(R.drawable.welcome_original_img);
        category categories8 = new category(R.drawable.welcome_original_img);
        category categories9 = new category(R.drawable.welcome_original_img);

        categories.add(categories1);
        categories.add(categories2);
        categories.add(categories3);
        categories.add(categories4);
        categories.add(categories5);
        categories.add(categories6);
        categories.add(categories7);
        categories.add(categories8);
        categories.add(categories9);
        categoryAdapter = new categoryAdapter(getContext(), categories, new categoryAdapter.categoryClickListener() {
            @Override
            public void onCategoryClick(category obj) {
                Intent i = new Intent(getContext(), ResultSearchActivity.class);
                startActivity(i);
            }
        });
        category_recyclerView.setAdapter(categoryAdapter);

        ingredientAdapter = new IngredientImagesAdapter(getContext(), ingredients, this);
        recyclerView.setAdapter(ingredientAdapter);

        countryAdapter = new CountryAdapter(getContext(), countries, this);
        country_recyclerView.setAdapter(countryAdapter);

        search_editText = view.findViewById(R.id.search_EditText);
        search_editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Intent i = new Intent(getContext(), ResultSearchActivity.class);
                    startActivity(i);
                }
                return false;
            }
        });

    }

    @Override
    public void onSuccessResult(ArrayList<Meal> myMeal) {
        for (Meal ingredient : myMeal) {
            //   System.out.println("################"+ingredient.strIngredient);
            if (ingredient.strIngredient != null) {
                ingredients.add(ingredient);
                ingredientAdapter.notifyDataSetChanged();
            }
        }
        for (Meal country : myMeal) {
            // System.out.println(country);
            countries.add(country);
            countryAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onFailureResult(String errorMessage) {

    }

    @Override
    public void onCountryClick(Meal country) {
        Intent intent = new Intent(getContext(), ResultSearchActivity.class);
        intent.putExtra("countryName", country.strArea);
        intent.putExtra("searchType","countryName");
        // System.out.println("##############"+country.strArea);
        startActivity(intent);
    }

    @Override
    public void onIngredientClick(Meal ingredient) {

        Toast.makeText(getContext(), ingredient.strIngredient, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ResultSearchActivity.class);
        intent.putExtra("ingredientName", ingredient.strIngredient);
        intent.putExtra("searchType","ingredientName");
        startActivity(intent);
    }
}