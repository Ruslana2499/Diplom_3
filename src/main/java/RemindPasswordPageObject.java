import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemindPasswordPageObject {
    private WebDriver driver;
    private final By formLoginLink = By.linkText("Войти"); //ссылка "Войти" на страницах: «Регистрация», «Восстановление пароля»
    public RemindPasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLoginButton() {
        driver.findElement(formLoginLink).click();
    }
}
