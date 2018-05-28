package utils;

import helpers.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


public class ConvertUtil {
	private static Logger logger = Logger.getLogger("ConvertUtil");
	
	/***
	 * Return the o Object if o not null. Otherwise return defaultVal
	 * @param o The object is passed to this method
	 * @param defaultVal The default object that you expect if o is null
	 * @return return a object
	 */
	
	public static Object getObject(Object o, Object defaultVal){
		if(o != null) return o;
		return defaultVal;
	}
	
	/***
	 * Return the Float if the input object not null and parsed successfully. Otherwise defaultVal
	 * @param input The input Object passed to this function
	 * @param defaultVal The default value that you expect if any error occur
	 * @return Return the float object
	 */
	public static Float getFloat(Object input, Float defaultVal){
		if(input == null) return defaultVal;
		Float result;
		try{
			result = Float.parseFloat(input.toString());
		}catch(Exception e){
			logger.info(e.getMessage().toString());
			result = defaultVal;
		}
		return result;
	}
	
	/***
	 * Return a string if input object not null. Otherwise return defaultVal
	 * @param input The input Object passed to this function
	 * @param defaultVal The default value that you expect if any error occur
	 * @return return a string
	 */
	
	public static String getString(Object input, String defaultVal){
		if(input == null) return defaultVal;
		return input.toString();
	}
	
	/***
	 * Return a integer if input object not null and parsed successfully. Otherwise return defaultVal
	 * @param input The input Object that passed to this function
	 * @param defaultVal The default value that you expect if any error occur
	 * @return Return integer object
	 */
	public static Integer getInt(Object input, Integer defaultVal){
		
		if(input == null) return defaultVal;
		Integer result = null;
		try{
			result = Integer.parseInt(input.toString());
		}catch(Exception e){
			logger.info(e.getMessage());
			result = defaultVal;
		}
		return result;
	}
	
	/***
	 * Return a double object if input object not null and parsed successfully. Otherwise defaultVal
	 * @param input The input object that passed to this function
	 * @param defaultVal The default value that you expect if any error occur
	 * @return Return a double object
	 */
	public static Double getDouble(Object input, Double defaultVal){
		
		if(input == null) return defaultVal;
		Double result;
		try{
			result = Double.parseDouble(input.toString()) ;
		}catch(Exception e){
			logger.info(e.getMessage());
			result = defaultVal;
		}
		return result;
	}
	
	/***
	 * Return a boolean if input object is instance of Boolean
	 *<br>Return true if input object in ("true","yes","1")
	 *<br>Return false if input object in ("false","no","0")
	 *<br>Otherwise return defaultVal
	 * @param input The input object that you pass to this function
	 * @param defaultVal The default value you expect if any error occur
	 * @return Return a boolean
	 */
	public static Boolean getBoolean(Object input, Boolean defaultVal){
		if(input == null) return defaultVal;
		if(input instanceof Boolean) return (Boolean)input;
		
		Boolean result;
		try{
			String valCase = input.toString().toLowerCase();
			switch(valCase){
			case "true" : return true;
			case "fasle" : return false;
			case "yes": return true;
			case "no" : return false;
			case "1" : return true;
			case "0" : return false;
			default:
				return defaultVal;
			}
		}catch(Exception e){
			result = defaultVal;
			logger.info(e.getMessage());
		}
		return result;
	}
	
	/***
	 * The method returns a long value if input object not null and parse successfully. Otherwise defaultVal
	 * @param input The input object is passed
	 * @param defaultVal The default value that you expect if any error occur
	 * @return Return a long object
	 */
	public static Long getLong(Object input, Long defaultVal){
		if(input == null) return (Long)defaultVal;
		Long result;
		try{
			result = Long.parseLong(input.toString().trim());
		}catch(Exception e){
			logger.info(e.getMessage());
			result = defaultVal;
		}
		return result;
	}
	
	/***
	 * This method return a date object provided by inputDate and formatPattern
	 * @param inputDate the String of date
	 * @param formatPattern the format pattern that you would like to parse date
	 * @param defaultVal The default date that you expect if any error occur
	 * @return Return a date object
	 */
	public static Date getDateTime(String inputDate,String formatPattern, Date defaultVal){
		
		if(inputDate == null  || "".equals(inputDate)) return defaultVal;
		
		Date date = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
			date = sdf.parse(inputDate);
		}catch(Exception e){
			date = defaultVal;
			logger.info(e.getMessage());
		}
		return date;
	}
	/***
	 * This method return a formatted String provided by date object and format pattern
	 * @param date The date will be format to string
	 * @param formatPattern The format pattern that you would like to format the date
	 * @param defaultVal The default value will be return if any error occur
	 * @return Return string object
	 */
	public static String getDateAsTring(Date date, String formatPattern,String defaultVal){
		
		String result;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
			result = sdf.format(date);
		}catch(Exception e){
			result = defaultVal;
			logger.info(e.getMessage());
		}
		return result;
	}

	public static int getYear(String formatPattern,String dateInString) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		Date date1 = sdf.parse(dateInString);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);

		return calendar.get(Calendar.YEAR);
	}

	public static int getMonth(String formatPattern,String dateInString) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
		Date date1 = sdf.parse(dateInString);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);

		return calendar.get(Calendar.MONTH);
	}


	/***
	 * The test method for all functions in this class
	 * @param args 
	 */
	public static void main(String[] args) throws ParseException {
		Logger logger = Logger.getLogger("ConvertUtil");
		String a="spaces  sdsds";
//or this
		String b= a.replaceAll("\\s+"," ");

		System.out.print(b);
		Log.info("asasasasa");
		Log.error("sdsdsds");

	}
	
}
