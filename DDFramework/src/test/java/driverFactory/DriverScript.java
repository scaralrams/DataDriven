package driverFactory;

import org.testng.annotations.Test;

import commomFunctions.CheckingSulplyrExistancePage_POM;
import commomFunctions.LogInPage_POM;
import commomFunctions.LogOutPage_POM;
import commomFunctions.SupplierAddingPage_POM;
import config.AppUtils;
import utils.ExcelUtils;

public class DriverScript extends AppUtils
{
	@Test
	public void AddingSupliers() throws Throwable
	{
	String XlPath="./XLinput/SuplierData.xlsx";
	String xlsheet="Data";
	String outxlpath="./ExcelOutput/Output.xlsx";
	ExcelUtils xl=new ExcelUtils(XlPath);
	int rc=xl.RowCount(xlsheet);
	for (int i = 1;i<=rc; i++)
	{
		System.out.println("The ROwCount ="+rc);
		driver.manage().window().maximize();
		LogInPage_POM lp=new LogInPage_POM(driver);
		lp.clickResetBtn();
		lp.enterUserName("admin");
		lp.enterPassWord("master");
		lp.clickLogINSubmitBtn();
		SupplierAddingPage_POM sap=new SupplierAddingPage_POM(driver);
		String Sname=xl.getcellData(xlsheet, i, 0);
		String Sadress=xl.getcellData(xlsheet, i, 1);
		String Scity=xl.getcellData(xlsheet, i, 2);
		String Scountry=xl.getcellData(xlsheet, i, 3);
		String Sperson=xl.getcellData(xlsheet, i, 4);
		String Sphone=xl.getcellData(xlsheet, i, 5);
		String Semail=xl.getcellData(xlsheet, i, 6);
		String Smobile=xl.getcellData(xlsheet, i, 7);
		String Snotes=xl.getcellData(xlsheet, i, 8);
		sap.SupplierLink();
		sap.PlusBtn_Meth();
		Thread.sleep(3000);
		String empid=sap.AutoGenratedID_MEth();
		sap.SupplyerName_Meth(Sname);
		sap.Address_Meth(Sadress);
		sap.City_Meth(Scity);
		sap.Country_Meth(Scountry);
		sap.ContactPerson_Meth(Sperson);
		sap.PhoneNumber_Meth(Sphone);
		sap.Email_Meth(Semail);
		sap.MobileNumber_Meth(Smobile);
		sap.Notes_Meth(Snotes);
		sap.AddBtn_Meth();
		Thread.sleep(3000);
		sap.confirmOKBtn_Meth();
		sap.SucessfullyAddedBtn_Meth();
		Thread.sleep(3000);
		CheckingSulplyrExistancePage_POM ce=new CheckingSulplyrExistancePage_POM(driver);
		Thread.sleep(3000);
		ce.notDispalyedInput(empid);
		ce.SubmitSearchBtn_Meth();
		boolean res=ce.CheckID_presentORnot();
		if (res) 
		{
			xl.setCellData(xlsheet, i, 9, "PASS", outxlpath);
		} else 
		{
			xl.setCellData(xlsheet, i, 9, "FAIL", outxlpath);
		}
		LogOutPage_POM lo=new LogOutPage_POM(driver);
		lo.LogOUtBtn_Meth();
		
	}
	}

	
}
