package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Find web elements on Add New Customer web page
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement emailAdd;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement btnSearch;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement searchResult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;

	@FindBy(id = "SearchFirstName")
	WebElement firstName;

	@FindBy(id = "SearchLastName")
	WebElement lastName;

	// Action Methods for Search Customer page
	public void enterEmailAddress(String email) {
		emailAdd.sendKeys(email);
	}

	public void clickOnSearchButton() {
		btnSearch.click();
	}

	public boolean searchCustomerByEmail(String email) {
		boolean found = false;
		int ttlRows = tableRows.size();
		//int ttlCols = tableColumns.size();

		for (int i = 1; i <= ttlRows; i++) {
			WebElement webEleEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmail = webEleEmail.getText();

			if(actualEmail.equals(email)) {
				found = true;
			}
		} return found;
	}

	////////////// Search Customer by FirstName and LastName /////////////////
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public boolean searchCustomerByName(String name) {
		boolean found = false;
		int ttlRows = tableRows.size();
		//int ttlCols = tableColumns.size();

		for (int i = 1; i <= ttlRows; i++) {
			WebElement webEleName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String actualName = webEleName.getText();

			if(actualName.equals(name)) {
				found = true;
			}
		} return found;
	}

}
