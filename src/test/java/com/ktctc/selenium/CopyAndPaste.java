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

public class CopyAndPaste {

	public static String Browser = "chrome";
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		if(Browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(Browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			}
		driver.get("https://csvjson.com/json_beautifier");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//*[@id=\"json\"]"));
		action.keyDown(source, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement target = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		action.keyDown(target, Keys.CONTROL).sendKeys("v").build().perform();
		
		

	}

}
