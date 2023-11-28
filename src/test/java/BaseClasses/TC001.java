package BaseClasses;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TC001 extends TestListenerAdapter {
	
	public  Logger log = LogManager.getLogger(TC001.class);
	public  static ExtentReports extent;
	public  ExtentSparkReporter spark;
	//public  ExtentTest et;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
	LocalDateTime now = LocalDateTime.now(); 
	String testName;
	WebDriver driver;

	@BeforeTest
	public void setup(ITestContext context)
	{
		
		testName=context.getCurrentXmlTest().getName();
		String DateFormat=dtf.format(now);
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("reports/"+testName+DateFormat+".html"); //creates html report to print the logs created by extent reports
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Test Type", testName);
		extent.setSystemInfo("Date:", now.toString());
		
	}
	
	 
	public String screenshotone(WebDriver d)
	{
		TakesScreenshot scrShot =((TakesScreenshot)d);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("screenshot/"+dtf.format(now)+".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return DestFile.getAbsolutePath();
	}
	
	
	public void result(Boolean b, String a, String logmessage, WebDriver screendriver)
	{
	  if(b)
	  {
	  extent.createTest(a).log(Status.PASS,logmessage).addScreenCaptureFromPath(this.screenshotone(screendriver));
	  }
	  
	  else
	  {
		  extent.createTest(a).log(Status.FAIL,logmessage).addScreenCaptureFromPath(this.screenshotone(screendriver));
	  }
		  
	  
	}
	
	public WebDriver GetBrowser()
	{
		ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    	options.addArguments("--remote-allow-origins=*");
    	driver= new ChromeDriver(options);
    	driver.get("https://automationexercise.com/login");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.manage().window().maximize();
    	return driver;
	}
	
	
	@AfterTest
	public void closeReport()
	{
		extent.flush();
	}
	 


}
