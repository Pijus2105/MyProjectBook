package com.issuewire.actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.issuewire.base.MainClass;

public class Action extends MainClass implements ActionInterface  {
	
	
	@Override
	public void scrollbyElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	@Override
	public void click(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.build().perform();
	}
	
	
}
