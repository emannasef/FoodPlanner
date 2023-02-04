package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen;

public class Ingredient {
    String quantity;
    String name ;
    int imageId;

    public Ingredient(String quantity, String name, int imageId) {
        this.quantity = quantity;
        this.name = name;
        this.imageId = imageId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
