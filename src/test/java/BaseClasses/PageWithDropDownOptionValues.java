package BaseClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.StringComparator;

public class PageWithDropDownOptionValues  {
	
	WebDriver d;
	ArrayList<String> obj = new ArrayList<String>();
	//ArrayList<String> obj2 = new ArrayList<String>();
	
	@FindBy(xpath="//select[@name='cname']")
    WebElement dropdown;
	
	public PageWithDropDownOptionValues(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void getOptionValues()
	{
		Select s = new Select(dropdown);
		List<WebElement> l = s.getOptions();
		int flags=0;
		
		
		for(WebElement w:l)
		{
			obj.add(w.getText());
			System.out.println("Values inside dropdown: " + w.getText());
		}
		
		Object[] r = obj.toArray();
		Object[] j = r.clone();
		Arrays.sort(r);
		
		for(int i=0;i<r.length;i++)
		{
			if(r[i].toString().equals(j[i].toString()))
			{
				flags=0;
			}
			else
			{
			flags=1;
			break;
			}
				
		}
		
		if(flags==1)
		{
			System.out.println("Link list is not sorted");
		}
		else 
		{
			System.out.println("Link list is sorted");
		}
		
		
		
	}
	
	
	//Using by implementing comparator interface
	public void testSort()
	{
		
		Select s = new Select(dropdown);
		List<WebElement> l = s.getOptions();
		for(WebElement w:l)
		{
			obj.add(w.getText());
			System.out.println("Values inside dropdown: " + w.getText());
		}
		
		Object obj3 = obj.clone();
        obj.sort(new StringComparator());
        for(String f:obj)
        {
        	System.out.println(f);
        	//System.out.println(obj3);
        }
		
        if(obj.equals(obj3))
        {
        	System.out.println("List is sorted");
        }
        else
        {
        	System.out.println("List is not sorted");
        }
        	
	}

}
