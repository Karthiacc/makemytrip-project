package org.dropdown;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();

driver.get("https://www.amazon.in/");
	WebElement ddn = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
	
	Select s=new Select(ddn);
	boolean multiple = s.isMultiple();
	System.out.println(multiple);
//	s.selectByIndex(2);
	
	
	List<WebElement> options = s.getOptions();
	for (int i = 0; i < options.size(); i++) {
		WebElement e = options.get(i);
		String text = e.getText();
		boolean contains = text.contains("Electronics");
		if (contains) {
			System.out.println("true");
		}
	}
	s.selectByVisibleText("Electronics");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13");
	driver.findElement(By.id("nav-search-submit-button")).click();
TakesScreenshot tk=(TakesScreenshot)driver;
File src = tk.getScreenshotAs(OutputType.FILE);
File des=new File("C:\\Users\\Venkat\\eclipse-workspace\\Dropdown\\Screenshot\\img.png");
FileUtils.copyFile(src, des);

driver.quit();
	
	
	
}
}
