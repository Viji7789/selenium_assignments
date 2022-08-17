package practice_forms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Juice_shop {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://juice-shop.herokuapp.com/#/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		register();
	}

	public static void register() throws InterruptedException {
		Thread.sleep(4000);
		//WebElement frame=driver.findElement(By.id("mat-dialog-0"));
		driver.switchTo().alert().dismiss();
		//driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		}
}
