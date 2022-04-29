package tests;

import helpers.AdvertisementsServiceHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import model.AdvertisementModel;
import model.ClassifiedModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Validator;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AdvertisementsTests extends Validator {
    private AdvertisementsServiceHelper advertisementsServiceHelper;
    private static final Logger logger = LoggerFactory.getLogger(AdvertisementsTests.class);

    @BeforeClass
    public void init()
    {
        advertisementsServiceHelper = new AdvertisementsServiceHelper();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/advertisements ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("ADVERTISEMENTS")
    @Test
    public void getAdvertisementsVehicle_Test()
    {
        logger.info("Reklamlar İçin İstek Atılıyor..");
        AdvertisementModel advertisements = advertisementsServiceHelper.getAdvertisement("VEHICLE");
        logger.info("Reklamlar Başarı İle Alındı.");

        logger.info("Reklamlar İçerisindeki Değerler Doğrulanıyor..");
        validateAdvertisements(advertisements);
        logger.info("Reklamlar İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("ADVERTISEMENTS")
    @Description("/v1/api/advertisements ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Test
    public void getAdvertisementsShopping_Test()
    {
        logger.info("Reklamlar İçin İstek Atılıyor..");
        AdvertisementModel advertisements = advertisementsServiceHelper.getAdvertisement("SHOPPING");
        logger.info("Reklamlar Başarı İle Alındı.");

        logger.info("Reklamlar İçerisindeki Değerler Doğrulanıyor..");
        validateAdvertisements(advertisements);
        logger.info("Reklamlar İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/advertisements ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("ADVERTISEMENTS")
    @Test
    public void getAdvertisementsRealEstate_Test()
    {
        logger.info("Reklamlar İçin İstek Atılıyor..");
        AdvertisementModel advertisements = advertisementsServiceHelper.getAdvertisement("REAL_ESTATE");
        logger.info("Reklamlar Başarı İle Alındı.");

        logger.info("Reklamlar İçerisindeki Değerler Doğrulanıyor..");
        validateAdvertisements(advertisements);
        logger.info("Reklamlar İçerisindeki Değerler Başarıyla Doğrulandı..");
    }
}
