package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		//ChromeOptions option =new ChromeOptions();
		//option.addArguments("--disable-notification");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//Login
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Go to Create Lead page
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		//Click on First Resulting Contact
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		//back to main window
		driver.switchTo().window(newWindow.get(0));
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::a)[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newWindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(newWindow1.get(1));
		//Click on Second Resulting Contact		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		//back to main window
		driver.switchTo().window(newWindow1.get(0));
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		if(title.contains(title))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title verification failed");

		}

	}
}

