import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
    private WebDriver driver;
    private final By indexPageLoginAccountButton = By.xpath("//*[contains(@class, 'button_button__33qZ0')]"); //кнопка «Войти в аккаунт» на главной странице
    private final By indexPageAccountLink = By.linkText("Личный Кабинет"); //кнопка «Личный Кабинет» на главной странице

    private final By constructorSectionBuns = By.xpath("//*[contains(@class, 'tab_tab__')][1]"); //первый элемент конструктора «Булки»
    private final By constructorSectionSauces = By.xpath("//*[contains(@class, 'tab_tab__')][2]"); //второй элемент конструктора «Соусы»
    private final By constructorSectionFillings = By.xpath("//*[contains(@class, 'tab_tab__')][3]"); //третий элемент конструктора «Начинки»

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountButton() {
        driver.findElement(indexPageLoginAccountButton).click();
    }

    public void clickLoginToButton() {
        driver.findElement(indexPageAccountLink).click();
    }

    public void clickBunsTab() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(constructorSectionBuns));
        driver.findElement(constructorSectionBuns).click();
    }

    public void clickSaucesTab() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(constructorSectionSauces));
        driver.findElement(constructorSectionSauces).click();
    }

    public void clickFillingsTab() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(constructorSectionFillings));
        driver.findElement(constructorSectionFillings).click();
    }

    public boolean isBunsTabSelected() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.attributeContains(driver.findElement(constructorSectionBuns), "class", "tab_tab_type_current__2BEPc"));
        return driver.findElement(constructorSectionBuns)
                .getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    public boolean isFillingsTabSelected() {
        return driver.findElement(constructorSectionFillings)
                .getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    public boolean isSaucesTabSelected() {
        return driver.findElement(constructorSectionSauces)
                .getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

}
