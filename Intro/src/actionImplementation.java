import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class actionImplementation {

	public static void main(String[] args) throws IOException {
		System.setProperty("WebDriver.chrome.driver", "D:/Ajin/chromedriver-win64.chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		URL link = new URL("https://www.amazon.in/");
		String name = driver.getTitle();
		System.out.println(name);
		HttpURLConnection http=(HttpURLConnection)link.openConnection();
int resCode=http.getResponseCode();
System.out.println(resCode);

		Actions a = new Actions(driver);
		// a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).click();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("BEER").doubleClick().build().perform();
		a.moveToElement(driver.findElement(By.id("nav-search-submit-button"))).click().build().perform();
		// driver.quit();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String parentID=it.next();
		String chilsID=it.next();
		driver.switchTo().window(chilsID);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(span,'Budweiser 0.0 Non Alcoholic Pouch, 4 X 330 ml')]")));
		 WebElement product = driver.findElement(By.xpath("//h2[contains(span,'Budweiser 0.0 Non Alcoholic Pouch, 4 X 330 ml')]"));
		 a.scrollToElement(product).perform();
		 a.click(product).perform();
		 Set<String> links=driver.getWindowHandles();
		 Iterator<String> it1=links.iterator(); 
			
		// a.scrollFromOrigin(null, 0, 0);

	}

}
