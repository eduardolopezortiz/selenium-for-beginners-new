package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
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
		
		
		//enter password
		//click login button
		
		//verification
		//new url
		//logout button i visible
		//successful login 
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
