package Page_object_pattern;

import Base.Base_Page1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Verification_Preferences_POM extends Base_Page1 {
    WebDriverWait wait;
    public Verification_Preferences_POM(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By pageTitle = By.xpath("//*[contains(text(),'Provide Business Details and Set Preferences')]");
    By registrationNumber = By.name("business_registration_number");
    By countryDropdown = By.xpath("//*[contains(text(),'Select Your Preferred Countries')]");
    By country = By.xpath("//*[contains(text(),'Nepal')]");
    By vocationalSchool = By.xpath("//label[contains(text(),'Vocational School')]");
    By upload1 = By.xpath("(//input[@type='file'])[1]");
    By upload2 = By.xpath("(//input[@type='file'])[2]");
    By submitButton = By.xpath("//button[contains(text(),'Submit')]");


    public boolean isPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();

    }

    public void enterRegistrationNumber(String reg) {
        wait.until(ExpectedConditions.elementToBeClickable(registrationNumber)).sendKeys(reg);

    }

    public void selectCountry() {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(country)).click();

    }

    public void selectVocationalSchool() {
        wait.until(ExpectedConditions.elementToBeClickable(vocationalSchool)).click();

    }



    public void uploadBusinessDocument() {
        File folder = new File("UploadFiles");
        File[] files = folder.listFiles();
        Assert.assertNotNull(files, "UploadFiles folder not found");
        Assert.assertTrue(files.length > 0, "No files found"
        );

        Random random = new Random();
        File randomFile = files[random.nextInt(files.length)];
        driver.findElement(upload1).sendKeys(randomFile.getAbsolutePath());
        System.out.println("Uploaded File : " + randomFile.getName()
        );

    }



    public void uploadCertificate() {
        File folder = new File("UploadFiles");
        File[] files = folder.listFiles();
        Assert.assertNotNull(files);
        Assert.assertTrue(files.length > 0);

        Random random = new Random();
        File randomFile = files[random.nextInt(files.length)];
        driver.findElement(upload2).sendKeys(randomFile.getAbsolutePath());
        System.out.println("Uploaded File : " + randomFile.getName()
        );

    }


    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

    }


}