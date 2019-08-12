package MicroServices.CodeTestSelenium;

import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ExtractText {

	@Test
	public void Extract_Placeholdertext()
	{
		// TODO Auto-generated method stub
		/*String OptionstoEnter = "chennai";*/
		try
		{
		File DriverExe = new File(
					"C:\\Applications\\LNP\\LNP_Automation\\LNP Scripts\\Selenium\\LNP Regression Suite\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", DriverExe.getAbsolutePath());
			WebDriver Driver = new FirefoxDriver();
			Driver.get("https://www.programmableweb.com/category/open-data/api");
			String txtplaceholder = Driver.findElement(By.xpath("//input[@id='edit-term--2']")).getAttribute("placeholder");
			System.out.println("Default text is " +txtplaceholder);
			Pattern pat = Pattern.compile("\\d+,\\d+");
			Matcher match = pat.matcher(txtplaceholder);
			while(match.find())
			{
			System.out.println("Programmableweb has " + match.group() + " APIs");
			}
			//
			WebElement Tab = Driver.findElement(By.id("myTab"));
			List<WebElement> Tabtoselect = Tab.findElements(By.tagName("li"));
			int pageTotal = 0;
			for(WebElement element : Tabtoselect) {
				String txtTab = element.getText();
				String[] splitTabText = txtTab.split("\n");
				if(splitTabText.length < 2) {
					continue;
				}
				String noOfAtricles= splitTabText[1].replace("(", "");
				noOfAtricles= noOfAtricles.replace(")", "");
				pageTotal = pageTotal + Integer.parseInt(noOfAtricles);
				System.out.println("There are " + noOfAtricles + " " + splitTabText[0] + " in this page.");
			}
			System.out.println("Total number of resources are "+pageTotal);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}
