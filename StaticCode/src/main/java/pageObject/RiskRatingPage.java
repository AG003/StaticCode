package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RiskRatingPage 
{
	Select dropDown;
	
	public RiskRatingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "country")
	private WebElement dropdown_Country;
	
	@FindBy(how = How.NAME, using = "belongsToPolitics")
	private WebElement dropdown_Politician;
	
	@FindBy(how = How.NAME, using = "Submit")
	private WebElement btn_Submit;
	
	public void fillDetails()
	{
		dropDown = new Select(dropdown_Country);
		dropDown.selectByValue("XYZ"); // country whose having major roles in illegal actiities
		dropDown = new Select(dropdown_Politician);
		dropDown.selectByValue("Yes"); // Yes/No
	}
	public void clickOnSubmit()
	{
		btn_Submit.click();
	}

}
