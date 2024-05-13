package Testbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2 {
	WebDriver driver;
	@BeforeMethod
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();
		
	}
	@Test
	public void verify_enabled() throws InterruptedException {
		WebElement element1=driver.findElement(By.xpath("(//input[@name='inlineRadioOptions'])[1]"));
		Boolean act=element1.isEnabled();
		Assert.assertEquals(act, true);
	}
@Test
public void verify_selected() {
	WebElement element2=driver.findElement(By.xpath("(//input[@name='inlineRadioOptions'])[2]"));
	element2.click();
	Assert.assertEquals(element2.isSelected(), true);
}
@AfterMethod
public void close() {
	driver.close();
}
}
