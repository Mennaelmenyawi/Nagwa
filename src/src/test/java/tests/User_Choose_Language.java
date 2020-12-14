package tests;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Data.ExcelReader;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import configurations.config;

@Test
public class User_Choose_Language extends TestBase {
	
	
	public config configreader;
	public WebElement EnglishButton;
	public WebElement SearchButton;
	public WebElement Searchbar;
	public WebElement SecondChoice;
	public WebElement Worksheet;
	   public static ExtentReports report ;
	    public static ExtentTest logger;
	
	    
	    @BeforeTest
		public void Setup() {
	    	ChromeOptions chromeOptions= new ChromeOptions();
	    	//chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aabdelaaty\\Desktop\\menna\\eclipse-workspace\\Nagwa\\Selenium-master\\Nagwa Task\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.navigate().to("https://www.nagwa.com/");

			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/src/test/java/task "+ GetCurrentTime()+".html"));
			extent.config().setTheme(Theme.DARK); 
			report=new ExtentReports();
			report.attachReporter(extent);
			report.setSystemInfo("Project Name","Nagwa Task");
			report.setSystemInfo("Host name","Menna");
			report.setSystemInfo("Environemnt","Testing Environment");
			

		}
	    @DataProvider(name="ExcelData")

		  public Object[][] PaginationData() throws IOException { ExcelReader ER=new
		  ExcelReader(); return ER.getExcelData(); }
	    
	    @Test(priority=1 , dataProvider="ExcelData")
	public void ChooseLanguage(String SearchText) throws InterruptedException
	{
		
		 logger = report.createTest("Open Nagwa website");


		EnglishButton.click();
        SearchButton.click();
        Searchbar.sendKeys(SearchText);
        Searchbar.sendKeys(Keys.ENTER);
        SecondChoice.click();
        Worksheet.click();
        
        
       
        
		
				        
						logger.pass("Test Case Passed Successfully");

				    
				}
				
				

	    @Test(priority=2 )
	 public void countsQuestions() {
         List<WebElement> totalLinks = driver.findElements(By.className("one-part-question"));
         int totalQuestions = totalLinks.size();
         System.out.println("Total NO.OF QUESTIONS : " + totalQuestions);
     }
//	 @AfterClass
//		public void EndTest() {
//
//		driver.quit();
//		}


@AfterMethod
public void getResult(ITestResult result) {
if(result.getStatus() == ITestResult.FAILURE) {
	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	logger.fail(result.getThrowable());

}
else if(result.getStatus() == ITestResult.SUCCESS) {
	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED " , ExtentColor.GREEN));
}
else {
	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	logger.skip(result.getThrowable());
}
report.flush();

}


public static String GetCurrentTime () {

DateFormat format = new SimpleDateFormat("dd MMMM YYYY hh:mm:ss");
Date date=new Date();
return  format.format(date);

}
}
	
	
	

