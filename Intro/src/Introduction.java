import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class Introduction {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name = driver.getTitle();
		System.out.println(name);
		// Thread.sleep(7000);
		// driver.findElement(By.id("APjFqb")).sendKeys("Beer");
		driver.findElement(By.id("inputUsername")).sendKeys("AjinJoy");
		driver.findElement(By.name("inputPassword")).sendKeys("Avemariam");
		driver.findElement(By.className("signInBtn")).click();
		// driver.close();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ajin");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("joyajin009@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8888564724");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
		Thread.sleep(5000);
		String password = driver.findElement(By.xpath("//form/p")).getText();

		String[] arr = password.split("'");
		String arr2[] = arr[1].split(",");
		System.out.println(arr2[0]);

	}
}
