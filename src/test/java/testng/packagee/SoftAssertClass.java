package testng.packagee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertClass {
	
	
	@Test(groups="Regression")
	public void SoftAssertMethod() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String extitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String extext = "Search";
		SoftAssert softassert = new SoftAssert();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		String actitle = driver.getTitle();
		softassert.assertEquals(actitle, extitle, "Title Test Failed");
		String actext = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
		softassert.assertEquals(actext, extext, "Text Test Failed");
		driver.close();
		softassert.assertAll();
		
		
	}

}
