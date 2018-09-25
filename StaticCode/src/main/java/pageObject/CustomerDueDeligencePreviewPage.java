package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerDueDeligencePreviewPage 
{
	public CustomerDueDeligencePreviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "Submit")
	private WebElement btn_Submit;
	
	@FindBy(how = How.NAME, using = "Reject")
	private WebElement btn_Reject;
	
	public void clickOnSubmitButton()
	{
		btn_Submit.click();
	}
	
	public void clickOnRejecButton()
	{
		btn_Reject.click();
	}

}
