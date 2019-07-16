package regressiontests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class TC2_Employee_CRUD extends Base{
	Base base;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		base=new Base();
		base.initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		loginPage.loginToApplication("Luke", "Skywalker");
	}
	
	@Test(priority=0)
	public void verifyLogin()
	{
		Assert.assertTrue(homePage.onHomeOrNot(),"Unable to login" );
	}
@Test(priority=1)
public void verifyEmployeeAddition()
{
	boolean flag=homePage.verifyEmployeeCreation("fname", "lname", "2019-08-12","test123@xyz.com" );
		Assert.assertTrue(flag," employee not added");
	}
@Test(priority=2)
public void verifyEmployeeDetails()
{
	boolean flag1=homePage.editEmployeeDetails("fname lname");
	Assert.assertTrue(flag1,"employee details not opened");
}
@Test(priority=3)
public void verifyEmployeeEdit()
{
	boolean flag1=homePage.editEmployeeDetails("fname lname");
	Assert.assertTrue(flag1,"employee not edited");
	
	}
@Test(priority=4)
public void verifyEmployeeDelete()
{
boolean flag2=homePage.deleteEmployeeRecord("fedit lname");
Assert.assertFalse(flag2);
}

@Test(priority=5)
public void verifyLogout()
{
	Assert.assertTrue(homePage.isLoggingOutOrNot(),"Unable to Logout");
	}
@AfterMethod
public void tearDown(){
	try{
		Thread.sleep(5000);
	}
	catch(InterruptedException e){
		
		e.printStackTrace();
		
	}
	driver.close();
}

}
