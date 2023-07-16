package com.naveenautomationlabs.AutomationFramework;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;
import com.naveenautomationlabs.AutomationFramework.pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.utils.ExcelUtils;

public class YourStoreTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore();
	}

	@Test(dataProvider="loginDataProvider")
	public void validateLoginUsingValidCredentials(String userName,String password) {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal(userName,password);
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account");
	}

	@DataProvider(name="loginDataProvider")
	public String[][] getDataFromExcelFile() throws Exception {
		logger.info("data provider get executed");
		String file = "C:\\Users\\Neelam Nagariya\\Desktop\\Testing\\Data.xlsx";
		int rowCount = ExcelUtils.getRowCount(file, "sheet1");
		int columnCount = ExcelUtils.getColumnCount(file, "sheet1", rowCount);
		String[][] virtualSheet = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(file, "sheet1",i,j);
			}
		}
		return virtualSheet;
	}

	

	@Test
	public void validateClickingDisplayItemOnMainPageTakesToItemPage() {
		Assert.assertTrue(yourStore.ClickOnDisplayItemOnMainPage());
	}

	@Test
	public void validateFooterDisplayImagesMoving() {
		Assert.assertFalse(yourStore.checkFooterDisplayImagesMoving(), "Footer Display images are not moving");
	}

	@Test
	public void validateDisplayImageIsMovingOnMainPage() {
		Assert.assertFalse(yourStore.checkDisplayImagesMoving(), "Display image not moving");
	}

	@Test
	public void validateWishListIsUpdated() {
		Assert.assertTrue(yourStore.checkWishListUpdated(), "Wish list not updated");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
