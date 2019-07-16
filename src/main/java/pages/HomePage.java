package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;




public class HomePage extends Base{

	LoginPage LoginPage;
	@FindBy(xpath="//*[@id=\"greeting\"]")
	WebElement unameHello;
	@FindBy(xpath="/html/body/div/header/div/p[1]")
	WebElement logoutBtn;
	@FindBy(xpath="//*[@id=\"bAdd\"]")
	WebElement createLnk;
	@FindBy(xpath="//*[@id=\"bEdit\"]")
	WebElement editLnk;
	@FindBy(xpath="//*[@id=\"bDelete\"]")
	WebElement deleteLnk;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[1]/input")
	WebElement firstName;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[2]/input")
	WebElement lastName;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[3]/input")
	WebElement startDate;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[4]/input")
	WebElement email;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/div/button[2]")
	WebElement addBtn;
	@FindBy(xpath="/html/body/div/div/div/form/fieldset/div/button[1]")
	WebElement updateBtn;
	
	@FindBy(xpath="/html/body/div/div/div/div/ul/li[6]")
	WebElement employeeEle;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean onHomeOrNot(){
		return unameHello.isDisplayed();
	}
	public boolean  isLoggingOutOrNot(){
		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		logoutBtn.click();
		LoginPage=new LoginPage();
		return LoginPage.lgnBtn.isDisplayed();
		
	}
	public boolean verifyEmployeeCreation(String fname,String lname,String date,String email){
		
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		createLnk.click(); firstName.sendKeys(fname);lastName.sendKeys(lname);
		startDate.sendKeys(date); this.email.sendKeys(email); addBtn.click();
		List<WebElement> employeeList=driver.findElements(By.xpath("//*[@id='employee list']/li"));
				for(WebElement employee:employeeList)
				{
					if (employee.getText().equalsIgnoreCase("fname"+" "+" lname")){
						return true;
					}
				}
	return false;
	}
	public boolean verifyEmployeeDetails(String ename)
	{
		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
			
		}
		List<WebElement> employeeList=driver.findElements(By.xpath("//*[@id='employee']/li"));
				for (WebElement employee:employeeList)
				{
					if(employee.getText().equalsIgnoreCase(ename))
					{
						Actions action=new Actions(driver).doubleClick(employee);
						action.build().perform();
						return updateBtn.isDisplayed();
					}
				}
		return false;
	}
	
	public boolean editEmployeeDetails(String name)
	{
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
		List<WebElement> employeeList=driver.findElements(By.xpath("//*[@id='employee-list']/li"));
				for(WebElement employee:employeeList)
				{
					if(employee.getText().equalsIgnoreCase(name))
					{
						employee.click();
					}
				}
		editLnk.click();
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e1){
		
			e1.printStackTrace();	
		}
		firstName.clear();
		firstName.sendKeys("fedit");
		updateBtn.click();
		
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();	
		}
		List<WebElement> employeeListNew=driver.findElements(By.xpath("//*[@id='employee-list']/li"));
				for (WebElement employee:employeeListNew)
				{
					if(employee.getText().equalsIgnoreCase("fedit"+" "+"lname"))
					{
						return true;
					}
				}
		return false;
	}

	public boolean deleteEmployeeRecord(String ename)
	{
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();	
		}
		List<WebElement> employeeList=driver.findElements(By.xpath("//*[@id='employee-list']/li"));
				for(WebElement employee:employeeList)
				{
					if(employee.getText().equalsIgnoreCase(ename)){
						employee.click();
					}
				}
		deleteLnk.click();
		driver.switchTo().alert().accept();
		List<WebElement> employeeListNew=driver.findElements(By.xpath("//*[@id='employee-list']/li"));
				for(WebElement employee:employeeListNew)
				{
					if (!employee.getText().equalsIgnoreCase(ename))
					{
						return false;
					}
				}
			return true;
	}
}
