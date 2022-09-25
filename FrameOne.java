package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameOne {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		String topic = driver.findElement(By.xpath("//label[@style='font-size:40px']")).getText();
		System.out.println(topic);
		//Switch to FirstFrame
		WebElement frameOne = driver.findElement(By.xpath("//label[@style='font-size:40px']/following::iframe"));
		driver.switchTo().frame(frameOne);
		//move to inner frame
		WebElement innerFrame = driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::iframe"));
		driver.switchTo().frame(innerFrame);
		WebElement checkBox = driver.findElement(By.id("a"));
		checkBox.click();
		//Verify check box is checked
		if(checkBox.isSelected()==true)
		{
			System.out.println("CheckBox is checked in inner Frame");  
		}
		else
		{
			System.out.println("CheckBox is not checked");  
		}
		driver.switchTo().parentFrame();
		//Enter Text
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Pavi");
		driver.switchTo().defaultContent();
		//Switch to Second frame
		driver.switchTo().frame(1);
		//select the value from drop down
		WebElement SelectAnimals = driver.findElement(By.id("animals"));
		Select option=new Select(SelectAnimals);
		option.selectByIndex(2);
	}
}
