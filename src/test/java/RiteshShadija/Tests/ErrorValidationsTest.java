package RiteshShadija.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import RiteshShadija.SeleniumFrameworkDesign.pageobjects.CartPage;
import RiteshShadija.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import RiteshShadija.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

	
	@Test(groups= {"ErrorHandling"})
	public void loginErrorValidation()
	{
		L1.loginApplication("gone@gmail.com", "sdfg");
		Assert.assertEquals(L1.getErrorMessage(), "Hello2");
		// comment by the y
		//comment by the x hello2
		
	}
	
	@Test
	public void productErrorValidation()
	{
		
		String productName="ZARA COAT 3";		
		ProductCatalogue pc=L1.loginApplication("name19@gmail.com","Ritesh@56");
		pc.addProductToCart(productName);
		CartPage c1=pc.goToCartPage();
		Boolean match= c1.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertTrue(match);
		
	}
}
