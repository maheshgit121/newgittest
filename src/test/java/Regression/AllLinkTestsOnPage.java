package Regression;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClasses.LinkValidation;
import BaseClasses.TC001;

public class AllLinkTestsOnPage extends TC001 {
	
	TC001 t = new TC001();
	WebDriver d;
	
	
	@BeforeClass
	public void LaunchBrowser() {
		
		d=t.GetBrowser();
		
	}
	
	@Test
	public void Linkstest() throws IOException
	{
		LinkValidation lval=new LinkValidation(d);
		lval.FindAndCompareAllLinks(t);
		lval.quit();
	}
	
	
	

}
