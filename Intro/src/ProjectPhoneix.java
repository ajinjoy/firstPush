import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ProjectPhoneix {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Akoi");
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("Akoi@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Alpha");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("20122025");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(text);

	}

}
