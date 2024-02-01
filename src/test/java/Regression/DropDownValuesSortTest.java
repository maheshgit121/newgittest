package Regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClasses.PageWithDropDownOptionValues;
import BaseClasses.TC001;

public class DropDownValuesSortTest  {
	
	
	WebDriver driver;
	
	TC001 tc = new TC001();
	PageWithDropDownOptionValues p;
	
	String url = "http://www.manasa-tutorial.com/";
	
	@Test
	
	public void verifyOptionValuesStatus()
	{
	   driver =tc.GetBrowser(url);
	   p = new PageWithDropDownOptionValues(driver);
	  //	p.getOptionValues();
	   p.testSort();
	   driver.quit();
	   
	}
	
	
	
	

}
