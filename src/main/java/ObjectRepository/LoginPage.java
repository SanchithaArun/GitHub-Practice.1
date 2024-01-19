package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule1:
	//Rule 2:Declaration
     @FindBy(name="user_name")
		private WebElement usernameEdt;
		@FindBy(name ="user_password")
		private WebElement passwordEdt;
		@FindBy(id="submitButton")
		private WebElement loginBtn;
		//Rule3:Initialization

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//Rule4:utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business Library
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
