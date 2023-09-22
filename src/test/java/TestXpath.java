import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.TC001;

public class TestXpath extends TC001 {
	
	WebDriver d;
	Logger l = LogManager.getLogger(TestXpath.class);
	
    public void set()
    {   
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
    	options.addArguments("--remote-allow-origins=*");
    	d= new ChromeDriver(options);
    	d.get("https://automationexercise.com/login");
    	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	d.manage().window().maximize();
    	l.debug("Setup is successfull");
     	
    	
    }
    
    public void quit()
    {
    	d.quit();
    	l.debug("Quit is successfull");
    }
    
    public void login()
    {
    	d.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
    	
    	if(new String(d.getTitle()).equals("Automation Exercise - Signup / Login"))
    	{
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys("maheshcharaj@gmail.com");
    		d.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")).sendKeys("Test@123");
    		d.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    	}
    }
    
    public void VerifyLoginError()
    {
    		
    		Assert.assertTrue(d.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(), "Login Failed");
    		l.debug("Login passed verification is successful");
    		extent.createTest("MyFirstTestXpath").log(Status.PASS,"Login Verification was successful").addScreenCaptureFromPath(this.screenshotone(d));
    		extent.flush();
    	
    }
    
    @Test
    
    public  void main1()
    {
    	TestXpath t = new TestXpath();
    	t.set();
    	t.login();
    	t.VerifyLoginError();
    	t.quit();
    }
	

}
