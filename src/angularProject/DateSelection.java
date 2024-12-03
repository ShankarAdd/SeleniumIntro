package angularProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DateSelection {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		String month = "6";
		String date = "15";
		String year = "2027";

		String[] expectedResult = { month, date, year };

		driver.findElement(By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month"))
				.get(Integer.parseInt(month) - 1).click();

		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		List<WebElement> ele = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.get(i ).getAttribute("value"));
			Assert.assertEquals(ele.get(i).getAttribute("value"), expectedResult[i]);
		}
	}

}