package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TC001 {
	
	    WebDriver driver;
	 
	    //Name
		@FindBy(xpath="//input[@type=\'text\' and @name=\'name\']")
		WebElement name;
		
		//EmailAddress
		@FindBy(xpath="//input[@type=\"email\" and @data-qa=\"signup-email\"]")
		WebElement emailAddressSignUp;
		
		//SignUp
		@FindBy(xpath="//button[@type=\"submit\" and @data-qa=\"signup-button\"]")
		WebElement signUpButton;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void FillHomePageFields()
		{
			name.sendKeys("Testuser"+ dtf.format(now));
			emailAddressSignUp.sendKeys(dtf.format(now)+"@mail.com");
			signUpButton.click();
		}

}
