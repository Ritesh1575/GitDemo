package RiteshShadija.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RiteshShadija.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver d1;
	
	public CartPage(WebDriver d1)
	{
		super(d1);
		this.d1=d1;
		PageFactory.initElements(d1, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTexts;
	
	@FindBy(css= ".totalRow button")
	WebElement checkoutEle;
	
	public Boolean VerifyProductDisplay(String pn)
	{
		Boolean match= productTexts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(pn));
		return match;
		
	}
	public CheckoutPage goToCheckoutPage()
	{
		checkoutEle.click();
		return new CheckoutPage(d1);
	}
}
