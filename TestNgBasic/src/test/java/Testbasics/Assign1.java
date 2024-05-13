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

public class Assign1 {
	WebDriver driver;

	@BeforeMethod
	public void button_textb() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
	}

	@Test
	public void Verifybutton_text() {
		String expresult = "Show Message";
		WebElement element1 = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actresult = element1.getText();
		System.out.println(System.getProperty("user.dir"));
		Assert.assertEquals(actresult, expresult);

	}

	@Test
	public void verify_text() {
		String expresult = "Enter Message";
		WebElement element2 = driver.findElement(By.xpath("//label[@for='inputEmail4']"));
		String actresult = element2.getText();
		Assert.assertEquals(actresult, expresult);

	}

	@Test
	public void verify_showmessage() {
		WebElement element3 = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		String expresult = "Helo Robo";
		element3.sendKeys(expresult);
		WebElement element4 = driver.findElement(By.xpath("//button[@id='button-one']"));
		element4.click();
		WebElement element5 = driver.findElement(By.xpath("//div[@id='message-one']"));
		String actresult = element5.getText();
		boolean status=actresult.endsWith(expresult);
		Assert.assertEquals(status, true);
	}

	@AfterMethod
	public void close_tab() {
		driver.close();
	}
}
