package practice_forms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tutorials_Ninja {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("http://tutorialsninja.com/demo/index.php");
		driver.navigate().to("http://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				currency();
				canon_EOS();
				iPhone();
				MacBook();
				registration();
	}
		public static void currency() {
			

			WebElement currency=driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//span[@class='hidden-xs hidden-sm hidden-md']"));
			currency.click();
			
			WebElement Euro=driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/button[@name='EUR']"));
			Euro.click();
		}
		public static void canon_EOS() {
			
			WebElement Canon=driver.findElement(By.xpath("//a[text()='Canon EOS 5D']"));
			Canon.click();
			
			WebElement Add_to_Cart1=driver.findElement(By.id("button-cart"));
			Add_to_Cart1.click();
			
			String Error_Message=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
			System.out.println(Error_Message);
			
			driver.navigate().back();
			
		}
		
		public static void iPhone() {
			
		WebElement iPhone=driver.findElement(By.xpath("//a[text()='iPhone']"));
		iPhone.click();
		
		WebElement Quantity=driver.findElement(By.name("quantity"));
		Quantity.clear();
		Quantity.sendKeys("2");
		
		driver.findElement(By.id("button-cart")).click();
		//String Success_msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/i")).getText();
	//System.out.println(Success_msg);
	
	driver.findElement(By.id("cart-total")).click();
	driver.findElement(By.xpath("//strong[text()=' View Cart']")).click();
	
	WebElement Update_quantity=driver.findElement(By.xpath("//div[@class='input-group btn-block']//input"));
	Update_quantity.clear();
	Update_quantity.sendKeys("3");
	
	driver.findElement(By.xpath("//button[@type='submit']//i")).click();
	//String Success_msg1=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
//System.out.println(Success_msg1);

String Eco_Tax=driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//table//tr[2]//td[2]")).getText();
	System.out.println("Eco_Tax is:"+ Eco_Tax);
	
	String VAT=driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//table//tr[3]//td[2]")).getText();
	System.out.println("Vat is:"+ VAT);
	
	driver.findElement(By.xpath("//a[text()='Checkout']")).click();
	//String Error_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/i")).getText();
	//System.out.println(Error_msg);
	
	//Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-danger']")).click();
	
	driver.findElement(By.xpath("//a[text()='Continue']")).click();
		}
		
		public static void MacBook() {
			
	WebElement MacBook=driver.findElement(By.xpath("//a[text()='MacBook']"));
	MacBook.click();
	
	String Mac_Quantity=driver.findElement(By.id("input-quantity")).getAttribute("value");
	System.out.println(Mac_Quantity);
	if(Mac_Quantity.equals("1"))
 {
	System.out.println("Default quantity is 1");
}else
{
	System.out.println("Default quantity is not 1");
}
	

WebElement Add_to_Cart2=driver.findElement(By.id("button-cart"));
Add_to_Cart2.click();

driver.findElement(By.partialLinkText("cart")).click();
//driver.findElement(By.id("cart-total")).click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion']//a[@href='#collapse-coupon']")));
driver.findElement(By.xpath("//a[@href='#collapse-coupon']")).click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-coupon")));
driver.findElement(By.id("input-coupon")).click();
driver.findElement(By.name("coupon")).sendKeys("ABCD123 ");

driver.findElement(By.id("button-coupon")).click();

String Warning_msg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/i")).getText();
System.out.println(Warning_msg);

driver.findElement(By.xpath("//button[@type='button' and @class='close']")).click();

driver.findElement(By.xpath("//a[text()='Use Gift Certificate ']")).click();

driver.findElement(By.id("input-voucher")).sendKeys("AXDFGH123 ");

driver.findElement(By.id("button-voucher")).click();

String Warning_msg2=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/i")).getText();
System.out.println(Warning_msg2);

driver.findElement(By.xpath("//button[@type='button' and @class='close']")).click();

 //wait=new WebDriverWait(driver,Duration.ofSeconds(30) );
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout"))).click();
driver.findElement(By.partialLinkText("Checkout")).click();
		}
	public static void registration() {
		driver.findElement(By.id("button-account")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Viji");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Natarajan");
		driver.findElement(By.id("input-payment-email")).sendKeys("viji@mail.com");
		driver.findElement(By.id("input-payment-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-payment-password")).sendKeys("pass123");
		driver.findElement(By.id("input-payment-confirm")).sendKeys("pass123");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("123 Avenue");
		driver.findElement(By.id("input-payment-city")).sendKeys("Mississauga");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("l2314");
		WebElement country=driver.findElement(By.id("input-payment-country"));
		country.click();
		Select select=new Select(country);
		select.selectByVisibleText("Canada");

		WebElement Region=driver.findElement(By.id("input-payment-zone"));
		Region.click();
		Select select1=new Select(Region);
		select1.selectByVisibleText("Ontario");

		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-register")).click();
		//driver.findElement(By.name("comment")).sendKeys("Payment option");
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.id("button-payment-method")).click();
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("window.scrollBy(0,-550)", "");		
		driver.findElement(By.xpath("//i[@class='fa fa-phone']")).click();
		driver.findElement(By.id("input-name")).sendKeys("viji");
		driver.findElement(By.id("input-email")).sendKeys("viji@mail.com");
		driver.findElement(By.id("input-enquiry")).sendKeys("enquiring about product");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}

	}

