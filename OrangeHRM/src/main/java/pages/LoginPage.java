package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By user_name = By.tagName("//input[@name='username']");
	By pwd = By.tagName("//input[@name='password']");
	By ohrm_branding = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img");
	By login_btn = By.xpath("//button[@type='submit']");
	By invalid_cred = By.xpath("//*[text()='Invalid credentials']");
	By blank_fields = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]");
	By home_page = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[1]/a[1]/div[2]/img[1]");
	By forgot_pwd = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/p[1]");
	By profile_dropdown = By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/span[1]/i[1]");
	By logout = By.xpath("//a[text()='Logout']");

	public LoginPage(WebDriver driver) {
		driver = this.driver;
	}

	public void enterUsername(String username) {
		driver.findElement(user_name).sendKeys(username);
	}

	public void enterPwd(String password) {
		driver.findElement(pwd).sendKeys(password);
	}

	public void clickLoginBtn() {
		driver.findElement(login_btn).click();
	}

	public void checkHomepage() {
		driver.findElement(home_page).isDisplayed();
	}

	public void loginPg() {
		driver.findElement(ohrm_branding).isDisplayed();
	}

	public void loggedIn() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void invalidCred() {
		driver.findElement(invalid_cred).isDisplayed();
	}

	public void reqFieldError() {
		driver.findElement(blank_fields);
	}

	public void profile_dropdwn() {
		driver.findElement(profile_dropdown).click();
	}

	public void clickLogout() {
		driver.findElement(logout).click();
	}
}
