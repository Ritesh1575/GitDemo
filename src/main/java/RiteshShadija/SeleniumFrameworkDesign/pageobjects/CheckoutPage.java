package RiteshShadija.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RiteshShadija.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver d1;
	
	public CheckoutPage(WebDriver d1)
	{
		super(d1);
		this.d1=d1;
		PageFactory.initElements(d1, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css= "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath= "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]/span")
	WebElement selectCountry;
	
	public void selectCountry(String countryName)
	{
		
		Actions a=new Actions(d1);
		a.sendKeys(country, countryName).build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		selectCountry.click();
		d1.findElement(By.cssSelector(".action__submit")).click();
	}
	
	public ConfirmationPage submitOrder()
	{


		return new ConfirmationPage(d1);
	}
	
	
	
}
