package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Data_Output;



public class Doctor_Details extends BasePage{
	
	public Doctor_Details(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	Properties pr;
	
	@FindBy(xpath="(//input[@class='c-omni-searchbox c-omni-searchbox--small'])[1]") WebElement Ent_searchCity;
	@FindBy(xpath="//i[@class='icon-ic_cross_solid']")WebElement Btn_Cross;
	@FindBy(xpath="//div[@class='c-omni-suggestion-group']/div/span[1]") List<WebElement>drp_City;
	@FindBy(xpath="(//input[@class='c-omni-searchbox c-omni-searchbox--small'])[2]") WebElement Ent_searchDoc;
	@FindBy(xpath="//span[@class='c-omni-suggestion-item__content']/div") List<WebElement> Srch_result;
	@FindBy(xpath="//div[@data-qa-id='doctor_gender_section']") WebElement Slt_Gender;
	@FindBy(xpath="//div[@data-qa-id='doctor_gender_section']/ul/li") List<WebElement> drp_Gender;
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']") WebElement Slt_Stories;
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']/ul/li") List<WebElement> drp_Stories;
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']") WebElement Slt_Exp;
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']/ul/li") List<WebElement> drp_Exp;
	@FindBy(xpath="//span[@data-qa-id='all_filters']") WebElement Slt_AllFilter;
	@FindBy(xpath="//div[@class='pure-u-6-24']//label") List<WebElement> rad_Associate;
	@FindBy(xpath="//div[@class='pure-u-4-24']/div/label") List<WebElement> rad_AllFilter;
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']") WebElement SortBy;
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']/ul/li") List<WebElement> drp_SortBy;
	@FindBy(xpath="//h2[@class='doctor-name']") List<WebElement> get_DocNames;
	@FindBy(xpath="//div[@data-qa-id='doctor_experience']") List<WebElement> get_DocExp;
	@FindBy(xpath="//span[@data-qa-id='consultation_fee']") List<WebElement> get_ConFees;
	@FindBy(xpath="(//div[@class='product-tab'])[5]//div[1]") WebElement Slt_Surgeries;
	@FindBy(xpath="//div[@class='u-d-flex flex-ai-center u-spacer--top-md']") WebElement doc_scroll;
	
	public void Search() throws InterruptedException {
		
		Ent_searchCity.click();
		Btn_Cross.click();
		pr = testing.BaseClass.properties;
//		String city = Data_Input.cityName;
//		Ent_searchCity.sendKeys("bangalore");
		Ent_searchCity.sendKeys(pr.getProperty("city"));
		Thread.sleep(2000);
		for(int i=0;i<drp_City.size();i++) {
			if(drp_City.get(i).getText().equalsIgnoreCase("Bangalore")) {
				drp_City.get(i).click();
			}
		}
		
//		String doctor = Data_Input.DocType;
//		Ent_searchDoc.sendKeys("Dentist");
		Ent_searchDoc.sendKeys(pr.getProperty("doctor"));
		Thread.sleep(2000);
		for(int i=0;i<Srch_result.size();i++) {
			if(Srch_result.get(i).getText().equalsIgnoreCase("Dentist")) {
				Srch_result.get(i).click();
			}
		}
		
	}
	
	public void get_Doctors() throws InterruptedException {
		

		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(Slt_Stories));
		Slt_Stories.click();
		drp_Stories.get(1).click();
//		for(int i=0;i<drp_Stories.size();i++) {
//			if(drp_Stories.get(i).getText().equalsIgnoreCase("10+ Patient Stories")) {
//				drp_Stories.get(i).click();
//			}
//		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Slt_Exp));
		Slt_Exp.click();
		drp_Exp.get(1).click();
//		for(int i=0;i<drp_Exp.size();i++) {
//			if(drp_Exp.get(i).getText().equalsIgnoreCase("10+ Years of experience")) {
//				drp_Exp.get(i).click();
//			}
//		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Slt_AllFilter));
		Slt_AllFilter.click();
		for(int i=0;i<rad_AllFilter.size();i++) {
			if(rad_AllFilter.get(i).getText().equalsIgnoreCase("Above ₹500")) {
				rad_AllFilter.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Slt_AllFilter));
		Slt_AllFilter.click();
		for(int i=0;i<rad_AllFilter.size();i++) {
			if(rad_AllFilter.get(i).getText().equalsIgnoreCase("Available Today")) {
				rad_AllFilter.get(i).click();
			}
		}
		
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(SortBy));
		SortBy.click();
		drp_SortBy.get(1).click();
//		for(int i=0;i<drp_SortBy.size();i++) {
//			if(drp_SortBy.get(i).getText().equalsIgnoreCase("Consultation Fee - Low to High")) {
//				drp_SortBy.get(i).click();
//			}
//		}
		
	}
	
	public void print_Doctor_Names() throws InterruptedException {
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			System.out.println("Names: "+get_DocNames.get(i).getText()+", Exp: "+ get_DocExp.get(i).getText() +" Consulation Fees: " +get_ConFees.get(i).getText());
		}
		Data_Output.WriteToExcel(get_DocNames, get_DocExp, get_ConFees);
	}
	
	public void clickOnSurgeries() {
		wait.until(ExpectedConditions.elementToBeClickable(Slt_Surgeries));
		Slt_Surgeries.click();
	}
	public void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		wait.until(ExpectedConditions.visibilityOf(doc_scroll));
		js.executeScript("arguments[0].scrollIntoView();",doc_scroll);
		Thread.sleep(10000);
	}
	
}
