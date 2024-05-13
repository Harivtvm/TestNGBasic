package Testbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assign5 {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/table-filter.php");
		driver.manage().window().maximize();
}
	@Test(dataProvider = "Tablefiltername",dataProviderClass = DataProviders.class)
	public void verifysearch(String name) {
		SoftAssert softassert=new SoftAssert();
		WebElement element=driver.findElement(By.xpath("//select[@name='example_length']"));
		element.click();
		WebElement element1=driver.findElement(By.xpath("//input[@type='search']"));
		element1.sendKeys(name);
		List<WebElement> tablelistname=driver.findElements(By.xpath("//table[@id='example']//td[1]"));
		for(WebElement elem:tablelistname) {
		String a=elem.getText();
			if (name.equals(a)) {
				softassert.assertEquals(name, a);
				softassert.assertAll();
				System.out.println(name+" found");
			}else {
				System.out.println(name+" not found");
				softassert.assertEquals(name, a);
				softassert.assertAll();
			}
		
		}		
}
	@AfterMethod
	public void close() {
		driver.close();
	}
}