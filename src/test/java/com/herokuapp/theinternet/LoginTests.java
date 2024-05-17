package com.herokuapp.theinternet;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

public class LoginTests {

	@Test(priority = 1, groups = { "positiveTests", "smokeTests" })
	public void positiveLoginTest() {
		System.out.println("Starting LoginTest");
		// create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started");
		sleep(1);

		// maximize browser window
		driver.manage().window().maximize();

		// Open Pages
		String url = "https://the-internet.herokuapp.com/login";// create a variable to store the url of the tet site
		driver.get(url);

		sleep(1);

		System.out.println("Page is opened.");

		sleep(2);

		// enter username
		WebElement username = driver.findElement(By.xpath("/html//input[@id='username']"));
		username.sendKeys("tomsmith");

		sleep(2);

		// enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		sleep(2);

		/* click login button */
		WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		logInButton.click();
		sleep(2);

		// VERIFICATION URL
		// new url

		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "<<<<<<<<<<<<<  Actual URL is not same as expected URL >>>>>>>>>>");

		// logout button is visible
		WebElement logOutButton = driver
				.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "<<<< Log Out button is not visible >>>>");
		sleep(3);

		// successful login message
		WebElement successMesagge = driver.findElement(By.xpath("/html//div[@id='flash']"));// find div of success
																							// Message
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMesagge.getText();
		// Assert.assertEquals(actualMessage, expectedMessage, "<<<< Actual message is
		// not the same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);

		driver.quit();
		System.out.println("Test finish");

	}

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTests", "smokeTests" })
	public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
		System.out.println("Starting negativeLoginTest with " + username + " and " + password);
		// create driver
		WebDriver driver = new FirefoxDriver();
		System.out.println("Browser started");
		sleep(1);

		// maximize window
		driver.manage().window().maximize();
		
		// Open Pages
		String url = "https://the-internet.herokuapp.com/login";// create a variable to store the url of the tet site
		driver.get(url);
		sleep(1);

		sleep(1);

		System.out.println("Page is open");

		sleep(1);

		// enter username
		WebElement usernameElement = driver.findElement(By.xpath("/html//input[@id='username']"));
		usernameElement.sendKeys(username);

		sleep(1);

		// enter password
		WebElement passwordElement = driver.findElement(By.xpath("/html//input[@id='password']"));
		passwordElement.sendKeys(password);
		sleep(2);

		// click login button
		WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		logInButton.click();
		sleep(1);

		/* VERIFICATIONS */

		// Incorrect username message Your username is invalid!

		WebElement IncorrectUserMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));// find div of
																									// incorrect
																									// username
																									// Message

		String actualErrorMessage = IncorrectUserMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualErrorMessage
						+ "\nExpected Message: " + expectedErrorMessage);

		sleep(2);

		// close browser
		driver.quit();

		System.out.println("incorrectUsernameTest finish");

	}

	/**
	 * Stop execution for the given amount of time
	 * 
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
