package Page_object_pattern;

import Base.Base_Page1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Professional_Experience_POM extends Base_Page1 {

    public Professional_Experience_POM(WebDriver driver){
        this.driver = driver;
    }

    By yearsOfExperienceDropdown = By.xpath("(//button[@role='combobox'])[1]");
    By studentsRecruited = By.xpath("//input[@placeholder='Enter an approximate number.']");
    By focusArea = By.xpath("//input[contains(@placeholder,'Undergraduate')]");
    By nextButton = By.xpath("//button[contains(text(),'Next')]");


    public boolean isProfessionalExperiencePageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(studentsRecruited)).isDisplayed();
    }

    public void selectYearsOfExperience(String experience){
        driver.findElement(yearsOfExperienceDropdown).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By option = By.xpath("//span[normalize-space()='"
                + experience +
                "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    public void enterStudentsRecruited(String value){
        driver.findElement(studentsRecruited).sendKeys(value);
    }


    public void enterFocusArea(String value){
        driver.findElement(focusArea).sendKeys(value);
    }

    public void enterSuccessMetrics(String value){
        By successMetrics = By.xpath("//*[contains(text(),'Success Metrics')]/following::input[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMetrics)).sendKeys(value);
    }


    public void selectService(String service){
        By serviceLabel = By.xpath("//label[normalize-space()='" + service + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(serviceLabel)).click();
    }

    public void clickNext(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}