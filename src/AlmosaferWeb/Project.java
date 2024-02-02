package AlmosaferWeb;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import org.openqa.selenium.WebDriver;


public class Project {

	WebDriver driver = new ChromeDriver();
	
	String URL = "https://global.almosafer.com/en";
	Random randForCity = new Random();
	String []webSites = {"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
	String []citiesInEnglish = {"dubai","jeddah","riyadh"};
	int randomEnglishCity = randForCity.nextInt(citiesInEnglish.length);
	String[] citiesInArabic = {"دبي","جدة"};
	int randomArabicCity = randForCity.nextInt(citiesInArabic.length);

}
