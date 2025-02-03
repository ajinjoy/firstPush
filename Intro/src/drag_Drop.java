import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class drag_Drop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String name = driver.getTitle();
		System.out.println(name);
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")));
		int frames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(links);
		System.out.println(frames);
		Thread.sleep(1000);
		int footerLinks=driver.findElements(By.xpath("//*[@id='gf-BIG']//li/a")).size();
		 //for(int i=1;i<=footerLinks;i++) 
		 //{ 
			 String linkName=driver.findElement(By.xpath("//*[@id='gf-BIG']//li/a[1]")).getText();
			 System.out.println(linkName);
			 //}
		

	}

}
