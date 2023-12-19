package commomFunctions;



import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.jsoup.nodes.Document;

import config.AppUtils;


public class FunctionalLibrary extends AppUtils
{
	
	public boolean VerifiyingUserLogin(String un, String ps) throws InterruptedException
	{
	
		boolean returningvalue=false;
		driver.get(property.getProperty("url"));
		driver.findElement(By.xpath(property.getProperty("resetBtn"))).click();
		WebElement UserName= driver.findElement(By.xpath(property.getProperty("usernameField")));
		UserName.sendKeys(un);
		WebElement Passowrd= driver.findElement(By.xpath(property.getProperty("passwordField")));
		Passowrd.sendKeys(ps);
		driver.findElement(By.xpath(property.getProperty("loginBtn"))).click();
		Thread.sleep(3000);
		//WebElement LogOutBtn=driver.findElement(By.xpath("(//a[text()=' Logout' and @href='logout.php'])[2]"));
		// List of error messages or texts that indicate incorrect details
	String idmiss="Please enter user ID";
	String idorpassmiss="Incorrect user ID or password";
	String psmiss="Please enter password"; 
	String pageSource = driver.getPageSource();
		

        // Parse the HTML using JSoup
        Document doc = Jsoup.parse(pageSource);

        // Extract visible text from the document
        String allText = doc.text();

				 if (allText.contains(idmiss)||allText.contains(idorpassmiss)||allText.contains(psmiss)) 
		        {
					 returningvalue=true;
		        }
				 else 
				{
					 returningvalue=false;
				}
		    

		

		driver.findElement(By.xpath(property.getProperty("okBtn"))).click();
	return	returningvalue;
	
	
	
		
		
		
	}
	


}
