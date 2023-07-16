package com.naveenautomationlabs.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;
import com.naveenautomationlabs.AutomationFramework.pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.pages.MyWishList;
import com.naveenautomationlabs.AutomationFramework.pages.MyWishList.MyWishListTable;
import com.naveenautomationlabs.AutomationFramework.pages.YourStore;

public class MyWishListTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private MyWishList myWishList;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore();
	}
	@Test(priority=1)
	public void validateLogin() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("tony@gmail.com","Password2");
		myWishList=myAccount.clickWishListBtn();
	}
	@Test
	public void validateGettingCellElementFromTable() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("tony@gmail.com","Password2");
		myWishList=myAccount.clickWishListBtn();
		String s= myWishList.getCellElementFromTable(MyWishListTable.PRODUCT_NAME,"Product 15").getText();
		System.out.println(s);
	}
	@Test
	public void validateAssert() {
	Assert.assertEquals(false, false);	
	}

}
