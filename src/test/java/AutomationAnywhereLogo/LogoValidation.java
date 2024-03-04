package AutomationAnywhereLogo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoValidation{

public static void main(String[] args){
System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.get("https://automationanywhere.com");

Boolean logoStatus = driver.findElement(By.xpath("//a[@class='coh-link header-logo']//img[@alt='Automation Anywhere']")).isDisplayed();
Assert.assertTrue(logoStatus, "Logo is displaying");

Boolean btnStatus = driver.findElement(By.xpath("//a[@title='Request Demo']")).isEnabled();
Assert.assertTrue(btnStatus, "Button is clickable");


}

}

