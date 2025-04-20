package RiteshShadija.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RiteshShadija.SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver d1;
	
	public LandingPage(WebDriver d1)
	{
		super(d1);
		this.d1=d1;
		PageFactory.initElements(d1, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail1;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		useremail1.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
		ProductCatalogue pc=new ProductCatalogue(d1);
		return pc;
	}

	public void goTo()
	{
		d1.get("https://rahulshettyacademy.com/client");
		//System.out.println(useremail1);
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
