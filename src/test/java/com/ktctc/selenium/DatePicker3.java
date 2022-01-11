package com.ktctc.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker3 {
	
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
		while(!(monthyear.equals("October 1983"))) {
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			monthyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
		}
		driver.findElement(By.xpath("//*[@data-date=\"27\"]")).click();
		

	}

}
