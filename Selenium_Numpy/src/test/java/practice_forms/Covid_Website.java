package practice_forms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
public class Covid_Website {

	
		public static void collectHospitalNames() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			int numberofhosp = driver.findElements(By.xpath("//div[@class='card custom-card']")).size();

			for(int i=1; i<=numberofhosp;i++){
				
				String hospitalName = driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//a")).getText();
				System.out.println(hospitalName.replace("Contact", ""));
			
				String Total_availablebeds=driver.findElement(By.xpath("//div[@aria-controls='collapseOne-"+i+"']//span[@class='count-text']")).getText();
				System.out.println(Total_availablebeds);
				
				driver.findElement(By.xpath("//div[@type='button' and @aria-controls='collapseOne-"+i+"']")).click();
				
				String O2Beds=driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='HDU(O2)']/following-sibling::div")).getText();
				System.out.println("O2 bed availability:" + O2Beds);
				
				String Ventilator=driver.findElement(By.xpath("//div[@class='card custom-card']["+i+"]//div[text()='Ventilator']/following-sibling::div")).getText();
				System.out.println("Ventilator availability:"+Ventilator);
				
				
				//Contact details
				driver.findElement(By.xpath("//div[@id='headingOne-" + i + "']//span[@class='pl-1']")).click();
				//Thread.sleep(1000);
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30) );
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='lblhosCno']")));
				String Contact_number=driver.findElement(By.xpath("//span[@id='lblhosCno']")).getText();
				System.out.println(Contact_number);
				driver.findElement(By.xpath("//button[@type='button'and @class='close']")).click();
				System.out.println("\n");

				}
			
				}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		collectHospitalNames();

	}

}
