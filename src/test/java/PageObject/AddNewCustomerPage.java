package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//Find web elements on Add New Customer web page
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement genderMale;
	
	@FindBy(xpath = "//input[@id='Gender_Female']")
	WebElement genderFemale;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDateOfBirth;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompany;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement chkTaxExempt;
	
	/*@FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
	WebElement txtNewsletter;
	
	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	WebElement txtCustomerRoles;*/
	
	/*@FindBy(xpath = "//li[@id='select2-SelectedCustomerRoleIds-result-85pl-1']")
	WebElement listItemAdministrator;
	
	@FindBy(xpath = "//li[@id='select2-SelectedCustomerRoleIds-result-smi9-2']")
	WebElement listItemForumModerators;
	
	@FindBy(xpath = "//li[@id='select2-SelectedCustomerRoleIds-result-kl2e-3']")
	WebElement listItemRegisterdr;
	
	@FindBy(xpath = "//li[@id='select2-SelectedCustomerRoleIds-result-ftqr-4']")
	WebElement listItemGuests;
	
	@FindBy(xpath = "//li[@id='select2-SelectedCustomerRoleIds-result-s29q-5']")
	WebElement listItemVendors;*/
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement dropdownVendorManager;
	
	@FindBy(xpath = "//input[@id='Active']")
	WebElement chkActive;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminComment;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	// Action Methods for Web Elements for Add New Customer 
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		lnkCustomers_menu.click();
	}
	
	public void clickOnCustomersMenuItem() {
		lnkCustomers_menuitem.click();
	}
	
	public void clickOnAddNew() {
		btnAddnew.click();
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void enterFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	
	public void clickOnGender(String gender) {
		if(gender.equals("Male")) {
			genderMale.click();
		}
		else if(gender.equals("Female")) {
			genderFemale.click();
		}
		else {
			genderMale.click();
		}
	}
	
	public void enterDateOfBirth(String dob) {
		txtDateOfBirth.sendKeys(dob);
	}
	
	public void enterManagerOfVendors(String vendors) {
		Select drpvendors = new Select(dropdownVendorManager);
		drpvendors.selectByVisibleText(vendors);
	}
	
	public void enterCompanyName(String cmpname) {
		txtCompany.sendKeys(cmpname);
	}
	
	public void clickOnTaxExempt() {
		chkTaxExempt.click();
	}
	
	/*public void enterNewsletter(String news) {
		Select drpnews = new Select(txtNewsletter);
		drpnews.selectByVisibleText(news);
	}
	
	public void enterCustomerRoles(String roles) {
		Select drproles = new Select(txtCustomerRoles);
		drproles.selectByVisibleText(roles);
	}*/
	
	public void clickOnActive() {
		chkActive.click();
	}
	
	public void enterAdminComment(String comment) {
		txtAdminComment.sendKeys(comment);
	}
	
	public void clickOnSave() {
		btnSave.click();
	}

}
