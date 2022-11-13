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
	By Logo = By.xpath("//a[@class='navbar-brand']");
	
	//PR Distribution
	By Texta= By.xpath("//div[@class='left-content']");
	
	//Submit Button
	By submitPR = By.xpath("//span[@id='btn-start']");
	
	//PR Distribution Network
	By LogoA = By.xpath("//img[@title='Press Release Distribution Network']");
	
	//ONLINE PRESS RELEASE DISTRIBUTION
	By Textc = By.xpath("//div[@class=' col-md-8 col-md-offset-2']");
	
	//View Brands Button
	By viewBrands = By.xpath("//div[@class='col-md-4 col-sm-4']//div[@class='w3-right pull-right']");
	
	//Get Our Story Button
	By getOurStory = By.xpath("//a[@title='Get Your Story']");
	
	//100% Satisfaction Gurrantee
	By LogoB = By.xpath("//img[@title='free pr sites']");
	
	//Guaranteed News Distribution with Media Coverage
	By Text = By.xpath("//div[@class='media-text-wrapper clearfix']");
	
	//View Brands (Getting Published on Our Sites)
	By viewBrandsB = By.xpath("//div[@class='col-md-12 distri']//div[@class='w3-right pull-right']");
	
	
	
	
	

}
