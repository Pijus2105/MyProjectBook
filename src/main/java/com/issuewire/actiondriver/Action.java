package com.issuewire.actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.issuewire.actioninterface.ActionInterface;
import com.issuewire.base.MainClass;

public class Action extends MainClass implements ActionInterface  {
	
	


	public void scrollbyElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}



	public void click(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.build().perform();
	}
	

	public boolean findElement(WebDriver driver, WebElement element) {
		boolean flag = true;
		
		try {
			element.isDisplayed();
			flag=true;
		} catch (Exception e) {
			flag = false;
		}
		finally {
			if (flag) {
				System.out.println("Successfully Found element at");
				
			}else {
				System.out.println("Unable to locate element at");
			} 
		}
		return flag;
		}
		
	
	public boolean isSelected(WebDriver driver, WebElement element) {
		boolean flag= true;
		flag=findElement(driver, element);
	
		if(flag) {
			flag = element.isSelected();
			
			if(flag) {
				System.out.println("The element is Selected");
				
			}else {
				System.out.println("The element is not Selected");
			}
		}else {
			System.out.println("Not Found");
			}
			return flag;
	
	}
	
	
	public boolean isEnabled(WebDriver driver, WebElement element) {
		
		boolean flag= true;
		flag= findElement( driver, element);
		
		if(flag) {
			flag = element.isEnabled();
			
			if(flag) {
				System.out.println("The element is Enable");
				
			}else {
				System.out.println("The element is unenable");
			}
		}else {
			System.out.println("Not Found");
		}
		return flag;
	}
	
	
	
	
	
}
