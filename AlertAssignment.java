package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node04d4uviku9lwpglaq6yk0lyt345050.node0");
		driver.manage().window().maximize();
		//Switch to simple alert
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String simpleAlert = driver.findElement(By.id("simple_result")).getText();
		System.out.println(simpleAlert);
		//Confirm Alert accept
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		String confirmAlert = driver.findElement(By.id("result")).getText();
		System.out.println("In confirm alert " +confirmAlert);
		//Confirm Alert dismiss
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		String confirmAlert1 = driver.findElement(By.id("result")).getText();
		System.out.println("In confirm alert " +confirmAlert1);
		//Switch to SWEET alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		WebElement sweetAlert = driver.findElement(By.xpath("//span[text()='Dismiss']"));
		sweetAlert.click();
		//		//Switch to SWEET model alert
		//		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		//		WebElement sweetAlert1 = driver.findElement(By.xpath("(//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all']//span)[2]"));
		//		sweetAlert1.click();
		//Switch to prompt alert
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert alert5 = driver.switchTo().alert();
		alert5.sendKeys("Pavi");
		alert5.accept();
		String promptAlert = driver.findElement(By.id("confirm_result")).getText();
		System.out.println("In alert " +promptAlert);
		// sweet alert confirmation
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-confirmdialog-yes']")).click();
		// Minimize and maxmize
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		//driver.switchTo().alert();
		driver.findElement(By.xpath("(//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top ui-draggable-handle']//a)[4]")).click();
		driver.findElement(By.xpath("//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-minimize ui-corner-all']")).click();

	}
}
