package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class BaseClass {

	WebDriver driver;
	LoginPage loginPg;
	AddNewCustomerPage addNewCustPg;
	SearchCustomerPage searchCustPg;
	Properties readConfiq;
	
	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
