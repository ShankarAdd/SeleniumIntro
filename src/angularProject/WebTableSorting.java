package angularProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//thead /tr /th[position()=1]")).click();
		
		List<WebElement> allElements = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> nonSortedList = allElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = nonSortedList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(nonSortedList.equals(sortedList));

		List<String> priceOfVeg;

		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			priceOfVeg = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceOfVegetable(s)).collect(Collectors.toList());

			priceOfVeg.forEach(s -> System.out.println(s));

			if (priceOfVeg.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

		} while (priceOfVeg.size() < 1);
	}

	private static String getPriceOfVegetable(WebElement s) {

		String returnPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return returnPrice;
	}

}
