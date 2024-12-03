package angularProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("password")).sendKeys("learning");

		driver.findElement(By.xpath("//span[text()=' User']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']")));

		driver.findElement(By.xpath("//button[text()='Okay']")).click();

		WebElement elements = driver.findElement(By.xpath("//select[@class='form-control']"));

		Select oneElement = new Select(elements);

		oneElement.selectByValue("consult");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.cssSelector("input[name='signin']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-info']")));

		List<WebElement> listOfProducts = driver.findElements(By.cssSelector("button[class='btn btn-info']"));

		for (int i = 0; i < listOfProducts.size(); i++) {

			listOfProducts.get(i).click();

		}
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();

	}

}
