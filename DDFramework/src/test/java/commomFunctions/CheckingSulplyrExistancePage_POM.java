package commomFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckingSulplyrExistancePage_POM 
{
	WebDriver Classdriver;
	
	public CheckingSulplyrExistancePage_POM(WebDriver driver)
	{
		this.Classdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String id;
	@FindBy(xpath = "//button/span[@data-phrase='SearchBtn' and @class='glyphicon glyphicon-search ewIcon']")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement IdInputField;
	
	@FindBy(id = "btnsubmit")
	WebElement SubmitSearchBtn;
	
	@FindBy(xpath = "//table[@id='tbl_a_supplierslist']/tbody/tr/td[6]/div/span/span")
	WebElement TableEmpId;
	public void notDispalyedInput(String empid) throws InterruptedException
	{
		Thread.sleep(2000);
		if (IdInputField.isDisplayed())
		{
			Thread.sleep(3000);
			this.id=empid;
			IdInputField.clear();
			IdInputField.sendKeys(empid);
			
		}
		else 
		{
			Thread.sleep(3000);
			SearchBtn.click();
			this.id=empid;
			IdInputField.clear();
			IdInputField.sendKeys(empid);
			
			
		}
		
	}
	public void SubmitSearchBtn_Meth() throws InterruptedException
	{
		Thread.sleep(3000);
		SubmitSearchBtn.click();
	}
	
	
	
	public boolean CheckID_presentORnot()
	{
		if (id.equals(TableEmpId.getText()))
		{
			return true;
			
		}
		else
		{
		return false;
		}
	}
	
}
