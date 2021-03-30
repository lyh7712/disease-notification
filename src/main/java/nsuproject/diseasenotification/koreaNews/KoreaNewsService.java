package nsuproject.diseasenotification.koreaNews;

import lombok.RequiredArgsConstructor;
import nsuproject.diseasenotification.dto.KoreaNewsRequestDto;
import nsuproject.diseasenotification.koreaNews.KoreaNews;
import nsuproject.diseasenotification.koreaNews.KoreaNewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class KoreaNewsService {

    @Autowired
    private final KoreaNewsRepository koreaNewsRepository;

    @Transactional
    public Long save(KoreaNewsRequestDto requestDto) {
        return koreaNewsRepository.save(requestDto.toEntity()).getId();
    }


    public List<KoreaNews> findAllNews() {
        return koreaNewsRepository.findAll();
    }

    // Controller 가져온 크롤링 데이터 URL
    // URL 접근 Jsoup로 필터
    // 데이터 Set + List 형태로 DB에 저장

    //API를 통해 가져온 크롤링 데이터 DB 저장
    public void insertNews(String url) {

        try {

            Document doc = Jsoup.connect(url).get();

            Elements element = doc.select(".group_news");

            for (Element el : element.select("a.news_tit")) {

                KoreaNews news = new KoreaNews();
                news.setTitle(el.text());
                news.setUrl(el.attr("href"));
                //개발일지 - URL 정보를 가져오는 문제점 Elements의 attr 속성을 찾아서 해결
                //DB에 최신화되는 정보를 넣어줘야 하기 떄문에 Controller에 타이머 필요
                koreaNewsRepository.save(news);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
