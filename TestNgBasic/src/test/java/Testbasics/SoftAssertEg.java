package Testbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertEg {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/window-popup.php");
		driver.manage().window().maximize();
}
	@Test
	public void verifytext_title() {
		WebElement element1=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String exptext="Like us On Fac";
		String exptitle="Follow @obsqurazone on Faceb";
		String acttext=element1.getText();
		String acttitle=element1.getAttribute("title");
		softassert.assertEquals(acttext, exptext);
		softassert.assertEquals(acttitle, exptitle);
		softassert.assertAll();
	}
}
