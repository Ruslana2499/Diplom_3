import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
    private WebDriver driver;

    private final By loginFormInputEmail = By.name("name"); //поле ввода email на странице «Вход»
    private final By loginFormInputPassword = By.name("Пароль"); //поле ввода пароля на странице «Вход»

    private final By formSubmitButton = By.xpath("//*[contains(@class, 'button_button__33qZ0')]"); //кнопка «Войти» на странице «Вход»

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fill(String email, String password) {
        driver.findElement(loginFormInputEmail).sendKeys(email);
        driver.findElement(loginFormInputPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(formSubmitButton).click();
    }
}
