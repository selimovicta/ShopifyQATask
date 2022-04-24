package registration;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class registration {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	
		
		driver.get("https://qa-practical-test.myshopify.com/pages/form-builder");
		System.out.println(driver.getTitle());
		
		//Automation redirected to our Shopify website and previewed its title.
		
		driver.findElement(By.id("password")).sendKeys("brauff");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/button")).click();
		
		//Enter the "brauff" key so the website can be accessible and click the submit button
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/div/a[1]")).click();
		
		//Click the account icon in the header
		
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/a[2]")).click();
		
		//Click the create an account button
		
	
		driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("Tarik");
		driver.findElement(By.id("RegisterForm-LastName")).sendKeys("Selimovic");
		
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.substring(0, Math.min(uuid.length(), 3));
		driver.findElement(By.id("RegisterForm-email")).sendKeys("selimovicta", uuid, "@gmail.com");
	
		//Uses an email with 3 different characters to ensure reliability of the automation script
		
		driver.findElement(By.id("RegisterForm-password")).sendKeys("tariktask1");
		
		//Enter all information for account creation
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"create_customer\"]/button")).click();
		
		String signupHeading2 = driver.findElement(By.xpath("//*[@id=\"shopify-section-announcement-bar\"]/div/p")).getText();
		System.out.println("The registration has been completed-----" + signupHeading2);
		
	}

}
