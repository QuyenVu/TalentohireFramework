package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
    protected WebDriver driver;
    private static ImageGalleryPage imageGalleryPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public static ImageGalleryPage getImageGalleryPage() {
        return imageGalleryPage = new ImageGalleryPage();
    }
}
