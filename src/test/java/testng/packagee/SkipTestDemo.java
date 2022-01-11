package testng.packagee;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestDemo {
	boolean setupdata = false;
	
	@Test(enabled = false)
	public void skipTest1() {
		System.out.println("Skip This Test1 : Do Not Execute");
	}
	
	@Test
	public void skipTest2() {
		System.out.println("Skip This Test2 Forcefully : Do Not Execute");
		throw new SkipException("Skip This Test and Continue with next");
	}
	
	@Test
	public void skipTest3() {
		System.out.println("Skip This Test3 With Condition : Do Not Execute");
		if(setupdata == true) {
			System.out.println("Execute The Test");
		}
		else {
			System.out.println("Skip This Test 3");
			throw new SkipException("Skip This Test 3 and Continue with next");
		}
	}


}
