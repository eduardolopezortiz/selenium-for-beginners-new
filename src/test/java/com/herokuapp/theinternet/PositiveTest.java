package com.herokuapp.theinternet;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTest {
	
	
	
	@Test
	public void loginTest() {
		System.out.println("Test started");
		//create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser started");
		sleep(1);
				
		//Open Pages
		String url = "https://the-internet.herokuapp.com/login";//create a variable to store the url of the tet site
		driver.get(url);
		sleep(1);
		
		
		
		//maximize  window
		driver.manage().window().maximize();
	
		
		sleep(1);

		System.out.println("Page is open");
		
		sleep(2);
		
		//enter username
		WebElement username = driver.findElement(By.xpath("/html//input[@id='username']"));
		username.sendKeys("tomsmith");
		
		sleep(2);
		
		//enter password
		WebElement password = driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		sleep(3);
		
		//click login button
		WebElement logInButton = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		logInButton.click();
		sleep(4);
		
		
		
		
		//VERIFICATION
		//new url		
		
		//logout button is visible
		WebElement logOutButon = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
		logOutButon.click();
		
		sleep(4);
		
		//successful login message
		WebElement successMesagge = driver.findElement(By.cssSelector("div#flash"));
		
		
		driver.close();
		System.out.println("Test finish");
		
	}

	/**
	 * Stop execution for the given amount of time 
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
