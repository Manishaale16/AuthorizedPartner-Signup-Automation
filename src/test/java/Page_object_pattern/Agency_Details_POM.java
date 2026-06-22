package Page_object_pattern;

import Base.Base_Page1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Agency_Details_POM extends Base_Page1 {
    public Agency_Details_POM(WebDriver driver) {
        this.driver = driver;
    }

    By agencyPageTitle = By.xpath("//*[contains(text(),'About your Agency')]");
    By agencyName = By.xpath("//input[@placeholder='Enter Agency Name']");
    By roleInAgency = By.xpath("//input[@placeholder='Enter Your Role in Agency']");
    By agencyEmail = By.xpath("//input[@placeholder='Enter Your Agency Email Address']");
    By website = By.xpath("//input[contains(@placeholder,'Agency Website')]");
    By address = By.xpath("//input[@placeholder='Enter Your Agency Address']");
    By regionDropdown = By.xpath("//button[@role='combobox']");
    By nextButton = By.xpath("//button[contains(text(),'Next')]");


    public boolean isAgencyPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(agencyPageTitle)).isDisplayed();
    }

    public void enterAgencyName(String value) {
        driver.findElement(agencyName).sendKeys(value);
    }

    public void enterRoleInAgency(String value) {
        driver.findElement(roleInAgency).sendKeys(value);
    }

    public void enterAgencyEmail(String value) {
        driver.findElement(agencyEmail).sendKeys(value);
    }

    public void enterWebsite(String value) {
        driver.findElement(website).sendKeys(value);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void clickRegionDropdown() {
        driver.findElement(regionDropdown).click();
    }

    public void selectRegion(String region) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(regionDropdown).click();
        By regionOption = By.xpath("//span[normalize-space()='" + region + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(regionOption)).click();
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}