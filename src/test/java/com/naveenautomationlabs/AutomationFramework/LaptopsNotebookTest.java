package com.naveenautomationlabs.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;
import com.naveenautomationlabs.AutomationFramework.pages.LaptopsNotebook;
import com.naveenautomationlabs.AutomationFramework.pages.YourStore;

public class LaptopsNotebookTest extends TestBase {
	private YourStore yourStore;
	private LaptopsNotebook laptopsNotebook;

	@BeforeMethod
	public void setUp() {
		initialisation();
		yourStore = new YourStore();
	}

	@Test
	public void validateClickingOnListOfLaptopsNotebookGoTORespectivePage() {
		laptopsNotebook = yourStore.mouseHoverLaptopsNotebookLink();
		String nameOfProduct = "MacBook";
		laptopsNotebook.checkClickOnProductOfLaptopsNotebookGoRespectivePage(nameOfProduct);
		Assert.assertEquals(wd.getTitle(), nameOfProduct);
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
