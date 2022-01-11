package com.ktctc.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
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
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> rownum = driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
		int rows = rownum.size();
		List<WebElement> colnum = driver.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr[32]/td"));
		int col = colnum.size();
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=col;j++) {
				String webele = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(webele+"  ");
			}
			System.out.println();
		}

	}

}

 