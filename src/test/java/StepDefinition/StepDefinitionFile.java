package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionFile extends BaseClass{

	@Before
	public void setup() throws Exception {
		System.out.println("Setup method executed...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		readConfiq =new Properties();
		FileInputStream file = new FileInputStream("confiq.properties");
		readConfiq.load(file);
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	/*
	 * @When("User enters Username as {string} and Password as {string}") public
	 * void user_enters_username_as_and_password_as(String emailadd, String
	 * password) { loginPg.enterEmail(emailadd); loginPg.enterPassword(password); }
	 */

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
		loginPg.enterEmail(string);
		loginPg.enterPassword(string2);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
		loginPg.clickOnLoginButton();
	}

	/////////////////////////////  Login feature  ///////////////////////////	

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("User close browser")
	public void user_close_browser() {
		driver.close();
		//driver.quit();
	}

	/////////////////////////////  Add New Customer  ///////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomersMenu();
	}

	@When("Click on customers Menu Irem")
	public void click_on_customers_menu_irem() {
		addNewCustPg.clickOnCustomersMenuItem();
	}

	@When("Click on Add New button")
	public void click_on_add_new_button() throws Exception {
		addNewCustPg.clickOnAddNew();
		Thread.sleep(3000);
	}

	@Then("User can view Add New customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer information")
	public void user_enter_customer_information() {
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prashant");
		addNewCustPg.enterLastName("Jadhav");
		addNewCustPg.clickOnGender("Male");
		addNewCustPg.enterDateOfBirth("08/08/1978");
		addNewCustPg.enterCompanyName("Cognizant Solution");
		//addNewCustPg.enterNewsletter("Test store 2");
		//addNewCustPg.enterCustomerRoles("Administrators");
		addNewCustPg.enterManagerOfVendors("Vendor 1");
		addNewCustPg.enterAdminComment("Admin Comments");
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expMessage) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expMessage)) {
			Assert.assertTrue(true);  //Pass
		}
		else {
			Assert.assertTrue(false);  //Fail
		}

	}

	//////////////////   Search Customer by Email  ///////////////////
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustPg.enterEmailAddress("admin@yourStore.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws Exception {
		searchCustPg.clickOnSearchButton();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "admin@yourStore.com";
		//Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail));
		if(searchCustPg.searchCustomerByEmail(expectedEmail)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	//////////  Search Customer by FirstName and LastName  ///////////
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustPg.enterFirstName("Prashant");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustPg.enterLastName("Jadhav");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Prashant Jadhav";
		if(searchCustPg.searchCustomerByName(expectedName)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@After
	public void teardown(Scenario sce) throws Exception {
		System.out.println("Teardown method executed...");
		if(sce.isFailed()==true) {
			
			//convert web driver object to TakeScreenshot
			String fileWithPath = "E:\\eclipse-workspace\\CucumberFramework\\Screenshots\\screenshot_failed.png";
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			
			//call getScreenshotAs method to create image file
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//move image file to new destination
			File destFile = new File(fileWithPath);
			
			//copy file at destination
			FileUtils.copyFile(srcFile, destFile);
			
		}
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStepMethodDemo() {
		System.out.println("This is before step ....");
	}
	
	@AfterStep
	public void afterStepMethodDemo() {
		System.out.println("This is after step ....");
	}

}