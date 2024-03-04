package testing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	public static Properties properties=new Properties();

	@BeforeTest
	@Parameters({"os","browser"})
	public void Intiate_WebDriver(String os, String browser) throws IOException {
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		 properties.load(file);
		
		//loading log4j2 file
		logger.info("WebDriver initiated");

		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		    }
		else if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(browser.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();
 
	}
	@AfterTest(groups= {"smoke"})
	public void Close_Driver() {
		driver.quit();
	}
	
	public void screenshot(WebDriver driver,String ScreenShotName ) throws IOException {
		try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destinationPath = (System.getProperty("user.dir") + "\\screenshots\\" + ScreenShotName +".png");
            Files.copy(source.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
	}
}
