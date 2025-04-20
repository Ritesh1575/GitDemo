package RiteshShadija.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RiteshShadija.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver d1;
	
	public ProductCatalogue(WebDriver d1)
	{
		super(d1);
		this.d1=d1;
		PageFactory.initElements(d1, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css= ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastmessage= By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String pn)
	{
		WebElement prod= getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(pn)).findFirst().orElse(null);
		return prod;
		
	}
	public void addProductToCart(String pn)
	{
		WebElement prod= getProductByName(pn);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastmessage);
		waitForElementToDisappear();
		
	}
}
