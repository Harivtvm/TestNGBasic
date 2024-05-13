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

public class Assign6 {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://selenium.qabible.in/form-submit.php");
		driver.manage().window().maximize();
}
	@Test(dataProvider = "Formfill6D",dataProviderClass = DataProviders.class)
	public void verifyform_fill(String fname,String lname,String user,String place,String state,String pin) {
		WebElement element1=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		element1.sendKeys(fname);
		System.out.println(fname);
		WebElement element2=driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		element2.sendKeys(lname);
		System.out.println(lname);
		WebElement element3=driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
		element3.sendKeys(user);
		System.out.println(user);
		WebElement element4=driver.findElement(By.xpath("(//input[@class='form-control'])[4]"));
		element4.sendKeys(place);
		System.out.println(place);
		WebElement element5=driver.findElement(By.xpath("(//input[@class='form-control'])[5]"));
		element5.sendKeys(state);
		System.out.println(state);
		WebElement element6=driver.findElement(By.xpath("(//input[@class='form-control'])[6]"));
		element6.sendKeys(pin);
		System.out.println(pin);
		WebElement element7=driver.findElement(By.xpath("//input[@class='form-check-input']"));
		element7.click();
		WebElement element8=driver.findElement(By.xpath("//button[@type='submit']"));
		element8.click();
		WebElement element9=driver.findElement(By.xpath("//div[@id='message-one']"));
		String act=element9.getText();
		String exp="Form has been submitted successfully!";
		Assert.assertEquals(act, exp);
}
	@AfterMethod
	public void close() {
		driver.close();
	}
}