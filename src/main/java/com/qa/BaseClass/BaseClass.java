package com.qa.BaseClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.Utilities.WebEventListener;


public class BaseClass {

	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListener;

public BaseClass() throws Exception{
	
	
	prop=new Properties();

	try {
		FileInputStream ip=new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\AmazonCart\\src\\main\\java"+ "\\com\\qa\\Config\\Config.properties");
		prop.load(ip);
	
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	
}

public void initialization() throws Exception{
	String browsername;
	browsername=prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Fire Fox\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	
	else if(browsername.equals("FF"))
	{
		System.out.println("FF Driver does not exists");
	}
	e_driver=new EventFiringWebDriver(driver);
	eventListener=new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("URL"));
	driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);

}


}




