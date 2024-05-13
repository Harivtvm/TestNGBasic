package Testbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign3 {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/bootstrap-alert.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyheader_bcolor() {
		WebElement element1=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String exptext="Bootstrap Alert";
		String acttext=element1.getText();
		WebElement element2=driver.findElement(By.xpath("//div[@class='col-md-6']//button[3]"));
		String expbcolor="rgba(255, 193, 7, 1)";
		String actbcolor=element2.getCssValue("background-color");
		System.out.println(actbcolor);
		softassert.assertEquals(acttext, exptext);
		softassert.assertEquals(actbcolor, expbcolor);
		softassert.assertAll();
	}
@AfterMethod
public void close() {
	driver.close();
}
}
