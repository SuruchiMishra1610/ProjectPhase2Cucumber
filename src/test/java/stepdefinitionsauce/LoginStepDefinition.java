package stepdefinitionsauce;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitionsauce.HooksSauce;

public class LoginStepDefinition {
	
	WebDriver driver = HooksSauce.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
		System.out.println("Launched Browser successfully");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@When("I enter the correct username and password.")
	public void i_enter_the_correct_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");
		
		WebElement UserPass = driver.findElement(By.id("password"));
		UserPass.sendKeys("secret_sauce");
	  
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("I enter the username as {string} and password as {string}")
	public void i_enter_the_username_as_and_password_as(String UserNameVal, String UserPassVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys(UserNameVal);
		
		WebElement UserPass = driver.findElement(By.id("password"));
		UserPass.sendKeys(UserPassVal);
	}

	@When("I click on Login Button")
	public void i_click_on_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginLink = driver.findElement(By.id("login-button"));
		LoginLink.click();
	  
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String string) {
	    // Write code here that turns the phrase above into concrete actions

		WebElement Errormsg = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String ActError = Errormsg.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ExpError,ActError);
	}
	
	@When("I click on add to cart on product {string}")
	public void i_click_on_add_to_cart_on_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   WebElement ProductName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
	   ProductName.click();
	   WebElement AddCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	   AddCart.click();
	}

	
	@Then("Basket item value is {int}")
	public void basket_item_value_is(int expResult) {
	    // Write code here that turns the phrase above into concrete actions
		   List<WebElement> CartValue = driver.findElements(By.xpath("//span[@class='shopping_cart_badge'][1]"));
		   int Cartcount = CartValue.size();
		   Assert.assertEquals(Cartcount,expResult);
	}
	


}
