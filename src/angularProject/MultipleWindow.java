package angularProject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> st = driver.getWindowHandles();
		Iterator<String> ids = st.iterator();
		String parentId = ids.next();
		String childId = ids.next();
		
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
//		It is not possible until 4.0 version
//		File file = name.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("logo.png"));
//		It is not possible untill 4.0 version
//		System.out.println(driver.getRect().getDimension().getHeight());
//		System.out.println(driver.getRect().getDimension().getWidth());
	}

}
