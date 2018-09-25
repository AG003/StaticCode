package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientRequestPage 
{
	
	public ClientRequestPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "name")
	private WebElement txtbx_Name;
	
	@FindBy(how = How.NAME, using = "phone")
	private WebElement txtbx_Phone;
	
	@FindBy(how = How.NAME, using = "ssn")
	private WebElement txtbx_SSN;
	
	@FindBy(how = How.NAME, using = "local address")
	private WebElement txtbx_LocalAddress;
	
	@FindBy(how = How.NAME, using = "permanent address")
	private WebElement txtbx_PermanentAddress;
	
	@FindBy(how = How.NAME, using = "Branch Code")
	private WebElement dropdown_BranchCode;
	
	@FindBy(how = How.NAME, using = "submit button")
	private WebElement btn_SubmitButton;
	
	public void enterName(String name)
	{
		txtbx_Name.sendKeys(name);
	}
	
	public void enterPhone(String phone)
	{
		txtbx_Phone.sendKeys(phone);
	}
	
	public void enterSSN(String ssn)
	{
		txtbx_SSN.sendKeys(ssn);
	}
	
	public void enterLocalAddress(String address)
	{
		txtbx_LocalAddress.sendKeys(address);
	}
	
	public void enterPermanentAddress(String address)
	{
		txtbx_PermanentAddress.sendKeys(address);
	}
	
	public void selectBranchCode(String branchCode)
	{
		Select dropDown = new Select(dropdown_BranchCode);
		dropDown.selectByValue(branchCode);
	}
	
	public void clickOnSubmitButton()
	{
		btn_SubmitButton.click();
	}
	
	public void fillPersonalDetails()
	{
		enterName("Ashok");
		enterPhone("9874563214");
		enterSSN("123456789");
		enterLocalAddress("Noida, India");
		enterPermanentAddress("Delhi, India");
		selectBranchCode("KBCBANK0000735");
	}
	
	

}
