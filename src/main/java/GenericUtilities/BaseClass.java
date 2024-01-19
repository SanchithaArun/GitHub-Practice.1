package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 * @author asanchitha
 *
 */
public class BaseClass {
	public ExelFileUtility eUtil= new ExelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("======DB Connection Successful======");
		
	}
//	@Parameters("Browser")
	//@BeforeTest(alwaysRun=true)
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
	  String URL = pUtil.readDataFromPropertyFile("url");
	 driver= new EdgeDriver();
	  //if(BROWSER.equalsIgnoreCase("Edge"))
	//  {
	//	  driver=new EdgeDriver();
	//  }
	//  else if(BROWSER.equalsIgnoreCase("Chrome"))
	//  {
	//	  driver=new ChromeDriver();
	//  }
	  sUtil.maximizeWindow(driver);
	  sUtil.implicitWait(driver);
	  driver.get(URL);
	  System.out.println("======Browser Launch Successful======");
	//For Listeners
	  sDriver=driver;
	}

	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
	     String USERNAME = pUtil.readDataFromPropertyFile("UserName");
	     String PASSWORD = pUtil.readDataFromPropertyFile("Password");
	     LoginPage lp=new LoginPage(driver);
	     lp.loginToApp(USERNAME, PASSWORD);
	     System.out.println("======Login to App Successful======");
	     
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("======Logout of the App Successful======");
		
		
	}
	//@AfterTest(alwaysRun=true)
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("======Browser closed Successfully======");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("======DB closed Successfully======");
	}

}
