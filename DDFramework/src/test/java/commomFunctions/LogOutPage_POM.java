package commomFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage_POM 
{
	WebDriver driver;
	public LogOutPage_POM(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[text()=' Logout'] )[2]")
	WebElement LogOUtBtn;
	public void LogOUtBtn_Meth()
	{
		LogOUtBtn.click();
	}

}
