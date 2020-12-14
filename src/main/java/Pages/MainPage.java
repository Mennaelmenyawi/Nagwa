package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;
import org.testng.annotations.*;
import configurations.config;


public class MainPage extends PageBase{
	public config configreader;
	public WebElement EnglishButton;
	public WebElement SearchButton;
	public WebElement Searchbar;
	public WebElement SecondChoice;
	public WebElement Worksheet;
	

	public MainPage(WebDriver driver) {
		super(driver);

		configreader = new config("MainPagePaths.properties");
		getelements();
	}
	
	public void getelements ()
	{  	
		try {
			EnglishButton = driver.findElement(By.xpath(configreader.Getproperities("English")));
            SearchButton = driver.findElement(By.xpath(configreader.Getproperities("SearchButton")));
            Searchbar =  driver.findElement(By.xpath(configreader.Getproperities("Searchbar")));
            SecondChoice = driver.findElement(By.xpath(configreader.Getproperities("SecondChoice")));
            Worksheet =  driver.findElement(By.xpath(configreader.Getproperities("Worksheet")));
         	} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	  @Test(priority=1 , dataProvider="ExcelData")

	public void ChooseLanguage(String SearchText) throws InterruptedException
	{

		EnglishButton.click();
        SearchButton.click();
        Searchbar.sendKeys(SearchText);
        Searchbar.sendKeys(Keys.ENTER);
        SecondChoice.click();
        Worksheet.click();
        
        
       
        
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
				    public Boolean apply(WebDriver driver) {
				        return "https://www.nagwa.com/".equals(driver.getCurrentUrl().toString());
				    }
				};
				
				

				}
	 public void countsQuestions() {
         List<WebElement> totalLinks = driver.findElements(By.className("one-part-question"));
         int totalQuestions = totalLinks.size();
         System.out.println("Total NO.OF QUESTIONS : " + totalQuestions);
     }
	}


	

