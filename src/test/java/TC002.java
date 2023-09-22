import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClasses.TC001;

public class TC002 extends TC001 {
	
	@Test
	public void logtest()
	{
		
		System.out.println("Test First Method execution is passed");
		log.debug("Log of First method");
		extent.createTest("MyFirstTest").log(Status.PASS, "Test First Method execution is passed - Report logging!");
		extent.flush();
	}
	
	@Test
	public void logtest2()
	{
		
		System.out.println("Test Second Method execution is passed");
		log.debug("Log of Second method");
		extent.createTest("MyFirstTest").log(Status.PASS, "Test Second Method execution is passed - Report logging!");
		extent.flush();
	}
	
	
	@Test
	public void logtest3()
	{
		
		System.out.println("Test Third Method execution is passed");
		log.debug("Log of Third method");
		extent.createTest("MyFirstTest").log(Status.PASS, "Test Third Method execution is passed - Report logging!");
		extent.flush();
	}
	
	
	@Test
	public void logtest4()
	{
		
		System.out.println("Test Four Method execution is passed");
		log.debug("Log of Four method");
		extent.createTest("MyFirstTest").log(Status.PASS, "Test Four Method execution is passed - Report logging!");
		extent.flush();
	}
	
	

}
