package com.issuewire.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.issuewire.actioninterface.ActionInterface;
import com.issuewire.base.MainClass;



public class Action extends MainClass implements ActionInterface  {
	
	WebDriver driver;	


	//This Method For JavaScript
	public void scrollbyElement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}


   //This Method For Click
	public void click(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.build().perform();
	}
	

	//This Method For Find Element
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
		
	//This Method For is Selected
	public boolean isSelected(WebDriver driver, WebElement element) {
		boolean flagSelected= false;
		
		//Initialize The Find Element For This Method
		flagSelected=findElement(driver, element);
	
		//If Flag Variable Initialize To The Element By The Pass Parameter>>
		if(flagSelected) {
			//<< Then If Get The Element For Selected Then Will Select 
			flagSelected = element.isSelected();
			
			if(flagSelected) {
				System.out.println("The element is Selected");
				
			}else {
				System.out.println("The element is not Selected");
			}
		}else {
			System.out.println("Not Found");
			}
			return flagSelected;
	
	}
	
	
	public boolean isEnabled(WebDriver driver, WebElement element) {
		
		boolean flagEnable= false;
		flagEnable= findElement( driver, element);
		
		if(flagEnable) {
			flagEnable = element.isEnabled();
			
			if(flagEnable) {
				System.out.println("The element is Enable");
				
			}else {
				System.out.println("The element is unenable");
			}
		}else {
			System.out.println("Not Found");
		}
		return flagEnable;
	}
	
	
	
	public boolean type(String text, WebElement element) {
		
		boolean flagType = false;
		
		try {
			flagType = element.isDisplayed();
			element.clear();
			element.sendKeys(text);
			
			flagType = true;
			
			
		} catch (Exception e) {
			System.out.println("Location Not found");
			flagType = false;
		} finally {
			if (flagType) {
				System.out.println("Entered The Value");
			} else {
				System.out.println("Not Enter The Value");
			}
		}
		return flagType;
	}
	
	
	
	
	public boolean sendkeysValue(String value, WebElement element) {
		boolean flagValue = false;
		
		try {
			element.sendKeys(value);
			flagValue =true;
			return true;
		} catch (Exception e) {
			 return false;
		} finally {
			if (flagValue) {
				System.out.println("Enter Dropdown Value");
			}else {
				System.out.println("Unable The Dropdown Value");
			}
		}
		
	}
	
	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * @return 
	 * 
	 */
	
	
	public boolean selectByindex(int index, WebElement element) {
		boolean flagIndex = false;
		
		try {
			Select sel = new Select(element);
			sel.selectByIndex(index);
			flagIndex = true;
			
			return true;
		} catch (Exception e) {
			return false;
		}finally {
	      if(flagIndex) {
	    	  System.out.println("Enter Dropdown Index Value");
	      } else {
	    	  System.out.println("Unable to The Dropdown Value");
	      }
		}
	}
	
	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * @return 
	 */
	
	
	public boolean selectByValue(String value, WebElement element) {
		boolean flagSelectByValue = false;
		
		try {
			Select sel = new Select(element);
			sel.selectByValue(value);
			flagSelectByValue = true;
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flagSelectByValue) {
				System.out.println("Enter Dropdown Value");
			}else {
				System.out.println("Unable Dropdown Value");
			}
		}
	}
	
	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * @return 
	 */
	
	
	
	public boolean selectVisible(String VisibleText, WebElement element) {
		boolean flagVisible = false;
		
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(VisibleText);
			flagVisible = true;
			
			return true;
		} catch(Exception e) {
			return false;
		} finally {
			if(flagVisible) {
				System.out.println("Enter Dropdown VisibleText");
			} else {
				System.out.println("Unable Dropdown VisibleText");
			}
		}
	}
	
	
	public boolean mouseHoverByJavaScript(WebElement element) {
		boolean flagJavaScript=false;
		try {
			WebElement mo = element;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flagJavaScript= true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flagJavaScript){
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}
	
	
	public boolean JSClick(WebDriver driver, WebElement element)throws Exception {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}
	public boolean switchToFrameByIndex(WebDriver driver,int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
}
