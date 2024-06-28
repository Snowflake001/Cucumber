package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.FilterPage;

public class FilterSteps extends BaseClass {
	
	FilterPage filterpg = new FilterPage(driver);
	
	
	@Then("User Selects A to Z filter and validate")
	public void user_selects_a_to_z_filter_and_validate() throws InterruptedException {
	    filterpg.ApplyandValidateAtoZFilter();
	}
	
	@Then("User Selects Z to A filter and validate")
	public void user_selects_z_to_a_filter_and_validate() throws InterruptedException {
	    filterpg.ApplyandValidateZtoAFilter();
	}
	
	@Then("User Selects Low to High Filter and validate")
	public void user_selects_low_to_high_filter_and_validate() throws InterruptedException {
	    filterpg.ApplyandValidateLowToHighFilter();
	}
	
	@Then("User Selects High to Low Filter and validate")
	public void user_selects_High_to_Low_filter_and_validate() throws InterruptedException {
	    filterpg.ApplyandValidateHighToLowFilter();
	}
	
	

}
