package practice_forms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Dress_Shop {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		add_to_cart() ;
		add_to_compare();
		checkout();
		}

	private static void add_to_cart() {
		driver.findElement(By.id("search_query_top")).sendKeys("summer dress"+Keys.ENTER);
		
		Actions actions=new Actions(driver);
		//WebElement summer_dress=driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']"));
		WebElement summer_dress=driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]//a"));
		actions.moveToElement(summer_dress).build().perform();
		
		driver.findElement(By.xpath("//a[@title='Add to cart' and @data-id-product='5']")).click();
		
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
		
	}
	
	private static void add_to_compare() throws InterruptedException {
		driver.navigate().refresh();
			Actions actions=new Actions(driver);
			WebElement summer_dress=driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]//a"));
			actions.moveToElement(summer_dress).build().perform();
			driver.findElement(By.xpath("//a[@class='add_to_compare' and @data-id-product='5']")).click();
			
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();

				WebElement faded_short=driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[4]//a"));
				actions.moveToElement(faded_short).build().perform();
				driver.findElement(By.xpath("//a[@class='add_to_compare' and @data-id-product='1']")).click();
				
				
				driver.findElement(By.xpath("//div[@class='bottom-pagination-content clearfix']//form[@class='compare-form']")).click();

				JavascriptExecutor executor=(JavascriptExecutor)driver; 
				executor.executeScript("window.scrollBy(0,700)");
				
				String first_price=driver.findElement(By.xpath("//table[@id='product_comparison']//td[2]//div[3]//span[@class='price product-price']")).getText();
				System.out.println(first_price);
				String second_price=driver.findElement(By.xpath("//table[@id='product_comparison']//td[3]//div[3]//span[@class='price product-price']")).getText();
				System.out.println(second_price);
				first_price=first_price.replace("$","");
				second_price=second_price.replace("$","");
				float price1=Float.parseFloat(first_price);
				float price2=Float.parseFloat(second_price);
				if(price1 > price2) {
					driver.findElement(By.xpath("//table[@id='product_comparison']//td[2]//div[5]//div//div//a[1]")).click();
				}
				else {
					driver.findElement(By.xpath("//table[@id='product_comparison']//td[3]//div[5]//div//div//a[1]")).click();
				}
				driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
				if(price1 < price2) {
				driver.findElement(By.xpath("//td[2]//i[@class='icon-trash']")).click();
				}
				else {
					driver.findElement(By.xpath("//td[3]//i[@class='icon-trash']")).click();

				}
	}

	public static void checkout() {
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		WebElement cart=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		actions.moveToElement(cart).click().build().perform();
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")).click();
//create account		
		driver.findElement(By.id("email_create")).sendKeys("test5135@email.com");
		driver.findElement(By.id("SubmitCreate")).click();
//register
		driver.findElement(By.id("customer_firstname")).sendKeys("fname");
		driver.findElement(By.id("customer_lastname")).sendKeys("lname");
		driver.findElement(By.id("passwd")).sendKeys("hello");
//address		
		driver.findElement(By.id("firstname")).sendKeys("fname");
		driver.findElement(By.id("lastname")).sendKeys("lname");
		driver.findElement(By.id("address1")).sendKeys("avenue");
		driver.findElement(By.id("city")).sendKeys("sauga");
		WebElement state=driver.findElement(By.id("id_state"));
		state.click();
		Select select =new Select(state);
		select.selectByVisibleText("Connecticut");
		driver.findElement(By.id("postcode")).sendKeys("87653");
		
		WebElement country=driver.findElement(By.id("id_country"));
		country.click();
		Select select1=new Select(country);
		select1.selectByVisibleText("United States");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("9871235476");
		driver.findElement(By.id("alias")).sendKeys("alias");
		
		driver.findElement(By.id("submitAccount")).click();
//update address		
		JavascriptExecutor executor=(JavascriptExecutor)driver; 
		executor.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_update']//a")).click();
		
		driver.findElement(By.id("phone")).sendKeys("9632587410");
		driver.findElement(By.id("submitAddress")).click();
		driver.findElement(By.name("processAddress")).click();
//shipping mode
		
		executor.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
//payment
		executor.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
		executor.executeScript("window.scrollBy(0,400)");

		driver.findElement(By.xpath("//p[@id='cart_navigation']//button")).click();
//order confirmation		
		driver.findElement(By.xpath("//a[@title='Back to orders']")).click();
		String order_ref=driver.findElement(By.xpath("//table[@id='order-list']//a[@class='color-myaccount']")).getText();
		System.out.println("Order reference :"+ order_ref);
		String status=driver.findElement(By.xpath("//table[@id='order-list']//span[@class='label dark']")).getText();
		System.out.println("Order Status :"+ status);
		driver.findElement(By.xpath("//a[@class='color-myaccount']")).click();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		String tax_amount=driver.findElement(By.xpath("//div[@id='order-detail-content']//table//tfoot//tr[2]//span")).getText();
		System.out.println("Item price with tax:"+ tax_amount);
		String Total=driver.findElement(By.xpath("//table[@id='order-list']//span[@class='price']")).getText();
		System.out.println("Total Price with shipping :" + Total);

//sign out
		actions.sendKeys(Keys.PAGE_UP).build().perform();

		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	}
}
