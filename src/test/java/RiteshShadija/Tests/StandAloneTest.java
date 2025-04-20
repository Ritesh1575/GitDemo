package RiteshShadija.Tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver d1= new ChromeDriver();
		d1.manage().window().maximize();
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d1.get("https://rahulshettyacademy.com/client");
		d1.findElement(By.className("form-control")).sendKeys("gone@gmail.com");
		d1.findElement(By.id("userPassword")).sendKeys("Ritesh@12");
		d1.findElement(By.name("login")).click();
		
		WebDriverWait wait= new WebDriverWait(d1,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> products=d1.findElements(By.cssSelector(".mb-3"));
		
		int j=products.size();
		
		for(WebElement product: products)
		{
			String str= product.findElement(By.cssSelector("input")).getText();
			System.out.println(str);
		}
		
//		WebElement prod= products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//		
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(d1.findElement(By.cssSelector(".ng-animating"))));
//		d1.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		
//		List<WebElement> cartProducts= d1.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match= cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
//		d1.findElement(By.cssSelector(".totalRow button")).click();
//		
//		Actions a=new Actions(d1);
//		a.sendKeys(d1.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		
//		d1.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
//		d1.findElement(By.cssSelector("a.action__submit")).click();
//		
//		String  confirmMessage=d1.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		d1.close();
	}

}
