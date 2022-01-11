package com.ktctc.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropDownhandling {

	public static String Browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		if(Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.xpath("//*[@id='fromCity']"));
		Actions action = new Actions(driver);
		action.doubleClick(from).perform();
		WebElement ele = driver.findElement(By.xpath("//*[@placeholder='From']"));
		ele.sendKeys("del");
		Thread.sleep(3000);
		ele.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		ele.sendKeys(Keys.ENTER);
				
		

	}

}
