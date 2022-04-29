package tests;

import helpers.AccessLogsServiceHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import model.AccessLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Validator;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccessLogsTests extends Validator {
    private AccessLogsServiceHelper accessLogsServiceHelper;
    private static final Logger logger = LoggerFactory.getLogger(AccessLogsTests.class);

    @BeforeClass
    public void init()
    {
        accessLogsServiceHelper = new AccessLogsServiceHelper();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/payment-details ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("ACCESS-LOGS")
    @Test
    public void getAccessLogs_Test()
    {
        logger.info("Erişim Kayıtları İçin İstek Atılıyor..");
        List<AccessLogModel> accessLogs = accessLogsServiceHelper.getAccessLogs(1);
        logger.info("Erişim Kayıtları Başarı İle Alındı.");

        //Yanıt İçerisinde Getirilen Veri Sayısının Beklenildiği Gibi Geldiği Doğrulanır.
        assertEquals(accessLogs.size(), 20);
        logger.info("Yanıt Erişim Kaydı Sayısı : " + accessLogs.size() + "    Beklenen Erişim Kaydı Sayısı : " + 20);

        //Getirilen Verilerin Her Birinin Json Değerlerinin Boş Olmadığı Doğrulanır.
        //Integer Değerler Hiçbir Zaman Null Olamayacağı İçin Kontrol Edilmemiştir.
        logger.info("Erişim Kayıtları İçerisindeki Değerler Doğrulanıyor..");
        for (AccessLogModel accessLog: accessLogs) {
            validateAccessLog(accessLog);
        }
        logger.info("Erişim Kayıtları İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/payment-details ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("ACCESS-LOGS")
    @Test
    public void getAccessLog_Test()
    {
        logger.info("Erişim Kaydı İçin İstek Atılıyor..");
        AccessLogModel accessLog = accessLogsServiceHelper.getAccessLog(61021);
        logger.info("Erişim Kaydı Başarı İle Alındı.");

        logger.info("Erişim Kaydı İçerisindeki Değerler Doğrulanıyor..");
        validateAccessLog(accessLog);
        logger.info("Erişim Kaydı İçerisindeki Değerler Başarıyla Doğrulandı..");
    }
}
