package actionclassPackage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayed {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		boolean flag = false;
		try {
			driver.findElement(By.id("userName")).sendKeys("username");
			flag = true;
		}catch(NoSuchElementException e) {
		}finally {
			if(flag) {
				System.out.println("WebElement Successfully located");
			}else {
				System.out.println("unable to locate elemnet");
			}
			driver.quit();
		}
		
	}
	
}
