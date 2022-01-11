package com.ktctc.selenium;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CapturingScreenshot2 extends Setup {

	public static void main(String[] args) throws IOException {
		CapturingScreenshot2 obj = new CapturingScreenshot2();
		obj.set();
		Date currentdate = new Date();
		String filename = currentdate.toString().replace(" ", "-").replace(":", "-");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//Screenshot//"+filename+".png"));
		}

}
