package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//Get the price of the first product
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("price of the first product " +price);  
		//4. Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Number of rating of the first product " +rating);  
		//5. Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> one=new ArrayList<String>(windowHandles);
		//Switch to another
		driver.switchTo().window(one.get(1));	
		//6. Take a screen shot of the product displayed
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File Designation=new File("./Snaps/Screenshort.png");
		FileUtils.copyFile(screenshotAs, Designation);
		Thread.sleep(2000);
		//7. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();

		//8. Get the cart subtotal and verify if it is correct.
		Thread.sleep(2000);
		String subTotal = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']//span[@class='a-price-whole']")).getText();
		System.out.println("cart subtotal " +subTotal); 
		if(price.equals(subTotal))
		{
			System.out.println("Mobile Price verified"); 
		}
		else
		{
			System.out.println("Mobile Price wrong"); 
		}
		
		// Close the browser
		driver.quit();
	}

}
