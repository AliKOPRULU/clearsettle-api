# Clearsettle API

-MERCHANT LOGIN
-TRANSACTION REPORT
-TRANSACTION QUERY
-GET TRANSACTION
-GET CLIENT
-GET MERCHANT

*Interface Future<V> : A Future represents the result of an asynchronous computation.
*Class Optional<T> : A container object which may or may not contain a non-null value.
*Stream() : A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value. 

## APPENDIX

PSP API :

- [PSP API Function Reference](http://docs.raima.com/rdm/current/C_UG/Content/PSPUG/PSPAPIReference.htm)

Currency : 

- [ISO 4217](http://www.xe.com/iso4217.php)

Country code :

- [ISO 3166-1 alpha-3](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3)

Characters :

- [ISO 8859-1](http://sites.utoronto.ca/webdocs/HTMLdocs/NewHTML/iso_table.html)

###Look - private static final Logger logger = LoggerFactory.getLogger

- [Asynchronous Methods](https://spring.io/guides/gs/async-method/)

##Unchecked

-  All the request are logged on the Clearsettle side. 

##Not:
TransactionQuery:Parametre Detayları; status, operation, paymentMethod, errorCode, filterField, Enum kullanılabilirdi yalnız, verilenler tamamı mı bilinmiyor, Char limit 8-10 kat fazla, şimdilik pas geçildi. 
-Testde kullanılabilir öğren.  

Useful links:https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-write-clean-assertions-with-jsonpath/

http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html

http://www.bahadirakin.com/mockito-ilk-adimlar/

http://www.bahadirakin.com/test-yazarken-uyulmasi-gereken-7-kural/

----
https://travis-ci.org
heroku.com
https://www.versioneye.com

-----
https://bintray.com/bintray/jcenter

