package Testbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestcase {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		//WebDriverManager.edgedriver().setup();
		//driver=new EdgeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void VerifyTitle()
	{
		System.out.println(driver.getTitle());
		String actualtile=driver.getTitle();
		String expectedtitle="hari";
	Assert.assertEquals(actualtile, expectedtitle);
	}
	@Test
	public void verify_url() {
		System.out.println(driver.getCurrentUrl());
		String actualurl=driver.getCurrentUrl();
		String expectedurl="hari";
		Assert.assertEquals(actualurl, expectedurl);
	}
	}
	


