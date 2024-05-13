package Testbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
}
	@Test(priority=1,enabled=true)
	public void verifycheckboxheader() {
		String expected="Single Checkbox";
		WebElement element1=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String actual=element1.getText();
		Assert.assertEquals(actual, expected);      //hard assert
		
	}
	@Test(priority=2,dependsOnMethods = "verifycheckboxheader")
	public void verifycheckboxheadersecond() {
		String expected="Multiple Checkbox";
		WebElement element2=driver.findElement(By.xpath("(//div[@class='card-header'])[3]"));
		String actual=element2.getText();
		Assert.assertEquals(actual, expected,"Failed due to bug");
}
	@Test(invocationCount = 1)
	public void verifystatus() {
		
		WebElement element3=driver.findElement(By.xpath("//input[@class='form-check-input']"));
		boolean status=element3.isDisplayed();
		//Assert.assertEquals(status, true);
		//Assert.assertTrue(status);
		Assert.assertFalse(element3.isDisplayed(),"Failed due to bug");
		System.out.println("hello");
		
}
}