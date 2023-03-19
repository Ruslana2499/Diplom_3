import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.burgers.common.Constants;
import ru.praktikum.burgers.pageobjects.AccountPageObject;
import ru.praktikum.burgers.pageobjects.HomePageObject;
import ru.praktikum.burgers.pageobjects.LoginPageObject;

public class RedirectFromAccountToConstructorTests extends TestsBase {
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
    @DisplayName("тест переход по клику на «Конструктор» из личного кабинета")
    public void testClickTheConstructor() {
        homePageObject.clickLoginToButton();
        accountPageObject.clickConstructorButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("тест переход по клику на логотип Stellar Burgers из личного кабинета")
    public void testClickLogo() {
        homePageObject.clickLoginToButton();
        accountPageObject.clickLogo();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }
}
