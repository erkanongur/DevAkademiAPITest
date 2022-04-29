package helpers;

import constants.EndPoints;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.UserModel;
import org.apache.http.HttpStatus;
import utils.ConfigManager;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersServiceHelper {
    //"config.properties" Dosyasından İstek Atılacak URL Değeri Okunur.
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseURL");

    public UsersServiceHelper(){
        //Bu Sayfada Ayrıca Belirtilmedikçe İstek Atılacak URL Belirtilir.
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Step
    public List<UserModel> getUsers(int pageNo){
        Response response =
                given().
                        log().uri().
                        log().method().
                        param("pageNo", pageNo).
                when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_USERS).
                then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        contentType(ContentType.JSON).//İçeriğin Json Olduğu Doğrulanır.
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemeData/usersJsonSchema.json")).//Json Şema Doğrulaması Yapılır.
                        extract().response();

        //Json Dizisi POJO Listesine Dönüştürülür.
        return response.jsonPath().getList("data", UserModel.class);
    }

    @Step
    public void getUsers_pageNoMaxValue(){
        Response response =
                given().
                        log().uri().
                        log().method().
                        param("pageNo", Integer.MAX_VALUE).
                        when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_USERS).
                        then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        extract().response();
    }

    @Step
    public UserModel getUser(int userID){
        Response response =
                given().
                        log().uri().
                        log().method().
                        when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_USERS + "/" + userID).
                        then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        contentType(ContentType.JSON).//İçeriğin Json Olduğu Doğrulanır.
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemeData/userJsonSchema.json")).//Json Şema Doğrulaması Yapılır.
                        extract().response();

        //Json Yanıtı POJO'e Dönüştürülür.
        return response.jsonPath().getObject("data", UserModel.class);
    }
}
