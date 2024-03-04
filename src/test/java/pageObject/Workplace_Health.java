package pageObject;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workplace_Health extends BasePage{
	
	public Workplace_Health(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Properties pr = testing.BaseClass.properties;
	
	@FindBy(xpath="(//input[@id='name'])[1]") WebElement Name;
	@FindBy(xpath="(//input[@id='organizationName'])[1]") WebElement Org_Name;
	@FindBy(xpath="(//input[@id='contactNumber'])[1]") WebElement Cont_No;
	@FindBy(xpath="(//input[@id='officialEmailId'])[1]") WebElement Email;
	@FindBy(xpath="(//select[@id='organizationSize'])[1]") WebElement drp_OrgSize;
	@FindBy(xpath="(//select[@id='interestedIn'])[1]") WebElement drp_Int;
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-grey-3'])[1]") public WebElement btn_NotDisplay;
	@FindBy(xpath="(//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue'])[1]") public WebElement btn_Display;
	@FindBy(xpath="(//div[@class=\"text-center\"]/div)[1]") public WebElement txt_Thankyou;
	@FindBy(xpath="//h2[normalize-space()='Schedule a Demo']")WebElement ScheduleScroll;
	
	
	public void enter_Wrong_Details() {
		Name.sendKeys(pr.getProperty("Name"));
		Org_Name.sendKeys(pr.getProperty("OrgName"));
		Cont_No.sendKeys(pr.getProperty("ContactNo"));
		Email.sendKeys(pr.getProperty("WrongEmail"));
		Select sl = new Select(drp_OrgSize);
		sl.selectByVisibleText("501-1000");
		Select sl1 = new Select(drp_Int);
		sl1.selectByVisibleText("Taking a demo");
		btn_NotDisplay.isDisplayed();
		
	}
	
	public void clear_All_Fields() throws InterruptedException {
		Thread.sleep(2000);
		Name.clear();
		Org_Name.clear();
		Cont_No.clear();
		Email.clear();
		
	}
	
	public void enter_Correct_Details() throws InterruptedException {
		Thread.sleep(2000);
		Name.sendKeys(pr.getProperty("Name"));
		Org_Name.sendKeys(pr.getProperty("OrgName"));
		Cont_No.sendKeys(pr.getProperty("ContactNo"));
		Email.sendKeys(pr.getProperty("CorrectEmail"));
		Select sl = new Select(drp_OrgSize);
		sl.selectByVisibleText("501-1000");
		Select sl1 = new Select(drp_Int);
		sl1.selectByVisibleText("Taking a demo");		
	}
	
	public void buttonDisplay() {
		System.out.println(btn_Display.isDisplayed());
	}
	
	public void buttonClick() {
		btn_Display.click();
	}
	public void get_ThankYou_Message() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println(txt_Thankyou.getText());
		
	}
	
	public void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		wait.until(ExpectedConditions.visibilityOf(ScheduleScroll));
		js.executeScript("arguments[0].scrollIntoView();",ScheduleScroll);
		Thread.sleep(10000);
	}
}
