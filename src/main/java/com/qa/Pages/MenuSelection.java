package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.BaseClass;

public class MenuSelection extends BaseClass{
	
	
	@FindBy(xpath="//span[contains(text(),'Tutorials')]")
	WebElement TutMenu;
	
	@FindBy(xpath="//span[contains(text(),'Python Tutorial')]")
	WebElement selected;
	
	public MenuSelection() throws Exception {
		PageFactory.initElements(driver, this);
	}
public void OpenMenu()
{

	Actions action=new Actions(driver);
	   action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Tutorials')]"))).build().perform();
	   action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Python Tutorial')]"))).build().perform();
	   action.click().build().perform();
	  // driver.findElement(By.xpath("//canvas[@class='ns-qt8h2-e-3 image']")).click();
}

public void js() {
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("scroll(0, -250)");
}

public void PageSelection() {

	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	Actions action=new Actions(driver);
   action.moveToElement(driver.findElement(By.xpath("//span[@class='page-numbers current' and contains(text(),3)]"))).build().perform();
    action.click().build().perform();
}
}
