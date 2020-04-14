package Generic;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public abstract class Base_page {
	public WebDriver driver;
	public Base_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void verify_Visibility( int time,WebElement element)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.visibilityOf(element));
	Reporter.log("Element is located", true);
}
catch(Exception e)
{
    Reporter.log("failed to locate Element", true);
    Assert.fail();
}
}

public void verify_Click( int time,WebElement element)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.elementToBeClickable(element));
	Reporter.log("Element is clicked", true);
	
}
catch(Exception e)
{
    Reporter.log("Failed to Click Element", true);
    Assert.fail();
}
}

public void verify_Title( int time,String title)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.titleContains(title));
	Reporter.log("title displayed",true);
}
catch(Exception e)
{
    Reporter.log("title not displayed", true);
    Assert.fail();
}
}

public void verify_ElementLocation( int time,By xpath)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
	Reporter.log("Loaded new window", true);
}
catch(Exception e)
{
    Reporter.log("Failed to find located element");
    Assert.fail();
}
}

public void verify_NoOfWindows(int time,int expectedNumberOfWindows)
{
WebDriverWait wait= new WebDriverWait(driver, time);
try
{
	wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	Reporter.log("loaded new window", true);
}
catch(Exception e)
{
   Reporter.log("Failed to load new window", true);
   Assert.fail();
}
}
}


