package Regression;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClasses.LinkValidation;
import BaseClasses.TC001;

public class LinkTest extends TC001 {
	
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
	public void TestResistraion() throws InterruptedException, IOException
	{
	  LinkValidation lv = new LinkValidation(driver);
	  lv.FindAllLinks();
	  lv.quit();
	}

}
