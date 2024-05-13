package Testbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAnnotation {
	@BeforeSuite
	public void before_suite() {
		System.out.println("entering before suite");
	}
@BeforeClass
public void before_class() {
	System.out.println("entering before class");
}
@BeforeMethod
public void before_method() {
	System.out.println("entering before method");

}
@BeforeTest
public void before_test() {
	System.out.println("entering before test");}

@Test
public void testcase_1() {
	System.out.println("entering testcase 1");}
@Test
public void testcase_2() {
	System.out.println("entering testcase 2  ");}
@AfterSuite
public void after_suite() {
	System.out.println("entering after suite");
}
@AfterClass
public void after_class() {
System.out.println("entering after class");
}
@AfterMethod
public void after_method() {
System.out.println("entering after method");

}
@AfterTest
public void after_test() {
System.out.println("entering after test");}


}
