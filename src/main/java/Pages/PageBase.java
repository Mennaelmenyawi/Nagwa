package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver;

	// create constructor to initialize Elements (driver)
	public PageBase(WebDriver driver)
	{
		//PageFactory.initElements(driver, this);       // this refer to the same class we are working on it
	this.driver=driver;
	}


	// making method for clicking and sending values to the field 

	protected static  void clickButton	(WebElement Button)
	{
		Button.click();
	}

	protected static  void Settext (WebElement TextElement , String Value)
	{
		TextElement.sendKeys(Value);

	}

	protected  void UploadFiles()
	{
		String filePath = System.getProperty("user.dir") + "/Upload/data1.xlsx";
		driver.findElement(By.id("fileupload")).sendKeys(filePath);
		driver.findElement(By.id("fileupload")).click();

	}



}
