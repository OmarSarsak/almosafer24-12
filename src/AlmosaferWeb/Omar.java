package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Omar extends Project {

	@BeforeTest
	public void mySetUp() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popUpScreen = driver.findElement(By.className("sc-iBmynh"));

		if (popUpScreen.isDisplayed()) {
			WebElement SARButton = driver.findElement(By.className("cta__saudi"));
			SARButton.click();
		}
	}

	@Test(priority = 1)
	public void CheckTheDefualtlanguageIsEnglish() {
		String ExpectedLanguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("HTML")).getAttribute("lang").toUpperCase();
		assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2)
	public void CheckTheDefualtCurrencyIsSAR() {
		String ExpectedCurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNumber() {
		String ExpectedContactNumber = "+966554400000";
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4)
	public void CheckQitafLogo() {
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		assertEquals(theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(), true);

	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelectedByDefualt() {
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"), "false");

	}
	
	@Test(priority = 7)
	public void RandomMethodToChangeTheLanguage() {
		Random rand = new Random();
		int randomIndexForTheWebSites = rand.nextInt(webSites.length);
		driver.get(webSites[randomIndexForTheWebSites]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			String ExpectedLang = "ar";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLang, ExpectedLang);
		}
		else {
			String ExpectedLang = "en";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLang, ExpectedLang);
		}
			
	}
	
	@AfterTest
	public void myPostTest() {

	}
}
