import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ProjectDaffodils {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		String expProd = "";
		int flag = 0;
		for (int i = 0; i < products.size() - 1; i++) {

			expProd = products.get(i).getText();
			flag++;
			// System.out.println(expProd);
			if (expProd.contains("Broco")) {
				break;

			}
		}
		System.out.println(expProd);
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])" + "[" + flag + "]")).click();
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		String verify = driver.findElement(By.className("product-name")).getText();
		Assert.assertEquals(expProd, verify);
		System.out.println("OK!!!!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//label[text()='Choose Country']")).isDisplayed()) {
			System.out.println("Navigation complete!!!");
		}

	}
}
