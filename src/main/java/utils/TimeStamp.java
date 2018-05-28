package utils;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;


public class TimeStamp {
	protected Logger logger;
	private WebDriver driver;
	
	
	public TimeStamp(){
		logger = Logger.getLogger(this.getClass().getName() + "]");
	}
	
	public TimeStamp(WebDriver driver){
		this.driver = driver;
		logger = Logger.getLogger(this.getClass().getName() + "],[" + driver);
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	public String getTimeStamp() throws Exception {
		
		//format timestamp
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		
		//get current date and time
		Date date = new Date();
		logger.info(        sdf.format(date));
		
		return sdf.format(date);
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	// Return current date as string in MM/dd/yyyy format.
	public String getCurrentDate() throws Exception {
		
		String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());		
		logger.info("        Returned Current Date: " + currentDate);
	    return currentDate;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	public String getCurrentDate(String format) throws Exception {
		
		String currentDate = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());		
		logger.info("        Returned Current Date: " + currentDate);
	    return currentDate;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	public String getPreviousDate(String format, int days) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -days);		
		String previousDate = new SimpleDateFormat(format).format(cal.getTime());		
		logger.info("        Returned Previous Date: " + previousDate);
	    return previousDate;
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------
	public String getFutureDate(String format, int days) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);		
		String futureDate = new SimpleDateFormat(format).format(cal.getTime());		
		logger.info("        Returned Future Date: " + futureDate);
	    return futureDate;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------
	//Parses date of specified format and converts date to new specified format
	public String getConvertedDate(String oldFormat, String newFormat, String oldDate) throws Exception {
		Date date = new SimpleDateFormat(oldFormat).parse(oldDate);
		String newDate = new SimpleDateFormat(newFormat).format(date);
		newDate = newDate.toUpperCase();
		logger.info("        Returned New Format Date: " + newDate);
	    return newDate;
	}
	
	

}
