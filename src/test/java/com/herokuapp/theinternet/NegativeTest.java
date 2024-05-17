package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest {
	
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, groups = { "negativeTests", "smokeTests" })
	public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
		System.out.println("Starting negativeLoginTest with " + username + " and " + password);
		// create driver
		WebDriver driver = new FirefoxDriver();
		System.out.println("Browser started");
		sleep(1);

		// Open Pages
		String url = "https://the-internet.herokuapp.com/login";// create a variable to store the url of the tet site
		driver.get(url);
		sleep(1);

		// maximize window
		driver.manage().window().maximize();

		sleep(1);

		System.out.println("Page is open");

		sleep(2);

		// enter username
		WebElement usernameElement = driver.findElement(By.xpath("/html//input[@id='username']"));
		usernameElement.sendKeys("username");

		sleep(2);

		// enter password
		WebElement passwordElement = driver.findElement(By.xpath("/html//input[@id='password']"));
		passwordElement.sendKeys("password");
		sleep(2);

		// click login button
		WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		logInButton.click();
		sleep(1);

		/* VERIFICATIONS */

		// Incorrect username message Your username is invalid!

		WebElement IncorrectUserMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));// find div of
																									// incorect username
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

	/* INCORRECT PASSWORD */

	/*
	 * @Test(priority = 2, groups= {"negativeTests" }) public void
	 * incorrectPasswordTest() {
	 * System.out.println("starting incorrectPasswordTest"); //create driver
	 * WebDriver driver = new ChromeDriver(); System.out.println("Browser started");
	 * sleep(1);
	 * 
	 * //Open Pages String url = "https://the-internet.herokuapp.com/login";//create
	 * a variable to store the url of the tet site driver.get(url); sleep(1);
	 * 
	 * 
	 * 
	 * //maximize window driver.manage().window().maximize();
	 * 
	 * 
	 * sleep(1);
	 * 
	 * System.out.println("Page is open");
	 * 
	 * sleep(2);
	 * 
	 * //enter username WebElement username =
	 * driver.findElement(By.xpath("/html//input[@id='username']"));
	 * username.sendKeys("tomsmith");
	 * 
	 * sleep(2);
	 * 
	 * //enter password WebElement password =
	 * driver.findElement(By.xpath("/html//input[@id='password']"));
	 * password.sendKeys("incorrectSuperSecretPassword!"); sleep(2);
	 * 
	 * //click login button WebElement logInButton = driver.findElement(By.
	 * xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
	 * logInButton.click(); sleep(1);
	 * 
	 * 
	 * 
	 * VERIFICATIONS
	 * 
	 * 
	 * //Incorrect username message Your username is invalid!
	 * 
	 * WebElement IncorrectUserMessage =
	 * driver.findElement(By.xpath("/html//div[@id='flash']"));//find div of
	 * incorect username Message String expectedErrorMessage =
	 * "Your password is invalid!"; String actualErrorMessage =
	 * IncorrectUserMessage.getText();
	 * 
	 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
	 * "Actual message does not contain expected message.\nActual Message: " +
	 * actualErrorMessage + "\nExpected Message: " + expectedErrorMessage);
	 * 
	 * sleep(2);
	 * 
	 * //close browser driver.quit();
	 * System.out.println("incorrectPasswordTest finish");
	 * 
	 * }
	 */

	/*
	 * private String getTextIgnoreIcon(WebElement successMesagge) { // Obtener el
	 * texto del div String textoCompleto = successMesagge.getText().trim();
	 * 
	 * // Excluir el texto del icono "x" String textoSinIcono =
	 * textoCompleto.replace("x", "").trim();
	 * 
	 * return textoSinIcono; }
	 */

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