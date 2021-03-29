package nsuproject.diseasenotification.koreaNews;

import lombok.RequiredArgsConstructor;
import nsuproject.diseasenotification.dto.KoreaNewsRequestDto;
import nsuproject.diseasenotification.service.KoreaNewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jpa")
public class KoreaNewsController {

    @Autowired
    private KoreaNewsService service;

    // "/news"에 접근하면 내부적으로 크롤링 설정

    @GetMapping("/news")
    public void getNews() {

        String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EC%BD%94%EB%A1%9C%EB%82%98";

        service.insertNews(url);
    }

    @GetMapping("/allnews")
    public List<KoreaNews> getAllNews() {
        return service.findAllNews();
    }


}

