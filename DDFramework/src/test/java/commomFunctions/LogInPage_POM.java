package commomFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage_POM 
{
	WebDriver LogInPage_POM_driver;
	public LogInPage_POM(WebDriver driver)
	{
		this.LogInPage_POM_driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath ="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath ="//div[@id='msLoginDialog']//span[@aria-hidden='true'][normalize-space()='×']")
	WebElement ClosingLogINModuleBtn;
	
	@FindBy(linkText = "Forgot Password")
	WebElement ForgotPasswordLink;
	
	@FindBy(linkText = "Register")
	WebElement RegisterLink;
	
	
	@FindBy(xpath ="//li[@id='mi_login']//a[@href='login.php'][normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath ="//input[@id='password']")
	WebElement password;
	
	@FindBy(id ="btnsubmit")
	WebElement LoginSubmitBtn;
	
	@FindBy(id ="btnreset")
	WebElement resetBtn;
	//methods to implement 
	public void launchingURL()
	{
		this.LogInPage_POM_driver.get("http://webapp.qedgetech.com/login.php");
	}
	
	public void enterUserName(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterPassWord(String pword)
	{
		password.sendKeys(pword);
	}
	
	public void clickResetBtn()
	{
		resetBtn.click();
	}
	public void clickLogINSubmitBtn()
	{
		LoginSubmitBtn.click();
	}
	
	
	
	
	
	
	

	
	
	
	
	
	

}
