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

public class DataProviderEg {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://amazon.in");
		driver.manage().window().maximize();
}
@Test(dataProvider = "Amazonproductlist",dataProviderClass = DataProviders.class)
public void verifysearch(String product) {
	WebElement element1=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	element1.sendKeys(product);
	System.out.println(product);
	WebElement element2=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	element2.click();
	
}
@Test(dataProvider = "Facebookdata",dataProviderClass = DataProviders.class)
public void verifylogin(String usrname,String password) {
	driver.get("https://www.facebook.com/");
	WebElement element1=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
	element1.sendKeys(usrname);
	WebElement element2=driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
	element2.sendKeys(password);
		
}
@AfterMethod
public void close() {
	driver.close();
}
}
