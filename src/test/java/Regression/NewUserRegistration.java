package Regression;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClasses.HomePage;
import BaseClasses.RegistrationPage;
import BaseClasses.RegistrationSuccessfullPage;
import BaseClasses.TC001;

public class NewUserRegistration extends TC001{
	
	WebDriver driver;
	
	@BeforeClass
	public void set()
    {   
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    	options.addArguments("--remote-allow-origins=*");
    	driver= new ChromeDriver(options);
    	driver.get("https://automationexercise.com/login");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.manage().window().maximize();
    	log.debug("Setup is successfull");
    	
    }
	
	@Test
	public void TestResistraion() throws InterruptedException
	{
	HomePage hp = new HomePage(driver);
	RegistrationPage rp = new RegistrationPage(driver);
	RegistrationSuccessfullPage rs = new RegistrationSuccessfullPage(driver);
	
	hp.FillHomePageFields();
	rp.FormFill();
	rp.CreateForm();
	rs.VerifySuccessfullMsg();
	
	}
	
	@AfterClass
    public void quit()
    {
    	driver.quit();
    	log.debug("Quit is successfull");
    }
}
