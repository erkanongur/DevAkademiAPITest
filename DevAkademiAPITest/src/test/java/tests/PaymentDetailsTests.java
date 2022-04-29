package tests;

import helpers.PaymentDetailsServiceHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import model.ClassifiedModel;
import model.PaymentDetailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Validator;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PaymentDetailsTests extends Validator {
    private PaymentDetailsServiceHelper paymentDetailsServiceHelper;
    private static final Logger logger = LoggerFactory.getLogger(PaymentDetailsTests.class);

    @BeforeClass
    public void init()
    {
        paymentDetailsServiceHelper = new PaymentDetailsServiceHelper();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/payment-details ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("PAYMENT-DETAILS")
    @Test
    public void getPaymentDetails_Test()
    {
        logger.info("Ödeme Detayları İçin İstek Atılıyor..");
        List<PaymentDetailModel> paymentDetails = paymentDetailsServiceHelper.getPaymentDetails(1);
        logger.info("Ödeme Detayları Başarı İle Alındı.");

        //Yanıt İçerisinde Getirilen Veri Sayısının Beklenildiği Gibi Geldiği Doğrulanır.
        assertEquals(paymentDetails.size(), 20);
        logger.info("Yanıt Ödeme Detayı Sayısı : " + paymentDetails.size() + "    Beklenen Ödeme Detayı Sayısı : " + 20);

        //Getirilen Verilerin Her Birinin Json Değerlerinin Boş Olmadığı Doğrulanır.
        //Integer Değerler Hiçbir Zaman Null Olamayacağı İçin Kontrol Edilmemiştir.
        logger.info("Ödeme Detayları İçerisindeki Değerler Doğrulanıyor..");
        for (PaymentDetailModel paymentDetail: paymentDetails) {
            validatePaymentDetail(paymentDetail);
        }
        logger.info("Ödeme Detayları İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/payment-details ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("PAYMENT-DETAILS")
    @Test
    public void getPaymentDetail_Test()
    {
        logger.info("Ödeme Detayı İçin İstek Atılıyor..");
        PaymentDetailModel paymentDetail = paymentDetailsServiceHelper.getPaymentDetail(561021);
        logger.info("Ödeme Detayı Başarı İle Alındı.");

        logger.info("Ödeme Detayı İçerisindeki Değerler Doğrulanıyor..");
        validatePaymentDetail(paymentDetail);
        logger.info("Ödeme Detayı İçerisindeki Değerler Başarıyla Doğrulandı..");
    }
}
