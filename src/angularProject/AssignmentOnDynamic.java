package angularProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOnDynamic {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption1")).click();

		String ele = driver.findElement(By.cssSelector("label[for='bmw']")).getText();

		WebElement newOne = driver.findElement(By.id("dropdown-class-example"));

		Select best = new Select(newOne);

		best.selectByVisibleText(ele);

		driver.findElement(By.id("name")).sendKeys(ele);

		driver.findElement(By.cssSelector("input[value='Alert']")).click();

		System.out.println(driver.switchTo().alert().getText());

		String[] textFromAlert = driver.switchTo().alert().getText().split(",");

		String fromAlertToCOmpare = textFromAlert[0].split(" ")[1];

		if (fromAlertToCOmpare.equals(ele)) {
			System.out.println("Both names verified successfully");
		} else {
			System.out.println("Both names are not matching");
		}
		driver.switchTo().alert().accept();
	}

}
