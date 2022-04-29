package utils;

import helpers.ClassifiedsServiceHelper;
import helpers.UsersServiceHelper;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.*;

//Validator Sınıfında Birden Fazla Testin Doğrulamasında Kullanılabilecek Methodlar Bulunmaktadır.
public class Validator {
    public void validateAdvertisements(AdvertisementModel advertisements){
        //category Doğrula
        assertNotNull(advertisements.getCategory());

        //impressionCount Doğrula
        isPozitive(advertisements.getImpressionCount());

        //clickCount Doğrula
        isPozitive(advertisements.getClickCount());

        //content Doğrula
        assertNotNull(advertisements.getContent());

        //contentType Doğrula
        assertNotNull(advertisements.getContentType());

        //createdDate Doğrula
        isValidTimestamp(advertisements.getCreatedDate());
    }
    public void validateAccessLog(AccessLogModel accessLog){
        //userId Doğrula
        assertEquals(accessLog.getUserId(), new UsersServiceHelper().getUser(accessLog.getUserId()).getId());

        //endpoint Doğrula
        assertNotNull(accessLog.getEndpoint());

        //createDate Doğrula
        isValidTimestamp(accessLog.getCreatedDate());
    }
    public void validatePaymentDetail(PaymentDetailModel paymentDetail){
        //classifiedId Doğrulanır.
        assertEquals(paymentDetail.getClassifiedId(), new ClassifiedsServiceHelper().getClassified(paymentDetail.getClassifiedId()).getId());

        //createdDate Doğrulanır.
        isValidTimestamp(paymentDetail.getCreatedDate());

        //amount Doğrulanır.
        isPozitive(paymentDetail.getAmount());

        //discount Doğrulanır.
        isPozitive(paymentDetail.getDiscount());
    }
    public void validateUser(UserModel user){
        //FirstName Doğrulanır.
        assertNotNull(user.getFirstName());

        //LastName Doğrulanır.
        assertNotNull(user.getLastName());

        //Status Doğrulanır.
        assertNotNull(user.getStatus());
    }
    public void validateClassified(ClassifiedModel classified){

        //userId Doğrulanır.
        validateUser(new UsersServiceHelper().getUser(classified.getUserId()));

        //title Doğrulanır.
        assertNotNull(classified.getTitle());

        //description Doğrulanır.
        assertNotNull(classified.getDescription());

        //currency Doğrulanır.
        assertNotNull(classified.getCurrency());

        //price Doğrulanır.
        assertNotNull(classified.getPrice());
        isPozitive(classified.getPrice());

        //status Doğrulanır.
        assertNotNull(classified.getStatus());

        //createdDate Doğrulanır
        isValidTimestamp(classified.getCreatedDate());

        //publishedBy Doğrulanır.
        assertNotNull(classified.getPublishedBy());

        //city Doğrulanır.
        assertNotNull(classified.getCity());

        //category Doğrulanır.
        assertNotNull(classified.getCategory());

        //classifiedAttributes Doğrulanır.
        assertNotNull(classified.getClassifiedAttributes());
        for (ClassifiedAttributes classifiedAttribute: classified.getClassifiedAttributes()) {
            //classifiedAttributes Objesinin İçerisindeki classifiedId ile ilandaki ID değerlerinin aynı olduğu doğrulanır.
            assertEquals(classifiedAttribute.getClassifiedId(), classified.getId());

            //attributeName Doğrulanır.
            assertNotNull(classifiedAttribute.getAttributeName());

            //attributeValue Doğrulanır.
            assertNotNull(classifiedAttribute.getAttributeValue());
        }

        //coordinate Doğrulanır.
        assertNotNull(classified.getCoordinate());
    }

    //isValidTimeStamp Methodu Aınan Parametrenin Unix Timestamp Formatında Olduğunu Doğrular.
    public static boolean isValidTimestamp(long timeStamp) {
        long dv = timeStamp*1000; //milisaniye tipinde olması gerekmektedir.

        Date df = new java.util.Date(dv);

        String inDate = new SimpleDateFormat("yyyy-MM-dd").format(df);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(inDate.trim());
        }
        catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public boolean isPozitive(double value){
        return value > 0;
    }
    public boolean isPozitive(int value){
        return value > 0;
    }
}
