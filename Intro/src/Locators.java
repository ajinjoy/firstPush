import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String name = driver.getTitle();
		System.out.println(name);
		// Thread.sleep(7000);
		// driver.findElement(By.id("APjFqb")).sendKeys("Beer");
		driver.findElement(By.id("inputUsername")).sendKeys("AjinJoy");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText().toString();
		String expected = "You are successfully logged in.";
		Assert.assertEquals(msg, expected);

	}

}
