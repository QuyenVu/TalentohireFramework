Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  @valid
  Scenario: The user will upload an image from local machine to server
    Given user is on test_gallery Page
    When he upload the his image from local "test.jpg"
    Then verify the image will be uploaded to server successfully

  @invalid
  Scenario: The user will upload an invalid file from local machine to server
    Given user is on test_gallery Page
    When he upload the invalid file from local "test.docx"
    Then verify the file will not be uploaded to server successfully