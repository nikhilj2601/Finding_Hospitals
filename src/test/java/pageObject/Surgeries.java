package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Surgeries extends BasePage{
	
	public Surgeries(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	@FindBy(xpath="//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']//p") List<WebElement> get_SurgeriesName;
	@FindBy(xpath="//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']") WebElement Slt_Corporate;
	@FindBy(xpath="//div[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']//div/div") List<WebElement> drp_Corporate;
	@FindBy(xpath="//h1[contains(text(),'We are experts in Surgical solutions for 50+ ailme')]") WebElement h1_Popular;
	
	public void print_Surgeries_Name() {
//		System.out.println("************************************************************");
		System.out.println("Surgeries Name: ");
		for(int i=0;i<get_SurgeriesName.size();i++) {
			System.out.println(get_SurgeriesName.get(i).getText());
		}
//		System.out.println("************************************************************");

	}
	
	public void Select_Health_Wellness_Plans() {
		Slt_Corporate.click();
		for(int i=0;i<drp_Corporate.size();i++) {
			if(drp_Corporate.get(i).getText().equalsIgnoreCase("Health & Wellness Plans")) {
				drp_Corporate.get(i).click();
			}
		}
	}
	
	public void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		wait.until(ExpectedConditions.visibilityOf(h1_Popular));
		js.executeScript("arguments[0].scrollIntoView();",h1_Popular);
		Thread.sleep(10000);
	}
}
