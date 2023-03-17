import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPageObject {
    private WebDriver driver;
    private final By headerConstructorLink = By.xpath("//*[contains(@class, 'AppHeader_header__link__3D_hX')]"); //ссылка Конструктор (переход на главную страницу)
    private final By headerLogoLink = By.cssSelector(".AppHeader_header__logo__2D0X2 a"); //логотип Stellar Burgers (переход на главную страницу)
    private final By accountPageLogoutButton = By.className ("Account_button__14Yp3");//кнопка «Выйти» в личном кабинете
    public AccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(headerConstructorLink).click();
    }

    public void clickLogo() {
        driver.findElement(headerLogoLink).click();
    }
    public void clickLogout() {
        driver.findElement(accountPageLogoutButton).click();
    }
}
