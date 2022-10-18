package org.Makemytrip_Task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(2000);	driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	WebElement popup = driver.findElement(By.xpath("//a[@class='close']"));
	popup.click();
	Thread.sleep(3000);
//	From
	driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
	WebElement from = driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']//child::input"));
	from.sendKeys("tri");
	Thread.sleep(3000);
	
	List<WebElement> all = driver.findElements(By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']"));
	for (int i = 0; i < all.size(); i++) {
		WebElement element = all.get(i);
		String text = element.getText();
		boolean contains = text.contains("Tiruchirappalli");
		System.out.println(text);
	}

	WebElement tri = driver.findElement(By.xpath("(//div[@class='calc60'])[2]"));
	Actions a=new Actions(driver);
	a.moveToElement(tri).click().perform();

	
	//	To
	WebElement to = driver.findElement(By.id("toCity"));
	to.sendKeys("che");
	Thread.sleep(3000);
	
	List<WebElement> allto = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
	for (int i = 0; i < allto.size(); i++) {
		WebElement webElement = allto.get(i);
		String text = webElement.getText();
		boolean contains = text.contains("chennai");
		System.out.println(text);
	}
	
	WebElement option = driver.findElement(By.xpath("(//div[@class='makeFlex hrtlCenter'])[2]"));
	a.moveToElement(option).click().perform();
	
	
	driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
	
	driver.findElement(By.xpath("//div[@aria-label='Thu Oct 20 2022']")).click();
	
	
	
	




}
}
