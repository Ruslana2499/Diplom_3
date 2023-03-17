import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingToAccountTests extends TestsBase {
    private LoginPageObject loginPageObject = new LoginPageObject(driver);
    private HomePageObject homePageObject = new HomePageObject(driver);

    @Before
    public void setUp() {
        driver.get(Constants.HOME_PAGE_URL);
        homePageObject.clickAccountButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
    }

    @Test
    @DisplayName("тест переход в личный кабинет по клику на «Личный кабинет»")
    public void testSuccessfulRegistration() {
        homePageObject.clickLoginToButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.ACCOUNT_PAGE));
        Assert.assertEquals(Constants.ACCOUNT_PAGE, driver.getCurrentUrl());
    }
}
