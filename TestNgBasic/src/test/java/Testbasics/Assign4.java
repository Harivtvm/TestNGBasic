package Testbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4 {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyheaderand_name() {
		WebElement element1=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
		String expheader="Table with Pagination Example";
		String actheader=element1.getText();
		WebElement element2=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[1]//td[1]"));
		String expname="Tiger Nixon";
		String actname=element2.getText();
		softassert.assertEquals(actheader, expheader);
		softassert.assertEquals(actname, expname);
		softassert.assertAll();
	}
}
