package commomFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierAddingPage_POM 
{
	
	WebDriver driver;
	public SupplierAddingPage_POM(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//div[@class='panel-heading ewGridUpperPanel']//a[@class='btn btn-default ewAddEdit ewAdd btn-sm']")
	WebElement PlusBtn;
	
	@FindBy(linkText ="Suppliers")
	WebElement supplierLInk;
	
	@FindBy(xpath = "//input[@placeholder='Supplier Name']")
	WebElement SupplierName;
	
	@FindBy(xpath = "//textarea[@placeholder='Address']")
	WebElement Address;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement City;
	
	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement Country;
	
	@FindBy(xpath = "//input[@placeholder='Contact Person']")
	WebElement ContactPerson;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	WebElement MobileNumber;
	
	@FindBy(xpath = "//textarea[@placeholder='Notes']")
	WebElement Notes;
	
	@FindBy(xpath = "//button[@id='btnAction']")
	WebElement AddBtn;
	
	@FindBy(xpath = "//button[@id='btnCancel']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement confirmOKBtn;
	
	@FindBy(xpath = "//button[contains(@class,'ajs-button btn btn-danger')]")
	WebElement confirmCancelBtn;
	
	@FindBy(xpath = "//input[@id='x_Supplier_Number']")
	WebElement  AutonGenneratedID;
	
	@FindBy(xpath ="//button[@class='ajs-button btn btn-primary']" )
	WebElement SucessfullyAddedBtn;
	
	//Desiging Methods for operations
	
	public void PlusBtn_Meth()
	{
		PlusBtn.click();
	}
	public void SupplyerName_Meth(String supplyerName)
	{
		SupplierName.sendKeys(supplyerName);
	}
	public void Address_Meth(String address)
	{
		Address.sendKeys(address);
	}
	
	public void City_Meth(String city)
	{
		City.sendKeys(city);
	}
	
	public void Country_Meth(String country)
	{
		Country.sendKeys(country);
	}
	
	public void ContactPerson_Meth(String contactPerson)
	{
		ContactPerson.sendKeys(contactPerson);
	}
	
	public void PhoneNumber_Meth(String phoneNumber)
	{
		PhoneNumber.sendKeys(phoneNumber);
	}
	
	public void Email_Meth(String email)
	{
		Email.sendKeys(email);
	}
	public void MobileNumber_Meth(String mobile)
	{
		MobileNumber.sendKeys(mobile);
	}
	public void Notes_Meth(String notes)
	{
		Notes.sendKeys(notes);
	}
	public void AddBtn_Meth()
	{
		AddBtn.click();
	}
	public void CancelBtn_Meth()
	{
		CancelBtn.click();
		
	}
	public void confirmOKBtn_Meth()
	{
		confirmOKBtn.click();
	}
	public void confirmCancelBtn_Meth()
	{
		confirmCancelBtn.click();
		
	}
	
	public String AutoGenratedID_MEth()
	{
		String id=AutonGenneratedID.getAttribute("value");
		return id;
		
	}
	public void SucessfullyAddedBtn_Meth()
	{
		SucessfullyAddedBtn.click();
		
	}
	public void SupplierLink()
	{
		supplierLInk.click();
	}
	
	
	

}
