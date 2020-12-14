package tests;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;



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
	  
	
	    
	    @DataProvider(name="ExcelData")

		  public Object[][] SearchData() throws IOException { ExcelReader ER=new
		  ExcelReader(); return ER.getExcelData(); }
	    
	    @Test(priority=1, dataProvider="ExcelData")
	public void ChooseLanguage(String SearchText) throws InterruptedException, IOException
	{
	    	configreader = new config("MainPagePaths.properties");
	    	EnglishButton = driver.findElement(By.xpath(configreader.Getproperities("English")));

      

		EnglishButton.click();
		Thread.sleep(5000);
		SearchButton = driver.findElement(By.xpath(configreader.Getproperities("SearchButton")));

       SearchButton.click();
		Thread.sleep(5000);

       Searchbar =  driver.findElement(By.xpath(configreader.Getproperities("SearchBar")));
       Searchbar.sendKeys(SearchText);
       Searchbar.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

       SecondChoice = driver.findElement(By.xpath(configreader.Getproperities("SecondChoice")));
        SecondChoice.click();
		Thread.sleep(5000);

        Worksheet =  driver.findElement(By.xpath(configreader.Getproperities("Worksheet")));

       Worksheet.click();
		Thread.sleep(5000);
		List<WebElement> totalLinks = driver.findElements(By.className("one-part-question"));
        int totalQuestions = totalLinks.size();
        System.out.println("Total NO.OF QUESTIONS : " + totalQuestions);

				    
				}
				
	 @AfterClass
		public void EndTest() {

		driver.quit();
		}



}
	
	
	

