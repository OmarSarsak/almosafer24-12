package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
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
	
	@Test(priority = 6)
	public void CheckDepatureDateAndReturnDate() {
		LocalDate today = LocalDate.now();
		int ExpectedDepatureDate = today.plusDays(1).getDayOfMonth();
		int ExpectedReturnDate = today.plusDays(2).getDayOfMonth();
		
		int ActualDepatureDate = Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText());
		int ActualReturnDate = Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText());
		assertEquals(ActualDepatureDate, ExpectedDepatureDate);
		assertEquals(ActualReturnDate, ExpectedReturnDate);

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
	
	@Test(priority = 8)
	public void switchToHotelTab() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		
		if(driver.getCurrentUrl().contains("ar")) {
			WebElement SearchCityInput = driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));
			SearchCityInput.sendKeys(citiesInArabic[randomArabicCity]);
		}
		else {
			WebElement SearchCityInput = driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
			SearchCityInput.sendKeys(citiesInEnglish[randomEnglishCity]);
		}

	}
	
	@AfterTest
	public void myPostTest() {

	}
}
