package AutomationAnywhereLogo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PageVerification{

public static void main(String[] args) throws InterruptedException{
System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.get("https://automationanywhere.com");
Thread.sleep(5000);
driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
Boolean productsPage = driver.findElement(By.xpath("//a[@href='/products' and text()='Products']")).isDisplayed();
Assert.assertTrue(productsPage, "Products link is not available");
driver.findElement(By.xpath("//a[@href='/products' and text()='Products']")).click();
Thread.sleep(5000);
Boolean solutionsPage = driver.findElement(By.xpath("//a[@href='/solutions' and text()='Solutions']")).isDisplayed();
Assert.assertTrue(solutionsPage, "Solutions link is not available");
driver.findElement(By.xpath("//a[@href='/solutions' and text()='Solutions']")).click();
Thread.sleep(5000);
Boolean resourcesPage = driver.findElement(By.xpath("//a[@href='/resources' and text()='Resources']")).isDisplayed();
Assert.assertTrue(resourcesPage, "Resources link is not available");
driver.findElement(By.xpath("//a[@href='/resources' and text()='Resources']")).click();
Thread.sleep(5000);
Boolean companyPage = driver.findElement(By.xpath("//a[@href='/company/about-us' and text()='Company']")).isDisplayed();
Assert.assertTrue(companyPage, "Company link is not available");
driver.findElement(By.xpath("//a[@href='/company/about-us' and text()='Company']")).click();

  }

}

