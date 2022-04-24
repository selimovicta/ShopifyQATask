package contactUs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class contactUs {

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
		
		driver.findElement(By.xpath("//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[3]/a")).click();
		
		//Click the Contact us element in the header
		
		driver.findElement(By.id("ContactForm-name")).sendKeys("Tarik Selimovic");
		driver.findElement(By.id("ContactForm-email")).sendKeys("selimovicta@gmail.com");
		driver.findElement(By.id("ContactForm-phone")).sendKeys("062855545");
		driver.findElement(By.id("ContactForm-body")).sendKeys("Hope you have a great day!");
		
		//Enter all information and a comment
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"ContactForm\"]/div[4]/button")).click();
		
		//Click the Submit button
		
		String signupHeading2 = driver.findElement(By.xpath("//*[@id=\"ContactForm\"]/div[1]")).getText();
		System.out.println("You have contacted the store succsesfully-----" + signupHeading2);

	}

}
