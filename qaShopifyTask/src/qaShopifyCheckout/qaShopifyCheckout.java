package qaShopifyCheckout;
import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class qaShopifyCheckout {

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

		driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[2]/a")).click();
		
		//Open catalog
		
		driver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[1]/div/div[1]/div/h3/a")).click();
		
		//Click on the first product
		
		driver.findElement(By.xpath("//*[@id=\"product-form-template--14211560177749__main\"]/div[2]/div/div/div/div/button[1]")).click();
		
		//Add item to cart
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//Enter shipping details
		
		driver.findElement(By.id("checkout_email_or_phone")).sendKeys("selimovicta@gmail.com");
		driver.findElement(By.id("checkout_shipping_address_first_name")).sendKeys("Tarik");
		driver.findElement(By.id("checkout_shipping_address_last_name")).sendKeys("Selimovic");
		driver.findElement(By.id("checkout_shipping_address_address1")).sendKeys("Splitska 43");
		driver.findElement(By.id("checkout_shipping_address_zip")).sendKeys("71000");
		driver.findElement(By.id("checkout_shipping_address_city")).sendKeys("Sarajevo");
		
		//Wait and click continue to shipping
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		driver.findElement(By.id("continue_button")).click();
		
		//Pick a shipping option/ method
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//If the payment system had been implemented, the payment process would be automated too, Stripe/PayPal API integration
		driver.findElement(By.id("continue_button")).click();
		
		String signupHeading2 = driver.findElement(By.xpath("/html/body/div/div/div/header/nav/ol/li[3]/span")).getText();
		System.out.println("The checkout has been completed-----" + signupHeading2);
	}

}
