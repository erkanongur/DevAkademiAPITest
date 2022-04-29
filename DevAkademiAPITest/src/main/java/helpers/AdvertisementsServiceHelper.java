package helpers;

import constants.EndPoints;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.AccessLogModel;
import model.AdvertisementModel;
import org.apache.http.HttpStatus;
import utils.ConfigManager;

import static io.restassured.RestAssured.given;

public class AdvertisementsServiceHelper {
    //"config.properties" Dosyasından İstek Atılacak URL Değeri Okunur.
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseURL");

    public AdvertisementsServiceHelper(){
        //Bu Sayfada Ayrıca Belirtilmedikçe İstek Atılacak URL Belirtilir.
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Step
    public AdvertisementModel getAdvertisement(String category){
        Response response =
                given().
                        log().uri().
                        log().method().
                        param("category", category).
                        when().
                        log().parameters().
                        log().body().
                        get(EndPoints.GET_ADVERTISEMENTS).
                        then().
                        log().status().
                        statusCode(HttpStatus.SC_OK).//HttpStatus Değeri Doğrulanır.
                        contentType(ContentType.JSON).//İçeriğin Json Olduğu Doğrulanır.
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemeData/advertisementsJsonSchema.json")).//Json Şema Doğrulaması Yapılır.
                        extract().response();

        //Json Dizisi POJO Listesine Dönüştürülür.
        return response.jsonPath().getObject("data", AdvertisementModel.class);
    }
}
