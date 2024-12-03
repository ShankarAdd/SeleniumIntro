package angularProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorScrolling {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");	
			Thread.sleep(5000);
			js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
			
			List<WebElement> elements = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
			
			int sum=0;
			
			for (int i = 0; i < elements.size(); i++) {
				sum = sum + Integer.parseInt(elements.get(i).getText());
			}
			System.out.println(sum);
			int number = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
			Assert.assertEquals(sum, number);
	}

}
