package org_windowhandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.get("https://www.amazon.in/");
	WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	search.sendKeys("iphone 13",Keys.ENTER);
	
	driver.findElement(By.xpath("(//span[text()='Apple iPhone 14 128GB (Product) RED'])[1]")).click();
	
	String parentwindow = driver.getWindowHandle();
	System.out.println(parentwindow);
	
	Set<String> allwindow = driver.getWindowHandles();
	
	List<String> eachwindow=new ArrayList<String>();
	eachwindow.addAll(allwindow);
	
	String string = eachwindow.get(0);
	driver.switchTo().window(string);
	
	driver.findElement(By.xpath("(//span[text()='Apple iPhone 13 Mini (128GB) - Starlight'])[2]")).click();
	
	String string2 = eachwindow.get(1);
	driver.switchTo().window(string2);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
