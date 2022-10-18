package org.javascript_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.id("email"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].setAttribute('value','ajcas')", username);

		WebElement password = driver.findElement(By.id("pass"));
		executor.executeScript("arguments[0].setAttribute('value','yasv')", password);

		WebElement login = driver.findElement(By.name("login"));
		executor.executeScript("arguments[0].click()", login);

		driver.quit();

	}

}
