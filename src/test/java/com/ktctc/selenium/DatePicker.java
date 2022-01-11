package com.ktctc.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	
	public static String Browser = "chrome";
	public static WebDriver driver; 

	public static void main(String[] args) {
		if(Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://jqueryui.com/datepicker/#date%E2%88%92range");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).click();
		String monthyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
		System.out.println(monthyear);
		String month = monthyear.split(" ")[0].trim();
		String year = monthyear.split(" ")[1].trim();
		System.out.println(month);
		System.out.println(year);
		while(!(month.equals("October") && year.equals("1983"))) {
			driver.findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			monthyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
		    month = monthyear.split(" ")[0].trim();
			year = monthyear.split(" ")[1].trim();
		}
		
		driver.findElement(By.xpath("//*[@data-date='27']")).click();
		

	}

}
