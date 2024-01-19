package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of re-usable methods related to excel file
 * @author asanc
 *
 */
public class ExelFileUtility {
/**
 * 
 * @param sheetname
 * @param Rownum
 * @param Cellnum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readTestDataFromExelFile(String sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fise= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
   		Workbook wb=WorkbookFactory.create(fise);
   		String value = wb.getSheet(sheetname).getRow(Rownum).getCell(Cellnum).getStringCellValue();
   		
   		return value;

	}

}
