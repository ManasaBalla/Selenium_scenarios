package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login extends PageObject{
	
	public WebDriver driver;
	ReadProperties read = new ReadProperties();
	
	public Login(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
	
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/login?referer=https://www.myntra.com/']")
	@CacheLookup
	WebElement login;
	
	@FindBy(how = How.XPATH, using = "//input[@class= 'form-control mobileNumberInput' and @type= 'tel']")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(how = How.XPATH, using = "//input[@class= 'form-control has-feedback' and @type ='password']")
	@CacheLookup
	WebElement password;
	
	public void enterMobile(String mobile) {
		
		this.mobile.clear();
		this.mobile.sendKeys(mobile);
	/*WebElement cont"//div[@class='submitBottomOption' and text() = 'CONTINUE']")*/
		
	}
	
	public void enterPassword(String password) {
		
		this.password.clear();
		this.password.sendKeys(password);
		
	}
	
	public void loginButton() {
		
		login.click();
	}
	
	public void submit() {
		
		password.submit();
	}
	
	public void cont() {
		
		driver.findElement(By.xpath("//div[@class='submitBottomOption' and text() = 'CONTINUE']")).click();
		
	}
	
	/*public void passwordLogin() {
		
		driver.findElement(By.xpath("//span[text()=' Password ']")).click();
		
	}*/
	

}
