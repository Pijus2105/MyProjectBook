/**
 * 
 */
package com.issuewire.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.issuewire.base.MainClass;

/**
 * @author PIJUS GHOSH
 *
 */
public class LogIn extends MainClass  {
	
	//Test-01
	@FindBy(xpath = ("//a[@title='login']"))
	WebElement LogInbutton;
	
	//Test-02
	@FindBy(xpath = ("//input[@id='submit-btn1']"))
	WebElement SubmitButton;
	
	    //Test-03 & 4 & 5
		@FindBy(xpath = ("//input[@id='email']"))
		WebElement inValidUser;

		//Test-03 & 4 & 5
		@FindBy(xpath = ("//input[@id='password']"))
		WebElement inValidPassword;
		
		//Test-06
		@FindBy(xpath = ("//input[@id='email']"))
		WebElement ValidUser;
		
		//Test-07
		@FindBy(xpath = ("//input[@id='password']"))
		WebElement ValidPassword;
		
		//Test-10
		@FindBy(xpath = ("//input[@id='email']"))
		WebElement iValidUser;

		//Test-10
		@FindBy(xpath = ("//input[@id='password']"))
		WebElement nValidPassword;
		
		//popup Test - 11 &12
		
		//TC-014
		@FindBy(linkText =("Forgot Password"))
        WebElement UserForGotPassword;
		
		//TC-015
		@FindBy(linkText =("Signup"))
        WebElement UserSignUp;
		
}
