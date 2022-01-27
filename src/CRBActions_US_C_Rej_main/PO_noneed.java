package CRBActions_US_C_Rej_main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_US_C_Rej.Step05_PO_noneed;
import lib.Excel;


public class PO_noneed {

	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;

	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 4, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 4, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 5, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void PO_Login() throws InterruptedException 
	{

		Step05_PO_noneed login = new Step05_PO_noneed(driver);
		login.login();
	}


	// test to authorize request from PO
	@Test(priority=1)
	public void authorize_PO() 
	{

		Step05_PO_noneed auth_PO = new Step05_PO_noneed(driver);
		auth_PO.authorize_PO();
	}


}


