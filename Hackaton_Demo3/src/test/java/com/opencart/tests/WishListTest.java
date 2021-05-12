package com.opencart.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opencart.pages.WishListPage;
import com.opencart.utils.BaseClassPage;

public class WishListTest extends BaseClassPage{
	
	@BeforeTest
	public void launchingBrowser()
	{			
		initialization(); 
		}
		
	
	@Test
	public void createAccountDetails() throws Exception {
		 WishListPage wl=new WishListPage();
		   wl.moveHovering();
		    
		   wl.getMonitors().click();
		   wl.getSortby().click();
		   Select ob=new Select(wl.getSortby());
		   ob.selectByVisibleText("Price (High > Low)");
		   Thread.sleep(1000);
		   wl.getAddtowishlist().click();
		   wl.getAddtocart().click();
		   
	}

}
