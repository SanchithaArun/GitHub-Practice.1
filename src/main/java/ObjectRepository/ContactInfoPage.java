package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(className="dvHeaderText")
	private WebElement ContactHeaderText;


public ContactInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement getContactHeaderText() {
	return ContactHeaderText;
}
//Business Library
/**
 * This method capture the contact header and return it to caller
 * @return
 */
public String captureheaderText()
{
	return ContactHeaderText.getText();
}
}