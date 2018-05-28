package utils;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class RandomCharacter {
	protected Logger logger;
	private WebDriver driver;
	
	public RandomCharacter(){
		logger = Logger.getLogger(this.getClass().getName() + "]");
	}
	
	public RandomCharacter(WebDriver driver){
		this.driver = driver;
		logger = Logger.getLogger(this.getClass().getName() + "],[" + driver);
	}
	
	//Get random alphabetic characters
	public String getRandomAlphaString(int length) throws Exception {		
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		charset = RandomStringUtils.random(length, charset.toCharArray());
		logger.info("        Returned Random Alpha String: " + charset);
		return charset;		
	}
	
	//Get random numeric characters
	public String getRandomNumericString(int length) throws Exception {		
		String charset = "1234567890";		
		charset = RandomStringUtils.random(length, charset.toCharArray());
		logger.info("        Returned Random Numeric String: " + charset);
		return charset;		
	}
	
	//Get random alphanumeric characters
	public String getRandomAlphaNumericString(int length) throws Exception {		
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";		
		charset = RandomStringUtils.random(length, charset.toCharArray());
		logger.info("        Returned Random AlphaNumeric String: " + charset);
		return charset;		
	}
	
}
