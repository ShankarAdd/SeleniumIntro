package introductionPart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelePart {

	public static void main(String[] args) {
		//Invoking the browser
		//WebDriver sc= new ChromeDriver();
		WebDriver sc= new EdgeDriver();
		sc.get("https://rahulshettyacademy.com");
		System.out.println(sc.getTitle());
		System.out.println(sc.getCurrentUrl());
		
		
		//close is used to close the current window
		sc.close();
		//it will close all associated window
		//sc.quit();
	}

}
