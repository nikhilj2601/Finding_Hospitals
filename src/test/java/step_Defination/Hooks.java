package step_Defination;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testing.BaseClass;
 
public class Hooks{
	public Logger logger = LogManager.getLogger(this.getClass());
	static Properties p;
	public static BaseClass bs = new BaseClass();
	public static WebDriver driver = new ChromeDriver();
 
 
	@BeforeAll
	public static void getWebDriver() throws IOException{
		
//		bs.Intiate_WebDriver("Windows", "chrome");
		p = BaseClass.properties;
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p.load(file);
//		logger = testing.BaseClass.Logger
		driver.get(p.getProperty("URL"));
//		driver.get("https://www.practo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
 
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		TakesScreenshot ts=(TakesScreenshot)driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());

	}
}