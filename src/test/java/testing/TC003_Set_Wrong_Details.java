package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Workplace_Health;

public class TC003_Set_Wrong_Details extends BaseClass{
	
	Workplace_Health wh;
	@Test(priority=1)
	public void ScrollTo() throws InterruptedException {
		wh = new Workplace_Health(driver);
		logger.info("scrolling ");
		wh.scroll();
	}
	
	@Test(priority=2)
	public void set_Wrong_Details() throws InterruptedException {
		logger.info("Entering details");
		wh.enter_Wrong_Details();
		logger.info("details entered ");
	}
	
	@Test(priority=3)
	public void buttonDisplayed() {
		Assert.assertEquals(wh.btn_NotDisplay.isDisplayed(), true);
		logger.info(" Wrong details entered verified");
	}
	
	@Test(priority=4)
	public void clearFields() throws InterruptedException {
		logger.info("clearing all fields ");
		wh.clear_All_Fields();
		
	}

}
