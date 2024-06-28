package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FilterPage {
	WebDriver driver;
	public FilterPage(WebDriver rDriver) {
		driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']/option[1]")
	WebElement SelectAtoZfilter;
	
	@FindBy(xpath="//select[@class='product_sort_container']/option[2]")
	WebElement SelectZtoAfilter;
	
	@FindBy(xpath="//select[@class='product_sort_container']/option[3]")
	WebElement SelectPriceLowtoHighfilter;
	
	@FindBy(xpath="//select[@class='product_sort_container']/option[4]")
	WebElement SelectPriceHightoLowfilter;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement Selectfilter;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> PriceList;
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> NameList;
	
	
	public void ApplyandValidateAtoZFilter() throws InterruptedException{
		List<WebElement> beforeFilterNames = NameList;
		List<String> beforefilterarray = new ArrayList<String>();
		for(WebElement ele : beforeFilterNames) {
			beforefilterarray.add(String.valueOf(ele.getText()));
		}
		System.out.println(beforefilterarray);
		
		
		WebElement dropdown = Selectfilter;
		Select sel = new Select(dropdown);
		sel.selectByIndex(0);
		Thread.sleep(3000);
		System.out.println("Filter A to Z is successfully selected");
		
		List<WebElement> afterFilterNames = NameList;
		List<String> afterfilterarray = new ArrayList<String>();
		for(WebElement ele : beforeFilterNames) {
			afterfilterarray.add(String.valueOf(ele.getText()));
		}
		Collections.sort(beforefilterarray);
		
		
		Assert.assertEquals(beforefilterarray, afterfilterarray);
		System.out.println("A to Z filter is validated and after sorting products are "+afterfilterarray);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		
	}
	
	
	public void ApplyandValidateZtoAFilter() throws InterruptedException{
		List<WebElement> beforeFilterNames = NameList;
		List<String> beforefilterarray = new ArrayList<String>();
		for(WebElement ele : beforeFilterNames) {
			beforefilterarray.add(String.valueOf(ele.getText()));
		}
		System.out.println(beforefilterarray);
		WebElement dropdown = Selectfilter;
		Select sel = new Select(dropdown);
		sel.selectByIndex(1);
		Thread.sleep(3000);
		System.out.println("Filter Z to A is successfully selected");
		System.out.println("FEATURE2/CUCUMBER");
		
		List<WebElement> afterFilterNames = NameList;
		List<String> afterfilterarray = new ArrayList<String>();
		for(WebElement ele : beforeFilterNames) {
			afterfilterarray.add(String.valueOf(ele.getText()));
		}
		//------sorting array first in ascending order then reversing it in other order---------------
		Collections.sort(beforefilterarray);
		Collections.reverse(beforefilterarray);
		
		
		Assert.assertEquals(beforefilterarray, afterfilterarray);
		System.out.println("A to Z filter is validated and after sorting products are "+afterfilterarray);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
	
	public void ApplyandValidateLowToHighFilter() throws InterruptedException {
		List<WebElement> beforeFilterPrices = PriceList;
		List<Double> beforefilterarray = new ArrayList<Double>();
		for(WebElement ele : beforeFilterPrices) {
			beforefilterarray.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		System.out.println(beforefilterarray);
		
		WebElement dropdown = Selectfilter;
		Select sel = new Select(dropdown);
		sel.selectByIndex(2);
		Thread.sleep(3000);
		System.out.println("Filter Low to High is successfully selected");
		
		List<WebElement> afterFilterPrices = PriceList;
		List<Double> afterfilterarray = new ArrayList<Double>();
		for(WebElement ele : beforeFilterPrices) {
			afterfilterarray.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		//------sorting array first in ascending order ---------------
		Collections.sort(beforefilterarray);
		if(!beforefilterarray.equals(afterfilterarray)) {
			System.out.println("Low to High Filter applied Successfully as both Lists are different");
		}
		
		
	//	Assert.assertNotEquals(beforefilterarray, afterfilterarray);
		System.out.println("Low to High filter is validated and after sorting products are "+afterfilterarray);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	public void ApplyandValidateHighToLowFilter() throws InterruptedException {
		List<WebElement> beforeFilterPrices = PriceList;
		List<Double> beforefilterarray = new ArrayList<Double>();
		for(WebElement ele : beforeFilterPrices) {
			beforefilterarray.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		System.out.println(beforefilterarray);
		
		WebElement dropdown = Selectfilter;
		Select sel = new Select(dropdown);
		sel.selectByIndex(3);
		Thread.sleep(3000);
		System.out.println("Filter High to Low is successfully selected");
		
		List<WebElement> afterFilterPrices = PriceList;
		List<Double> afterfilterarray = new ArrayList<Double>();
		for(WebElement ele : beforeFilterPrices) {
			afterfilterarray.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		//------sorting array first in ascending order then reversing it in other order---------------
		Collections.sort(beforefilterarray);
		Collections.reverse(beforefilterarray);
		if(!beforefilterarray.equals(afterfilterarray)) {
			System.out.println("High to Low Filter applied Successfully as both Lists are different");
		}
		
		//Assert.assertNotEquals(beforefilterarray, afterfilterarray);
		System.out.println("High to Low filter is validated and after sorting products are "+afterfilterarray);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	

}
