package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://www.leafground.com/window.xhtml");
		//click button
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> one=new ArrayList<String>(windowHandles);
		//Switch to another
		driver.switchTo().window(one.get(1));
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		if(title.equals(title))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title verification failed");

		}

	}

}
