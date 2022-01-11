package com.ktctc.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks {

	static String Browser = "chrome";
	public static WebDriver driver;
	
	
	public static void main(String[] args) {
	
		if(Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> alllinks =  driver.findElements(By.tagName("select"));
		int nooflinks = alllinks.size();
		System.out.println(nooflinks);
		for(int i=1;i<=nooflinks;i++) {
			String Link = alllinks.get(i).getAttribute("type");
			System.out.println(Link);
			String text = alllinks.get(i).getText();
			System.out.println(text);
			
		}
		
	}

}
