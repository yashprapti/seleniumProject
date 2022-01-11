package testng.packagee;

import org.testng.annotations.Test;

@Test(groups={"User Registration"})
public class GroupsInTestNg {
	
	
	
	@Test(groups={"Regression","Smoke"})
	public void test1() {
		System.out.println("I am Test 1 in [Regression,Smoke]");
	}
	
	@Test(groups="Smoke")
	public void test2() {
		System.out.println("I am Test 2 in [Smoke]");
	}
	@Test(groups={"UAT","Smoke"})
	public void test3() {
		System.out.println("I am Test 3 in [UAT,Smoke]");
	}
	@Test(groups="UAT")
	public void test4() {
		System.out.println("I am Test 4 in [UAT]");
	}
	@Test(groups="Regression")
	public void test5() {
		System.out.println("I am Test 5 in [Regression]");
	}
	@Test(groups={"Regression","Smoke","UAT"})
	public void test6() {
		System.out.println("I am Test 6 in [Regression,Smoke,UAT]");
	}
	@Test(groups={"Regression","UAT"})
	public void test7() {
		System.out.println("I am Test 7 in [Regression,UAT]");
	}
	@Test(groups="Smoke")
	public void test8() {
		System.out.println("I am Test 8 in [Smoke]");
	}
	@Test(groups="Regression")
	public void test9() {
		System.out.println("I am Test 9 in [Regression]");
	}
	@Test(groups="UAT")
	public void test10() {
		System.out.println("I am Test 10 in [UAT]");
	}
	
	
	
	
	

}
