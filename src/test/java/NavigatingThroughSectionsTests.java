import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.burgers.common.Constants;
import ru.praktikum.burgers.pageobjects.HomePageObject;

public class NavigatingThroughSectionsTests extends TestsBase {
    private HomePageObject homePageObject = new HomePageObject(driver);

    @Before
    public void setUp() {
        driver.get(Constants.HOME_PAGE_URL);
    }

    @Test
    @DisplayName("тест клик по «Соусы»")
    public void testGoToSaucesSection() {
        homePageObject.clickSaucesTab();
        Assert.assertTrue(homePageObject.isSaucesTabSelected());
    }

    @Test
    @DisplayName("тест клик по «Начинки»")
    public void testGoToFillingsSection() {
        homePageObject.clickFillingsTab();
        Assert.assertTrue(homePageObject.isFillingsTabSelected());
    }

    @Test
    @DisplayName("тест клик по «Булки»")
    public void testGoToBunsSection() {
        homePageObject.clickSaucesTab();
        homePageObject.clickBunsTab();
        Assert.assertTrue(homePageObject.isBunsTabSelected());
    }

}
