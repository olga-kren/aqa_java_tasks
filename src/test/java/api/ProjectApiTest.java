package test.java.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import test.java.pages.SearchResultPage;
import test.java.utils.PropertyLoader;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@Epic("API")
@Feature("Tasks")
public class ProjectApiTest {
    private Logger logger = LogManager.getLogger(ProjectApiTest.class);
    private final String API_TOKEN = "bc89023bd78f7f0573baaa3a6cef3178155be0fa";
    private final String API_PROJECT_PATH = "/projects";
    private final String API_TASK_PATH = "/tasks";
    private long generatedID;
    private long generatedTaskID;

/*    @Story("Get all projects")
    @Test(dependsOnMethods = "createProject")
    public void getAllProjects(){
    logger.info("List of pojects");
       List<String> projectListAll = 
               given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .when()
                .get(PropertyLoader.loadProperty("api.url") + API_PATH)
                .then()
                .statusCode(200)
                .extract()
                .path("name");
        for (String a:projectListAll) {
            System.out.println(a);
            
        }

    }*/
    @Story("Create a task")
    @Test
    public void createTask(){
        logger.info("New task created");
        String taskBody =
                "{\"content\": \"Task for Lesson 14\", " +
                "\"due_string\": \"next Monday at 12:00\", " +
                "\"priority\": 4}";
        generatedTaskID =
                given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .header("Content-Type", "application/json")
                .body(taskBody)
                .when()
                .post(PropertyLoader.loadProperty("api.url") + API_TASK_PATH)
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("id")
        ;
    }

    @Story("Get Task by ID")
    @Test(dependsOnMethods = "createTask")
    public void getTaskById() {
        logger.info("Get task by ID "+ generatedTaskID);
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .when()
                .get(PropertyLoader.loadProperty("api.url") + API_TASK_PATH + "/" + generatedTaskID)
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("getTaskByIdSchema.json"));

    }
    @Story("Update task")
    @Test(dependsOnMethods = "createTask")
    public void updateTask(){
        logger.info("Update task");
        String newTaskBody =
                "{\"content\": \"Updated content task for Lesson 14\", " +
                "\"priority\": 2}";
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .header("Content-Type", "application/json")
                .body(newTaskBody)
        .when()
                .post(PropertyLoader.loadProperty("api.url") + API_TASK_PATH + "/" + generatedTaskID)
        .then()
                .statusCode(204)
        ;

    }
    @Story("Get Updated Task by ID")
    @Test(dependsOnMethods = "updateTask")
    public void getUpdatedTaskById() {
        logger.info("Get updated task by ID "+ generatedTaskID);
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
        .when()
                .get(PropertyLoader.loadProperty("api.url") + API_TASK_PATH + "/" + generatedTaskID)
        .then()
                .statusCode(200)
                .log().body();

    }
    @Story("Close task")
    @Test(dependsOnMethods = "getUpdatedTaskById")
    public void CloseTaskById(){
        logger.info("Task with ID: " + generatedTaskID + " closed");
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
        .when()
                .post(PropertyLoader.loadProperty("api.url") + API_TASK_PATH + "/" + generatedTaskID + "/close")
        .then()
                .statusCode(204);
    }

    @Story("Delete task")
    @Test(dependsOnMethods = "CloseTaskById")
    public void deleteTaskById(){
        logger.info("Task with ID: " + generatedTaskID + " deleted");
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
        .when()
                .delete(PropertyLoader.loadProperty("api.url") + API_TASK_PATH + "/" + generatedTaskID)
        .then()
                .statusCode(204);
    }
}


