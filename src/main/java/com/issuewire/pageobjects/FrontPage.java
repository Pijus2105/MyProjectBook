/**
 * 
 */
package com.issuewire.pageobjects;

import org.openqa.selenium.By;

/**
 * @author PIJUS GHOSH
 *
 */
public class FrontPage {
	
	//IssueWire Logo
	//TC-001 (Verify the issuewire image text logo is right side and clickable)
	By Logo = By.xpath("//a[@class='navbar-brand']");
	
	
	//Submit Button
	//TC-004 (Verify the submit press release is Clickable)
	By submitPR = By.xpath("//span[@id='btn-start']");
	
	
	
	//TC_006(Verify on the front page shown that only 3 Press Release Distribution Service)
	By PRdistribution = By.xpath("//div[@class='col-md-12 text-center mid-txt2']");
	
	
	//TC_007 (Verify TRADITIONAL NEWSROOM at the right side middle side 	PR DISTRIBUTION & left side PRESS RELEASE PACKAGE)
	By PRpackage = By.xpath("//body[1]/div[2]/div[1]/div[2]");
		
	//View Brands Button
	//TC__008 (Verify after click the view more brands another tab is open)
	By viewBrands = By.xpath("//div[@class='col-md-4 col-sm-4']//div[@class='w3-right pull-right']");
	
	
	
	//TC_009(Verify Press Release Distribution Sites)
	By PRdidtSites =By.xpath("//div[@class='w3-left']");
	
	
	
	//Text
	//TC_012 (Verify that the middle side "GET GUARANTEED PR DISTRIBUTION, 	SYNDICATION, PROMOTION, AND COVERAGE" and text also)
	By Textr = By.xpath("//div[@class='col-md-10 col-md-offset-1']");
	
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
	
	
	
	

}
