package BaseClasses;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryCapital {
	
	
	WebDriver d;
	
	public CountryCapital(WebDriver driver)
	{
		this.d=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//table/descendant::tbody/tr")
	List<WebElement> l;
	
	public void findcapital(String country)
	{
		for(WebElement row:l)
		{
			List<WebElement>col = row.findElements(By.tagName("td"));
			
			if(col.get(1).findElement(By.tagName("Strong")).getText().equals(country))
			{
				System.out.println("Capital city is:" + col.get(2).getText());
				
			}
			
		}
	}

}
