package nsuproject.diseasenotification.worlddata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class WorldDataController {

    @Autowired
    WorldService service;

    @GetMapping("/world")
    public void getWorldData() {

        String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=%EC%84%B8%EA%B3%84+%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84&qdt=0&ie=utf8&query=%EC%A0%84%EC%84%B8%EA%B3%84+%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";

        service.insertData(url);
    }
}
