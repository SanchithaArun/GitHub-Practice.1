package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class CreatingNewContactPage extends SeleniumUtility {
@FindBy(name="lastname")
private WebElement lastnameEdt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;
@FindBy(name="leadsource")
private WebElement leadsourceDropDown;
//initialization
public CreatingNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);

}
//Utilization
public WebElement getLastnameEdt() {
	return lastnameEdt;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}
public WebElement getLeadsourceDropDown() {
	return leadsourceDropDown;
}
//Business Logic
/**
 * This method will create a new Contact with Mandatory details
 * @param LASTNAME
 */

public void createNewContact(String LASTNAME)
{
lastnameEdt.sendKeys(LASTNAME);
SaveBtn.click();
}
/**
 * This method will create a new Contact with LeadSource dropdown
 * @param LASTNAME
 * @param LEADSOURCE
 */
public void createNewContact(String LASTNAME,String LEADSOURCE)
{
	lastnameEdt.sendKeys(LASTNAME);
	handleDropdown(leadsourceDropDown,LEADSOURCE);
	
	SaveBtn.click();
}

}
