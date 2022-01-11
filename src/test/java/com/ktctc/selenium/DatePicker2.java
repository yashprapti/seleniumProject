package com.ktctc.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {

	public static String Browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		}

		driver.get("https://jqueryui.com/datepicker/#localization");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		WebElement drp = driver.findElement(By.id("locale"));
		Select select = new Select(drp);
		select.selectByVisibleText("English");
		driver.findElement(By.id("datepicker")).click();
		String monthyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
		System.out.println(monthyear);
		String month = monthyear.split(" ")[0].trim();
		String year = monthyear.split(" ")[1].trim();
		
		while(!(month.equals("March")&&year.equals("2022"))) {
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			monthyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']")).getText();
			System.out.println(monthyear);
			month = monthyear.split(" ")[0].trim();
			year = monthyear.split(" ")[1].trim();
		}
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr"));
		int rowcount = rows.size();
		System.out.println(rowcount);
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td"));
		int colcount = columns.size();
		System.out.println(colcount);
		aa:for(int i=1;i<=rowcount;i++) {
			for(int j=1;j<=colcount;j++) {
				try {
					String date = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr["+i+"]/td["+j+"]/a")).getText();
					System.out.println(date);
					if(date.equals("18")) {
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
						break aa;
						
					}
			}
				catch(NoSuchElementException exception) {
				System.out.println("Handle exception");
				j++;
			}
				

	}
			
			
}
		
	}
}
