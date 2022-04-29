package tests;

import helpers.UsersServiceHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Validator;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class UsersTests extends Validator {
    private UsersServiceHelper usersServiceHelper;
    private static final Logger logger = LoggerFactory.getLogger(UsersTests.class);

    @BeforeClass
    public void init()
    {
        usersServiceHelper = new UsersServiceHelper();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/users ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("USERS")
    @Test
    public void getUsers_Test()
    {
        logger.info("Kullanıcılar İçin İstek Atılıyor..");
        List<UserModel> users = usersServiceHelper.getUsers(new Random().nextInt(10));
        logger.info("Kullanıcılar Başarı İle Alındı.");

        //Yanıt İçerisinde Getirilen Veri Sayısının Beklenildiği Gibi Geldiği Doğrulanır.
        assertEquals(users.size(), 20);
        logger.info("Yanıt Kullanıcı Sayısı : " + users.size() + "    Beklenen Kullanıcı Sayısı : " + 20);

        //Getirilen Verilerin Her Birinin Json Değerlerinin Boş Olmadığı Doğrulanır.
        //Integer Değerler Hiçbir Zaman Null Olamayacağı İçin Kontrol Edilmemiştir.
        logger.info("Kullanıcılar İçerisindeki Değerler Doğrulanıyor..");
        for (UserModel user: users) {
            validateUser(user);
        }
        logger.info("Kullanıcılar İçerisindeki Değerler Başarıyla Doğrulandı..");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("/v1/api/users ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("USERS")
    @Test
    public void getUsers_pageNoMaxValue_Test()
    {
        logger.info("Kullanıcılar İçin İstek Atılıyor..");
        usersServiceHelper.getUsers_pageNoMaxValue();
        logger.info("Kullanıcılar Başarı İle Alındı.");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("/v1/api/users ucuna istek atılır yanıt içerisindeki kısımlar doğrulanır.")
    @Story("USERS")
    @Test
    public void getUser_Test()
    {
        logger.info("Kullanıcı İçin İstek Atılıyor..");
        UserModel user = usersServiceHelper.getUser(1);
        logger.info("Kullanıcı Başarı İle Alındı.");

        logger.info("Kullanıcı İçerisindeki Değerler Doğrulanıyor..");
        validateUser(user);
        logger.info("Kullanıcı İçerisindeki Değerler Başarıyla Doğrulandı..");
    }
}
