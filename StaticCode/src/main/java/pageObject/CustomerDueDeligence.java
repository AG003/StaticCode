package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerDueDeligence 
{
	public WebDriver driver;
	public Select dropDown;
	
	public CustomerDueDeligence(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using = "requestId")
	private WebElement txtbx_RequestId;
	
	@FindBy(how = How.NAME, using = "searchButton")
	private WebElement btn_Search;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'REQ')]")
	private WebElement link_RequestId;
	
	@FindBy(how = How.NAME, using = "EvidenceForCustomerSSN")
	private WebElement dropdown_EvidenceForCustomerSSN;
	
	@FindBy(how = How.NAME, using = "StatusForCustomerSSN")
	private WebElement dropdown_StatusForCustomerSSN;
	
	@FindBy(how = How.NAME, using = "EvidenceForLocalAddress")
	private WebElement dropdown_EvidenceForLocalAddress;
	
	@FindBy(how = How.NAME, using = "StatusForLocalAddress")
	private WebElement dropdown_StatusForLocalAddress;
	
	@FindBy(how = How.NAME, using = "EvidenceForPermanentAddress")
	private WebElement dropdown_EvidenceForPermanentAddress;
	
	@FindBy(how = How.NAME, using = "StatusForPermanentAddress")
	private WebElement dropdown_StatusForPermanentAddress;
	
	@FindBy(how = How.NAME, using = "Next")
	private WebElement btn_Next;
	
	public void enterRequestedId(String requestId)
	{
		txtbx_RequestId.sendKeys(requestId);
	}
	
	public void clickOnSearchButton()
	{
		btn_Search.click();
	}
	
	public void searchForRequest(String reqId)
	{
		enterRequestedId(reqId);
		clickOnSearchButton();
	}
	
	public void openRequest()
	{
		searchForRequest("REQ0000123");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(link_RequestId));
		link_RequestId.click();
	}
	
	public void enterSSNDetail()
	{
		dropDown = new Select(dropdown_EvidenceForCustomerSSN);
		dropDown.selectByValue("Yes");// Can be Yes/No
		dropDown = new Select(dropdown_StatusForCustomerSSN);
		dropDown.selectByValue("Complet");// Can be Complet/In-progress
	}
	
	public void enterLocalAddressDeatil()
	{
		dropDown = new Select(dropdown_EvidenceForLocalAddress);
		dropDown.selectByValue("Yes");
		dropDown = new Select(dropdown_StatusForLocalAddress);
		dropDown.selectByValue("Complet");
	}
	
	public void verifyPermanentAddressDetail()
	{
		dropDown = new Select(dropdown_EvidenceForPermanentAddress);
		dropDown.selectByValue("Yes");
		dropDown = new Select(dropdown_StatusForPermanentAddress);
		dropDown.selectByValue("In-progess");
	}
	
	public void enterQuestionsDetails()
	{
		enterSSNDetail();
		enterLocalAddressDeatil();
		verifyPermanentAddressDetail();
	}
	
	public void clickOnNextButton()
	{
		btn_Next.click();
	}

}
