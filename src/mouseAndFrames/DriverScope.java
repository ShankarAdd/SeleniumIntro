package mouseAndFrames;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScope {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Give me the count of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting webdriver scope
		WebElement footerElement = driver.findElement(By.id("gf-BIG"));
		
		//We get link only that are available in the footer section
		System.out.println(footerElement.findElements(By.tagName("a")).size());
		
		//In footer section i need links which are available in the footer of 1st column
		WebElement footerOfFirstColumn = footerElement.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(footerOfFirstColumn.findElements(By.tagName("a")).size());
		
		//Go to each particular link and click
		for(int i=1;i<footerOfFirstColumn.findElements(By.tagName("a")).size();i++) {
			
			//It will click on from mouse perspective "right clicks"
			String rightClickOnMouse = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerOfFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(rightClickOnMouse);
		}
		//Go to all tabs and get the title of every tabs
		Set<String> windowsId = driver.getWindowHandles();
		
		Iterator<String> it = windowsId.iterator();
		
			while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
