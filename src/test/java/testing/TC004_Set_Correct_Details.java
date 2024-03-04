package testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Workplace_Health;

public class TC004_Set_Correct_Details extends BaseClass{
	
	public Workplace_Health wh;
	
	@Test(priority=1)
	public void ScrollTo() throws InterruptedException {
		wh = new Workplace_Health(driver);
		wh.scroll();
	}
	
	@Test(priority=2)
	public void set_Correct_Details() throws Exception {
		logger.info("Entering details again ");
		wh.enter_Correct_Details();
		logger.info("Details entered ");
	}
	
	@Test(priority=3)
	public void buttonDisplayed() {
		wh.buttonDisplay();
		logger.info("correct details entered ");
	}
	
	@Test(priority=4)
	public void click() {
		wh.buttonClick();
		logger.info("submit button clicked ");
	}
	
	@Test(priority=5)
	public void getMsg() throws InterruptedException {
		Thread.sleep(120000);
		wh.get_ThankYou_Message();
		logger.info("Thank you message displayed ");
	}
	
	@Test(priority=6)
	public void verifyMsg() throws Exception {
		Assert.assertEquals(wh.txt_Thankyou.isDisplayed(), true);
	}
	
	

}
