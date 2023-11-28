package BaseClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utilities.WriteToExcel;

public class LinkValidation  {
	
	WebDriver d;
	WriteToExcel ex = new WriteToExcel();
	String ClassName=this.getClass().getName();
	String logmessage ="Links Comparision";
	
	//Find all links on the page
	@FindBy(xpath="//a")
	
	List<WebElement> l;
	//WebElement l1;
	
	public LinkValidation(WebDriver driver)
	{
		this.d=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FindAllLinks() throws IOException
	{
		System.out.println("Before Findalllinks");
		ex.SimpleWrite(l);
		//ex.SimpleWriteWithouList(l1);
		
	}
	
	public void FindAndCompareAllLinks(TC001 t) throws IOException
	{
		System.out.println("Links Verification Starts");
		Boolean f= ex.CompareLinksOnThePage(l);
		t.result(f, ClassName, logmessage,d);
		
	}
	
	public void quit()
	{
		System.out.println("Browser has been closed");
		d.quit();
	}
	


}
