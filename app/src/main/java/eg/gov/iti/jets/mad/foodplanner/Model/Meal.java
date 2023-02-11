package eg.gov.iti.jets.mad.foodplanner.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
@Entity(tableName = "Meal")
public class Meal {
    @PrimaryKey
    @ColumnInfo(name = "ID")
    @NonNull
    public String idMeal;

    @ColumnInfo(name = "MealName")
    public String strMeal;

    @ColumnInfo(name = "MealCategory")
    public String strCategory;
    @ColumnInfo(name = "MealIngredient")
    public String strIngredient;

    @ColumnInfo(name = "MealArea")
    public String strArea;

    @ColumnInfo(name = "MealInstructions")
    public String strInstructions;

    @ColumnInfo(name = "MealThumb")
    public String strMealThumb;

    @ColumnInfo(name = "MealTags")
    public String strTags;

    @ColumnInfo(name = "MealYoutube")
    public String strYoutube;

    @ColumnInfo(name = "MealIngredient1")
    public String strIngredient1;

    @ColumnInfo(name = "MealIngredient2")
    public String strIngredient2;

    @ColumnInfo(name = "MealIngredient3")
    public String strIngredient3;

    @ColumnInfo(name = "MealIngredient4")
    public String strIngredient4;

    @ColumnInfo(name = "MealIngredient5")
    public String strIngredient5;

    @ColumnInfo(name = "MealIngredient6")
    public String strIngredient6;

    @ColumnInfo(name = "MealIngredient7")
    public String strIngredient7;

    @ColumnInfo(name = "MealIngredient8")
    public String strIngredient8;

    @ColumnInfo(name = "MealIngredient9")
    public String strIngredient9;

    @ColumnInfo(name = "MealIngredient10")
    public String strIngredient10;

    @ColumnInfo(name = "MealIngredient11")
    public String strIngredient11;

    @ColumnInfo(name = "MealIngredient12")
    public String strIngredient12;

    @ColumnInfo(name = "MealIngredient13")
    public String strIngredient13;

    @ColumnInfo(name = "MealIngredient14")
    public String strIngredient14;

    @ColumnInfo(name = "MealIngredient15")
    public String strIngredient15;

    @ColumnInfo(name = "MealIngredient16")
    public String strIngredient16;

    @ColumnInfo(name = "MealIngredient17")
    public String strIngredient17;

    @ColumnInfo(name = "MealIngredient18")
    public String strIngredient18;

    @ColumnInfo(name = "MealIngredient19")
    public String strIngredient19;

    @ColumnInfo(name = "MealIngredient20")
    public String strIngredient20;


    @ColumnInfo(name = "MealMeasure1")
    public String strMeasure1;

    @ColumnInfo(name = "MealMeasure2")
    public String strMeasure2;

    @ColumnInfo(name = "MealMeasure3")
    public String strMeasure3;

    @ColumnInfo(name = "MealMeasure4")
    public String strMeasure4;

    @ColumnInfo(name = "MealMeasure5")
    public String strMeasure5;

    @ColumnInfo(name = "MealMeasure6")
    public String strMeasure6;

    @ColumnInfo(name = "MealMeasure7")
    public String strMeasure7;

    @ColumnInfo(name = "MealMeasure8")
    public String strMeasure8;

    @ColumnInfo(name = "MealMeasure9")
    public String strMeasure9;

    @ColumnInfo(name = "MealMeasure10")
    public String strMeasure10;

    @ColumnInfo(name = "MealMeasure11")
    public String strMeasure11;

    @ColumnInfo(name = "MealMeasure12")
    public String strMeasure12;

    @ColumnInfo(name = "MealMeasure13")
    public String strMeasure13;

    @ColumnInfo(name = "MealMeasure14")
    public String strMeasure14;

    @ColumnInfo(name = "MealMeasure15")
    public String strMeasure15;

    @ColumnInfo(name = "MealMeasure16")
    public String strMeasure16;

    @ColumnInfo(name = "MealMeasure17")
    public String strMeasure17;

    @ColumnInfo(name = "MealMeasure18")
    public String strMeasure18;

    @ColumnInfo(name = "MealMeasure19")
    public String strMeasure19;

    @ColumnInfo(name = "MealMeasure20")
    public String strMeasure20;

    @ColumnInfo(name = "MealUserEmail")
    public String userEmail;

    @ColumnInfo(name = "MealIsFav")
    public boolean isFav;

}



