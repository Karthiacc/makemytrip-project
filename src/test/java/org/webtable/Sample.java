package org.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.get("https://demo.guru99.com/test/web-table-element.php");
	
	driver.manage().window().maximize();
	
	WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
	
	List<WebElement> tr = driver.findElements(By.tagName("tr"));
	int size = tr.size();
	System.out.println(size);
	
	List<WebElement> th = driver.findElements(By.tagName("th"));
	int size2 = th.size();
	System.out.println(size2);
	
//	String text = tr.get(2).getText();
//	System.out.println(text);
//	
//	for (int i = 0; i < tr.size(); i++) {
//		String text2 = tr.get(i).getText();
//		System.out.println(text2);
//	}
	
	List<WebElement> td = tr.get(2).findElements(By.tagName("td"));
	
	for (int i = 0; i < td.size(); i++) {
		String text2 = td.get(i).getText();
		System.out.println(text2);
	}
	
	
	
}
}
