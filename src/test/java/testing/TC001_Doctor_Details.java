package testing;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Doctor_Details;

public class TC001_Doctor_Details extends BaseClass{
	
	
	public Doctor_Details dd;
	public  Doctor_Details dd1;
	public Doctor_Details dd2;
	

	@Test(priority=1, groups= {"smoke"})
	public void Check_for_correct_page() {
		String Actual_title =driver.getTitle();
		String Expected_title ="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
		Assert.assertEquals(Actual_title,Expected_title );
		logger.info("Visited the correct site");
		
	}
	@Test(priority=2)
	public void getting_correct_city() throws Exception {
		dd = new Doctor_Details(driver);
		dd.Search();
		logger.info("Selected the city and doctor ");
//		screenShoot.takeSnapShot(driver,"docDetails");
//		screenshot(driver,"doctorDetails");
//		dd.print_Doctor_Names();
		
		
	}
	@Test(priority=3)
	public  void get_list_of_doctors() throws InterruptedException {
		logger.info("getting list of doctors ");
		dd.get_Doctors();
		logger.info("printed the list of doctors ");
	}
	
	
	@Test(priority=4)
	public  void Scolldown() throws InterruptedException {
		
		dd.scroll();
		logger.info("Scrolled down ");
	}
	@Test(priority=5)
	public  void Printing_names() throws Exception {
		
//		screenShoot.takeSnapShot(driver, "docDetails");
//		screenshot(driver,"doctorDetails");
		logger.info("printing doctors details in excel");
		dd.print_Doctor_Names();
	}
	@Test(priority=6)
	public void surgeriesClicked() {
		logger.info("clicking on surgeries");
		dd.clickOnSurgeries();
		logger.info("clicked on surgeries");
	}
	
	
	
	
	
	
	
	

}
