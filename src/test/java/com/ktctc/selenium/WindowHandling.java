package com.ktctc.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static String Browser = "chrome";
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		if(Browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(Browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			}
		driver.get("https://www.swtestacademy.com/window-handling-in-selenium/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"post-856\"]/div/div[2]/p[6]/a")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
		WebElement source = driver.findElement(By.xpath("//*[@id=\"textareawrapper\"]/div/div[6]/div[1]/div/div/div/div[5]"));
		Actions action = new Actions(driver);
		action.keyDown(source, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		WebElement target = driver.findElement(By.xpath("//*[@id=\"textareawrapper\"]/div/div[6]/div[1]/div/div/div/div[5]/pre[16]"));
		action.keyDown(target, Keys.CONTROL).sendKeys("v").build().perform();
		Thread.sleep(2000);
		driver.switchTo().window(parentwindow);
		
		
		
		

	}

}
