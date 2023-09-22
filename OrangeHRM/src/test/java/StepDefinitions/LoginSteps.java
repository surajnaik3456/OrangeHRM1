package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends TestBase {

	LoginPage login;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@Given("user is on login page")
	public void user_on_loginpage() throws InterruptedException {
		//Thread.sleep(2000);
		login =new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img")));
		login.loginPg();
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		login.enterUsername(username);
		login.enterPwd(password);
	}

	@And("click on Login button")
	public void click_on_login_button() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.clickLoginBtn();
	}

	@Then("user should land on homepage")
	public void user_should_land_on_homepage() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[1]/a[1]/div[2]/img[1]")));
		login.checkHomepage();
	}

	@When("^user enters invalid (.*) and valid (.*)$")
	public void user_enters_invalid_username(String username, String password) throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		login.enterUsername(username);
		login.enterPwd(password);
	}

	@Then("^the user should get an error message indicating Invalid Credentials$")
	public void invalid_credentials() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invalid credentials']")));
		login.invalidCred();
	}

	@When("^user enters valid (.*) and invalid (.*)$")
	public void user_enters_invalid_password(String username, String password) throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		login.enterUsername(username);
		login.enterPwd(password);
	}

	@When("^the user leaves both username and password fields empty$")
	public void blank_fields() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		System.out.println("Both field empty");
	}

	@Then("^the user should get an error message indicating required fields$")
	public void required_field_error() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]")));
		login.reqFieldError();
	}
	@When("user clicks on forgot your password link")
	public void forgot_password_link()
	{ 
	login = new LoginPage(driver);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/p[1]")));
	login.forgot_pwd_click();
	}
	@Then("Reset password page is displayed")
	public void reset_pg_displayed()
	{
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/h6[1]")));
		login.reset_pg();
	}
	@And ("Enter username in username text field")
	public void enter_username()
	{
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
		login.reset_username_field();
	}
	@And ("click on Reset password button")
	public void click_reset_btn()
	{
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.click_reset_pwd();
	}
	@Then ("reset password link is sent via email")
	public void reset_pwd_link_sent()
	{
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/h6[1]")));
		login.reset_link_sent();
	}
	@Given("^the user is logged in$")
	public void logged_in(String username, String password) throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.enterUsername(username);
		login.enterPwd(password);
		login.clickLoginBtn();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[1]/a[1]/div[2]/img[1]")));
		login.checkHomepage();
		//Thread.sleep(1000);
	}

	@When("^the user clicks on profile dropdown$")
	public void profile_dropdown() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/span[1]/i[1]")));
		login.profile_dropdwn();
	}

	@And("^clicks the logout$")
	public void click_logout() throws InterruptedException {
		//Thread.sleep(1000);
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
		login.clickLogout();
	}

	@Then("^the user should be logged out and redirected to the login page$")
	public void login_page_displayed() {
		login = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img")));
		login.loginPg();
	}
}
