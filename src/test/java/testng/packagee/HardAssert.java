package testng.packagee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssert {
	
	
	public static WebDriver driver;
	@Test(groups="UAT")
	public void assertMethod() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String extitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		String actitle = driver.getTitle();
		System.out.println(actitle);
		Assert.assertEquals(actitle, extitle, "Tile Test Failed");
		driver.close();
		 
		
		
		
	}

}
