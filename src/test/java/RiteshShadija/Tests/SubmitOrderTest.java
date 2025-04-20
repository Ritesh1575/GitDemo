package RiteshShadija.Tests;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RiteshShadija.SeleniumFrameworkDesign.pageobjects.CartPage;
import RiteshShadija.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import RiteshShadija.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import RiteshShadija.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import RiteshShadija.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest
{
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(String email, String password, String product) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		//String productName="ZARA COAT 3";
		ProductCatalogue pc=L1.loginApplication(email,password);
		pc.addProductToCart(product);
		CartPage c1=pc.goToCartPage();
		Boolean match= c1.VerifyProductDisplay(product);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=c1.goToCheckoutPage();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();		
		String  confirmMessage= confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	}

	
	//This is develop branch
	// changes made by Y
	// changes made by at 121 am 
	
	//changes made by x
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"gone@gmail.com", "Ritesh@12", "ZARA COAT 3"}, {"name19@gmail.com", "Ritesh@56", "IPHONE 13 PRO"}};
	}
}