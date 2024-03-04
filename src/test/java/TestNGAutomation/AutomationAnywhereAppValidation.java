package TestNGAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

	public class AutomationAnywhereAppValidation{

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialization() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://automationanywhere.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	}

	@Test
	public void LogoValidationTest(){
	Boolean logoStatus = driver.findElement(By.xpath("//a[@class='coh-link header-logo']//img[@alt='Automation Anywhere']")).isDisplayed();
	softAssert.assertTrue(logoStatus, "Logo is displaying");

	Boolean btnStatus = driver.findElement(By.xpath("//a[@title='Request Demo']")).isEnabled();
	softAssert.assertTrue(btnStatus, "Button is clickable");
	}

	@Test
	public void AutomationAnywhereAppPageValidation() throws InterruptedException{
	WebElement productsLink = driver.findElement(By.xpath("//a[@href='/products' and text()='Products']"));
	Boolean productsPage = productsLink.isDisplayed();
	softAssert.assertTrue(productsPage, "Products Link is Displaying");
	
	productsLink.click();
	Thread.sleep(5000);

	WebElement solutionsLink = driver.findElement(By.xpath("//a[@href='/solutions' and text()='Solutions']"));
	
	Boolean solutionsPage = solutionsLink.isDisplayed();
	softAssert.assertTrue(solutionsPage, "Solutions Link is Displaying");
	solutionsLink.click();
	Thread.sleep(5000);
	WebElement resourcesLink = driver.findElement(By.xpath("//a[@href='/resources' and text()='Resources']"));
	
	Boolean resourcesPage = resourcesLink.isDisplayed();
	softAssert.assertTrue(resourcesPage, "Resources Link is Displaying");
	resourcesLink.click();
	Thread.sleep(5000);
	WebElement companyLink = driver.findElement(By.xpath("//a[@href='/company/about-us' and text()='Company']"));
	Boolean companyPage = companyLink.isDisplayed();
	softAssert.assertTrue(companyPage, "Company Link is Displaying");
	companyLink.click();

	}

	@AfterMethod
	public void tearDown(){
	softAssert.assertAll();
	driver.quit();
	}

	}
	
