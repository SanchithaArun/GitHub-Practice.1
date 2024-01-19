package GenericUtilities;

import java.util.Date;

/**
 * This class consists of Java related reusable methods
 * @author asanchitha
 *
 */

public class JavaUtility {

	public String getSystemDate() {
		// TODO Auto-generated method stub
          Date d =new Date();
          String[] dArr = d.toString().split(" ");
          String currentDate = dArr[2]+"-"+dArr[5]+"-"+dArr[3].replaceAll(":", "-");
          return currentDate;
	}

}
