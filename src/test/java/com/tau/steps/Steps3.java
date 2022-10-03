package com.tau.steps;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tau.base.BaseUtil;

import org.testng.asserts.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps3 extends BaseUtil{

	
	/**************************************************/
	// Multiple annotations
	/**************************************************/
	private WebDriver driver;
	@Given("I am in the login page")
	@Given("I am in the login page of the Para Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
        
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
	      driver.findElement(By.name("username")).sendKeys("abdo");
	        driver.findElement(By.name("password")).sendKeys("123456");
	        driver.findElement(By.name("username")).submit();
	        }

	@Then("I should be taken to the Overview page")
	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException{
		
          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
          driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
	        driver.quit();
	}

	

	/**************************************************/
	// scenario outline
	/**************************************************/
//	private WebDriver driver;
//	@Given("I am in the login page of the Para Bank Application")
//	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("http://parabank.parasoft.com/parabank/index.htm");
//        
//	}
//
//	@When("I enter valid {string} and {string}")
//	public void i_enter_valid_credentials(String userName,String password) {
//	      driver.findElement(By.name("username")).sendKeys(userName);
//	        driver.findElement(By.name("password")).sendKeys(password);
//	        driver.findElement(By.name("username")).submit();
//	        }
//
//	@Then("I should be taken to the Overview page")
//	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
//            Thread.sleep(5000);
//	        driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
//	        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
//
//	        driver.quit();
//	}

	/**************************************************/
	// data tables
	/**************************************************/
//	private WebDriver driver;
//	@Given("I am in the login page of the Para Bank Application")
//	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("http://parabank.parasoft.com/parabank/index.htm");
//        
//	}
//
//	@When("I enter valid credentials")
//	public void i_enter_valid_credentials(DataTable table) {
//		List<String> loginForm = table.asList();
//		driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
//		driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
//		driver.findElement(By.name("username")).submit();
//	}
//	@Then("I should be taken to the Overview page")
//	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
//            Thread.sleep(5000);
//	        driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
//	        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
//
//	        driver.quit();
//	}

	/**************************************************/
	                // Hooks
	/**************************************************/
//	private WebDriver driver;
//	@Before
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//
//	@Given("I am in the login page of the Para Bank Application")
//	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
//		driver.get("http://parabank.parasoft.com/parabank/index.htm");
//
//	}
//
//	@When("I enter valid {string} and {string}")
//	public void i_enter_valid_credentials(String userName, String password) {
//		driver.findElement(By.name("username")).sendKeys(userName);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.name("username")).submit();
//	}
//
//	@Then("I should be taken to the Overview page")
//	public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
//		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
//	}
//	@After()
//	public void quitBrowser() {
//	    driver.quit();
//	}
	
	

		private BaseUtil baseUtil;	

		public Steps3(BaseUtil util) {
			this.baseUtil = util;
		}	

		private WebDriver driver;
		@Before
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	
		@Given("I am in the login page of the Para Bank Application")
		public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
			driver.get("http://parabank.parasoft.com/parabank/index.htm");
		}
	
		@When("I enter valid {string} and {string} with {string}")
		public void i_enter_valid_credentials(String username, String password, String userFullName) {
			baseUtil.userFullName = userFullName;
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("username")).submit();
		}
	
		@Then("I should be taken to the Overview page")
		public void i_should_be_taken_to_the_Overview_page() throws Exception {
			String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
			assertTrue(actualuserFullName.contains(baseUtil.userFullName));
			driver.findElement(By.linkText("Log Out")).click();
			driver.quit();
		}
		@After()
		public void quitBrowser() {
		    driver.quit();
		}


}
