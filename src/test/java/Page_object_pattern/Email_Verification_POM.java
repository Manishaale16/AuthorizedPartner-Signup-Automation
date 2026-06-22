package Page_object_pattern;

import Base.Base_Page1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Email_Verification_POM extends Base_Page1 {
    public Email_Verification_POM(WebDriver driver){this.driver = driver;
    }
    By otpTitle = By.xpath("//*[contains(text(),'Email Verification code')]");
    By otpInput = By.cssSelector("input[data-input-otp='true']");
    By verifyButton = By.xpath("//button[contains(text(),'Verify Code')]");
    By successMessage = By.xpath("//*[contains(text(),'Your account has been created successfully')]");

    public boolean isOTPPageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(otpTitle)).isDisplayed();
    }

    public void enterOTP(String otp){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(otpInput));

        input.click();
        input.sendKeys(otp);
    }

    public void clickVerifyButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(verifyButton)).click();
    }
    public boolean isAccountCreatedMessageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}