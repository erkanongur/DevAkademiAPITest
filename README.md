
# DEVAKADEMI API TEST

&nbsp;&nbsp;&nbsp;&nbsp;Dev-Akademi yarışmasında geliştiricilere veri sağlamakta kullanılan API servisi için bir Java Maven test otomasyon projesidir.  
&nbsp;&nbsp;&nbsp;&nbsp;Bu projede amaç, tüm API uçlarının olası kullanım senaryolarında fonksiyonelliğini koruduğunun otomatize edilmiş testler ile doğrulanmasıdır.
Projede zaman kısıtından ötürü başarılı durum senaryolarına odaklandım. Fail durumlarının kontrol
edilmemesinin nedeni budur. Ayrıca Jmeter ile örnek bir performans testi hazırlamayı da düşünüyordum fakat
bu konuda zaman kısıtından çok sistemin kilitlenmesine yol açıp diğer yarışmacıları etkileyebileceği için yapmadım.
Ayrıca çok istek atılırsa güvenlik önlemlerinden dolayı IP adresimin bloklanacağı belirtildi :D



## Projenin Kullanımı
&nbsp;&nbsp;&nbsp;&nbsp;Bu bölümde projenin gereksinimlerinden ve kullanmından
bahsedeceğim. Bir Maven projesi olduğu için çok rahat bir şekilde derleyicinizde
açtığınız anda pom.xml dosyasındaki gereksinimleri yükleyecektir. Kullanılan cihazda
aynı zamanda Java SDK 11'in yüklü olması gerekmektedir.  

&nbsp;&nbsp;&nbsp;&nbsp;Proje açılıp gereksinimler yüklendikten sonra proje içerisindeki
test package üzerine sağ tıklatıp aşağıdaki görseldeki gibi "Run" seçeneği ile testleri
başlatabilirsiniz.

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/asbr97s.png)

&nbsp;&nbsp;&nbsp;&nbsp;Testler tamamlandıktan sonra rapor oluşturabilmek için projenin
bulunduğu konumda bulunan "createAllureReport.bat" dosyasını çalıştırabilirsiniz. Tarayıcınızda
rapor otomatik olarak açılacaktır.

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/6npjbjd.png)

&nbsp;&nbsp;&nbsp;&nbsp;Rapor ilk açıldığında aşağıdaki görseldeki gibi görünecektir.
Bu sayfada test senaryolarımızın sayısını, hangi oranda bir başarı sağladığımızı görebiliriz.
Bu rapor Allure kütüphanesi ile oluşturulmuştur.

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/80b3pq0.png)

&nbsp;&nbsp;&nbsp;&nbsp;Ana sayfa dışında Suites ve Graphs sekmerinde test sonuçları
hakkında detaylı bilgiler görebiliriz. Suites sekmesinde hangi testlerin başarılı veya
başarısız olduğunu, başarısız ise hata loglarını, testin ne kadar sürdüğünü vs. görebiliriz.

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/1m08cyl.png)

&nbsp;&nbsp;&nbsp;&nbsp;Son olarak Graphs sekmesine göz atalım. Burada test sonuçları
görsel araçlarla sunulmuştur. Başarı oranı, önem seviyesine göre sınıflandırma ve
yanıt süresine göre sınıflandırma gibi seçenekler bulunmaktadır.

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/f7ikpfk.png)


## Kullanılan Teknolojiler

**RestAssured v4.5.0**  
&nbsp;&nbsp;&nbsp;&nbsp; Projede API isteklerini yönetmek, API seviyesinde testler yapmak ve bir çok http işlemlerini yönetebilmek için **RestAssured** kütüphanesi kullanılmıştır.  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://rest-assured.io/  

**TestNG v7.5**  
&nbsp;&nbsp;&nbsp;&nbsp; Projede testlerin yönetilmesi ve sonuçların görselleştirilmesi için **TestNG** kütüphanesi kullanılmıştır.  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://testng.org/doc/  

**Allure-TestNG v2.17.2**  
&nbsp;&nbsp;&nbsp;&nbsp; Projede her ne kadar TestNG kütüphanesi ile raporlar oluşturulsa da, daha güzel ve detaylı raporlar oluşturabilmek için **Allure-TestNG** kütüphanesi kullanılmıştır.  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://docs.qameta.io/allure/  

