$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("End2End_Tests.feature");
formatter.feature({
  "line": 1,
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of this feature is to test End 2 End integration.",
  "id": "automated-end2end-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2922842,
  "status": "passed"
});
formatter.before({
  "duration": 5165092466,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "The user will upload an image from local machine to server",
  "description": "",
  "id": "automated-end2end-tests;the-user-will-upload-an-image-from-local-machine-to-server",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@valid"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user is on test_gallery Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "he upload the his image from local \"test.jpg\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "verify the image will be uploaded to server successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ImageGalleryPageSteps.user_is_on_test_gallery_Page()"
});
formatter.result({
  "duration": 491631341,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test.jpg",
      "offset": 36
    }
  ],
  "location": "ImageGalleryPageSteps.he_upload_the_his_image_from_local(String)"
});
formatter.result({
  "duration": 106894086,
  "status": "passed"
});
formatter.match({
  "location": "ImageGalleryPageSteps.verify_the_image_will_be_uploaded_to_server_successfully()"
});
formatter.result({
  "duration": 5077795425,
  "status": "passed"
});
formatter.after({
  "duration": 1061081730,
  "status": "passed"
});
formatter.after({
  "duration": 43019,
  "status": "passed"
});
});