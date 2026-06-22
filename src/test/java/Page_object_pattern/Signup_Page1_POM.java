package Page_object_pattern;

import Base.Base_Page1;
import Practice.SignupTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup_Page1_POM extends Base_Page1 {
    public Signup_Page1_POM(WebDriver driver) {
        this.driver = driver;
    }

    By registerAgencyText = By.xpath("//*[contains(text(),'Register Your Agency')]");
    By termsCheckbox = By.xpath("//*[@id=\"remember\"]");
    By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    By accountSetupTitle = By.xpath("//*[contains(text(),'Provide your personal details')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By email = By.name("email");
    By phone = By.xpath("//input[@name='phoneNumber']");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By nextButton = By.xpath("//button[contains(text(),'Next')]");

    public boolean isTermsPageDisplayed() {
        return driver.findElement(registerAgencyText).isDisplayed();
    }

    public void acceptTerms() {
        driver.findElement(termsCheckbox).click();
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();

    }
    public boolean isAccountSetupDisplayed(){
        return driver.findElement(accountSetupTitle).isDisplayed();
    }
    public void enterFirstName(String value) {
        driver.findElement(firstName)
                .sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName)
                .sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email)
                .sendKeys(value);
    }

    public void enterPhone(String value) {
        driver.findElement(phone)
                .sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password)
                .sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword)
                .sendKeys(value);
    }

    public void clickNext() {
        driver.findElement(nextButton)
                .click();
    }
}


