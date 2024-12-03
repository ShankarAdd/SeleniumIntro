package angularProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormProject {

	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//div[@class='form-group'] /input[@name='name']")).click();
		driver.findElement(By.xpath("//div[@class='form-group'] /input[@name='name']")).sendKeys("Shankar");
		
		driver.findElement(By.xpath("//div[@class='form-group'] /input[@name='email']")).click();
		driver.findElement(By.xpath("//div[@class='form-group'] /input[@name='email']")).sendKeys("Shankar@gmail.com");
		
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Passwordispassword");
		
		Assert.assertFalse(false);
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(true);
		
		WebElement elements= driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select options = new Select(elements);
		
		options.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.name("bday")).sendKeys("11122024");
		
		driver.findElement(By.className("btn-success")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'dismissible')]")).getText());
		
		
	}

}
