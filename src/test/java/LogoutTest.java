import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest extends TestsBase{
    private LoginPageObject loginPageObject = new LoginPageObject(driver);
    private HomePageObject homePageObject = new HomePageObject(driver);
    private AccountPageObject accountPageObject = new AccountPageObject(driver);

    @Before
    public void setUp() {
        driver.get(Constants.HOME_PAGE_URL);
        homePageObject.clickAccountButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
    }
    @Test
    @DisplayName("тест выход из аккаунта")
    public void testLogout() {
        homePageObject.clickLoginToButton();
        accountPageObject.clickLogout();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.LOGIN_URL));
        Assert.assertEquals(Constants.LOGIN_URL, driver.getCurrentUrl());
    }
}
