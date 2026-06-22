package Practice;
import Base.Base_Page1;
import Page_object_pattern.*;
import Utilities.GmailOTPReader;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignupTest extends Base_Page1 {

    @Test
    public void CompleteSignupFlow() throws Exception {
        Signup_Page1_POM signup = new Signup_Page1_POM(driver);
        Assert.assertTrue(signup.isTermsPageDisplayed(), "Terms Page Not Displayed");
        signup.acceptTerms();
        signup.clickContinue();
        Assert.assertTrue(signup.isAccountSetupDisplayed(), "Account Setup Page Not Displayed");
        String email = "alemenka410+" + System.currentTimeMillis() + "@gmail.com";
        String phone = "98123" + (int)(Math.random() * 100000);
        signup.enterFirstName("Manisha");
        signup.enterLastName("Ale");
        signup.enterEmail(email);
        signup.enterPhone(phone);
        signup.enterPassword("Manisha@123");
        signup.enterConfirmPassword("Manisha@123");
        long startTime = System.currentTimeMillis();
        signup.clickNext();

        Email_Verification_POM otp = new Email_Verification_POM(driver);
        Assert.assertTrue(otp.isOTPPageDisplayed(), "OTP Verification Page Not Displayed");
        String otpCode = GmailOTPReader.waitForOTP(startTime);
        Assert.assertNotNull(otpCode, "OTP Not Received");
        System.out.println("OTP Retrieved : " + otpCode);
        otp.enterOTP(otpCode);
        Thread.sleep(2000);
        otp.clickVerifyButton();
        Assert.assertTrue(otp.isAccountCreatedMessageDisplayed(), "Account Created Success Message Not Displayed");
        System.out.println("Signup Flow Completed Successfully");

        Agency_Details_POM agency = new Agency_Details_POM(driver);
        Assert.assertTrue(agency.isAgencyPageDisplayed(), "Agency Details Page Not Displayed");
        agency.enterAgencyName("MA Education Consultancy");
        agency.enterRoleInAgency("Director");
        agency.enterAgencyEmail("agency@gmail.com");
        agency.enterWebsite("www.maeducation.com");
        agency.enterAddress("Kathmandu, Nepal");
        agency.selectRegion("Australia");
        agency.clickNext();

        Professional_Experience_POM experience = new Professional_Experience_POM(driver);
        Assert.assertTrue(experience.isProfessionalExperiencePageDisplayed(), "Professional Experience Page Not Displayed");
        experience.selectYearsOfExperience("4 years");
        experience.enterStudentsRecruited("10");
        experience.enterFocusArea("Undergraduate Admissions");
        experience.enterSuccessMetrics("80");
        experience.selectService("Career Counseling");
        experience.selectService("Admission Applications");
        experience.selectService("Visa Processing");
        experience.selectService("Test Prepration");
        experience.clickNext();

        Verification_Preferences_POM verification = new Verification_Preferences_POM(driver);
        Assert.assertTrue(verification.isPageDisplayed(), "Verification page not displayed");
        verification.enterRegistrationNumber("REG123456");
        verification.selectCountry();
        verification.selectVocationalSchool();
        verification.uploadBusinessDocument();
        verification.uploadCertificate();
        verification.clickSubmit();



    }

}