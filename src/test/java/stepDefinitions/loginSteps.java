package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	
	WebDriver driver;
	WebElement accButton;
	
	@Given("user opens beCognizant portal")
	public void user_opens_be_cognizant_portal() {
	    driver = new EdgeDriver();
	    driver.get("https://be.cognizant.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	}

	@When("user entered valid username and password")
	public void user_entered_valid_username_and_password() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(90))           // Maximum wait time
                .pollingEvery(Duration.ofSeconds(5))           // Polling interval
                .ignoring(NoSuchElementException.class);
//		clicking on the profile button
	    accButton =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id=\"O365_MainLink_Me\"]")));
		accButton.click();
	}

	@Then("check if the home page of beCognizant is opening or not")
	public void check_if_the_home_page_of_be_cognizant_is_opening_or_not() {
	    Assert.assertEquals(accButton.isDisplayed(), true); 
	}

	@Then("user should see user account details")
	public void user_should_see_user_account_details() {
	    accButton.click();
	    
	    WebElement accName = driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']"));
	    Assert.assertEquals(accName.isDisplayed(), true);
	    driver.quit();
	}
}