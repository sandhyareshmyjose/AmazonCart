package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.BaseClass;

public class AddCart extends BaseClass{

	

@FindBy(xpath="//input[@id='twotabsearchtextbox']")

WebElement searchfield;

@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@type='submit']")
WebElement searechsubmit;

@FindBy(xpath="//input[@type='checkbox' and @name='s-ref-checkbox-Redmi']")
WebElement selectredme;

@FindBy(xpath="//img[@alt='Redmi Note 8 Pro (Halo White, 6GB RAM, 128GB Storage with Helio G90T Processor)']")
WebElement selectedphone;

@FindBy(xpath="//input[@id='add-to-cart-button']")

WebElement AddCart;

public AddCart() throws Exception{
	
	
	
	PageFactory.initElements(driver, this);
}

public void AddToCart(String productname)
{
	
	Actions action=new Actions(driver);
	action.moveToElement(searchfield).build().perform();
	action.click().build().perform();
	searchfield.sendKeys(productname);
	searechsubmit.click();
}


}
	

