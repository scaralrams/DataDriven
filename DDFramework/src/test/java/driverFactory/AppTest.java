package driverFactory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import commomFunctions.FunctionalLibrary;
import config.AppUtils;
import utils.ExcelUtils;

public class AppTest extends AppUtils 

{
	
	
	@Test
	public void fetchingData() throws Throwable
	{
		
		String xlpath="C:\\StockMarket\\LoginData.xlsx";
		String xlsheet="INvalid";
		ExcelUtils xl=new ExcelUtils(xlpath);
		int rowcount=xl.RowCount(xlsheet);
		for (int i=1; i<=rowcount; i++)
		{
			String us=xl.getcellData(xlsheet, i, 0);
			String pw=xl.getcellData(xlsheet, i, 1);
			FunctionalLibrary fi=new FunctionalLibrary();
			boolean res=fi.VerifiyingUserLogin(us, pw);
			if (res) 
			{
				xl.setCellData(xlsheet, i, 2, "PASS", xlpath);
				Assert.assertTrue(res);
			} else 
			{
				xl.setCellData(xlsheet, i, 2, "Fail", xlpath);
				Assert.assertFalse(res);
			}
			
		}
		
		
	}

	

}
