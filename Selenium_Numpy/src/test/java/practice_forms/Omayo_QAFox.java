package practice_forms;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Omayo_QAFox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebElement link=driver.findElement(By.xpath("//a[text()='Page One']"));
link.click();


WebElement text=driver.findElement(By.xpath("//div[@class='post-body entry-content']"));
String textgiven=text.getText();
System.out.println("The given text is:"+ textgiven);

WebElement home_link=driver.findElement(By.xpath("//div[@class='widget-content']/parent::div[@id='Text1']"));
home_link.click();

WebElement multibox=driver.findElement(By.id("multiselect1"));
Select multiselect=new Select(multibox);
multiselect.selectByIndex(2);
multiselect.selectByVisibleText("Audi");

/*WebElement dropdown=driver.findElement(By.id("drop1"));
dropdown.click();*/

WebElement dropselection=driver.findElement(By.id("ironman4"));
dropselection.click();

WebElement selenium_link=driver.findElement(By.id("link1"));
selenium_link.click();

driver.navigate().back();

WebElement TextAreaField=driver.findElement(By.id("ta1"));
TextAreaField.sendKeys("Hello Welcome to Test Automation Pracitce");

//table
System.out.println(driver.findElement(By.id("table1")).getText());


WebElement TextAreaFieldTwo=driver.findElement(By.xpath("//textarea[@rows='10' and @cols='30']"));
//TextAreaFieldTwo.sendKeys(Keys.CONTROL,Keys.HOME);
TextAreaFieldTwo.sendKeys("The appended text");

WebElement Preloaded_textbox=driver.findElement(By.id("textbox1"));
String TextIs=Preloaded_textbox.getText();
System.out.println(TextIs);

WebElement Enabled_Button=driver.findElement(By.id("but2"));
if(Enabled_Button.isEnabled())
{
	System.out.println("Button is enabled");
}

WebElement Disabled_Button=driver.findElement(By.id("but1"));
if(!Disabled_Button.isEnabled())
{
	System.out.println("Button is disabled");
}

List<WebElement> Buttons=driver.findElements(By.xpath("//button[@name='samename' and @type='button']"));
int no_of_buttons=Buttons.size();
for(int i=0;i<no_of_buttons;i++)
{
	System.out.println(Buttons.get(i).getText());
}

WebElement SearchField=driver.findElement(By.xpath("//input[@name='q']"));
SearchField.sendKeys("text");
driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();

WebElement SearchOutput=driver.findElement(By.xpath("//div[@class='status-msg-body']"));
System.out.println(SearchOutput.getText());

driver.findElement(By.id("radio2")).click();//Sex

driver.findElement(By.id("alert1")).click();//alert
driver.switchTo().alert().accept();

//defualt checkbox
if(driver.findElement(By.id("checkbox1")).isSelected()) {
	System.out.println("Orange is selected by default");
}

//readonly text
System.out.println(driver.findElement(By.id("rotb")).getText());

//prompt
driver.findElement(By.id("prompt")).click();
Alert prompt=driver.switchTo().alert();
prompt.sendKeys("Practice");
prompt.accept();

//confirmation alert
driver.findElement(By.id("confirm")).click();
driver.switchTo().alert().accept();

//hidden button
if(!driver.findElement(By.id("hbutton")).isDisplayed()){
	System.out.println("Hidden Button");
}
//name attribute
driver.findElement(By.name("textboxn")).sendKeys("Hello");

//same id and name
System.out.println(driver.findElement(By.xpath("//input[@id='sa' and @name='sa']")).getText());

driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']")).click();

driver.close();

	}

}
