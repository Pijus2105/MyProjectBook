/**
 * 
 */
package com.issuewire.actiondriver;


/**
 * @author PIJUS GHOSH
 *
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
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
	 * @return 
	 * 
	 */
	
	
	
	
	
	
	public boolean switchByFrameId(WebDriver driver, String frameId) {
		boolean flagFrameId =  false;
		
		try {
			driver.switchTo().frame(frameId);
			flagFrameId = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flagFrameId) {
				System.out.println("Frame with index \"" + frameId + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + frameId + "\" is not selected");
			}
		}
		
		
	}
	
	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * @return 
	 * 
	 */
	
	
	public boolean switchByFramename(WebDriver driver, String frameName) {
		boolean flagFrameName = false;
		
		try {
			driver.switchTo().frame(frameName);
			flagFrameName = true;
			return true;
		} catch (Exception e) {
			return false;
		}finally {
			if(flagFrameName) {
				System.out.println("Frame with index \"" + frameName + "\" is selected");
			}else {
				System.out.println("Frame with index \"" + frameName + "\" is selected");
			}
		}
		
	}
	
	
	public boolean switchByDefaultFrame(WebDriver driver) {
		boolean flagFrameDefault = false;
		
		try {
			driver.switchTo().defaultContent();
			flagFrameDefault = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flagFrameDefault) {
				System.out.println("Default Frame is selected");
			}else {
				System.out.println("Default Frame is not selected");
			}
		}
	}
	
	
	
	public void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flagmouseOver = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flagmouseOver = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flagmouseOver) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}
	
	
	public boolean moveToElement(WebDriver driver, WebElement element) {
		boolean flagmoveToElement = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(element).build().perform();
			flagmoveToElement = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flagmoveToElement;
	}

	
	
	public boolean mouseover(WebDriver driver, WebElement element) {
		boolean flagmouseover = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flagmouseover = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	
	
	
	
	public boolean mouseDraggble(WebDriver driver, WebElement element, int x, int y) {
		boolean flagDrag = false;
		try {
			new Actions(driver).dragAndDropBy(element, x, y).build().perform();
			Thread.sleep(5000);
			flagDrag =  true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flagDrag) {
				System.out.println("Frame with index \"" + element + "\" is performed");
			} else {
				System.out.println("Frame with index \"" + element + "\" is not performed");
			}
		}
	}
	
	
	
	
	
	public boolean draganddrop(WebDriver driver, WebElement element, WebElement target) {
		boolean flagDragAndDrop = false;
		
		try {
			new Actions(driver).dragAndDrop(element, target).build().perform();
			Thread.sleep(5000);
			flagDragAndDrop = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(flagDragAndDrop) {
				System.out.println("Drag & Drop is performed");
			} else {
				System.out.println("Drag & Drop is not performed");
			}
			
		}
		
		
		
		
		
		
	}
	
	
	public boolean rightclick(WebDriver driver,WebElement element) {
		boolean flagrightclick = false;
		try {
			Actions clicker = new Actions(driver);

            clicker.contextClick(element).build().perform();
			flagrightclick = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flagrightclick) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	
	
	
	
	
	
	public boolean switchWindowHandles(WebDriver driver, String windowTitle, int count) {
		boolean flagwindowHandle = false;
	
	try {
		Set<String> windowList = driver.getWindowHandles();
		
			String [] array = windowList.toArray(new String[0]);
			
			driver.switchTo().window(array[count-1]);
		
			if (driver.getTitle().contains(windowTitle)) {
				flagwindowHandle = true;
			} else {
				flagwindowHandle = false;
			}
		return flagwindowHandle;
	} catch (Exception e) {
			return false;
	} finally {
			 
			if(flagwindowHandle) {
			System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
		}
			
		}
	}
	
	
	
	
	
	
	
	public boolean childWindow(WebDriver driver) {
		boolean flagChildWindow = false;
		
		
		try {
			
			Set<String> childWindow = driver.getWindowHandles();
			
			Object popup[] = childWindow.toArray();
			
			driver.switchTo().window(popup[0].toString());
			
			flagChildWindow = true;
			return flagChildWindow;
		} catch (Exception e) {
			flagChildWindow = false;
			return flagChildWindow;
		} finally {
			if(flagChildWindow) {
				System.out.println("Focus navigated to the window with title");
			} else {
				System.out.println("The Window with title: is not Selected");
			}
				
		}
			
	}
	
	
	
	
	
	
	
	public int getColoumnCount(WebElement coloumn) {
		
		//This Will Be Make List Of All Elements
		List<WebElement> coloumns = coloumn.findElements(By.tagName("td")); 
		
		//Get Size
		int num = coloumns.size();
		System.out.println("Total Column" + num);
		
		//Iterate All Elements
		for(WebElement element : coloumns) {
			
			System.out.println("Name Of Coloumns" + element.getText());
			System.out.print("|");
		}
		 return num;
		
	}
	
	
	
	
	
	
	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int number = rows.size() - 1;
		
		return number;
		/**
		 * Verify alert present or not
		 * 
		 * @return: Boolean (True: If alert preset, False: If no alert)
		 * 
		 */
	}
	
	
	
	public boolean switchAlert(WebDriver drive) {
		boolean flagAlert = false;
		
		Alert alert = null;
		
		try {
			alert = driver.switchTo().alert();
			alert.accept();
			flagAlert = true;
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		} finally {
			if(flagAlert) {
				System.out.println("The Alert is handled successfully");
			}else {
				System.out.println("There was no alert to handle");
			}
		}
		
		return flagAlert;
		
	}
	
	
	
	
	
	
	
	public boolean launchURL(WebDriver driver, String URL) {
		boolean flagURL = false;
		
		try {
			driver.navigate().to(URL);
			
			flagURL = true;
			return flagURL;
			
		} catch (Exception e) {
			flagURL = false;
			return flagURL;
		} finally {
			if(flagURL) {
				System.out.println("Launch"+URL+"is successfully");
			}else {
				System.out.println("Launch"+URL+"is not successfully");
			}
		}
			
		
	}
	
	
	
	
	
	
	public boolean alertPresent (WebDriver drive) {
		
		try {
			driver.switchTo().alert();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
	public String getTitle(WebDriver driver) {
		boolean flagTitle =  false;
	
		 
		 String text = driver.getTitle();
		 
		 if(flagTitle) {
			 System.out.println("Current URL is: \""+text+"\"");
		 }
		 return text;
		 
	
	}
	
	
	
	
	
	
	
	public boolean click1(WebElement locator, String locatorName) {
		boolean flagClick1 = false;
     try {
    	 locator.click();
    	
    	 flagClick1 = true;
    	 return flagClick1;
     } catch (Exception e) {
    	 flagClick1= false;
    	 return flagClick1;
     } finally {
    	 if(flagClick1) {
    		 System.out.println("Click the locator" +locatorName+"Successfully");
    	 }else {
    		 System.out.println("Click the locator" +locatorName+"not Successfully");
    	 }
     }
	}
	
	
	
	
	
	
	
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	
	
	
	
	
	
	
	
	public void implicitWait(WebDriver driver, int timeOut) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	
	
	public void Explicitwait(WebDriver driver, WebElement element,  int timeout) {
		WebDriverWait wait = new WebDriverWait (driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
	
	
	
	
	
	
	public void pageLoadTimeunit(WebDriver driver, int timeout) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	
	
	
	
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	
	
	
	
	
	
	
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
