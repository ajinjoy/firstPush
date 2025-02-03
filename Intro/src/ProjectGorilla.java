import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProjectGorilla {

	public static void main(String[] args) throws InterruptedException {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the number of adults: ");
		int i = obj.nextInt();
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String name = driver.getTitle();
		System.out.println(name);
		passengerSelection(driver, i);
		Thread.sleep(1000);
		locationSelection("Pune", "Mumbai", driver);
		Thread.sleep(1000);
		dateSelection(driver);

	}

	public static void passengerSelection(WebDriver driver, int i) throws InterruptedException {
		WebElement currencydrp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currencydrpdwn = new Select(currencydrp);
		currencydrpdwn.selectByContainsVisibleText("USD");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for (int j = 1; j < i; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(500);
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		String passenger = driver.findElement(By.id("divpaxinfo")).getText();
		Assert.assertEquals(i + " Adult", passenger);
		System.out.println("Passengers selected are :" + i + " Adults");
	}

	public static void locationSelection(String from, String to, WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(), ' Pune (PNQ)')]")).click();
		Thread.sleep(1000);
		// String dest =
		// driver.findElement(By.xpath("//div[@class='left1']/input[@menuselection='true']")).getText();
		// System.out.println(dest);
		driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(), ' Mumbai (BOM)')])[2]")).click();
		Thread.sleep(1000);
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();

	}

	public static void dateSelection(WebDriver driver) throws InterruptedException {

		// driver.findElement(By.className("ctl00$mainContent$view_date1")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		Boolean flag = driver.findElement(By.xpath("(//input[@type='text'])[4]")).isEnabled();
		Assert.assertFalse(flag);
		System.out.println("OK!!!");

	}
}
