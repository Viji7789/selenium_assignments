package practice_forms;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tutorialspoint {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement PromptBox=driver.findElement(By.id("banner-accept"));
		PromptBox.click();


		WebElement firstname=driver.findElement(By.name("firstname"));
		firstname.sendKeys("Vijayalakshmi");

		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.sendKeys("Natarajan");

		WebElement gender=driver.findElement
				(By.xpath("//input[@value='Female']"));
		gender.click();

		WebElement experience=driver.findElement
				(By.xpath("//input[@value='1']"));
		experience.click();

		WebElement Date=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/form/table/tbody/tr[5]/td[2]/input"));
		Date.sendKeys("July-18-2022");

		WebElement Profession=driver.
			findElement(By.xpath("//input[@value='Automation Tester']"));
		Profession.click();

		WebElement Tool1=driver.
				findElement(By.xpath("//input[@value='RC']"));
			Tool1.click();

			WebElement Tool2=driver.
					findElement(By.xpath("//input[@value='Selenium Webdriver']"));
				Tool2.click();
				
			WebElement Continents=driver.findElement(By.name("continents"));
		Select select=new Select(Continents);
		select.selectByIndex(5);

		WebElement Commands=driver.
				findElement(By.xpath("//select[@name='selenium_commands']"));
		Select multiselect=new Select(Commands);
		multiselect.selectByVisibleText("Browser Commands");
		multiselect.selectByIndex(3);

		WebElement Button=driver.findElement(By.name("submit"));
		Button.click();
		driver.switchTo().alert().accept();
		driver.quit();
	}

}
