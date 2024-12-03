package angularProject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItemsToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// Implicit wait
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] names = { "Brocolli", "Cucumber", "Beetroot" };
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		addItems(driver, names);
		// Explicit wait

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] names) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			// Cucumber - 1kg => 1st index "Cucumber " and 2nd index "- 1kg"

			String splittedProduct = name[0].trim();
			// converting array to arraylist and also prevent the more memory consumption
			List itemsConverted = Arrays.asList(names);

			if (itemsConverted.contains(splittedProduct)) {
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (j == names.length)
					break;
			}
		}

	}
}
