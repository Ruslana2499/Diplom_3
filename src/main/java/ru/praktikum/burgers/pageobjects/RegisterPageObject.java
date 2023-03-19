package ru.praktikum.burgers.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject {
    private WebDriver driver;

    private final By formLoginLink = By.linkText("Войти"); //ссылка "Войти" на страницах: «Регистрация», «Восстановление пароля»
    private final By registrationButton = By.xpath("//*[contains(@class, 'button_button__33qZ0')]"); //кнопка «Зарегистрироваться»
    private final By registrationFormInputError = By.className("input__error"); //блок с ошибкой
    private final By registrationFormInputEmail = By.cssSelector("fieldset + fieldset input"); //поле ввода email страница «Регистрация»
    private final By registrationFormInputName = By.name("name"); //поле ввода имени страница «Регистрация»
    private final By registrationFormInputPassword = By.name("Пароль"); //поле ввода пароля страница «Регистрация»

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fill(String name, String email, String password) {
        driver.findElement(registrationFormInputName).sendKeys(name);
        driver.findElement(registrationFormInputEmail).sendKeys(email);
        driver.findElement(registrationFormInputPassword).sendKeys(password);
    }

    public void submit() {
        driver.findElement(registrationButton).click();
    }

    public String getErrorText() {
        if (driver.findElement(registrationFormInputError).isDisplayed()) {
            return driver.findElement(registrationFormInputError).getText();
        }
        return null;
    }

    public void clickLoginButton() {
        driver.findElement(formLoginLink).click();
    }
}
