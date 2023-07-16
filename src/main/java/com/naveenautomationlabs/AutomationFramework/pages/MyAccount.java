package com.naveenautomationlabs.AutomationFramework.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {
	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	@FindBy (css="a#wishlist-total span")
	WebElement wishListBtn;

	@FindBy(css = "#content>h2:first-of-type")
	private WebElement myAccountText;

	public String getMyAccountText() {
		return myAccountText.getText();
	}
	public MyWishList clickWishListBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(wishListBtn));
		wishListBtn.click();
		return new MyWishList();
	}

}
