package introductionPart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		//Without invoking the browser can we launch the browser?
		//By using system.setproperty and downloading the chromedriver download
		//Chromedriver is class and webdriver is interface
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Shankar");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Shankar@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("beast@gmail.com");
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7867789899");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.className("go-to-login-btn")).click();
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Shankarasa");
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		
	}
	
	

}
