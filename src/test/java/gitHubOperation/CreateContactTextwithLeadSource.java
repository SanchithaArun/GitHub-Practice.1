package gitHubOperation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.HomePage;
@Listeners(GenericUtilities.ListenersImplementation.class)
public class CreateContactTextwithLeadSource extends BaseClass {
	@Test
	public void CreateContactWithMandatoryInfo() throws EncryptedDocumentException, IOException, InterruptedException {
		//Read all the required data
		//Read the test data from excel file
		String LASTNAME = eUtil.readTestDataFromExelFile("Contacts",4,2);
		String LEADSOURCE = eUtil.readTestDataFromExelFile("Contacts", 4, 3);
		//Step 1:Click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//step 2: Click on create contact look up Image
		ContactPage cp=new ContactPage(driver);
		cp.CreateContactLookUpImg();
		
		//step3: Create new contact with mandatory fields
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);
		
		
		//Step4:Validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader = cip.captureheaderText();
		

         Assert.assertTrue(ContactHeader.contains(LASTNAME));
        System.out.println(ContactHeader);	
       
	}

}
