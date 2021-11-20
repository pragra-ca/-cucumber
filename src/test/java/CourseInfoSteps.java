import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;

public class CourseInfoSteps {

    Response response;


    @Given("We have access to url {string}")
    public void weHaveAccessToUrl(String url) {
        RestAssured.baseURI  = url;
    }

    @When("we will call api with course id {string} to path {string}")
    public void weWillCallApiWithCourseId(String courseId, String apiPath) {
         response = RestAssured.when().get(apiPath, courseId);
    }

    @Then("we should get status {int}")
    public void weShouldGetStatus(int status) {
        response.then().statusCode(200);
    }

    @And("course name should be {string}")
    public void courseNameShouldBe(String courseName) {
        response.then().body("courseName", equalTo(courseName));
    }


}
