package shopifyFormNegative;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class shopifyFormNegative {

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
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary/span")).click();
		driver.findElement(By.id("Search-In-Modal")).sendKeys("form");
		driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/div/div[2]/predictive-search/form/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/a/div/div")).click();
		
		// Here we test the search function of the website, that is working properly, and search our Form for automation.
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		driver.switchTo().frame("frame_8Q1zrNOWpYyVd3BKCe2hAA");
		
		// Iframe is changed
		
		driver.findElement(By.id("form_input_0")).sendKeys("Tarik");
		driver.findElement(By.id("form_input_3")).sendKeys("01/31/1999");
		
		//Only name and year of birth is entered
		
		driver.findElement(By.xpath("//*[@id=\"formGeneratorForm\"]/div/div/div[3]/div[3]/button")).click();
		String signupHeading2 = driver.findElement(By.xpath("//*[@id=\"formGeneratorForm\"]/div/div/div[2]/div/div")).getText();
		System.out.println("The form not submitted - test failed-----" + signupHeading2);

		// If an error message appears stating that the user did not enter their Surname, Email and ratings, the test failed.
	}

}
