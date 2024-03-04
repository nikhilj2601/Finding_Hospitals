package testing;

import org.testng.annotations.Test;

import pageObject.Surgeries;

public class TC002_Surgeries extends BaseClass{
		
	Surgeries sr;
	
	
	@Test(priority=1)
	public void ScrollDown() throws InterruptedException {
		logger.info("scolling down till surgeries ");
		sr = new Surgeries(driver);
		sr.scroll();
	}
	
	
	@Test(priority=2)
	public void get_Surgeries_List() {
		logger.info("printing surgeries in console ");
		Surgeries sr1 = new Surgeries(driver);
		sr1.print_Surgeries_Name();	
		logger.info("List of surgeries is printed ");
	}
	
	@Test(priority=3)
	public void clickOnForm() {
		logger.info("Navigating to workplace health page ");
		Surgeries sr2 = new Surgeries(driver);
		sr2.Select_Health_Wellness_Plans();
	}

}