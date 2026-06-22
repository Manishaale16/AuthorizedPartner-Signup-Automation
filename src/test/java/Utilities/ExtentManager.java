package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            System.getProperty("user.dir")
                                    + "/reports/ExtentReport.html"
                    );

            spark.config().setDocumentTitle(
                    "Automation Test Report"
            );

            spark.config().setReportName(
                    "Authorized Partner Signup Automation"
            );

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Tester",
                    "Manisha Ale"
            );

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG"
            );
        }

        return extent;
    }
}