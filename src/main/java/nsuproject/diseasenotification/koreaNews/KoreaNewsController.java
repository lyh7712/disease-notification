package nsuproject.diseasenotification.koreaNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KoreaNewsController {

    @Autowired
    private KoreaNewsService service;


    @GetMapping("/korea/news")
    public List<KoreaNews> getAllNews() {

        String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EC%BD%94%EB%A1%9C%EB%82%98";

        service.insertNews(url);

        return service.findAllNews();
    }

}

