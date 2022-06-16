package test;

import org.testng.annotations.Test;

import graphql.Assert;
import pages.HomePage;
import pages.RegisterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestPageObject {

	WebDriver driver;
	HomePage hp;
	RegisterPage rp;

	@BeforeClass
	public void beforeClass1() throws InterruptedException {
		System.out.println("Before Class...");
		// Open web browser
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before method...");
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/");
		Thread.sleep(1000);
		hp = new HomePage(driver);
		rp = new RegisterPage(driver);
	}

	@Test(enabled = false, priority = 2)
	public void register() throws InterruptedException {
		System.out.println("Test1 !!!");
		hp.navigate("custom");
		Thread.sleep(1000);
		hp.navigate("register");
		// rp.fillRegistrationForm("Tomer", "test@test.com", "password");
		Assert.assertTrue(rp.fillRegistrationForm("Tomer1", "test1@test.com", "password1"));
		Thread.sleep(1000);

	}

	@Test(enabled = true, priority = 1)
	public void register2() throws InterruptedException {
		System.out.println("Test2 !!!");
		hp.navigate("custom");
		Thread.sleep(1000);
		hp.navigate("register");
		// rp.fillRegistrationForm("Moshe", "Moshe@test2.com", "password2");
		Assert.assertTrue(rp.fillRegistrationForm("Moshe2", "Moshe2@test.com", "password2"));
		Thread.sleep(1000);

	}

	@Test(enabled = true, priority = 2)
	public void searchLocalTime() throws InterruptedException {
		// Assert.assertTrue(hp.searchLocalTime("New York City"), "Search local time");
		Assert.assertTrue(hp.searchLocalTime("New York City"));
		Thread.sleep(1000);
	}

	@AfterClass
	public void afterClass() {

		System.out.println("After Class...");
		driver.close();

	}

}
