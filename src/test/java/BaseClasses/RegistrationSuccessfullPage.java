package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

public class RegistrationSuccessfullPage extends TC001 {
	
     WebDriver driver;
	
	//Page Title
	@FindBy(xpath="//title[contains(text(),'Automation Exercise - Account Created')]")
	WebElement pageTitle;
	
	// Account Created text
	@FindBy(xpath="//b[contains(text(),'Account Created!')]")
	WebElement accountCreated;
	
	// Congratulations text
	@FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	WebElement congratulations;
	
	// Shopping Experience text
		@FindBy(xpath="//p[contains(text(),'You can now take advantage of member privileges to enhance your online shopping experience with us.')]")
		WebElement shopExp;
		
		//Page Initialization
		
		public RegistrationSuccessfullPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void VerifySuccessfullMsg()
		{
			
			Boolean pt = pageTitle.isDisplayed();
			Boolean ac = accountCreated.isDisplayed();
			Boolean cong = congratulations.isDisplayed();
			Boolean se = shopExp.isDisplayed();
			
			if(pt&&ac&&cong&&se)
			{
				log.debug("Registration is successfull");
				extent.createTest("RegistrationSuccessfull").log(Status.PASS,"Registration is successfull");
			}
			
			else
			{
				log.debug("Registration failed ");
	    		extent.createTest("RegistrationSuccessfull").log(Status.FAIL,"Registration failed ").addScreenCaptureFromPath(this.screenshotone(driver));
	  
			}
			
			
		}
		

}
