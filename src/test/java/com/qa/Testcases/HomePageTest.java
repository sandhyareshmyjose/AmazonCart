package com.qa.Testcases;

	import java.io.IOException;

import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.qa.BaseClass.BaseClass;
import com.qa.Pages.AddCart;
import com.qa.Pages.MenuSelection;

	public class HomePageTest extends BaseClass {
		
		MenuSelection menu;
		
		public HomePageTest() throws Exception{
			super();
		}
		
	@BeforeMethod
	
	public void setup() throws Exception
	{
		initialization();
	}

	@Test(priority=1)

	public void MenuSelection() throws Exception
	{
		menu=new MenuSelection();
		menu.js();
		menu.OpenMenu();
		
	}
	
	@Test(priority=2)
	
	public void PageSelection() throws Exception {
		menu.js();
		menu.OpenMenu();
		menu.PageSelection();
		System.out.println("Hello");
		
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}

	}


