package alikoprulu.impl;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Merchant;
import alikoprulu.model.response.Token;
import alikoprulu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 1.12.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired//çalışma zamanında hata vermesin diye otomatik bağlamaya yarıyor
    private RestTemplate restTemplate;//RESTful web servisler için kullanacağız

    @Value("${baseUrl}")
//Value varsayılan değer atar, ${baseUrl} application.properties de atadığımız baseUrl değerini yakalar
    private String baseUrl;

    @Async
    @Override
    public Future<Optional<Token>> login(Credential credential) {
        String url = baseUrl + "/merchant/user/login";
        Token token = null;

        try {
            token = restTemplate.postForObject(url, credential, Token.class);
        } catch (Exception e) {

        } finally {
            return new AsyncResult<>(Optional.ofNullable(token));//ofNullable null kabul eder. İstisna fırlatmaz
        }
    }

    @Async
    @Override
    public Future<Optional<Merchant>> merchant(Credential credential, String token) {
        String url = baseUrl + "/merchant";
        Merchant merchant = null;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", token);

        HttpEntity httpEntity = new HttpEntity<>(credential, httpHeaders);
        try {
            merchant = restTemplate.postForObject(url, httpEntity, Merchant.class);
        } catch (Exception e) {

        } finally {
            return new AsyncResult<>(Optional.ofNullable(merchant));
        }
    }
}
