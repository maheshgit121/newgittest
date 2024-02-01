package Regression;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClasses.CountryCapital;
import BaseClasses.TC001;

public class CapitalCountryTest extends TC001 {
	
WebDriver driver;
	
	@BeforeClass
	public void set()
    {   
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    	options.addArguments("--remote-allow-origins=*");
    	driver= new ChromeDriver(options);
    	driver.get("https://catking.in/list-of-countries-capitals-currencies-of-the-world");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.manage().window().maximize();
    	log.debug("Setup is successfull");
    	
    }
	
	@Test
	public void capitalTest()
	{
		CountryCapital cc = new CountryCapital(driver);
		cc.findcapital("India");
		driver.quit();
	}

}
