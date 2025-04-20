package RiteshShadija.SeleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RiteshShadija.SeleniumFrameworkDesign.pageobjects.CartPage;

public class AbstractComponent {

	WebDriver d1;
	
	@FindBy(css= "[routerlink*='cart']")
	WebElement cartHeader;
	
	public AbstractComponent(WebDriver d1)
	{
		this.d1=d1;
	}
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(d1,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait= new WebDriverWait(d1,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public void waitForElementToDisappear() 
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebDriverWait wait= new WebDriverWait(d1,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage c1=new CartPage(d1);
		return c1;
	}
}
