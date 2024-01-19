package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactEdt;
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public WebElement getCreateContactEdt() {
		return CreateContactEdt;
	}
	public void CreateNewContact()
	{
		
	
	CreateContactEdt.click();
	}

}
