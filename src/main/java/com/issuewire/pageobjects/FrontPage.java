/**
 * 
 */
package com.issuewire.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.issuewire.actiondriver.Action;
import com.issuewire.base.MainClass;

/**
 * @author PIJUS GHOSH
 *
 */
public class FrontPage extends MainClass {
	
	WebDriver driver;
	
	
	//IssueWire Logo
	//TC-001 (Verify the issuewire image text logo is right side and clickable)	
	@FindBy(xpath = ("//a[@class='navbar-brand']"))
	WebElement Logo;
	
	
	//Submit Button
	//TC-004 (Verify the submit press release is Clickable)

	@FindBy(xpath = ("//span[@id='btn-start']"))
	WebElement SubmitPR;
	
	//TC_006(Verify on the front page shown that only 3 Press Release Distribution Service)	
	@FindBy(xpath = ("//div[@class='col-md-12 text-center mid-txt2']"))
	WebElement ThreePRdis;
	
	
	
	//TC_007 (Verify TRADITIONAL NEWSROOM at the right side middle side 	PR DISTRIBUTION & left side PRESS RELEASE PACKAGE)
	@FindBy(xpath = ("//body[1]/div[2]/div[1]/div[2]"))
	WebElement PRpackage;
	
	
	
		
	//View Brands Button
	//TC__008 (Verify after click the view more brands another tab is open)		
	@FindBy(xpath = ("//div[@class='col-md-4 col-sm-4']//div[@class='w3-right pull-right']"))
	WebElement ViewMoreBrands;
	
	
	//TC_009(Verify Press Release Distribution Sites)
	@FindBy(xpath = ("//div[@class='w3-left']"))
	WebElement PRdistributionSites;
	
	//Text
	//TC_012 (Verify that the middle side "GET GUARANTEED PR DISTRIBUTION, 	SYNDICATION, PROMOTION, AND COVERAGE" and text also)
	@FindBy(xpath = ("//div[@class='col-md-10 col-md-offset-1']"))
	WebElement GSPC;
	
	//Get Our Story Button
	//TC_014(Verify get your story noticed button is clickable)
	By getOurStory = By.xpath("//a[@title='Get Your Story']");
	
	
	//Guaranteed News Distribution with Media Coverage
	//TC_016 (Verify Guaranteed News Distribution with Media Coverage)
	By Text = By.xpath("//div[@class='media-text-wrapper clearfix']");
	
	
	
	//TC_018(Verify the distribution company images are iterate)
	By PRlist = By.xpath("//div[@id='dist-img-div']");
	
	
	//TC_019 (Verify the "Getting Published on Our Sites" at the left side)
	By PubliSHsITES = By.xpath("//div[@class='h2']");
	
	
	
	
	//View Brands (Getting Published on Our Sites)
	//TC_022(Verify the "Getting Published on Our Sites" of view more brans is clickable)
	By viewBrandsB = By.xpath("//div[@class='col-md-12 distri']//div[@class='w3-right pull-right']");
	
	//TC_023 & TC_027
	
	
	
	//Get Started Now
	//TC_033 (Verify the get started now button is clickable)
	By getStartedNow = By.xpath("//a[@title='Get started now']");
	
	
	
	//Depends upon the policies of the recipient sites and Google News
	//TC_028 (Verify at the right side "Depends upon the policies of the recipient sites and Google News" 	and mandatory symbols)
	By mandatorySymbolText = By.xpath("//p[contains(text(),'* Depends upon the policies of the recipient sites')]");
	
	
	
	
	
	
	
	
	public FrontPage () {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	
	public boolean IssueWireLogo() throws Throwable {
	
		return Action.isDisplayed(getDriver(), Logo);
		
	}
	
	public signUp submitPRelease() {
		Action.Explicitwait(driver, SubmitPR, 10);
		Action.clicks(getDriver(), SubmitPR);
		return new signUp();
	}
	
	public boolean PRdistThree() {
	   return Action.isDisplayed(getDriver(), ThreePRdis);
	}
	
	
	
	public boolean PRpacka() {
		return Action.isDisplayed(getDriver(), PRpackage);
	}
	
	public pressReleaseDistributionSiteList viewMore() {
		Action.clicks(getDriver(), ViewMoreBrands);
		Action.childWindow(getDriver(), ViewMoreBrands);
		return new pressReleaseDistributionSiteList();
	}
	
	public boolean PRdistributionSites() {
		return Action.isDisplayed(getDriver(), PRdistributionSites);
	}
	
	public boolean textGSPC() {
		return Action.isDisplayed(getDriver(), GSPC);
	}
	
}
