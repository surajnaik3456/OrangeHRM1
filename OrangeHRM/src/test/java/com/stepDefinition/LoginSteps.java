package com.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
	System.out.println("Step1 : user is on login page");
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    Thread.sleep(2000);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	System.out.println("Step2 : user enters username and password");
	  driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Admin");
	  driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("admin123");
	  
	}

	@And("click on Login button")
	public void click_on_login_button() {
		System.out.println("Step3 : user clicks on Login button");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("user should land on homepage")
	public void user_should_land_on_homepage() {
		System.out.println("Step4 : user lands on homepage"); 
	}

}
