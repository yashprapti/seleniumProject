package testng.packagee;

import org.testng.annotations.DataProvider;

public class DataProviderFile {
	
	@DataProvider(name = "loginData")
	public Object[][] dataset() {
		
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_use","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
			
		};
	}

}
