package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTwo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		//Switch to FirstFrame
		WebElement frameOne = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
		driver.switchTo().frame(frameOne);
		//click on "Click Me" button
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		driver.switchTo().defaultContent();
		//count the Frame
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println("Total frame's in this Page "+iframes.size());
		//Third frame [Nested frame]
		WebElement frameThree = driver.findElement(By.xpath("(//div[@class='col-12 lg:col-6']//iframe)[3]"));
		driver.switchTo().frame(frameThree);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		String text = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
		if(text.contains("Clicked Me"))
		{
			System.out.println("Nested Frame clicked and button changed as:- " +text);
		}
		else
		{
			System.out.println("Nested Frame not clicked");
		}
		driver.switchTo().defaultContent();
		
	}

}
