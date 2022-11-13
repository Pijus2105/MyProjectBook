/**
 * 
 */
package com.issuewire.actioninterface;

/**
 * @author PIJUS GHOSH
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

	
	public void scrollbyElement(WebDriver driver, WebElement element);
	public void click(WebDriver driver, WebElement element);
	public boolean findElement(WebDriver driver, WebElement element);
	public boolean isSelected(WebDriver driver, WebElement element);
}
