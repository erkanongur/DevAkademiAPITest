package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//ConfigManager Sınıfı "config.properties" Dosyasında Bulunan Parametrelere Erişmekte Kullanılmaktadır.
public class ConfigManager {

    private static ConfigManager manager;
    private static final Properties properties = new Properties();

    //Constructor İçerisinde "config.properties" Dosyası Okunur.
    private ConfigManager() throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(inputStream);
    }

    //getInstance Methodu ConfigManager Sınıfından Birden Fazla Obje Oluşturulamamasını Sağlar.
    public static ConfigManager getInstance(){
        if(manager == null){
            synchronized (ConfigManager.class){
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  manager;
    }

    //getString Methodu İle "config.properties" Dosyasından İstenilen Parametre Değeri Okunur.
    public String getString(String key){
        return System.getProperty(key, properties.getProperty(key));
    }
}
