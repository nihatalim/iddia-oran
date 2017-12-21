# iddia-oran
Spring Boot ile iddia oranlarını ve maç sonuçlarını yarım saatte bir senkronize eder ve sunduğu API ile sonuçları size verir.

https://github.com/mertkahyaoglu/iddaa-oran reposunu temel almıştır.

Kullanabilmek için resources klasörü altındaki application.properties ve hibernate.cfg.xml dosyasına, kullanmak istediğiniz veritabanınızın adını yazın. Veritabanınızın kullanıcı adı ve şifresini de girin.

Projede kullanılan teknoloji/özellik/kütüphaneler:
1. Spring Boot
2. Hibernate
3. Swagger UI
4. Jsoup
5. Spring Scheduler

#DERLEME

Projeyi derlemek için veritabanı ayarlarınızı yaptıktan sonra aşağıdaki komutu çalıştırın.
./mvnw package 

Bu komuttan sonra target klasörü altında jar uzantılı executable bir dosya oluşturulacak. 

Java JDK8 çalıştırabilen herhangi bir makinede aşağıdaki komutla çalıştırabilirsiniz:
java -jar TARGETKLASÖRÜALTINDAKİJARDOSYASININADI.jar
