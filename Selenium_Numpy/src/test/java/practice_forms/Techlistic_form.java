package practice_forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Techlistic_form {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", 
		"C:\\chromedriver_win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

driver.manage().window().getPosition();

//driver.wait(2000);
WebElement firstname=driver.findElement(By.name("firstname"));
firstname.sendKeys("Vijayalakshmi");

WebElement lastname=driver.findElement(By.name("lastname"));
lastname.sendKeys("Natarajan");

WebElement gender=driver.findElement(By.id("sex-1"));
gender.click();

WebElement experience=driver.findElement(By.id("exp-0"));
experience.click();

WebElement Date=driver.findElement(By.id("datepicker"));
Date.sendKeys("July-18-2022"+Keys.ENTER);

WebElement Profession=driver.findElement(By.id("profession-1"));
Profession.click();

WebElement Tools=driver.findElement(By.id("tool-2"));
Tools.click();

WebElement Continents=driver.findElement(By.id("continents"));
Select select=new Select(Continents);
select.selectByIndex(5);

WebElement Commands=driver.findElement(By.id("selenium_commands"));
Select multiselect=new Select(Commands);
//multiselect.selectByValue("Browser Commands");
multiselect.selectByIndex(3);

WebElement Button=driver.findElement(By.id("submit"));
Button.click();

driver.close();
	}

}
