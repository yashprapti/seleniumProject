package com.ktctc.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Copy1 {

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
		driver.get("https://demo.ktctc.in/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@placeholder='Enter Email Address']")).sendKeys("octD3.shreyas@mailinator.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("Shiru@354");
		driver.findElement(By.xpath("/html/body/section/div/div/div/div/div/form/div/div[4]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/div/div[2]/nav/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Fixed Deposit package')]")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
