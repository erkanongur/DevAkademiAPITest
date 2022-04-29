package helpers;

import constants.EndPoints;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.AccessLogModel;
import org.apache.http.HttpStatus;
import utils.ConfigManager;

import java.util.List;

import static io.restassured.RestAssured.given;

public class AccessLogsServiceHelper {
    //"config.properties" Dosyasından İstek Atılacak URL Değeri Okunur.
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseURL");

    public AccessLogsServiceHelper(){
        //Bu Sayfada Ayrıca Belirtilmedikçe İstek Atılacak URL Belirtilir.
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Step
    public List<AccessLogModel> getAccessLogs(int pageNo){
        Response response =
                given().
                        log().uri().
                        log().method().
                        param("pageNo", pageNo).
                        when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_ACCESSLOGS).
                        then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        contentType(ContentType.JSON).//İçeriğin Json Olduğu Doğrulanır.
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemeData/accessLogsJsonSchema.json")).//Json Şema Doğrulaması Yapılır.
                        extract().response();

        //Json Dizisi POJO Listesine Dönüştürülür.
        return response.jsonPath().getList("data", AccessLogModel.class);
    }

    @Step
    public AccessLogModel getAccessLog(int accessLogId){
        Response response =
                given().
                        log().uri().
                        log().method().
                        when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_ACCESSLOGS + "/" + accessLogId).
                        then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        contentType(ContentType.JSON).//İçeriğin Json Olduğu Doğrulanır.
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemeData/accessLogJsonSchema.json")).//Json Şema Doğrulaması Yapılır.
                        extract().response();

        //Json Dizisi POJO Listesine Dönüştürülür.
        return response.jsonPath().getObject("data", AccessLogModel.class);
    }
}
