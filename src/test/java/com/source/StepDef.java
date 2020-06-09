package com.source;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Pages.Login;
import com.Pages.ReadProperties;
import com.snapshots.SnapShot;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;


public class StepDef {
	
	WebDriver driver;
	Login login;
	Actions action;
	ReadProperties read = new ReadProperties();
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
	}
	
	@After
	public void close() {
		
		driver.close();
	}
	
	@Given("The url is opened")
	public void the_url_is_opened() {
		
		driver.get("https://www.guru99.com/");		
		driver.manage().window().maximize();
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Meet Guru99 - Free Training Tutorials & Video for IT Courses", actualTitle);
	   
	}

	@When("Select Selenium course and switch tab")
	public void the_home_page_is_displayed() throws Exception {
		
		WebElement selenium  = driver.findElements(By.xpath("//*[@class='fa fa-code']")).get(0);
		action.contextClick(selenium).perform();
		
		SnapShot.takeSnapShot(driver, "C:/Tools/java-2018-09/ScreenShots");
		
		/*String keyString =   Keys.CONTROL+Keys.SHIFT.toString()+Keys.ENTER.toString();
		selenium.sendKeys(keyString);
		
		
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));*/
	    
	}

	@Then("Get Title of the new tab")
	public void select_Selenium_course() {
		
		/*ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)).getTitle();*/
		System.out.println("File is saved");
		
   
	}
		
		
	@Given("The url is opened and logged in")
	public void url_opened_loggedin() throws InterruptedException {
		
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		
		WebElement profile = driver.findElement(By.xpath("//*[text()='Profile']"));
		action = new Actions(driver);
		action.moveToElement(profile).build().perform();
		
		login = new Login(driver);
		
		login.loginButton();
		
		login.enterMobile(read.getMobile());
		
		login.cont();
		
		System.out.println("*****************************"+driver.getTitle());
	}
		
		
		
		//WebElement otpPagePassword = driver.findElement(By.xpath("//span[text()='Password']"));
		
		/*if(driver.getPageSource().contains("Verify with OTP")) {
			
			driver.findElement(By.xpath("//span[text()='Password']")).click();
			login.enterPassword(read.getPassword());
		}
		
		else if(driver.getPageSource().contains("Login to your account")){
			
			//driver.findElement(By.xpath("//span[text()='Password']")).click();
			login.enterPassword(read.getPassword());
		}
		
		login.submit();
		
	}*/
	
	@When("Open Aromas & Candles from Home Decor column in Home and Living category")
	public void open_aromasSection_from_homeDecor() {
		
		WebElement homeAndLiving = driver.findElement(By.xpath("//a[@href='/shop/home-living' and @class='desktop-main']"));
		action.moveToElement(homeAndLiving);
		
		WebElement aromasCandles = driver.findElement(By.xpath("//a[@href='/candles' and @class='desktop-categoryLink']"));
		aromasCandles.click();
		
		WebElement product = driver.findElements(By.xpath("//a[@href= 'candles/aapno-rajasthan/aapno-rajasthan-transparent-textured-zen-mode-aromatic-glass-candle/11615416/buy']")).get(0);
		product.click();
	}
	
	@Then("Add product to bag and handling cart")
	public void add_product_to_bag() {
		
		String mainWindow=driver.getWindowHandle();
		 // It returns no. of windows opened by WebDriver and will return Set of Strings
		 Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		 String childWindow=itr.next();
		    // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 if(!mainWindow.equals(childWindow)){
		 driver.switchTo().window(childWindow);
		 System.out.println("New Window ------->" + driver.switchTo().window(childWindow).getTitle());
		 }
		 }
		 
		 WebElement bag = driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"));
		 bag.click();
		 
		 WebElement cart = driver.findElement(By.xpath("//a[@href = 'checkout/cart' and @class = 'desktop-cart']"));
		 cart.click();
		 
		 System.out.println("*************************Opened Cart*******************");
	}
	
	@Given("URl is opened")
	public void url_is_opened() {
	    
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@When("The checkbox url is clicked")
	public void the_checkbox_url_is_clicked() {
	   
		driver.findElement(By.xpath("//*[@href='/checkboxes']")).click();
	}

	@Then("Select the desired checkbox")
	public void select_the_desired_checkbox() {
	    
		List<WebElement> checkboxes = driver.findElements(By.xpath("//form[@id='checkboxes']//following::input"));
		WebElement checkbox1 = checkboxes.get(0);
		WebElement checkbox2 = checkboxes.get(1);
		if(checkbox1.isSelected()) {
			System.out.println("checkbox 1 is already selected");
			checkbox1.click();
		}
		else if(checkbox2.isSelected()) {
			System.out.println("checkbox 1 is already selected");
			checkbox2.click();
		}
			checkbox1.click();
			System.out.println("Checkbox 1 is selected");
		
	}
	
	@When("The Drop down url is clicked")
	public void the_dropdown_url_is_clicked() {
		
		driver.findElement(By.xpath("//*[@href='dropdown/']")).click();
		
	}
	
	@Then("Select the desired option")
	public void select_the_desired_option() {
		
		driver.findElement(By.xpath("//*[@id='dropdown']")).click();
		
		List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='dropdown']//following::option"));
		dropdown.get(1);
		System.out.println("Option 1 is selected");
	}
		
		
	}
