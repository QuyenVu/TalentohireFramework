package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.ImageGalleryPage;

public class ImageGalleryPageSteps {

    @Given("^user is on test_gallery Page$")
    public void user_is_on_test_gallery_Page(){
        ImageGalleryPage.page().navigateTo_ImageGalleryPage();
    }

    @When("^he upload the his image from local \"(.*?)\"$")
    public void he_upload_the_his_image_from_local(String imageName) throws Throwable {
        ImageGalleryPage.page().uploadImageFile(imageName);
    }

    @Then("^verify the image will be uploaded to server successfully$")
    public void verify_the_image_will_be_uploaded_to_server_successfully() throws Throwable {
        Assert.assertTrue("The image is uploaded unsecessfully",ImageGalleryPage.page().verifyImageIsDisplayed());
        Thread.sleep(5000);
    }

    @When("^he upload the invalid file from local \"(.*?)\"$")
    public void he_upload_the_invalid_file_from_local(String imageName) throws Throwable {
        ImageGalleryPage.page().uploadImageFile(imageName);
        Thread.sleep(2000);
    }

    @Then("^verify the file will not be uploaded to server successfully$")
    public void verify_the_file_will_not_be_uploaded_to_server_successfully() throws Throwable {
        Assert.assertTrue("The file is not uploaded unsecessfully",ImageGalleryPage.page().verifyImageIsNotUploaded().contains("Only images avaliable to upload"));
        Thread.sleep(5000);
    }

}
