package SeleniumAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class codetest {

	public static void main(String[] args) {		
		int total = 0;
		
		//Setting the Chrome Driver as the browser to launch the application
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Welome\\Desktop\\Selenium Tools and Files\\chromedriver.exe");	
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");	
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.programmableweb.com/category/open-data/api");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String name = driver.findElement(By.id("edit-term--2")).getAttribute("placeholder");
		//System.out.println(name);
		
		//To split the string to separate the numeric value
		String a[] = name.split(" ");
		System.out.println("Programmable web has " + a[2] + " API's");
		
		//To display the values in the tabs
		List <WebElement> tabs = driver.findElements(By.xpath("//ul[@id='myTab']/li"));
		for (int i=1;i<tabs.size();i++)
		{
			//System.out.println(tabs.get(i).getText());
			
			String b[] = tabs.get(i).getText().split("\n");					
			System.out.println("There are " + b[1].substring(1,b[1].length()-1) +" " + b[0] + " in this page" );
			
			//To display the total of resources
			int temp = Integer.parseInt(b[1].substring(1,b[1].length()-1));
			total = total + temp;			
		}
		System.out.println("The total number of resoures are " +  total);
		
		driver.close();	
	}

}
