import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTests extends TestsBase {
    private RegisterPageObject registerPageObject = new RegisterPageObject(driver);
    private LoginPageObject loginPageObject = new LoginPageObject(driver);
    private HomePageObject homePageObject = new HomePageObject(driver);
    private RemindPasswordPageObject remindPasswordPageObject = new RemindPasswordPageObject(driver);

    @Before
    public void setUp() {
        driver.get(Constants.HOME_PAGE_URL);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginAccountUsingLoginToAccountButton() {
        homePageObject.clickAccountButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("тест вход через кнопку «Личный кабинет»")
    public void testLoginAccountUsingPersonalAccountButton() {
        homePageObject.clickLoginToButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void testLoginAccountUsingButtonInRegistrationForm() {
        driver.get(Constants.REGISTRATION_PAGE);
        registerPageObject.clickLoginButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("тест вход через кнопку в форме восстановления пароля")
    public void testLoginAccountUsingButtonInThePasswordRecoveryForm() {
        driver.get(Constants.REMIND_PASSWORD_PAGE);
        remindPasswordPageObject.clickLoginButton();
        loginPageObject.fill("ruslanamanbatchurina05098@yandex.ru", "12345!2№324");
        loginPageObject.clickLoginButton();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.HOME_PAGE_URL));
        Assert.assertEquals(Constants.HOME_PAGE_URL, driver.getCurrentUrl());
    }
}
