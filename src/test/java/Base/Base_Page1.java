package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Base_Page1 {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static WebDriver staticDriver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        staticDriver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://authorized-partner.vercel.app/register");
    }

    public static void captureScreenshoot(WebDriver driver, String testname) throws IOException{
        File source =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source,
                new File("Screenshots/"
                        + testname + ".png"));

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException{
        if(result.getStatus()==ITestResult.FAILURE){
            captureScreenshoot(driver, result.getName());
        }
        if(driver!=null){
            driver.quit();
        }
    }
}

