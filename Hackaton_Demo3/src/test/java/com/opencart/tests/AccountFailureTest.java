package com.opencart.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.pages.CreateAccountPage;
import com.opencart.utils.BaseClassPage;

public class AccountFailureTest extends BaseClassPage {
	public AccountFailureTest() {
		 
	 }
	 
	@BeforeTest
public void launchingBrowser()
{			
	initialization(); 
	}
	
	
	@Test
	public void createAccountDetails() throws Exception {
		
		CreateAccountPage obj= new CreateAccountPage();
	   
	    obj.getMyaccount().click();
	    obj.getRegister().click();
	    obj.getFirstname().sendKeys(prop.getProperty("FirstName"));
		obj.getLastname().sendKeys(prop.getProperty("LastName"));
		obj.getEmail().sendKeys(prop.getProperty("Email1"));
	    obj.getPassword().sendKeys(prop.getProperty("Pass"));
	    obj.getConformpassword().sendKeys(prop.getProperty("conpass"));
	    obj.getCheckbox().click();
	    obj.getContinuebtn().click();
	}
}
