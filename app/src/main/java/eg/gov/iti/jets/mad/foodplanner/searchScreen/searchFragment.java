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
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view.ResultSearchActivity;

public class searchFragment extends Fragment implements Network_Delegate, CountryClickListener, IngredientClickListener ,CategoryClickListener {


    RecyclerView ingredient_recyclerView;
    RecyclerView category_recyclerView;
    RecyclerView country_recyclerView;
    categoryAdapter categoryAdapter;
    CountryAdapter countryAdapter;
    IngredientImagesAdapter ingredientAdapter;
    EditText search_editText;
    Api_Client api_client;
    List<Meal> countries = new ArrayList();
    List<Meal> ingredients = new ArrayList();

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

        api_client=Api_Client.getInstance();
        api_client.categoryCall(this);
        api_client.getAreaCall(this);
        api_client.getIngredientCall(this);

        ingredient_recyclerView = view.findViewById(R.id.ingredient_recycleView);
        ingredient_recyclerView.setHasFixedSize(true);
        LinearLayoutManager ingredientLayoutManager = new LinearLayoutManager(getContext());
        ingredientLayoutManager.setOrientation(ingredientLayoutManager.HORIZONTAL);
        ingredient_recyclerView.setLayoutManager(ingredientLayoutManager);

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


        ingredientAdapter = new IngredientImagesAdapter(getContext(), ingredients, this);
        ingredient_recyclerView.setAdapter(ingredientAdapter);

        countryAdapter = new CountryAdapter(getContext(), countries, this);
        country_recyclerView.setAdapter(countryAdapter);

        search_editText = view.findViewById(R.id.search_EditText);
        search_editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    Intent i =new Intent(getContext(), ResultSearchActivity.class);
                    i.putExtra("searchType","name");
                    i.putExtra("searchName",search_editText.getText().toString());
                    startActivity(i);
                }
                return false;
            }
        });
    }

    @Override
    public void onSuccessResult(List<Meal> myMeal) {
        for (Meal ingredient : myMeal) {
            //   System.out.println("################"+ingredient.strIngredient);
            if (ingredient.strIngredient != null) {
                ingredients.add(ingredient);
                ingredientAdapter.notifyDataSetChanged();
            }
        }
        for (Meal country : myMeal) {
            // System.out.println(country);

            if (countries.size()<=26){
                countries.add(country);
                countryAdapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    public void onSuccessCategoryResult(List<Category> categories) {
        categoryAdapter = new categoryAdapter(getContext(), categories,this);
        category_recyclerView.setAdapter(categoryAdapter);
    }
    @Override
    public void onFailureResult(String errorMessage) {

    }
    @Override
    public void onCountryClick(Meal country) {
        Intent intent = new Intent(getContext(), ResultSearchActivity.class);
        intent.putExtra("countryName", country.strArea);
        intent.putExtra("searchType","country");
        // System.out.println("##############"+country.strArea);
        startActivity(intent);
    }

    @Override
    public void onIngredientClick(Meal ingredient) {

        Toast.makeText(getContext(), ingredient.strIngredient, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ResultSearchActivity.class);
        intent.putExtra("ingredientName", ingredient.strIngredient);
        intent.putExtra("searchType","ingredient");
        startActivity(intent);
    }

    @Override
    public void onCategoryClick(Category obj) {
        Intent i = new Intent(getContext(),ResultSearchActivity.class);
        i.putExtra("searchType","category");
        i.putExtra("searchCategory",obj.strCategory);
        startActivity(i);
    }
}