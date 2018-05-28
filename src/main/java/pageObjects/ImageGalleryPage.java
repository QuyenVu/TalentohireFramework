package pageObjects;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Common;

import java.io.File;

public class ImageGalleryPage extends  BasePage{

   private String url = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
   private String path = System.getProperty("user.dir")+ File.separator + FileReaderManager.getInstance().getConfigReader().getImagePath();

    public static ImageGalleryPage page(){

        return PageObjectManager.getImageGalleryPage();
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'js-file-input hidden')]")
    private WebElement txt_ImageGallery;

    @FindBy(how = How.XPATH, using = "//article[contains(@class,'thumbnails-list')]//img")
    private  WebElement img_Thumbnails;

    public void navigateTo_ImageGalleryPage(){
        driver.get(url);
    }

    public void uploadImageFile(String imageName){
        txt_ImageGallery.sendKeys(path+"\\"+imageName);
    }

    public boolean verifyImageIsDisplayed(){
        return img_Thumbnails.isDisplayed();
    }

    public String verifyImageIsNotUploaded() throws Exception {
        return Common.getInstance().closeAlertAndGetItsText(true);
    }
}
