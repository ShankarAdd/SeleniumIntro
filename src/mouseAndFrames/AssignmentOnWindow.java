package mouseAndFrames;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOnWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> getWin =  driver.getWindowHandles();
		Iterator<String> windows = getWin.iterator();
		String first = windows.next();
		String second = windows.next();
		driver.switchTo().window(second);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(first);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
	}

}