**SLF4J-Simple v1.7.35**  
&nbsp;&nbsp;&nbsp;&nbsp; Projede loglama işlemlerinin gerçekleştirilmesi içim **SLF4J-Simple** kütüphanesi kullanılmıştır.  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://www.slf4j.org/
## API Hakkında

&nbsp;&nbsp;&nbsp;&nbsp;Bu kısımda API içerisindeki uçlardan ve gerekli parametrelerden bahsedeceğiz. Öncelikle istek gönderebilmemiz için bir API anahtarına ihtiyacımız vardır. Aşağıda bu parametre gösterilmiştir.

&nbsp;&nbsp;&nbsp;&nbsp;API uçları ve aldıkları parametreler hakkında gerekli bilgiler aşağıda verilmiştir.

#### Users
```http
  GET v1/api/users
```

```http
  GET v1/api/users/{id}
```
| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | Kullanıcı ID bilgisi |

#### Payment-details
```http
  GET v1/api/payment-details
```

```http
  GET v1/api/payment-details/{id}
```
| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | Ödeme ID Bilgisi |

#### Classifieds
```http
  GET v1/api/classifieds/
```

```http
  GET v1/api/classifieds/{id}
```
| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | İlan ID Bilgisi |

#### Advertisements
```http
  GET v1/api/advertisements
```
#### Access-logs
```http
  GET v1/api/access-logs
```

```http
  GET v1/api/access-logs/{id}
```
| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | Log ID Bilgisi |

  
## Proje Yapısı
&nbsp;&nbsp;&nbsp;&nbsp;Bu kısımda projede nasıl bir sınıf yapısı kullandığımızdan ve bunların bize nasıl faydası olacağından bahsedeceğiz.
Proje yapısı aşağıdaki gibidir :   

![Uygulama Ekran Görüntüsü](https://i.hizliresim.com/i5drllh.png)

**Constants**  
&nbsp;&nbsp;&nbsp;&nbsp;Bu package içerisindeki "EndPoints" sınıfında istek atılacak API uçları tanımlanmaktadır.  

**Helpers**  
&nbsp;&nbsp;&nbsp;&nbsp;Bu package içerisinde ilgili API uçlarına restAssured ile istek atıp temel doğrulamaları yaparak yanıtı döndürecek methodlar bulunmaktadır.

**Model**  
&nbsp;&nbsp;&nbsp;&nbsp;Bu package içerisinde Helper sınıflarında elde edilen json yanıtları POJO(Plain Old Java Object) nesnesine dönüştürmekte kullanacağımız model sınıflar bulunmaktadır.  

**Utils**  
&nbsp;&nbsp;&nbsp;&nbsp;Bu package içerisinde konfigürasyon dosyamızı okumak için gereken ConfigManager sınıfı ve tekrar eden doğrulama fonksiyonları için Validator sınıfı bulunmaktadır.  

**Tests**  
&nbsp;&nbsp;&nbsp;&nbsp;Bu package içerisinde adı üzerinde olduğu gibi test sınıflarımız bulunmaktadır. Bu sınıflar içerisinde Helper sınıflarındaki methodları kullanarak API'ye istek atarılır ve Validator sınıfındaki methodlar ya da diğer yöntemler ile Helper sınıfılarından gelen yanıt doğrulanır.  

**Resources**  
&nbsp;&nbsp;&nbsp;&nbsp;Projemizi daha dinamik hale getirebilmek için değişken parametreler(URL, kullanıcı adı, şifreler vs.) buradaki config.properties dosyasından okunur. Aynı zamanda API uçlarının yanıtlarından oluşturulan json şemaları da bu klasörde bulunmaktadır.
Bu şemalar ile API'den gelen yanıtların doğru json yapısında geldiğini doğrularız.

## Son Olarak
&nbsp;&nbsp;&nbsp;&nbsp;Öncelikle bu yarışmada olmanın benim için ne kada gurur verici olduğunu belirtmek isterim. Pandemi sebebi ile online olarak yapılmasına rağmen katıldığım en iyi hackathon diyebilirim. Sabahtan akşama kadar bizimle iletişim halinde olup sorularımıza anında cevap veren bu güzel ekibe teşekkür ederim. Umarım bende bu takımın bir parçası olabilirim.  
Çok Teşekkürler..

