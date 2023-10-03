package BaseClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends TC001 {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	
	//Title Mr/Mrs
	@FindBy(xpath="//input[@type=\'radio\' and @value=\'Mr\']")
	WebElement TitleRadioButton;
	
	//Password
	@FindBy(xpath="//input[@type=\"password\" and @id=\"password\"]")
	WebElement password;
	
	//Date Of Birth
	@FindBy(xpath="//select[@id=\"days\"]")
	WebElement daysDropDown;
	
	//Month
	@FindBy(xpath="//select[@id=\"months\"]")
	WebElement monthDropDown;
	
	//Year
	@FindBy(xpath="//select[@id=\"years\"]")
	WebElement yearsDropDown;
	
	//Address Information
	//FirstName
	@FindBy(xpath="//input[@type=\"text\" and @id=\"first_name\"]")
	WebElement firstName;
	
	//Lastname
	@FindBy(xpath="//input[@type=\"text\" and @id=\"last_name\"]")
	WebElement lastName;
	
	//Company Name
	@FindBy(xpath="//input[@type=\"text\" and @id=\"company\"]")
	WebElement companyName;
	
	//Address1
	@FindBy(xpath="//input[@type=\"text\" and @id=\"address1\"]")
	WebElement address1;
	
	//Country
	@FindBy(xpath="//select[@id=\"years\"]")
	WebElement country;
	
	//state
	@FindBy(xpath="//input[@type=\"text\" and @id=\"state\"]")
	WebElement state;
	
	//city
	@FindBy(xpath="//input[@type=\"text\" and @id=\"city\"]")
	WebElement city;
	
	// Zipcode
	@FindBy(xpath="//input[@type=\"text\" and @id=\"zipcode\"]")
	WebElement zipcode;
	
	//Mobile Number
	@FindBy(xpath="//input[@type=\"text\" and @id=\"mobile_number\"]")
	WebElement mobileNumber;
	
	//CreateAccount Button
	@FindBy(xpath="//button[@type=\"submit\" and @data-qa=\"create-account\"]")
	WebElement createButton;
	
	
	//Page Initialization
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	
	public void FormFill()
	{
		
		TitleRadioButton.click();
		password.sendKeys("user2test");
		Select days = new Select(daysDropDown);
		days.selectByIndex(1);
		Select months = new Select(monthDropDown);
		months.selectByIndex(2);
		Select years = new Select(yearsDropDown);
		years.selectByIndex(1);
		firstName.sendKeys("User"+dtf.format(now));
		lastName.sendKeys("tester");
		companyName.sendKeys("New "+dtf.format(now)+" company");
		address1.sendKeys("24, 4th cross, Test Company");
		country.sendKeys("India");
		state.sendKeys("Karnataka");
		city.sendKeys("Bangalore");
		zipcode.sendKeys("560050");
		mobileNumber.sendKeys("8596748596");
		
		
	}
	//createform
	
	public void CreateForm() throws InterruptedException
	{
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", createButton);
		//js.executeScript("window.scrollBy(0,800)", "");
		createButton.click();
	}
	


}
