package introductionPart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivity {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://google.com");
//		driver.navigate().to("https://rahulshettyacademy.com");
//		Navigate to <= in the chrome page
		//driver.navigate().back(); 
//		Navigate to => in the chrome page
		//driver.navigate().forward();
		 
	}
}
