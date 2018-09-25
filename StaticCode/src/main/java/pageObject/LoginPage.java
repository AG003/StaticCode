package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement txtbx_Username;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement txtbx_Password;
	
	@FindBy(how = How.CLASS_NAME, using = "SubmitButton")
	private WebElement btn_SubmitButton;
	
	public void enterUsername(String name)
	{
		txtbx_Username.sendKeys(name);
	}
	
	public void enterPassword(String password)
	{
		txtbx_Username.sendKeys(password);
	}
	
	public void clickOnSubmitButton()
	{
		txtbx_Username.click();
	}
	
	public void loginAsSalesPerson()
	{
		enterUsername("Admin1");
		enterPassword("Abc111");
		clickOnSubmitButton();
	}
	
	public void loginAsAnalyst()
	{
		enterUsername("Admin2");
		enterPassword("Abc222");
		clickOnSubmitButton();
	}
	
	public void loginAsManager()
	{
		enterUsername("Admin3");
		enterPassword("Abc333");
		clickOnSubmitButton();
	}

}









