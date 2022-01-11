package com.ktctc.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling2 {
	
	public static String Browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args){

	if(Browser.equals("chrome")){
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	else if(Browser.equals("firefox")){
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}

	driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@name='confirmation']")).click();
	Alert alert = driver.switchTo().alert();
	String errmsg = alert.getText();
	System.out.println("Error massege is: "+errmsg);
	alert.dismiss();
	

	}
	

}
