package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base;
public class LoginPage extends Base{
	
@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[1]/input")
WebElement unameEle;
@FindBy(xpath="/html/body/div/div/div/form/fieldset/label[2]/input")
WebElement pwdEle;
@FindBy(xpath="/html/body/div/div/div/form/fieldset/button")
WebElement lgnBtn;


public  LoginPage ()
{
	PageFactory.initElements(driver,this);
}
	public void loginToApplication(String uname , String pwd)
	{
	unameEle.sendKeys(uname);
	pwdEle.sendKeys(pwd);
	lgnBtn.click();

	}

}


