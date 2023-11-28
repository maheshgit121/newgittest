package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


public class WriteToExcel {
	
	public void SimpleWrite(List<WebElement> z) throws IOException
	{
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet();
		int rc=1;
		int col=0;
		
		//Create Header
		
		Row r = s.createRow(0);
		Cell cell = r.createCell(0);
		cell.setCellValue("Link List");
		
		for(WebElement link:z)
		{
			r = s.createRow(rc++);
			cell = r.createCell(col);
			cell.setCellValue(link.getAttribute("href"));
			
		}
		
		File f = new File("E:\\New folder (2)\\link.xlsx");
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);
		w.close();
		o.close();
   
	}
	
	
	public void SimpleWriteWithouList(WebElement z) throws IOException
	{
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet();
		int rc=0;
		
			Row r = s.createRow(rc);
			Cell cell = r.createCell(rc);
			//cell.setCellValue(z.getAttribute("href"));
			cell.setCellValue(z.getText());
	
		
		File f = new File("E:\\New folder (2)\\link.xlsx");
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);
		w.close();
		o.close();
   
	}
	
	
	public Boolean CompareLinksOnThePage(List<WebElement> z) throws IOException
	{
		File f = new File("TestData/link.xlsx");
		FileInputStream i = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(i);
		XSSFSheet s = w.getSheetAt(0);
		Row r;
		Cell c;
		int rc=1;
		int col=0;
		Boolean result=false;
		int falsecount=0;
		
		
		for(WebElement e:z)
		{
			r=s.getRow(rc++);
			c=r.getCell(col);
			String res=c.getStringCellValue();
			result=res.equalsIgnoreCase(e.getAttribute("href"));
			if(result==false)
			{
				falsecount++;
				System.out.println("Invalid link name is: " + res);
				
			}
			
		}
		
		w.close();
		i.close();
		if(falsecount>0)
		return result;
		else
		{
			result=false;
			return result;
		}
		
   
	}
	
	
	
	

}
