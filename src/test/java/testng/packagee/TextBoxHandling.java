package testng.packagee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxHandling {

	// public static String Browser = "chrome";
	public static WebDriver driver;

	@Parameters({"browser"})
	@Test
	public void applicationLaunch(String browser) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get("https://zoom.us/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[5]/a")).click();
		driver.findElement(By.id("email")).sendKeys("oct.shreyas@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("abcdes");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div[1]/button")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String acmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_msg"))).getText();
		// String acmsg = driver.findElement(By.id("error_msg")).getText();
		// String acmsg =
		// driver.findElement(By.xpath("//*[@id=\\\"error_msg\\"]")).getText();
		System.out.println(acmsg);
		driver.close();

	}

}
