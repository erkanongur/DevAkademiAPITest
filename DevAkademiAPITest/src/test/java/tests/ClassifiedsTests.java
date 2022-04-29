package tests;

import helpers.ClassifiedsServiceHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import model.ClassifiedModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Validator;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ClassifiedsTests extends Validator {
    private ClassifiedsServiceHelper classifiedsServiceHelper;
    private static final Logger logger = LoggerFactory.getLogger(ClassifiedsTests.class);

    @BeforeClass
    public void init()
    {
        classifiedsServiceHelper = new ClassifiedsServiceHelper();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/classifieds ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("CLASSIFIEDS")
    @Test
    public void getClassifieds_Test()
    {
        logger.info("İlanlar İçin İstek Atılıyor..");
        List<ClassifiedModel> classifieds = classifiedsServiceHelper.getClassifieds(1);
        logger.info("İlanlar Başarı İle Alındı.");

        //Yanıt İçerisinde Getirilen Veri Sayısının Beklenildiği Gibi Geldiği Doğrulanır.
        assertEquals(classifieds.size(), 20);
        logger.info("Yanıt İlan Sayısı : " + classifieds.size() + "    Beklenen İlan Sayısı : " + 20);

        //Getirilen Verilerin Her Birinin Json Değerlerinin Boş Olmadığı Doğrulanır.
        //Integer Değerler Hiçbir Zaman Null Olamayacağı İçin Kontrol Edilmemiştir.
        logger.info("İlanlar İçerisindeki Değerler Doğrulanıyor..");
        for (ClassifiedModel classified: classifieds) {
            validateClassified(classified);
        }
        logger.info("İlanlar İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/classifieds ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("CLASSIFIEDS")
    @Test
    public void getClassified_Test()
    {
        logger.info("İlan İçin İstek Atılıyor..");
        ClassifiedModel classified = classifiedsServiceHelper.getClassified(1);
        logger.info("İlan Başarı İle Alındı.");

        logger.info("İlan İçerisindeki Değerler Doğrulanıyor..");

        validateClassified(classified);

        logger.info("İlan İçerisindeki Değerler Başarıyla Doğrulandı..");
    }
}
