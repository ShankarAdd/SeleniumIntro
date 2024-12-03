package angularProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksCheck {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> elements = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a= new SoftAssert();
		
		for (WebElement webElement : elements) {
			String url = webElement.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responCode = conn.getResponseCode();
			/*
			 * if(responCode>400) {
			 * System.out.println("The link with text "+webElement.getText()
			 * +" is broken with code"+responCode); continue; }
			 */
			System.out.println(responCode);
			a.assertTrue(responCode<400, "The link with text "+webElement.getText()+" is broken with code"+responCode);
		}
		a.assertAll();
	}

}
