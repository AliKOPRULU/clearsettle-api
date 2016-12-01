package alikoprulu.impl;

import alikoprulu.model.request.Credetial;
import alikoprulu.model.response.Token;
import alikoprulu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${baseUrl}")//Value vaesayılan değer atar, ${baseUrl} application.properties de atadığımız baseUrl değerini yakalar
    private String baseUrl;


    @Async
    @Override
    public Future<Optional<Token>> login(Credetial credetial) {
        String url=baseUrl+"/merchant/user/login";
        Token token=null;

        token=restTemplate.postForObject(url,credetial,Token.class);

        return new AsyncResult<>(Optional.ofNullable(token));//ofNullable null kabul eder. İstisna fırlatmaz
    }
}
