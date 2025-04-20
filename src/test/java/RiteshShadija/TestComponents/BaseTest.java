package RiteshShadija.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RiteshShadija.SeleniumFrameworkDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver d1;
	public LandingPage L1;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\RITESH\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\RiteshShadija\\resources\\GlobalData.properties");
		p.load(fis);
		
		String bn=System.getProperty("browser")!=null ? System.getProperty("browser"):  p.getProperty("browser");
		
		
		
		if(bn.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(bn.contains("headless"))
		{
			options.addArguments("headless");
		}
		d1= new ChromeDriver(options);
		d1.manage().window().setSize(new Dimension(1440,900));
		}
		
		else if(bn.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecako.driver", "C://geckodriver.exe");
			d1= new FirefoxDriver();
		}
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d1.manage().window().maximize();
		return d1;
	}
	
	
	public String getScreenshot(String testCaseName,WebDriver d1) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)d1;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir") + "//reports//" +  testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		d1= initializeDriver();
		L1=new LandingPage(d1);
		L1.goTo();
		return L1;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		d1.close();
	}

}
