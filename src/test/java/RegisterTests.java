import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.burgers.common.Constants;
import ru.praktikum.burgers.pageobjects.RegisterPageObject;

import java.util.Random;

public class RegisterTests extends TestsBase {
    private RegisterPageObject registerPageObject = new RegisterPageObject(driver);

    @Before
    public void setUp() {
        driver.get(Constants.REGISTRATION_PAGE);
    }

    @Test
    @DisplayName("тест успешной регистрации")
    public void testSuccessfulRegistration() {
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        registerPageObject.fill("РусланаHeckfyf", "ruslanamanbatchurina" + randomNumber + "@yandex.ru", "12345!2№324");
        registerPageObject.submit();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(Constants.LOGIN_URL));
        Assert.assertEquals(Constants.LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("тест ошибки для некорректного пароля")
    public void testPasswordTwoCharactersEntered() {
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        registerPageObject.fill("РусланаHeckfyf", "ruslanamanbatchurina" + randomNumber + "@yandex.ru", "123");
        registerPageObject.submit();
        Assert.assertEquals("Некорректный пароль", registerPageObject.getErrorText());
    }
}
