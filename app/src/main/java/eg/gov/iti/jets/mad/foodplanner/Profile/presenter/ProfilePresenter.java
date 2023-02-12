package eg.gov.iti.jets.mad.foodplanner.Profile.presenter;

import eg.gov.iti.jets.mad.foodplanner.Database.RepositoryInterface;

public class ProfilePresenter implements ProfilePresenterInterface {
    private RepositoryInterface repositoryInterface;

    public ProfilePresenter(RepositoryInterface repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public void addDataToFirebase(String mealName, String mealImage, String mealCountryName) {
        repositoryInterface.pushToFireStore(mealName,mealImage,mealCountryName);

    }
}
