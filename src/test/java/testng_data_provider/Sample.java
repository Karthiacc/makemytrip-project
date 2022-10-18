package testng_data_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
@Test(dataProvider="test1")
private void num(String user,String pass) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys(user);
	driver.findElement(By.id("pass")).sendKeys(pass);

}
@DataProvider(name="test1")
private Object[][] data() {
Object[][] obj=new Object[3][2];

obj[0][0]="akrthi";
obj[1][0]="@jkkj";

obj[0][1]="ashb";
obj[1][1]="23jhdn";
return obj;
}
}
