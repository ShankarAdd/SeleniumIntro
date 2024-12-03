package mouseAndFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		//finding the frame with index
		driver.switchTo().frame(0);
		
		//to find out how many frames are present in the dom
		System.out.println(driver.findElements(By.tagName("iframe")));
		
		//Finding the frame with webelement
		
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
//		driver.findElement(By.id("draggable")).click();
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions a= new Actions(driver);
		a.dragAndDrop(source, destination).build().perform();
		//if i want to perform other than iframe then i will fail to make it clickable otherthan iframe elements we need to use below statement
		driver.switchTo().defaultContent();

	}

}
